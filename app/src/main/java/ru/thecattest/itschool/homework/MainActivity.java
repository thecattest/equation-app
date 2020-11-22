package ru.thecattest.itschool.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void run(View view) {
        EditText aInput = (EditText)findViewById(R.id.a);
        EditText bInput = (EditText)findViewById(R.id.b);
        EditText cInput = (EditText)findViewById(R.id.c);
        TextView res = findViewById(R.id.res);

        try {
            Double a = Double.parseDouble(aInput.getText().toString());
            Double b = Double.parseDouble(bInput.getText().toString());
            Double c = Double.parseDouble(cInput.getText().toString());

            res.setText(solveEquation(a, b, c));
        } catch (Exception e) {
            Toast.makeText(this, "Don't use letters or empty strings", Toast.LENGTH_LONG).show();
        }

    }

    @SuppressLint("DefaultLocale")
    public String solveEquation(Double a, Double b, Double c) {
        double d = b * b - 4 * a * c;
        if (a != 0 && b != 0) {
            if (d > 0) {
                double x1 = (-b + sqrt(d)) / 2 / a;
                double x2 = (-b - sqrt(d)) / 2 / a;
                return String.format("%1$.5f %2$.5f", x1, x2);
            } else if (d == 0) {
                double x = (-b) / 2 / a;
                return String.format("%.5f", x);
            } else {
                return "none";
            }
        } else if (a == 0 && b == 0) {
            return c == 0 ? "any" : "none";
        } else if (a == 0 && b != 0) {
            if (c == 0) return "0";
            else return String.format("%.5f", -c / b);
        } else {
            if (c > 0) return "none";
            else if (c == 0) return "0";
            else return String.format("%1$.5f -%1$.5f", sqrt(-c));
        }
    }
}
