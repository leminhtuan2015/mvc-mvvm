package com.leminhtuan.mvc_mvvm.connection;

import com.leminhtuan.mvc_mvvm.api.NodeAPI;

import javax.inject.Inject;
import retrofit.Retrofit;

public class Connection {

    private Retrofit retrofit;

    @Inject
    public Connection(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public Retrofit getConnect(){
      return retrofit;
    }

    public NodeAPI getConnectNodeAPI(){
      return retrofit.create(NodeAPI.class);
    }
}
