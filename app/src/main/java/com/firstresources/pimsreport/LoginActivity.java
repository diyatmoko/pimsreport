package com.firstresources.pimsreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firstresources.pimsreport.helper.DBHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 17/05/2019
 */
public class LoginActivity extends AppCompatActivity {

    private DBHelper dbHelper;

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
        initViews();
    }

    private void initViews(){
        ButterKnife.bind(this);
        dbHelper = new DBHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String message = dbHelper.validateLogin(txtUserID.getText().toString(),
                            txtPassword.getText().toString());

                    if (message.equals("0") || message == "0") {
                        message = "User tidak ada!";
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                    } else {
                        message = "Login berhasil!";
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                        intent.putExtra("userid", message);
                        startActivity(intent);
                        finish();
                    }

                } catch (Exception ex) {
                    Toast.makeText(LoginActivity.this, ex.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
