package edu.txstate.sl20.electriccar;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {

    //Chapter11 Material

    int intAmount;
    int intYears;
    double dblRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        //first approach when not declaring universal variables...

        //final int intAmount = sharedPref2.getInt("amount", 0);
        //final int intYears = sharedPref2.getInt("years", 0);
        //final double dblRate = sharedPref2.getFloat("rate", 0);


        //Second approach when declaring universal variables
        intAmount = sharedPref2.getInt("amount", 0);
        intYears = sharedPref2.getInt("years", 0);
        dblRate = sharedPref2.getFloat("rate", 0);




        Button calculate = findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dblMonthlyPayment = (intAmount*(1+(dblRate*intYears)))/(12*intYears);
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                TextView monthlyPayment = findViewById(R.id.txtMonthlyPayment);
                monthlyPayment.setText(currency.format(dblMonthlyPayment));

            }
        });









    }
}
