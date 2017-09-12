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
import prism.gem.com.newbasestructure.db.MoolaDb;
import prism.gem.com.newbasestructure.repository.LogJsonInterceptor;
import prism.gem.com.newbasestructure.repository.MoolaApi;
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
    MoolaApi provideMoolaApi(UserHolder userHolder)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new LogJsonInterceptor(userHolder));
        return new Retrofit.Builder()
                .baseUrl(MoolaApi.HTTPS_MOOLA_BASE_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(MoolaApi.class);
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
    MoolaDb getMoolaDb()
    {
        MoolaDb db = Room
                .databaseBuilder(mApplication, MoolaDb.class, "moola_db")
                .build();
        return db;
    }

}
