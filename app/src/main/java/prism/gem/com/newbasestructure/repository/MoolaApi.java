package prism.gem.com.newbasestructure.repository;

import io.reactivex.Single;
import prism.gem.com.newbasestructure.dto.LoginInfoDTO;
import prism.gem.com.newbasestructure.dto.MoolaCustomerDTO;
import prism.gem.com.newbasestructure.dto.ResponseDTO;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by binhtv on 8/15/2017.
 */

public interface MoolaApi
{
    String HTTPS_MOOLA_BASE_API = "https://dl.gemvietnam.com:8022/";

    @GET("/authentication-2.0.0/version/check")
    Single<ResponseDTO<String>> checkVersion(@Query("os") String os, @Query("version") String version);

    @POST("/authentication-2.0.0/login/loginAsCustomer")
    Single<ResponseDTO<MoolaCustomerDTO>> login(@Body LoginInfoDTO loginInfoDTO);
}