package orgvictoryaxon.photofeed.login;

/**
 * Created by VictorYaxon.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
