package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InMMcK extends AppCompatActivity {
    EditText λ, μ, c, k;
    TextView l, lq, w, wq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_m_mc_k);
        λ = findViewById(R.id.λ5);
        μ = findViewById(R.id.μ5);
        c = findViewById(R.id.c1);
        l = findViewById(R.id.l4);
        lq = findViewById(R.id.lq4);
        w = findViewById(R.id.w4);
        wq = findViewById(R.id.wq4);
        k = findViewById(R.id.k5);
    }

    public void onClick(View view) {
        if (λ.getText().toString().equals("") || μ.getText().toString().equals("") || k.getText().toString().equals("") || c.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else {
            double myλ = Double.parseDouble(λ.getText().toString());
            double myμ = Double.parseDouble(μ.getText().toString());
            int myc = Integer.parseInt(c.getText().toString());
            int myk = Integer.parseInt(k.getText().toString());
            double r = myλ / myμ;
            double ρ = r / myc;
            double p = 0;
            if (ρ != 1) {
                double sum = 0;
                for (int n = 0; n < myc; n++) {
                    sum += Math.pow(r, n) / factorial(n);
                }
                p = 1 / (sum + (Math.pow(r, myc) / factorial(myc)) * ((1 - Math.pow(ρ, myk - myc + 1)) / (1 - ρ)));
            }
            if (ρ == 1) {
                double sum = 0;
                for (int n = 0; n < myc; n++) {
                    sum += Math.pow(r, n) / factorial(n);
                }
                p = 1 / (sum + (Math.pow(r, myc) / factorial(myc)) * (myk - myc + 1));
            }
            double lama_dash = myλ * (1 - ((p * Math.pow(r, myk)) / (Math.pow(myc, (myk - myc)) * factorial(myc))));

            double lq1 = (ρ * Math.pow(r, myc) * p) / (factorial(myc) * Math.pow(1 - ρ, 2)) *
                    (1 - Math.pow(ρ, (myk - myc + 1)) - (1 - ρ) * (myk - myc + 1) * Math.pow(ρ, (myk - myc)));
            lq.setText("Lq = " + lq1);
            double sum1 = 0;
            for (int n = 0; n < myc; n++) {
                sum1 += (myc - n) * (Math.pow(r, n) / factorial(n));
            }
            double l1 = lq1 + myc - (p * sum1);
            l.setText("L = " + l1);
            double w1 = l1 / lama_dash;
            w.setText("W = " + w1);
            double wq1 = lq1 / lama_dash;
            wq.setText("Wq = " + wq1);

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
