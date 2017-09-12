package prism.gem.com.newbasestructure.authen;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import prism.gem.com.newbasestructure.R;
import prism.gem.com.newbasestructure.common.BaseFragment;
import prism.gem.com.newbasestructure.common.DTOUtils;
import prism.gem.com.newbasestructure.dto.LoginInfoDTO;
import prism.gem.com.newbasestructure.dto.MoolaCustomerDTO;
import prism.gem.com.newbasestructure.dto.ResponseDTO;

import java.util.List;

/**
 * User: khangpv
 * Date: 01/09/2017
 */

public class SignInFragment extends BaseFragment<ISwitchSignUpSignIn> implements Validator.ValidationListener
{
    public static final String FLAG = "SignInFragment";

    SignInViewModel signInViewModel;
    Validator validator;
    @NotEmpty(messageResId = R.string.common_emailRequire)
    @Email(messageResId = R.string.common_invalidEmail)
    @BindView(R.id.etEmail) EditText etEmail;

    @Password
    @NotEmpty(messageResId = R.string.common_passwordRequire)
    @BindView(R.id.etPassWord) EditText etPassword;

    @Override
    public void afterView()
    {
        signInViewModel = ViewModelProviders.of(this).get(SignInViewModel.class);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.tvSignUp)
    void clickSignUp()
    {
        callBack.switchToSignUp();
    }

    @OnClick(R.id.btSignIn)
    void onLoginClick()
    {
        validator.validate();
    }

    @Override
    public int getLayout()
    {
        return R.layout.login_layout;
    }

    @Override
    public void onValidationSucceeded()
    {
        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setEmail(etEmail.getText().toString().trim());
        loginInfoDTO.setPassword(etPassword.getText().toString().trim());
        loginInfoDTO.setImei(Build.SERIAL);
        loginInfoDTO.setDeviceName(Build.MODEL);
        signInViewModel.doLogin(loginInfoDTO).observe(this, new Observer<ResponseDTO<MoolaCustomerDTO>>()
        {
            @Override
            public void onChanged(@Nullable ResponseDTO<MoolaCustomerDTO> responseDTO)
            {
                if (DTOUtils.isSuccess(responseDTO))
                {
                    Toast.makeText(getActivity(),"login success",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(),"login fail",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors)
    {
        for (ValidationError error : errors)
        {
            Toast.makeText(getActivity(),"validate fail",Toast.LENGTH_SHORT).show();
            break;
        }
    }
}
