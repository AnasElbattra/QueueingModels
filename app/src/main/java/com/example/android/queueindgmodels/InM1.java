package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InM1 extends AppCompatActivity {
    EditText λ, μ;
    TextView l, lq, w, wq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_m1);
        λ = findViewById(R.id.λ1);
        μ = findViewById(R.id.μ1);
        l = findViewById(R.id.l);
        lq = findViewById(R.id.lq);
        w = findViewById(R.id.w);
        wq = findViewById(R.id.wq);
    }

    public void onclick(View view) {
        if (λ.getText().toString().equals("") || μ.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else {
            double myλ = Double.parseDouble(λ.getText().toString());
            double myμ = Double.parseDouble(μ.getText().toString());
            double myw = 1 / (myμ - myλ);
            if (myw > 0)
                w.setText("W = " + myw);
            else Toast.makeText(getApplicationContext(), "W is a minus",
                    Toast.LENGTH_SHORT).show();
            double myl = myλ * myw;
            if (myl > 0)
                l.setText("L = " + myl);
            else Toast.makeText(getApplicationContext(), "L is a minus",
                    Toast.LENGTH_SHORT).show();
            double mywq = myλ / (myμ * (myμ - myλ));
            if (mywq > 0)
                wq.setText("Wq = " + mywq);
            else Toast.makeText(getApplicationContext(), "Wq is a minus",
                    Toast.LENGTH_SHORT).show();
            double mylq = mywq * myλ;
            if (mylq > 0)
                lq.setText("Lq = " + mylq);
            else Toast.makeText(getApplicationContext(), "Lq is a minus",
                    Toast.LENGTH_SHORT).show();

        }
    }
}

