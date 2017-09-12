package prism.gem.com.newbasestructure.common;

import android.content.Context;
import android.util.Log;
import org.apache.commons.lang3.StringUtils;
import prism.gem.com.newbasestructure.dto.MessageKey;
import prism.gem.com.newbasestructure.dto.ResponseDTO;
import prism.gem.com.newbasestructure.utils.LogUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by binhtv on 8/18/2017.
 */

public class HandlerException
{
    public static ResponseDTO handlerNetworkException(Throwable throwable)
    {
        LogUtils.errorLog(HandlerException.class, Log.getStackTraceString(throwable));
        ResponseDTO responseDTO = new ResponseDTO();
        if (throwable instanceof SocketTimeoutException)
        {
            responseDTO.setMessageKey(MessageKey.TIME_OUT_EXCEPTION);
        }
        else if (throwable instanceof UnknownHostException || throwable instanceof ConnectException)
        {
            responseDTO.setMessageKey(MessageKey.NO_INTERNET_EXCEPTION);
        }
        else
        {
            responseDTO.setMessageKey(MessageKey.UNKNOWN_EXCEPTION);
        }
        return responseDTO;
    }

}
