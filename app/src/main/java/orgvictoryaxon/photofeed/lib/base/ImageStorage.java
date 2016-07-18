package orgvictoryaxon.photofeed.lib.base;

import java.io.File;

/**
 * Created by VictorYaxon.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
