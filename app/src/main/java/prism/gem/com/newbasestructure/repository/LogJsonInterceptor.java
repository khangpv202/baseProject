package prism.gem.com.newbasestructure.repository;

import android.util.Log;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import prism.gem.com.newbasestructure.common.UserHolder;

import java.io.IOException;

/**
 * Created by admin on 8/16/2017.
 */

public class LogJsonInterceptor implements Interceptor
{
    UserHolder userHolder;

    public LogJsonInterceptor(UserHolder userHolder)
    {
        this.userHolder = userHolder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException
    {
        Request original = chain.request();
        Request request;
        if (StringUtils.isEmpty(userHolder.getToken()))
        {
            request = original;
        }
        else
        {
            request = original.newBuilder()
                    .addHeader("X-Authorization", userHolder.getToken())
                    .build();
        }

        Response response = chain.proceed(request);
        String rawJson = response.body().string();

        Log.d("response info", String.format("raw JSON response is: %s", rawJson));

        // Re-create the response before returning it because body can be read only once
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), rawJson)).build();
    }


}
