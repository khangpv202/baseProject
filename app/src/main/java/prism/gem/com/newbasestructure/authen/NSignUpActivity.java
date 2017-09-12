package prism.gem.com.newbasestructure.authen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import prism.gem.com.newbasestructure.R;
import prism.gem.com.newbasestructure.common.BaseActivity;

/**
 * User: khangpv
 * Date: 01/09/2017
 */

public class NSignUpActivity extends BaseActivity implements ISwitchSignUpSignIn
{
    @Override
    public void afterView()
    {
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(SignInFragment.FLAG);
        if (fragmentByTag == null)
        {
            fragmentByTag = new SignInFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frContainer, fragmentByTag, SignInFragment.FLAG).commit();
        }
    }

    @Override
    public int getLayout()
    {
        return R.layout.n_signup_activity;
    }

    @Override
    public void switchToSignUp()
    {
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(SignUpFragment.FLAG);
        if (fragmentByTag == null)
        {
            fragmentByTag = new SignUpFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frContainer, fragmentByTag, SignUpFragment.FLAG)
                    .addToBackStack(SignUpFragment.FLAG)
                    .commit();
        }
    }

    @Override
    public void switchToSignIn()
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStackImmediate();
    }
}
