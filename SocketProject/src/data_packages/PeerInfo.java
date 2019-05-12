package data_packages;

import java.io.Serializable;
import java.net.InetAddress;

public class PeerInfo implements Serializable {

    private static final long serialVersionUID = 1623831936324658271L;

    PeerInfo(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public InetAddress address;
    public int port;

}