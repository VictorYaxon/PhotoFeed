package orgvictoryaxon.photofeed.main.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;
import orgvictoryaxon.photofeed.domain.di.DomainModule;
import orgvictoryaxon.photofeed.lib.di.LibsModule;
import orgvictoryaxon.photofeed.main.ui.MainActivity;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
