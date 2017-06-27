package com.kyleriedemann.giantbombvideoplayer.Base.DependencyInjection.Modules;

import com.inkapplications.android.applicationlifecycle.ApplicationCallbacks;
import com.inkapplications.android.applicationlifecycle.ApplicationLifecycleSubscriber;
import com.kyleriedemann.giantbombvideoplayer.Base.DependencyInjection.Debug;
import com.kyleriedemann.giantbombvideoplayer.Base.DependencyInjection.Initializers.StethoInitializer;

import dagger.Module;
import dagger.Provides;
import inkapplicaitons.android.logger.ConsoleLogger;
import inkapplicaitons.android.logger.Logger;

import javax.inject.Singleton;

/**
 * Application dependencies necessary for Debugging, only when the app is debuggable.
 */
@Module
public class DebugModule {

    @Provides
    @Debug
    @Singleton
    ApplicationCallbacks applicationCallbacks(
        StethoInitializer stetho
    ) {
        ApplicationLifecycleSubscriber[] callbacks = { stetho };

        return new ApplicationCallbacks(callbacks);
    }

    @Provides
    @Debug
    @Singleton
    Logger debugLogger() {
        return new ConsoleLogger(1);
    }
}