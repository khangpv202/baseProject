package prism.gem.com.newbasestructure.common;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import prism.gem.com.newbasestructure.R;
import prism.gem.com.newbasestructure.utils.LogUtils;

/**
 * Created by khangpv on 8/21/2017.
 */

public abstract class BaseActivity extends LifecycleActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        LogUtils.errorLog(this,"current screen: "+this.getClass().getSimpleName());
        afterView();
    }

    public abstract void afterView();

    public abstract int getLayout();

    @Override
    public void onBackPressed()
    {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0)
        {
            super.onBackPressed();
            overridePendingTransition(R.anim.pull_in_left, R.anim.pull_out_right);
        }
        else
        {
            getSupportFragmentManager().popBackStack();
        }

    }

}
