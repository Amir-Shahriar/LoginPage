package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayActivity extends AppCompatActivity {

    ArrayList<String> input_array = new ArrayList<String>();

    EditText Array_Enter;
    TextView Array_Show;
    Button Add_Btn;
    String Txt_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        Array_Enter = (EditText) findViewById(R.id.Array_Enter);
        Array_Show = (TextView) findViewById(R.id.Array_Show);
        Add_Btn = (Button) findViewById(R.id.Add_Btn);
        Txt_Result = "";

        Intent get_user_type =getIntent();
        String user_type = get_user_type.getStringExtra("user_type");
        Toast.makeText(ArrayActivity.this, user_type, Toast.LENGTH_LONG).show();

        Add_Btn.setOnClickListener(v -> {
            input_array.add(Array_Enter.getText().toString());

            for (String show : input_array)
            {
                Txt_Result += show + "*";
            }
            Array_Show.setText(Txt_Result.toString());
            Txt_Result = "";
        });
    }
}