package data_packages;

import java.io.Serializable;

public class FileInfo implements Serializable {

    private static final long serialVersionUID = 656857255758163993L;

    FileInfo(PeerInfo owner, String filename, long size) {
        this.owner = owner;
        this.filename = filename;
        this.size = size;
    }
    public PeerInfo owner;
    public String filename;
    public long size;

}