package orgvictoryaxon.photofeed.main.ui;

/**
 * Created by VictorYaxon.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
