package edu.txstate.sl20.electriccar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btncarPayment = findViewById(R.id.btnCarPayment);
        final EditText txtNumberOfYears = findViewById(R.id.txtNumberOfYears);
        final EditText txtCarLoanAmount = findViewById(R.id.txtCarLoanAmount);
        final EditText txtInterestRate = findViewById(R.id.txtInterestRate);
        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);
        int amountSaved = sharedPref2.getInt("amount", 0);

        Toast.makeText(this, "" + amountSaved, Toast.LENGTH_LONG).show();
        int intNumberOfYears;
        btncarPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int intNumberOfYears = Integer.parseInt(txtNumberOfYears.getText().toString());
                int intLoanAmount = Integer.parseInt(txtCarLoanAmount.getText().toString());
                double dblInterestRate = Double.parseDouble(txtInterestRate.getText().toString());
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("years", intNumberOfYears);
                editor.putInt("amount", intLoanAmount);
                editor.putFloat("rate", (float) dblInterestRate);
                editor.commit();

                startActivity(new Intent(MainActivity.this, PaymentActivity.class));
            }
        });
    }
}
