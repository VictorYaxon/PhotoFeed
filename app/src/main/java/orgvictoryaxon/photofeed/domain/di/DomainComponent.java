package orgvictoryaxon.photofeed.domain.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {
}
