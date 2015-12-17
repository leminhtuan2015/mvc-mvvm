package com.leminhtuan.mvc_mvvm.modules;

import com.leminhtuan.mvc_mvvm.connection.Connection;
import com.leminhtuan.mvc_mvvm.utility.Constant;

import javax.inject.Singleton;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import dagger.Module;
import dagger.Provides;

@Module
public class ConnectionModule {

    @Provides
    @Singleton
    Connection provideConnection(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return new Connection(retrofit);
    }
}
