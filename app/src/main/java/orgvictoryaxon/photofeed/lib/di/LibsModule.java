package orgvictoryaxon.photofeed.lib.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.photofeed.lib.CloudinaryImageStorage;
import orgvictoryaxon.photofeed.lib.GlideImageLoader;
import orgvictoryaxon.photofeed.lib.GreenRobotEventBus;
import orgvictoryaxon.photofeed.lib.base.EventBus;
import orgvictoryaxon.photofeed.lib.base.ImageLoader;
import orgvictoryaxon.photofeed.lib.base.ImageStorage;

/**
 * Created by VictorYaxon.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }
}
