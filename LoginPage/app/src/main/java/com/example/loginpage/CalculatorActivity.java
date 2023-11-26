package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    Button multiply_btn;
    Button divide_btn;
    Button sum_btn;
    Button minus_btn;
    Button equal_btn;
    Button clear_btn;

    Button n0_btn;
    Button n1_btn;
    Button n2_btn;
    Button n3_btn;
    Button n4_btn;
    Button n5_btn;
    Button n6_btn;
    Button n7_btn;
    Button n8_btn;
    Button n9_btn;

    TextView Show_numbers;
    TextView History_numbers;

    String number_show;
    String number_history;
    ArrayList<BigInteger> each_number = new ArrayList<BigInteger>();
    ArrayList<String> operator_cam = new ArrayList<String>();
    BigInteger result;
    BigInteger second;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = BigInteger.valueOf(0);
        second = BigInteger.valueOf(0);

        number_show = "";
        number_history = "";

         n0_btn = (Button) findViewById(R.id.n0_btn);
         n1_btn = (Button) findViewById(R.id.n1_btn);
         n2_btn = (Button) findViewById(R.id.n2_btn);
         n3_btn = (Button) findViewById(R.id.n3_btn);
         n4_btn = (Button) findViewById(R.id.n4_btn);
         n5_btn = (Button) findViewById(R.id.n5_btn);
         n6_btn = (Button) findViewById(R.id.n6_btn);
         n7_btn = (Button) findViewById(R.id.n7_btn);
         n8_btn = (Button) findViewById(R.id.n8_btn);
         n9_btn = (Button) findViewById(R.id.n9_btn);

        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        sum_btn = (Button) findViewById(R.id.sum_btn);
        minus_btn = (Button) findViewById(R.id.minus_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        clear_btn = (Button) findViewById(R.id.clear_btn);

        Show_numbers = (TextView) findViewById(R.id.Show_numbers);
        History_numbers = (TextView) findViewById(R.id.history_numbers);

        Intent get_user_type =getIntent();
        String user_type = get_user_type.getStringExtra("user_type");
        Toast.makeText(CalculatorActivity.this, user_type, Toast.LENGTH_LONG).show();
        if (user_type.toString().equals("user"))
        {
            multiply_btn.setEnabled(false);
            divide_btn.setEnabled(false);
        }

        operator_cam.add("+");

        n0_btn.setOnClickListener(v -> {
            number_show += "0";
            number_history += "0";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n1_btn.setOnClickListener(v -> {
            number_show += "1";
            number_history += "1";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n2_btn.setOnClickListener(v -> {
            number_show += "2";
            number_history += "2";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n3_btn.setOnClickListener(v -> {
            number_show += "3";
            number_history += "3";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n4_btn.setOnClickListener(v -> {
            number_show += "4";
            number_history += "4";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n5_btn.setOnClickListener(v -> {
            number_show += "5";
            number_history += "5";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n6_btn.setOnClickListener(v -> {
            number_show += "6";
            number_history += "6";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n7_btn.setOnClickListener(v -> {
            number_show += "7";
            number_history += "7";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n8_btn.setOnClickListener(v -> {
            number_show += "8";
            number_history += "8";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });
        n9_btn.setOnClickListener(v -> {
            number_show += "9";
            number_history += "9";
            Show_numbers.setText(number_show.toString());
            History_numbers.setText(number_history.toString());
        });

        multiply_btn.setOnClickListener(v -> {
            BigInteger number = new BigInteger(number_show);
                each_number.add(number);
            number_show = "";
            number_history += "*";
            History_numbers.setText(number_history.toString());
            operator_cam.add("*");
        });
        divide_btn.setOnClickListener(v -> {
            BigInteger number = new BigInteger(number_show);
                each_number.add(number);
            number_show = "";
            number_history += "/";
            History_numbers.setText(number_history.toString());
            operator_cam.add("/");
        });
        sum_btn.setOnClickListener(v -> {
            BigInteger number = new BigInteger(number_show);
                each_number.add(number);
            number_show = "";
            number_history += "+";
            History_numbers.setText(number_history.toString());
            operator_cam.add("+");
        });
        minus_btn.setOnClickListener(v -> {
            BigInteger number = new BigInteger(number_show);
                each_number.add(number);
            number_show = "";
            number_history += "-";
            History_numbers.setText(number_history.toString());
            operator_cam.add("-");
        });
        equal_btn.setOnClickListener(v -> {
            BigInteger number = new BigInteger(number_show);
            each_number.add(number);
            number_show = "";
            result = each_number.get(0);
            for (int i = 1; i < each_number.size(); i++) {
                second = each_number.get(i);
                for (String operator : operator_cam) {
                    if (operator == "*") {
                        result = result.multiply(second);
                        Show_numbers.setText(result.toString());
                        break;
                    }
                    if (operator == "/") {
                        result = result.divide(second);
                        Show_numbers.setText(result.toString());
                        break;
                    }
                    if (operator == "+") {
                        result = result.add(second);
                        Show_numbers.setText(result.toString());
                        break;
                    }
                    if (operator == "-") {
                        result = result.min(second);
                        Show_numbers.setText(result.toString());
                        break;
                    }
                }
            }
            number_history = "";
            History_numbers.setText("");
        });
        clear_btn.setOnClickListener(v -> {
            number_show = "";
            each_number.clear();
            operator_cam.clear();
            Show_numbers.setText("");
            number_history = "";
            History_numbers.setText("");
        });

    }
}