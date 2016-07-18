package orgvictoryaxon.photofeed.photolist.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;
import orgvictoryaxon.photofeed.domain.di.DomainModule;
import orgvictoryaxon.photofeed.lib.di.LibsModule;
import orgvictoryaxon.photofeed.photolist.ui.PhotoListFragment;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
