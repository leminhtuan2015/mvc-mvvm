package com.leminhtuan.mvc_mvvm.flagments.users;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import com.leminhtuan.mvc_mvvm.R;
import com.leminhtuan.mvc_mvvm.controllers.MainActivity;
import com.leminhtuan.mvc_mvvm.controllers.UserActivity;
import com.leminhtuan.mvc_mvvm.models.User;
import com.leminhtuan.mvc_mvvm.utility.Constant;


public class ShowFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.users_show, container, false);
        User user = (User) getArguments().getSerializable(Constant.OBJECT);
        updateView(view, user);
        setAction(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void updateView(View view, User user){
        ((TextView)view.findViewById(R.id.user_show_textview)).setText("Hello :" + user.getName());
    }

    private void setAction(final View view){
        TextView logoutTextView = (TextView) view.findViewById(R.id.logout);

        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(Constant.EXIT_MESSAGE)
                        .setCancelable(false)
                        .setPositiveButton(Constant.YES, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent mainIntent = new Intent(view.getContext(), MainActivity.class);
                                startActivity(mainIntent);
                            }
                        })
                        .setNegativeButton(Constant.NO, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
