package orgvictoryaxon.photofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by VictorYaxon.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
