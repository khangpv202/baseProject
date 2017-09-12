package prism.gem.com.newbasestructure.authen;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import prism.gem.com.newbasestructure.BaseApplication;
import prism.gem.com.newbasestructure.common.UserHolder;
import prism.gem.com.newbasestructure.dto.LoginInfoDTO;
import prism.gem.com.newbasestructure.dto.MoolaCustomerDTO;
import prism.gem.com.newbasestructure.dto.ResponseDTO;
import prism.gem.com.newbasestructure.repository.UserRepository;

import javax.inject.Inject;

/**
 * User: khangpv
 * Date: 01/09/2017
 */

public class SignInViewModel extends AndroidViewModel
{
    @Inject
    UserRepository userRepository;
    @Inject UserHolder userHolder;

    public SignInViewModel(Application application)
    {
        super(application);
        ((BaseApplication) application).getAppComponent().inject(this);
    }
    public LiveData<ResponseDTO<MoolaCustomerDTO>> doLogin(LoginInfoDTO loginInfoDTO)
    {
        return userRepository.doLogin(loginInfoDTO);
    }


    public String getLocaleCurrent()
    {
        return userHolder.getLocalCurrent();
    }

    public boolean isEnglish()
    {
        return userHolder.getLocalCurrent().equals("en");
    }

    public String getVersion()
    {
        return userHolder.getVersion();
    }

}
