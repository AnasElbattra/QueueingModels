package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InDk extends AppCompatActivity {
    EditText λ, μ, k, m;
    TextView ti, wq, wq1;
    double myλ;
    double myμ;
    int myk;
    int tim;
    double n;
    int mym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_dk);
        λ = findViewById(R.id.λ2);
        μ = findViewById(R.id.μ2);
        ti = findViewById(R.id.ti);
        k = findViewById(R.id.k);
        wq = findViewById(R.id.wqd);
        wq1 = findViewById(R.id.wqd3);
        m = findViewById(R.id.m);

    }

    public void onClick(View view) {

        if (λ.getText().toString().equals("") || μ.getText().toString().equals("") || k.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "please put number",
                    Toast.LENGTH_LONG).show();
        else {
            myλ = Double.parseDouble(λ.getText().toString());
            myμ = Double.parseDouble(μ.getText().toString());
            myk = Integer.parseInt(k.getText().toString());

            if (myλ > myμ) {


                for (tim = 2; tim >= 2; tim++) {
                    double z = tim * myλ;
                    int z1 = (int) z;
                    double w = ((tim * myμ) - (myμ / myλ));
                    int w1 = (int) w;
                    int myk1;
                    myk1 = z1 - w1;
                    if (myk == myk1) {
                        ti.setText("ti = " + tim);
                        break;
                    }
                }
                Wq();
            } else if (myμ > myλ) {
                if (m.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "please put number",
                            Toast.LENGTH_LONG).show();
                else {
                    mym = Integer.parseInt(m.getText().toString());

                    for (tim = 2; tim >= 2; tim++) {
                        double z = tim * myμ;
                        int z1 = (int) Math.floor(z);
                        double w = tim * myλ;
                        int w1 = (int) Math.round(w);
                        int mym1 = z1 - w1;
                        if (mym == mym1) {
                            ti.setText("ti = " + tim);
                            break;
                        }
                        double mywq = (mym - 1) / 2 * myμ;
                        wq.setText("Wq = " + mywq);
                    }
                }

            } else Toast.makeText(getApplicationContext(), "please check your input",
                    Toast.LENGTH_LONG).show();
        }


    }

    public void Wq() {
        Double myWq = 0.0;
        for (n = 1; n < (myλ * tim); n++) {
            myWq = (1 / myμ - 1 / myλ) * (n - 1);
            int a = (int) Math.round(myWq);
            wq.setText("if n<λti :  Wq(" + n + ") = " + a);
        }
        if (myλ * tim == n)
            myWq = (1 / myμ - 1 / myλ) * (myλ * tim - 2);
        int a = (int) Math.round(myWq);
        wq1.setText("if n>=λti :  Wq(" + n + ") = " + a);


    }
}
