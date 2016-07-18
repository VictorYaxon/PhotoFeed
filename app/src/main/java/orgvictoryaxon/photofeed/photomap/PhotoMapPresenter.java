package orgvictoryaxon.photofeed.photomap;

import orgvictoryaxon.photofeed.photomap.events.PhotoMapEvent;

/**
 * Created by VictorYaxon.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
