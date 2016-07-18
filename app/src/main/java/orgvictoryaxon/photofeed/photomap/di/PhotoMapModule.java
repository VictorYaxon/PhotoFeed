package orgvictoryaxon.photofeed.photomap.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.photofeed.domain.FirebaseAPI;
import orgvictoryaxon.photofeed.lib.base.EventBus;
import orgvictoryaxon.photofeed.photomap.PhotoMapInteractor;
import orgvictoryaxon.photofeed.photomap.PhotoMapInteractorImpl;
import orgvictoryaxon.photofeed.photomap.PhotoMapPresenter;
import orgvictoryaxon.photofeed.photomap.PhotoMapPresenterImpl;
import orgvictoryaxon.photofeed.photomap.PhotoMapRepository;
import orgvictoryaxon.photofeed.photomap.PhotoMapRepositoryImpl;
import orgvictoryaxon.photofeed.photomap.ui.PhotoMapView;

/**
 * Created by VictorYaxon.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}
