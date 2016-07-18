package orgvictoryaxon.photofeed.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.photofeed.domain.FirebaseAPI;
import orgvictoryaxon.photofeed.lib.base.EventBus;
import orgvictoryaxon.photofeed.login.LoginInteractor;
import orgvictoryaxon.photofeed.login.LoginInteractorImpl;
import orgvictoryaxon.photofeed.login.LoginPresenter;
import orgvictoryaxon.photofeed.login.LoginPresenterImpl;
import orgvictoryaxon.photofeed.login.LoginRepository;
import orgvictoryaxon.photofeed.login.LoginRepositoryImpl;
import orgvictoryaxon.photofeed.login.SignupInteractor;
import orgvictoryaxon.photofeed.login.SignupInteractorImpl;
import orgvictoryaxon.photofeed.login.ui.LoginView;

/**
 * Created by VictorYaxon.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
