package orgvictoryaxon.photofeed.login;

import com.firebase.client.FirebaseError;

import orgvictoryaxon.photofeed.domain.FirebaseAPI;
import orgvictoryaxon.photofeed.domain.FirebaseActionListenerCallback;
import orgvictoryaxon.photofeed.lib.base.EventBus;
import orgvictoryaxon.photofeed.login.events.LoginEvent;

/**
 * Created by VictorYaxon.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;

    public LoginRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void signUp(final String email, final String password) {
        firebase.signUp(email, password, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(LoginEvent.onSignUpSuccess);
                signIn(email, password);
            }

            @Override
            public void onError(FirebaseError error) {
                post(LoginEvent.onSignUpError, error.getMessage());
            }
        });
    }

    @Override
    public void signIn(String email, String password) {
        if (email != null && password != null) {
            firebase.login(email, password, new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebase.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null, email);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onSignInError, error.getMessage());
                }
            });
        } else {
            firebase.checkForSession(new FirebaseActionListenerCallback() {
                @Override
                public void onSuccess() {
                    String email = firebase.getAuthEmail();
                    post(LoginEvent.onSignInSuccess, null, email);
                }

                @Override
                public void onError(FirebaseError error) {
                    post(LoginEvent.onFailedToRecoverSession);
                }
            });
        }
    }

    private void post(int type) {
        post(type, null);
    }

    private void post(int type, String errorMessage) {
        post(type, errorMessage, null);
    }

    private void post(int type, String errorMessage, String loggedUserEmail) {
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        loginEvent.setErrorMesage(errorMessage);
        loginEvent.setLoggedUserEmail(loggedUserEmail);
        eventBus.post(loginEvent);
    }

}
