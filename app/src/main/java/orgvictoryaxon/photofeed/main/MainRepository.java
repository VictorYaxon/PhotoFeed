package orgvictoryaxon.photofeed.main;

import android.location.Location;

/**
 * Created by VictorYaxon.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
