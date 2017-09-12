package prism.gem.com.newbasestructure.common;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by binhtv on 8/16/2017.
 */

@Singleton
public class SharedPrefsHelper
{
    public static String PREF_KEY = "moola_customer_key";
    public static String USER_KEY = "active_user";
    public static String LOCAL_CURRENT = "local_current";

    private SharedPreferences sharedPreferences;

    @Inject
    public SharedPrefsHelper(SharedPreferences sharedPreferences)
    {
        this.sharedPreferences = sharedPreferences;
    }

    public void put(String key, String value)
    {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value)
    {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, float value)
    {
        sharedPreferences.edit().putFloat(key, value).apply();
    }

    public void put(String key, boolean value)
    {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key)
    {
        return get(key, "");
    }

    public String get(String key, String defaultValue)
    {
        return sharedPreferences.getString(key, defaultValue);
    }

    public Integer get(String key, int defaultValue)
    {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public Float get(String key, float defaultValue)
    {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue)
    {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key)
    {
        sharedPreferences.edit().remove(key).apply();
    }

    public void removeAllKey()
    {
        sharedPreferences.edit().clear().commit();
    }
}
