package prism.gem.com.newbasestructure;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import prism.gem.com.newbasestructure.authen.SignInViewModel;
import prism.gem.com.newbasestructure.authen.SignUpViewModel;

import javax.inject.Singleton;

/**
 * Created by binhtv on 8/15/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);

        Builder appModule(AppModule appModule);

        AppComponent build();
    }


    void inject(SignUpViewModel signUpViewModel);

    void inject(SignInViewModel signInViewModel);

    void inject(MoolaApplication moolaApplication);
}
