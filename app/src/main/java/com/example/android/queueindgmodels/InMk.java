package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InMk extends AppCompatActivity {
    EditText λ, μ, k;
    TextView l, lq, w, wq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_mk);
        λ = findViewById(R.id.λ3);
        μ = findViewById(R.id.μ3);
        k = findViewById(R.id.k2);
        l = findViewById(R.id.l2);
        lq = findViewById(R.id.lq2);
        w = findViewById(R.id.w);
        wq = findViewById(R.id.wq2);
    }

    public void onClick(View view) {
        if (λ.getText().toString().equals("")||μ.getText().toString().equals("")||k.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else
        {
        double myλ = Double.parseDouble(λ.getText().toString());
        double myμ = Double.parseDouble(μ.getText().toString());
        double myk = Integer.parseInt(k.getText().toString());
        double ρ = myλ / myμ;

        double l1 = 0;
        if (ρ != 1) {
            l1 = ρ * ((1 - (myk + 1) * Math.pow(ρ, myk) + myk * Math.pow(ρ, (myk + 1))) / ((1 - ρ) * (1 - Math.pow(ρ, (myk + 1)))));
            if (l1 > 0)
                l.setText("L = " + l1);
            else Toast.makeText(getApplicationContext(), "L minus",
                    Toast.LENGTH_SHORT).show();
        }
        if (ρ == 1) {
            l1 = myk / 2;
            if (l1 > 0)
                l.setText("L = " + l1);
            else Toast.makeText(getApplicationContext(), "L minus",
                    Toast.LENGTH_SHORT).show();
        }
        double p = 0;
        if (ρ != 1) {
            p = Math.pow(ρ, myk) * ((1 - ρ) / (1 - Math.pow(ρ, myk)));
        }
        if (ρ == 1) {
            p = 1 / (myk + 1);
        }
        double myw = l1 / (myλ * (1 - p));
        if (myw > 0)
            w.setText("W = " + myw);
        else Toast.makeText(getApplicationContext(), "W minus",
                Toast.LENGTH_SHORT).show();
        double mywq = myw - (1 / myμ);
        if (mywq > 0)
            wq.setText("Wq = " + mywq);
        else Toast.makeText(getApplicationContext(), "Wq minus",
                Toast.LENGTH_SHORT).show();
        double myLq = myλ * (1 - p) * mywq;
        if (myLq > 0)
            lq.setText("Lq = " + myLq);
        else Toast.makeText(getApplicationContext(), "Lq minus",
                Toast.LENGTH_SHORT).show();


    }}
}
