package orgvictoryaxon.photofeed.photolist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.photofeed.domain.FirebaseAPI;
import orgvictoryaxon.photofeed.domain.Util;
import orgvictoryaxon.photofeed.entities.Photo;
import orgvictoryaxon.photofeed.lib.base.EventBus;
import orgvictoryaxon.photofeed.lib.base.ImageLoader;
import orgvictoryaxon.photofeed.photolist.PhotoListInteractor;
import orgvictoryaxon.photofeed.photolist.PhotoListInteractorImpl;
import orgvictoryaxon.photofeed.photolist.PhotoListPresenter;
import orgvictoryaxon.photofeed.photolist.PhotoListPresenterImpl;
import orgvictoryaxon.photofeed.photolist.PhotoListRepository;
import orgvictoryaxon.photofeed.photolist.PhotoListRepositoryImpl;
import orgvictoryaxon.photofeed.photolist.ui.PhotoListView;
import orgvictoryaxon.photofeed.photolist.ui.adapters.OnItemClickListener;
import orgvictoryaxon.photofeed.photolist.ui.adapters.PhotoListAdapter;

/**
 * Created by VictorYaxon.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}
