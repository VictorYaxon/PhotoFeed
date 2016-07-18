package orgvictoryaxon.photofeed.photomap;

/**
 * Created by VictorYaxon.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor {

    PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}
