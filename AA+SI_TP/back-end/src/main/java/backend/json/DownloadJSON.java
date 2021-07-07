package backend.json;

public class DownloadJSON {
    private int[] ids;

    public DownloadJSON() {
    }

    public DownloadJSON(int[] ids) {
        this.ids = ids;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
