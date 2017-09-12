package prism.gem.com.newbasestructure;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import prism.gem.com.newbasestructure.common.SharedPrefsHelper;
import prism.gem.com.newbasestructure.common.UserHolder;
import prism.gem.com.newbasestructure.db.MyDatabase;
import prism.gem.com.newbasestructure.repository.LogJsonInterceptor;
import prism.gem.com.newbasestructure.repository.AppAPI;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class AppModule
{

    private Application mApplication;

    public AppModule(Application app)
    {
        mApplication = app;
    }

    @Provides
    Context provideContext()
    {
        return mApplication;
    }

    @Singleton
    @Provides
    AppAPI provideMoolaApi(UserHolder userHolder)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new LogJsonInterceptor(userHolder));
        return new Retrofit.Builder()
                .baseUrl(AppAPI.HTTPS_BASE_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(AppAPI.class);
    }

    @Singleton
    @Provides
    Gson provideGson()
    {
        return new Gson();
    }

    @Provides
    SharedPreferences provideSharedPrefs()
    {
        return mApplication.getSharedPreferences(SharedPrefsHelper.PREF_KEY, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    MyDatabase getMoolaDb()
    {
        MyDatabase db = Room
                .databaseBuilder(mApplication, MyDatabase.class, "moola_db")
                .build();
        return db;
    }

}
