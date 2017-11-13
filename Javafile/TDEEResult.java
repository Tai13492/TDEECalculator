package com.example.tai.TDEECalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TDEEResult extends AppCompatActivity {
    double bmi,bmr,tdee;
    int usertdee;
    TextView mybmi,mytdee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdeeresult);
        Intent intentextras = getIntent();
        Bundle extrabundles = intentextras.getExtras();
        bmi = extrabundles.getDouble("bmi");
        bmr = extrabundles.getDouble("bmr");
        tdee = extrabundles.getDouble("tdee");
        usertdee = (int) tdee;
        mybmi = (TextView) findViewById(R.id.textView_BMI);
        mytdee = (TextView) findViewById(R.id.textView_TDEE);
        Healthy user = new Healthy(bmi,bmr,usertdee);
        mybmi.setText(user.bmiToString() + "\n" + user.healthyWeight());
        mytdee.setText(user.tdeeToString() + "\n" + user.calorieRecommendation());
    }
}
