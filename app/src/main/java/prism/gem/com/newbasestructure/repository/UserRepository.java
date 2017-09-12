package prism.gem.com.newbasestructure.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import prism.gem.com.newbasestructure.common.DTOUtils;
import prism.gem.com.newbasestructure.common.HandlerException;
import prism.gem.com.newbasestructure.common.UserHolder;
import prism.gem.com.newbasestructure.db.MoolaDb;
import prism.gem.com.newbasestructure.dto.LoginInfoDTO;
import prism.gem.com.newbasestructure.dto.MoolaCustomerDTO;
import prism.gem.com.newbasestructure.dto.ResponseDTO;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by binhtv on 8/15/2017.
 */

@Singleton
public class UserRepository
{
    private final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    MoolaApi moolaApi;
    Gson gson;
    UserHolder userHolder;
    MoolaDb moolaDb;
    Application application;

    @Inject
    public UserRepository(Application application, MoolaApi moolaApi, Gson gson, UserHolder userHolder, MoolaDb moolaDb/*, MoolaUserDAO moolaUserDAO*/)
    {
        this.application = application;
        this.moolaApi = moolaApi;
        this.gson = gson;
        this.userHolder = userHolder;
        this.moolaDb = moolaDb;
    }

    public LiveData<ResponseDTO<MoolaCustomerDTO>> doLogin(LoginInfoDTO loginInfoDTO)
    {
        final MutableLiveData<ResponseDTO<MoolaCustomerDTO>> data = new MutableLiveData<>();
        moolaApi.login(loginInfoDTO).subscribeOn(Schedulers.io())
                .subscribeOn(new ComputationScheduler())
                .subscribe(new SingleObserver<ResponseDTO<MoolaCustomerDTO>>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {

                    }

                    @Override
                    public void onSuccess(ResponseDTO<MoolaCustomerDTO> responseDTO)
                    {
                        if (DTOUtils.isSuccess(responseDTO))
                        {
                            MoolaCustomerDTO moolaCustomerDTO = responseDTO.getResult();
//                        moolaCustomerDTO.createEntity(moolaDb);
                        }
                        data.postValue(responseDTO);
                    }

                    @Override
                    public void onError(Throwable throwable)
                    {
                        data.postValue(HandlerException.handlerNetworkException(throwable));
                    }
                });
        return data;
    }


    public String getBaseImageUrl()
    {
        return userHolder.getBaseImageUrl();
    }
}
