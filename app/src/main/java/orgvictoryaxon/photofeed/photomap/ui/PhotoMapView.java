package orgvictoryaxon.photofeed.photomap.ui;

import orgvictoryaxon.photofeed.entities.Photo;

/**
 * Created by VictorYaxon.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
