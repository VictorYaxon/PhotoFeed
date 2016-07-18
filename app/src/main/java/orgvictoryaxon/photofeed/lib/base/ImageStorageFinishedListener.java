package orgvictoryaxon.photofeed.lib.base;

/**
 * Created by VictorYaxon.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
