package backend.json;

import backend.dao.Files;
import backend.dao.Posts;
import backend.dao.Ratings;
import backend.dao.Resources;

import java.sql.Timestamp;

public class ResourceJSON {
    private int idResource;
    private String title;
    private String description;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp registeredAt;
    private java.sql.Timestamp lastModifiedAt;
    private boolean visibility;
    private int nDownloads;
    private boolean available;
    private String resourceType;
    private UserJSON idUser;
    private RatingsJSON[] ratings;
    private FileJSON[] files;
    private PostJSON[] posts;

    public ResourceJSON(Resources r, Ratings[] rs, Files[] fs, PostJSON[] posts) {
        this.idUser = new UserJSON(r.getIdUser());
        this.idResource = r.getIdResource();
        this.title = r.getTitle();
        this.description = r.getDescription();
        this.createdAt = r.getCreatedAt();
        this.registeredAt = r.getRegisteredAt();
        this.lastModifiedAt = r.getLastModifiedAt();
        this.visibility = r.getVisibility();
        this.nDownloads = r.getnDownloads();
        this.available = r.getAvailable();
        this.resourceType = r.getIdResourceType().getType();
        this.ratings = new RatingsJSON[rs.length];
        this.files = new FileJSON[fs.length];
        for(int i = 0; i < rs.length; i++){
            this.ratings[i] = new RatingsJSON(rs[i]);
        }
        for(int i = 0; i < fs.length; i++){
            this.files[i] = new FileJSON(fs[i]);
        }
        this.posts = posts;
    }

    public PostJSON[] getPosts() {
        return posts;
    }

    public UserJSON getIdUser() {
        return idUser;
    }

    public FileJSON[] getFiles() {
        return files;
    }

    public int getIdResource() {
        return idResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public RatingsJSON[] getRatings() {
        return ratings;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public Timestamp getLastModifiedAt() {
        return lastModifiedAt;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public int getnDownloads() {
        return nDownloads;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getResourceType() {
        return resourceType;
    }
}
