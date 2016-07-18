package orgvictoryaxon.photofeed.main;

/**
 * Created by VictorYaxon.
 */
public class SessionInteractorImpl implements SessionInteractor {
    MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}
