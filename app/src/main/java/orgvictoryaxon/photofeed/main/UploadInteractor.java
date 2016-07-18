package orgvictoryaxon.photofeed.main;

import android.location.Location;

/**
 * Created by VictorYaxon.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
