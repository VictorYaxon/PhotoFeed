package orgvictoryaxon.photofeed.main;

import android.location.Location;

import orgvictoryaxon.photofeed.main.events.MainEvent;

/**
 * Created by VictorYaxon.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
