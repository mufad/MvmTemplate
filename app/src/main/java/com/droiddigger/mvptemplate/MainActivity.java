package com.droiddigger.mvptemplate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements InfoContract.view {


    private EditText etEmail, etUsername;
    private Button btnShow;

    private InfoContract.presenter infoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoPresenter = new InfoPresenter(this, this);
        infoPresenter.initPresenter();
    }

    @Override
    public void initViews() {
        etEmail = findViewById(R.id.email);
        etUsername = findViewById(R.id.username);
        btnShow = findViewById(R.id.btn_show);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(etUsername.getText().toString(), etEmail.getText().toString());
                infoPresenter.acquireData(user);
            }
        });
    }


    @Override
    public void showData(String email, String username) {
        Toast.makeText(this, "Email: " + email + "User Name: " + username, Toast.LENGTH_SHORT).show();
    }
}
