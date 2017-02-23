package com.wc.testnew;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by AndroidDeveloper on 2017/2/22/0022.
 *
 */

public class App extends Application {

    private RefWatcher watcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        watcher = LeakCanary.install(this);
    }

    public static RefWatcher getWatcher(Context context){
        App app = (App) context.getApplicationContext();
        return app.watcher;
    }
}
