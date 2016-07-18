package orgvictoryaxon.photofeed.photolist.events;

import orgvictoryaxon.photofeed.entities.Photo;

/**
 * Created by VictorYaxon.
 */
public class PhotoListEvent {
    private int type;
    private Photo photo;
    private String error;

    public final static int READ_EVENT = 0;
    public final static int DELETE_EVENT = 1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
