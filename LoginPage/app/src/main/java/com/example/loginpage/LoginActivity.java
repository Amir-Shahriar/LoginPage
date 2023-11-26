package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.vdx.designertoast.DesignerToast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText Username = (EditText) findViewById(R.id.etxt_UserName);
        EditText Password = (EditText) findViewById(R.id.etxt_Password);
        TextView switch_page_si = (TextView) findViewById(R.id.txtv_SignupTitle);
        Button Login_btn = (Button) findViewById(R.id.Login_btn);

        Login_btn.setOnClickListener(v -> {
            if (Username.getText().toString().equals("Admin") && Password.getText().toString().equals("1234"))
            {
                DesignerToast.Success(LoginActivity.this, "Success",
                       "Welcome admin",Gravity.CENTER, Toast.LENGTH_SHORT,DesignerToast.STYLE_DARK);
                Intent intent=new Intent(LoginActivity.this,CalculatorActivity.class);
                intent.putExtra("user_type", Username.getText().toString());
                startActivity(intent);
            }
            else if (Username.getText().toString().equals("user") && Password.getText().toString().equals("4567"))
            {DesignerToast.Success(LoginActivity.this, "Success",
                        "Welcome user",Gravity.CENTER, Toast.LENGTH_SHORT,DesignerToast.STYLE_DARK);
                Intent intent=new Intent(LoginActivity.this, CalculatorActivity.class);
                intent.putExtra("user_type", Username.getText().toString());
                startActivity(intent);
            }
            else if (Username.getText().toString().equals("guest") && Password.getText().toString().equals("789"))
            {

                DesignerToast.Success(LoginActivity.this, "Success",
                        "Welcome guest",Gravity.CENTER, Toast.LENGTH_SHORT,DesignerToast.STYLE_DARK);
                Intent intent=new Intent(LoginActivity.this,ArrayActivity.class);
                intent.putExtra("user_type", Username.getText().toString());
                startActivity(intent);
            }
            else DesignerToast.Warning(LoginActivity.this, "Warning",
                        "your Username or Password is incorrect",Gravity.CENTER, Toast.LENGTH_SHORT,DesignerToast.STYLE_DARK);
        });

        switch_page_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        // do nothing to disable the back button
    }
}