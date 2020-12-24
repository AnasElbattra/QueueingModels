package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InD1 extends AppCompatActivity {
    EditText λ, μ, t;
    TextView n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_d1);
        λ = findViewById(R.id.λ);
        μ = findViewById(R.id.μ);
        t = findViewById(R.id.t);
        n = findViewById(R.id.n);
    }

    public void onClick(View view) {
        if (λ.getText().toString().equals("") || μ.getText().toString().equals("") || t.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else {
            double myλ = Double.parseDouble(λ.getText().toString());
            double myμ = Double.parseDouble(μ.getText().toString());
            double myt = Double.parseDouble(t.getText().toString());
            double x = myt * myλ;
            int x1 = (int) x;
            double y = ((myμ * myt) - (myμ / myλ));
            int y1 = (int) y;
            int nsum = x1 - y1;
            if (nsum > 0)
                n.setText("n(t) = " + nsum);
            else
                Toast.makeText(getApplicationContext(), "the result minus",
                        Toast.LENGTH_LONG).show();
        }
    }


}


