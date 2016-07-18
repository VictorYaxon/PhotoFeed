package orgvictoryaxon.photofeed.photolist;

import orgvictoryaxon.photofeed.entities.Photo;
import orgvictoryaxon.photofeed.photolist.events.PhotoListEvent;

/**
 * Created by VictorYaxon.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
