package orgvictoryaxon.photofeed.photomap.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;
import orgvictoryaxon.photofeed.domain.di.DomainModule;
import orgvictoryaxon.photofeed.lib.di.LibsModule;
import orgvictoryaxon.photofeed.photomap.ui.PhotoMapFragment;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}
