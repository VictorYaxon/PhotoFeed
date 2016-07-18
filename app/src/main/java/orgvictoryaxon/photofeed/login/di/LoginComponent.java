package orgvictoryaxon.photofeed.login.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.photofeed.PhotoFeedAppModule;
import orgvictoryaxon.photofeed.domain.di.DomainModule;
import orgvictoryaxon.photofeed.lib.di.LibsModule;
import orgvictoryaxon.photofeed.login.ui.LoginActivity;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
