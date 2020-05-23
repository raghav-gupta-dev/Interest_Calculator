package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button hide;

    public void click( View view){

        hide=findViewById(R.id.Calc);
        getWindow().getDecorView().getRootView().getWindowToken();

        EditText editText= findViewById(R.id.Premium);
        String X = editText.getText().toString();
        double x =Double.parseDouble(X);

        editText=findViewById(R.id.Sum);
        X=editText.getText().toString();
        double b =Double.parseDouble(X);

        double ratio=  b/x;

        editText=findViewById(R.id.pre_num);
        X=editText.getText().toString();
        double n =Double.parseDouble(X);

        editText=findViewById(R.id.Time);
        X=editText.getText().toString();
        double t =Double.parseDouble(X);

        double m =t-n+1;


        double rate =0;

        double y=0 , Y=0 ;
        Log.i("info","button pressed");
        if(n==1){
            while (y < ratio) {
                rate += 1;
                y = Math.pow((1 + (rate / 40000)), 4*t);
            }
        }
        else if((m!=1)&&(m+n!=1)) {
            while (Y < ratio) {
                rate += 1;
                y = Math.pow((1 + (rate / 40000)), 4);
                Y = (Math.pow(y, m+n) - Math.pow(y, m));
                Y = Y / ((y) - 1);
                //Log.i("info","loop executed");
            }
        }
        else if((m+n!=1)) {
            while (Y < ratio) {
                rate += 1;
                y = Math.pow((1 + (rate / 40000)), 4);
                Y = (Math.pow(y, m+n) - y);
                Y = Y / ((y) - 1);
            }
        }
        else {
            while (y < ratio) {
                rate += 1;
                y = Math.pow((1 + (rate / 40000)), 4);
            }
        }
        Log.i("info","loop executed");
        rate/=100;

        editText=findViewById(R.id.interest);
        X=Double.toString(rate);
        X= "interest compounded quarterly = " + X+"%";
        editText.setText(X);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
