package prism.gem.com.newbasestructure.authen;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import prism.gem.com.newbasestructure.MoolaApplication;
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

public class SignUpViewModel extends AndroidViewModel
{
    @Inject
    UserRepository userRepository;
    @Inject UserHolder userHolder;

    public SignUpViewModel(Application application)
    {
        super(application);
        ((MoolaApplication) application).getAppComponent().inject(this);
    }

    public LiveData<ResponseDTO<MoolaCustomerDTO>> doLogin(LoginInfoDTO loginInfoDTO)
    {
        return userRepository.doLogin(loginInfoDTO);
    }

    public String getLocalCurrent()
    {
        return userHolder.getLocalCurrent();
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
