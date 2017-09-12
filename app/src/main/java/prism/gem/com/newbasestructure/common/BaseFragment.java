package prism.gem.com.newbasestructure.common;

import android.arch.lifecycle.LifecycleFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import prism.gem.com.newbasestructure.BaseCallBack;

/**
 * Created by khangpv on 8/22/2017.
 */

public abstract class BaseFragment<T> extends LifecycleFragment
{
    public T callBack;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof BaseCallBack)
        {
            callBack = (T) context;
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        callBack = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        afterView();
    }

    public void onBackPressed()
    {
        getActivity().onBackPressed();
    }

    public abstract void afterView();

    public abstract int getLayout();
}
