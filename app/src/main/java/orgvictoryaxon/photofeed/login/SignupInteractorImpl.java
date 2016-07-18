package orgvictoryaxon.photofeed.login;

/**
 * Created by VictorYaxon.
 */
public class SignupInteractorImpl implements SignupInteractor {
    private LoginRepository loginRepository;

    public SignupInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signUp(email, password);
    }
}
