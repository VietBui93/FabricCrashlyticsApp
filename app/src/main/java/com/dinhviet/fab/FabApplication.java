package com.dinhviet.fab;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;

/**
 * Created by FRAMGIA\bui.dinh.viet on 26/04/2017.
 */

public class FabApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

    }
}
