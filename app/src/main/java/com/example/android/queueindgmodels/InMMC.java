package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InMMC extends AppCompatActivity {
    EditText λ, μ, c;
    TextView l, lq, w, wq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_m_m_c);
        λ = findViewById(R.id.λ4);
        μ = findViewById(R.id.μ4);
        c = findViewById(R.id.c);
        l = findViewById(R.id.l3);
        lq = findViewById(R.id.lq3);
        w = findViewById(R.id.w3);
        wq = findViewById(R.id.wq3);
    }

    public void onClick(View view) {
        if (λ.getText().toString().equals("") || μ.getText().toString().equals("") || c.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else {
            double myλ = Double.parseDouble(λ.getText().toString());
            double myμ = Double.parseDouble(μ.getText().toString());
            int myc = Integer.parseInt(c.getText().toString());
            double r = myλ / myμ;
            double p = 0;


            if (r / myc < 1) {
                double sum = 0;
                for (int n = 0; n < myc; n++) {
                    sum += Math.pow(r, n) / factorial(n);
                }
                p = 1 / (sum + (myc * Math.pow(r, myc)) / (factorial(myc) * (myc - r)));
            } else if (r / myc >= 1) {
                double sum = 0;
                for (int n = 0; n < myc; n++) {

                    sum += Math.pow(r, n) / factorial(n);
                }
                p = 1 / (sum + (Math.pow(r, myc) / factorial(myc)) * (myc * myμ) / (myc * myμ - myλ));

            }
            double lq1 = (Math.pow(r, myc) * myλ * myμ) / (factorial((myc - 1)) * Math.pow(((myc * myμ) - myλ), 2)) * p;
            lq.setText("Lq = " + lq1);
            double wq1 = lq1 / myλ;
            wq.setText("Wq = " + wq1);
            double w1 = lq1 / myλ + 1 / myμ;
            w.setText("W = " + w1);
            double l1 = lq1 + myλ / myμ;
            l.setText("L = " + l1);
        }

    }

    public int factorial(int x) {
        int fact = 1;
        int i;
        for (i = 1; i <= x; i++) {
            fact = i * fact;
        }
        return fact;

    }
}
