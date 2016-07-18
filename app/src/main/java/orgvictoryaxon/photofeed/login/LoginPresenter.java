package orgvictoryaxon.photofeed.login;

import orgvictoryaxon.photofeed.login.events.LoginEvent;

/**
 * Created by VictorYaxon.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
