package orgvictoryaxon.photofeed.lib.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
