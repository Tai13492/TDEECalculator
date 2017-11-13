package com.example.tai.TDEECalculator;

/**
 * Created by Tai on 11/13/2017.
 */

public class Healthy {
    protected double bmi;
    protected double bmr;
    protected int tdee;
    public Healthy(double bmi,double bmr,int tdee){
            this.bmi = bmi;
            this.bmr = bmr;
            this.tdee = tdee;
    }
    public String healthyWeight(){
        if(this.bmi <= 18.5){
            return "You are extremely underweight, please consider following our calorie recommendation in order to gain weight and become more healthy";
        }else if(this.bmi <=24.9){
            return "You weight are considered as healthy! we recommend you to follow our calorie recommendation to maintain your weight!";
        }else if(this.bmi<=29.9){
            return "You are a little bit overweight, we recommend you to follow our calorie recommendation to lose weight slowly, meaning that you can stil enjoy lots of food!";
        }else{
            return "You are extremely overweight, please consider following our calorie recommendation in order to lose weight as quickly as possible and avoid diseases that come with obesity";
        }
    }
    public String bmiToString(){
        return "Your BMI is " + this.bmi;
    }
    public String tdeeToString(){
        return "Your TDEE is " + this.tdee + " kcal";
    }
    public String calorieRecommendation(){
        if(this.bmi <= 18.5){
            return "Since you are under weight, you should be in a caloric surplus, you should consume " + (this.tdee + 800) + " kcal per day.";
        }else if(this.bmi <=24.9){
            return "Since your weight is considered as healthy your daily calorie consumption should be approximately equal to your tdee.";
        }else if(this.bmi<=29.9){
            return "Since you are a little bit overweight, you should be in a slight calorie deficit, you should consume " + (this.tdee - 500) + " kcal per day";
        }else{
            return "Since your current weight is very dangerous to your health and you should consider to lose weight immediately, you should be in a proper calorie deficit, you should consume " + (this.tdee-1000) + " kcal per day.";
        }
    }
}
