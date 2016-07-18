package orgvictoryaxon.photofeed;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import orgvictoryaxon.photofeed.domain.di.DomainModule;
import orgvictoryaxon.photofeed.lib.di.LibsModule;
import orgvictoryaxon.photofeed.login.di.DaggerLoginComponent;
import orgvictoryaxon.photofeed.login.di.LoginComponent;
import orgvictoryaxon.photofeed.login.di.LoginModule;
import orgvictoryaxon.photofeed.login.ui.LoginView;
import orgvictoryaxon.photofeed.main.di.DaggerMainComponent;
import orgvictoryaxon.photofeed.main.di.MainComponent;
import orgvictoryaxon.photofeed.main.di.MainModule;
import orgvictoryaxon.photofeed.main.ui.MainView;
import orgvictoryaxon.photofeed.photolist.di.DaggerPhotoListComponent;
import orgvictoryaxon.photofeed.photolist.di.PhotoListComponent;
import orgvictoryaxon.photofeed.photolist.di.PhotoListModule;
import orgvictoryaxon.photofeed.photolist.ui.PhotoListView;
import orgvictoryaxon.photofeed.photolist.ui.adapters.OnItemClickListener;
import orgvictoryaxon.photofeed.photomap.di.DaggerPhotoMapComponent;
import orgvictoryaxon.photofeed.photomap.di.PhotoMapComponent;
import orgvictoryaxon.photofeed.photomap.di.PhotoMapModule;
import orgvictoryaxon.photofeed.photomap.ui.PhotoMapView;

/**
 * Created by VictorYaxon.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private LibsModule libsModule;
    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        photoFeedAppModule = new PhotoFeedAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public PhotoMapComponent getPhotoMapComponent(Fragment fragment, PhotoMapView view) {
        libsModule.setFragment(fragment);

        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoMapModule(new PhotoMapModule(view))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }
}
