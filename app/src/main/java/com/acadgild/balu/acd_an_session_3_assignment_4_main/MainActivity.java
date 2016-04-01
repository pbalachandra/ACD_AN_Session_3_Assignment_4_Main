package com.acadgild.balu.acd_an_session_3_assignment_4_main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText et_email, et_password;
    Button btn_login;
    TextView tv_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email = (EditText) findViewById(R.id.editText_email);
        et_password = (EditText) findViewById(R.id.editText_password);
        btn_login = (Button) findViewById(R.id.button_login);
        tv_signup = (TextView) findViewById(R.id.textView_signup);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (TextUtils.isEmpty(et_email.getText().toString())) {
            et_email.setError(getResources().getString(R.string.blank_email));
            Toast.makeText(this, getResources().getString(R.string.blank_email), Toast.LENGTH_LONG).show();
        }
        else if (!(Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches()))
        {
            et_email.setError(getResources().getString(R.string.invalid_email));
            Toast.makeText(this, getResources().getString(R.string.invalid_email),Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(et_password.getText().toString()))
        {
            et_password.setError(getResources().getString(R.string.blank_password));
            Toast.makeText(this, getResources().getString(R.string.blank_password), Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, getResources().getString(R.string.login_successful), Toast.LENGTH_LONG).show();
    }

}
