package com.leminhtuan.mvc_mvvm.services.user;

import android.os.AsyncTask;
import android.util.Log;

import com.leminhtuan.mvc_mvvm.api.NodeAPI;
import com.leminhtuan.mvc_mvvm.components.ConnectionComponent;
import com.leminhtuan.mvc_mvvm.components.DaggerConnectionComponent;
import com.leminhtuan.mvc_mvvm.connection.Connection;
import com.leminhtuan.mvc_mvvm.models.User;
import com.leminhtuan.mvc_mvvm.modules.ConnectionModule;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginService{
    private static ConnectionComponent connectionComponent = DaggerConnectionComponent.builder()
            .connectionModule(new ConnectionModule()).build();
    private static Connection connection = connectionComponent.provideConnection();
    private static NodeAPI nodeAPI = connection.getConnectNodeAPI();

    public static void perform(Callback<User> callback) {
        Call<User> call = nodeAPI.get("android");
        call.enqueue(callback);
    }
}
