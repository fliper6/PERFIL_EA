package backend.json;

import backend.dao.Files;

public class FileJSON {
    private int idFile;
    private String name;
    private String mimetype;
    private String path;
    private long size;

    public FileJSON(Files f) {
        this.idFile = f.getIdFile();
        this.name = f.getName();
        this.mimetype = f.getMimetype();
        this.path = f.getPath();
        this.size = f.getSize();
    }

    public long getSize() {
        return size;
    }

    public int getIdFile() {
        return idFile;
    }

    public String getName() {
        return name;
    }

    public String getMimetype() {
        return mimetype;
    }

    public String getPath() {
        return path;
    }
}
