package data_packages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;

public class Peer {

    private static final int PINGTIME = 1000;
    private static final int BUFFER_SIZE = 65536;

    //The port number used for internal communication
    private int PORT_NUMBER;

    //holds list of files that are in the network and not in current peer
    private volatile ArrayList<FileInfo> ExternalFileList = new ArrayList<>();

    //holds list of files shared by current peer
    private final ArrayList<FileInfo> LocalFileList = new ArrayList<>();
    private final ArrayList<String[]> LocalFileListPeers = new ArrayList<>();

    // Used for new peers to get list of files.
    private ServerSocket peerListener;

    // Used so that peers can reach this peer to receive files
    private ServerSocket peerSrc;

    private PeerInfo myPeer;

    public boolean initialize(int port) throws IOException, InterruptedException {

        PORT_NUMBER = port;
        try {
            peerListener = new ServerSocket(PORT_NUMBER);
        } catch (Exception ex) {
            return false;
        }

        peerSrc = new ServerSocket(0);

        myPeer = new PeerInfo(InetAddress.getLocalHost(), peerSrc.getLocalPort());

        //launches the listener, which informs new peers of its own file list
        new Thread(this::_peerListener).start();     //call lamda exp

        new Thread(this::_requestAccepter).start();

        //Fills External File list
        refreshFileList();

        return true;
    }

    public ArrayList<FileInfo> getAvailableFiles() {
        return ExternalFileList;
    }

    public ArrayList<FileInfo> getLocalFiles() {
        return LocalFileList;
    }

    public void removeFromLocalList(int idx[]) {
        Arrays.sort(idx);
        for (int i = idx.length - 1; i >= 0; --i) {
            LocalFileList.remove(idx[i]);
        }
    }

    public void addFilesToLocalList(String filenames, String[] onlythese) {
        String[] files = filenames.split("\\|");

        for (String file : files) {
            File f = new File(file);                //to sure if the file exist
            if (f.exists()) {
                FileInfo info = new FileInfo(myPeer, file, f.length());
                LocalFileList.add(info);
                LocalFileListPeers.add(onlythese);     //string of ips if private
            }
        }
    }

    public boolean requestFile(Reporter t, int idx, String filepath) {
        try {
            FileInfo fileInfo = ExternalFileList.get(idx);
            Socket connect = new Socket(fileInfo.owner.address, fileInfo.owner.port);
            FileOutputStream fstream = new FileOutputStream(filepath);

            DataOutputStream outToPeer = new DataOutputStream(connect.getOutputStream());
            outToPeer.writeUTF(fileInfo.filename);

            DataInputStream inFromPeer = new DataInputStream(connect.getInputStream());

            long len = inFromPeer.readLong();

            if (len == -1) {
                fstream.close();
                connect.close();
                return false;
            }

            byte[] data = new byte[BUFFER_SIZE];

            for (long off = 0; off < len; off += BUFFER_SIZE) {
                t.report((int) (off * 100 / len));

                long sz = len - off;
                if (sz > BUFFER_SIZE) {
                    sz = BUFFER_SIZE;
                }
                int read = inFromPeer.read(data, 0, (int) sz);   //to read the file seperated
                off -= sz - read;
                fstream.write(data, 0, read);
            }
            t.report(100);
            fstream.close();

            connect.close();
        } catch (SocketException e) {
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    public interface Reporter {

        void report(int param1);
    }

    public void close() {
        try {
            peerSrc.close();
            peerListener.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void _peerListener() {
        try {
            Socket ss = peerListener.accept();
            new Thread(this::_peerListener).start();  //keep accepting
            ArrayList<FileInfo> LocalFileListCpy = (ArrayList<FileInfo>) LocalFileList.clone();
            for (int i = 0; i < LocalFileListPeers.size(); ++i) {
                String[] curr = LocalFileListPeers.get(i);
                if (curr != null) {
                    boolean flag = false;
                    for (String x : curr) {
                        if (ss.getInetAddress().getHostAddress().equals(x)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {            //private for this peer
                        LocalFileListCpy.remove(i);
                    }
                }

            }
            ObjectOutputStream obj = new ObjectOutputStream(ss.getOutputStream());
            obj.writeObject(LocalFileListCpy);
        } catch (SocketException ex) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void _requestAccepter() {
        try {
            Socket ss = peerSrc.accept();
            new Thread(this::_requestAccepter).start();

            DataInputStream inFromPeer = new DataInputStream(ss.getInputStream());
            DataOutputStream outToPeer = new DataOutputStream(ss.getOutputStream());

            String filename = inFromPeer.readUTF();

            boolean found = false;
            for (FileInfo f : LocalFileList) {
                if (f.filename.equals(filename)) {
                    found = true;
                }
            }
            if (!found) {
                outToPeer.writeLong(-1);
                ss.close();
                return;
            }
            long len = new File(filename).length();
            outToPeer.writeLong(len);

            byte[] data = new byte[BUFFER_SIZE];

            FileInputStream fstream = new FileInputStream(filename);

            for (long off = 0; off < len; off += BUFFER_SIZE) {
                long sz = len - off;
                if (sz > BUFFER_SIZE) {
                    sz = BUFFER_SIZE;
                }
                fstream.read(data, 0, (int) sz);
                outToPeer.write(data, 0, (int) sz);
            }
            fstream.close();
            ss.close();
        } catch (SocketException ex) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshFileList() {
        ExternalFileList.clear();
        final byte[] ip;
        try {
            ip = InetAddress.getLocalHost().getAddress();
        } catch (Exception e) {
            return;
        }
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 2; i <= 254; i++) {

            ip[3] = (byte) i;
            Thread e = new Thread(() -> {
                FetchUserList(ip);
            });

            e.start();

            threads.add(e);

        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void FetchUserList(final byte[] ip) {
        try {

            InetAddress address = InetAddress.getByAddress(ip);

            if (address.equals(InetAddress.getLocalHost())) {
                return;
            }

            ArrayList<FileInfo> tempFileList;

            Socket ss = new Socket();
            //ss.setReuseAddress(true);

            ss.connect(new java.net.InetSocketAddress(address, PORT_NUMBER), PINGTIME);
            ObjectInputStream obj = new ObjectInputStream(ss.getInputStream());
            tempFileList = (ArrayList<FileInfo>) obj.readObject();
            ss.close();

            for (FileInfo fileInfo : tempFileList) {
                ExternalFileList.add(fileInfo);
            }
        } catch (ConnectException | SocketTimeoutException ex) {

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}