package com.example.tai.TDEECalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox sed,lact,mact,vact,eact;
    double act = 0;
    Spinner gender;
    Calculate calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender = (Spinner) findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        gender.setAdapter(adapter);
        sed = (CheckBox) findViewById(R.id.checkbox_sed);
        lact = (CheckBox) findViewById(R.id.checkbox_lact);
        mact = (CheckBox) findViewById(R.id.checkbox_mact);
        vact = (CheckBox) findViewById(R.id.checkbox_vact);
        eact = (CheckBox) findViewById(R.id.checkbox_eact);
    }
    public void calculateBMI(View view){
        TextView weight = (TextView) findViewById(R.id.plaintext_weight);
        TextView height = (TextView) findViewById(R.id.plaintext_height);
        TextView age = (TextView) findViewById(R.id.plaintext_age);
        String text = gender.getSelectedItem().toString();
        Log.i("test1",text);
        double myweight = Double.parseDouble(weight.getText().toString());
        double myheight = Double.parseDouble(height.getText().toString());
        double myage = Double.parseDouble(age.getText().toString());
        calculate = new Calculate(text,myweight,myheight,myage,act);
        double mybmi = calculate.calculateBMI();
        double mybmr = calculate.calculateBMR();
        double mytdee = calculate.calculateTDEE();
        //Toast.makeText(MainActivity.this,"BMI: " + myage + "BMR: " + mybmr + "TDEE " + mytdee,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,TDEEResult.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("bmi",mybmi);
        bundle.putDouble("bmr",mybmr);
        bundle.putDouble("tdee",mytdee);
        intent.putExtras(bundle);
        startActivity(intent);
        Log.i("test","Success");

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_sed:
                if (checked){
                    Log.i("test","sed checked");
                    changeChecked(sed);
                    act = 1.2;
                }
                break;
            case R.id.checkbox_lact:
                if (checked) {
                    Log.i("test", "light act checked");
                    changeChecked(lact);
                    act = 1.375;
                }
                break;
            case R.id.checkbox_mact:
                if (checked) {
                    Log.i("test", "mact act checked");
                    changeChecked(mact);
                    act = 1.55;
                }
                break;
            case R.id.checkbox_vact:
                if(checked){
                    Log.i("test", "vact act checked");
                    changeChecked(vact);
                    act = 1.725;
                }
                break;
            case R.id.checkbox_eact:
                if (checked) {
                    Log.i("test", "eact act checked");
                    changeChecked(eact);
                    act = 1.9;
                }
        }
    }
    public void changeChecked(CheckBox box){
        final CheckBox chb [] = {sed,lact,mact,vact,eact};
        for(int i = 0; i<chb.length;i++){
            if(!(chb[i].equals(box))){
                chb[i].setChecked(false);
            }
        }
    }
}
