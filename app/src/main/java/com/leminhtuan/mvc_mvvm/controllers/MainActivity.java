package com.leminhtuan.mvc_mvvm.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.leminhtuan.mvc_mvvm.R;
import com.leminhtuan.mvc_mvvm.api.NodeAPI;
import com.leminhtuan.mvc_mvvm.components.ConnectionComponent;
import com.leminhtuan.mvc_mvvm.components.DaggerConnectionComponent;
import com.leminhtuan.mvc_mvvm.connection.Connection;
import com.leminhtuan.mvc_mvvm.models.User;
import com.leminhtuan.mvc_mvvm.modules.ConnectionModule;
import com.leminhtuan.mvc_mvvm.services.user.LoginService;
import com.leminhtuan.mvc_mvvm.utility.Constant;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void usersLogin(View view) {
        LoginService.perform(loginCallback);
    }

    public void usersRegister(View view) {
        Intent userIntent = new Intent(this, UserActivity.class);
        userIntent.putExtra(Constant.MESSAGE, Constant.MESSAGE_REGISTER);
        startActivity(userIntent);
    }

    private Callback<User> loginCallback = new Callback<User>(){
        @Override
        public void onResponse(Response<User> response, Retrofit retrofit) {
            User userResponse = response.body();
            String userName = ((EditText) findViewById(R.id.user_login_username)).getText().toString();
            String userPassword = ((EditText) findViewById(R.id.user_login_password)).getText().toString();
            User userLogin = new User("", userName, userPassword);

            if(userResponse.getName().equals(userLogin.getName()) && userLogin.getPassword().equals("123")){
                Intent userIntent = new Intent(MainActivity.this, UserActivity.class);
                userIntent.putExtra(Constant.MESSAGE, Constant.MESSAGE_SHOW);
                userIntent.putExtra(Constant.OBJECT, userLogin);
                startActivity(userIntent);
            }else{
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, Constant.LOGIN_FAIL, Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d("id", "eeeeeeeeeeeee");
        }
    };
}
