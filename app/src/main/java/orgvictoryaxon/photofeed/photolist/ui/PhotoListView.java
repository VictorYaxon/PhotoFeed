package orgvictoryaxon.photofeed.photolist.ui;

import orgvictoryaxon.photofeed.entities.Photo;

/**
 * Created by VictorYaxon.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
