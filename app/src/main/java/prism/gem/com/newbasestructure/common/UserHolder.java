package prism.gem.com.newbasestructure.common;

import android.content.Context;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by khangpv on 8/16/2017.
 */

@Singleton
public class UserHolder
{
    private static final String TOKEN_KEY = "user_token";
    private static final String ACTIVE_USER_ID = "user_id";
    private static final String VERSION_KEY = "version_key";
    private static final String BASE_IMAGE_URL_KEY = "base_url_key";

    private Context context;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public UserHolder(Context context, SharedPrefsHelper sharedPrefsHelper)
    {
        this.context = context;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }


    public void setVersion(String version)
    {
        sharedPrefsHelper.put(VERSION_KEY, version);
    }

    public String getVersion()
    {
        String version = sharedPrefsHelper.get(VERSION_KEY);

        return StringUtils.isEmpty(version) ? ("-0") : sharedPrefsHelper.get(VERSION_KEY);
    }

    public String getToken()
    {
        return sharedPrefsHelper.get(TOKEN_KEY);
    }

    public String getActiveUserId()
    {
        return sharedPrefsHelper.get(ACTIVE_USER_ID);
    }

    public void setLocalCurrent(String localCurrent)
    {
        sharedPrefsHelper.put(SharedPrefsHelper.LOCAL_CURRENT + "-" + getActiveUserId(), localCurrent);
    }

    public String getLocalCurrent()
    {
        return sharedPrefsHelper.get(SharedPrefsHelper.LOCAL_CURRENT + "-" + getActiveUserId(), "en");
    }

    public void setBaseImageUrl(String baseImageUrl)
    {
        sharedPrefsHelper.put(BASE_IMAGE_URL_KEY, baseImageUrl);
    }

    public String getBaseImageUrl()
    {
        return sharedPrefsHelper.get(BASE_IMAGE_URL_KEY);
    }
}
