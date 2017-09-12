package prism.gem.com.newbasestructure.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import org.apache.commons.lang3.StringUtils;
import prism.gem.com.newbasestructure.BuildConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Central log utils, intend to replace all normal log.* in our application.
 * This support content empty as default.
 * <p/>
 * MoolaUser: lent
 * Date: 10/16/13
 */
public class LogUtils
{
// ------------------------------ FIELDS ------------------------------

    public static final String PREFIX_TAG = "PRISM_";
    public static boolean isDebugLogEnabled = BuildConfig.DEBUG;

// -------------------------- STATIC METHODS --------------------------

    public static void debugLog(final Object target, final String content)
    {
        if (isDebugLogEnabled)
        {
            Log.d(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
        }
    }

    public static void debugLog(final Class targetType, final String content)
    {
        if (isDebugLogEnabled)
        {
            Log.d(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
        }
    }


    public static void debugLog(final Object target, final String content, Throwable throwable)
    {
        if (isDebugLogEnabled)
        {
            Log.d(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
        }
    }

    public static void debugLog(final Class targetType, final String content, final Throwable throwable)
    {
        if (isDebugLogEnabled)
        {
            Log.d(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
        }
    }

    public static void infoLog(final Object target, final String content)
    {
        Log.i(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
    }

    public static void infoLog(final Class targetType, final String content)
    {
        Log.i(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
    }

    public static void infoLog(final Object target, final String content, Throwable throwable)
    {
        Log.i(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
    }

    public static void infoLog(final Class targetType, final String content, final Throwable throwable)
    {
        Log.i(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
    }

    public static void errorLog(final Object target, final String content)
    {
        Log.e(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
    }

    public static void errorLog(final Class targetType, final String content)
    {
        Log.e(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
    }

    public static void errorLog(final Object target, final String content, Throwable throwable)
    {
        Log.e(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
    }

    public static void errorLog(final Class targetType, final String content, final Throwable throwable)
    {
        Log.e(PREFIX_TAG + targetType.getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content, throwable);
    }

    public static void logStackTrace(Object o, final Exception object)
    {
        StackTraceElement[] stackTraceElements = object.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("++ Load Model Error ++");
        stringBuilder.append("\n" + object.getMessage());
        for (int i = 0; i < stackTraceElements.length; i++)
        {
            StackTraceElement stackTraceElement = stackTraceElements[i];
            stringBuilder.append("\n" + stackTraceElement.getFileName() + " " + stackTraceElement.getMethodName() + " " + stackTraceElement.getLineNumber());
        }
        stringBuilder.append("\n ------------The End Error ------");
        Log.e(PREFIX_TAG + object.getClass().getSimpleName(), stringBuilder.toString());
        logUserAction(o, stringBuilder.toString(), null);
    }

    public static void logUserAction(Object nameOfFragment, String idOfAction, Context context)
    {
        if (isDebugLogEnabled)
        {
            String mPath = Environment.getExternalStorageDirectory().toString() + "/moola/" + "log/";
            File file = new File(mPath);
            mPath = mPath + "log.txt";
            if (!file.exists())
            {
                file.mkdirs();
            }
            try
            {
                File file1 = new File(mPath);
                FileWriter fileWriter = new FileWriter(file1, true);

                BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);

                fileWriter.append(nameOfFragment.getClass().getSimpleName() + "---- " + idOfAction + " ----" + (context != null ? getCurrentMemory(context) : "") + "\n<br>");
                bufferFileWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                //exception handling left as an exercise for the reader
            }
        }
    }

    private static String getCurrentMemory(Context activity)
    {
        ActivityManager activityManager = (ActivityManager) activity.getSystemService(Activity.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(mi);
        //available memory, isLowMemory, threshold memory, totalMemory
        String value = "current_memory: " + (mi.availMem / 1048576) + "/" + mi.lowMemory + "/" + (mi.threshold / 1048576) + "/" + (mi.totalMem / 1048576);
        return value;
    }
}
