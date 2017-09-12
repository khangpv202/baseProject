package prism.gem.com.newbasestructure;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import prism.gem.com.newbasestructure.common.SharedPrefsHelper;
import prism.gem.com.newbasestructure.common.UserHolder;

import javax.inject.Inject;
import java.util.Locale;

/**
 * Created by binhtv on 8/15/2017.
 */

public class MoolaApplication extends Application
{
    private AppComponent appComponent;
    @Inject UserHolder userHolder;
    @Inject SharedPrefsHelper sharedPrefsHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this)
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
        Locale myLocale = new Locale(userHolder.getLocalCurrent());
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        Locale.setDefault(myLocale);
        res.updateConfiguration(conf, dm);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    public AppComponent getAppComponent()
    {
        return appComponent;
    }
}
