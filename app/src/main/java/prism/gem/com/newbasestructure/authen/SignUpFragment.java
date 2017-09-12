package prism.gem.com.newbasestructure.authen;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import prism.gem.com.newbasestructure.R;
import prism.gem.com.newbasestructure.common.BaseFragment;

import java.util.List;

/**
 * User: khangpv
 * Date: 01/09/2017
 */

public class SignUpFragment extends BaseFragment<ISwitchSignUpSignIn> implements Validator.ValidationListener
{
    public static final String FLAG = "SignUpFragment";

    @NotEmpty(messageResId = R.string.common_emailRequire)
    @Email(messageResId = R.string.common_invalidEmail)
    @BindView(R.id.etSignUpEmail) EditText etEmail;

    @Password
    @NotEmpty(messageResId = R.string.common_passwordRequire)
    @BindView(R.id.etSignUpPass) EditText etPassword;

    SignUpViewModel signUpViewModel;
    Validator validator;

    @Override
    public void afterView()
    {
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.tvSignIn)
    void clickSignIn()
    {
        callBack.switchToSignIn();
    }

    @OnClick(R.id.sign_up_customer_btSignUp)
    void doSignUpCustomer()
    {
        validator.validate();
    }

    @Override
    public int getLayout()
    {
        return R.layout.sign_up_layout;
    }




    @Override
    public void onValidationSucceeded()
    {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors)
    {

    }
}
