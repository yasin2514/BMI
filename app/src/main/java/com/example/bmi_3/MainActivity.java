package com.example.bmi_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cal;
    private TextView height, weight, bmi, result, message;
    private EditText fweight, ffeet, finch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (Button) findViewById(R.id.Calculate);
        weight = (TextView) findViewById(R.id.textView_height);
        height = (TextView) findViewById(R.id.textView_weight);
        bmi = (TextView) findViewById(R.id.textView_bmi);
        result = (TextView) findViewById(R.id.textView_result);
        message = (TextView) findViewById(R.id.textView_message);
        fweight = (EditText) findViewById(R.id.editText_weight);
        ffeet = (EditText) findViewById(R.id.editText_feet);
        finch = (EditText) findViewById(R.id.editText_inch);
        cal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String number1 = fweight.getText().toString();
        String number2 = ffeet.getText().toString();
        String number3 = finch.getText().toString();

        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double num3 = Double.parseDouble(number3);
        double foot_meter = num2/3.2808;
        double inch_meter = num3/39.370;
        double final_meter = foot_meter+inch_meter;
        double final_result = num1/(final_meter*final_meter);
        String re = Double.toString(final_result);
        String firstfiveChars = "";
        if (re.length() > 5)
        {
            firstfiveChars = re.substring(0, 5);
        }
        else
        {
            firstfiveChars = re;
        }

        double d = Double.parseDouble(firstfiveChars);

        if(d < 18.5)
        {
            result.setTextColor(Color.RED);
            String r = Double.toString(d);
            result.setText(r);
            message.setText("Underweight");
            message.setTextColor(Color.RED);
        }

        if(d > 18.5 && d < 24.9)
        {
            result.setTextColor(Color.GREEN);
            String r = Double.toString(d);
            result.setText(r);
            message.setText("Healthy");
            message.setTextColor(Color.GREEN);
        }


        if(d > 25.0 && d < 29.9)
        {
            result.setTextColor(Color.YELLOW);
            String r = Double.toString(d);
            result.setText(r);
            message.setText("Overweight");
            message.setTextColor(Color.YELLOW);
        }

        if(d >30.0)
        {
            result.setTextColor(Color.RED);
            String r = Double.toString(d);
            result.setText(r);
            message.setText("Obese");
            message.setTextColor(Color.RED);
        }
    }
}
