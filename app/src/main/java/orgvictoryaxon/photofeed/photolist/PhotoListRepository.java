package orgvictoryaxon.photofeed.photolist;

import orgvictoryaxon.photofeed.entities.Photo;

/**
 * Created by VictorYaxon.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
