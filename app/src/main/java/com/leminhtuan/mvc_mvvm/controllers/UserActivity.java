package com.leminhtuan.mvc_mvvm.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.leminhtuan.mvc_mvvm.R;
import com.leminhtuan.mvc_mvvm.api.NodeAPI;
import com.leminhtuan.mvc_mvvm.components.ConnectionComponent;
import com.leminhtuan.mvc_mvvm.components.DaggerConnectionComponent;
import com.leminhtuan.mvc_mvvm.connection.Connection;
import com.leminhtuan.mvc_mvvm.flagments.users.RegisterFragment;
import com.leminhtuan.mvc_mvvm.flagments.users.ShowFragment;
import com.leminhtuan.mvc_mvvm.models.User;
import com.leminhtuan.mvc_mvvm.modules.ConnectionModule;
import com.leminhtuan.mvc_mvvm.utility.Constant;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class UserActivity extends AppCompatActivity {

    private RegisterFragment registerFragment = new RegisterFragment();
    private ShowFragment showFragment = new ShowFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Constant.MESSAGE);
        User user = (User) intent.getSerializableExtra(Constant.OBJECT);
        setContentView(R.layout.users_flagment);
        setFragment(message, user);
    }

    private void setFragment(String message, User user){
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(message.equals(Constant.MESSAGE_SHOW)){
            Bundle showFragmentArgs = new Bundle();
            showFragmentArgs.putSerializable(Constant.OBJECT, user);
            showFragment.setArguments(showFragmentArgs);
            fragmentTransaction.replace(R.id.users_fragment_container, showFragment);
        }else{
            fragmentTransaction.replace(R.id.users_fragment_container, registerFragment);
        }
        fragmentTransaction.commit();
    }
}
