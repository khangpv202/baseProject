package prism.gem.com.newbasestructure.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import prism.gem.com.newbasestructure.R;

/**
 * Created by khangpv on 8/21/2017.
 */

public class Navigator
{
    public static void startActivity(Activity context, Class target,String key, String value)
    {
        Intent starter = new Intent(context, target);
        Bundle mBundle = new Bundle();
        mBundle.putString(key,value);
        starter.putExtras(mBundle);
        context.startActivity(starter);
        context.overridePendingTransition(R.anim.pull_in_right, R.anim.pull_out_left);
    }
    public static void startActivity(Activity context, Class target)
    {
        Intent starter = new Intent(context, target);
        context.startActivity(starter);
        context.overridePendingTransition(R.anim.pull_in_right, R.anim.pull_out_left);
    }

    public static void startActivityAndFinish(Activity context, Class target)
    {
        Intent starter = new Intent(context, target);
        context.startActivity(starter);
        context.overridePendingTransition(R.anim.pull_in_right, R.anim.pull_out_left);
        context.finish();
    }

    public static void startActivityForResult(Activity context, Class target, int requestCode)
    {
        Intent starter = new Intent(context, target);
        context.startActivityForResult(starter, requestCode);
        context.overridePendingTransition(R.anim.pull_in_right, R.anim.pull_out_left);
    }
}
