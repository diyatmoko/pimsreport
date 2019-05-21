package com.firstresources.pimsreport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 17/05/2019
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txtUserID)
    TextInputEditText txtUserID;
    @BindView(R.id.txtPassword)
    TextInputEditText txtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }
}
