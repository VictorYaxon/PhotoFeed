package orgvictoryaxon.photofeed.photolist;

import orgvictoryaxon.photofeed.entities.Photo;

/**
 * Created by VictorYaxon.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
