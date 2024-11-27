package com.example.bmi_ca2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ht, wt;
    Button cal, hp;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ht = (EditText) findViewById(R.id.ht);
        wt = (EditText) findViewById(R.id.wt);
        cal = (Button) findViewById(R.id.cal);
        hp = (Button) findViewById(R.id.hp);
        tv = (TextView) findViewById(R.id.tv);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = ht.getText().toString();
                String weight = wt.getText().toString();
                if(!height.isEmpty() && !weight.isEmpty()){
                    float ht = Integer.parseInt(height);
                    int wt = Integer.parseInt(weight);
                    if(ht >= 50 && ht <=250 && wt >= 3 && wt <= 150){
                        float htt = ht/100;
                        float bmi = wt / (htt*htt);
                        String bmii = String.format("%.1f", bmi);
                        if(bmi < 18.5){
                            tv.setText("Underweight ("+bmii+")");
                        } else if (bmi>=18.5 && bmi<=24.9) {
                            tv.setText("Normal Weight ("+bmii+")");
                        } else if (bmi>=25 && bmi<=29.9) {
                            tv.setText("Overweight ("+bmii+")");
                        } else if (bmi >= 30){
                            tv.setText("Obese ("+bmii+")");
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Enter a valid Height and Weight", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter values properly!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Underweight = <18.5 \nNormal weight = 18.5–24.9 \nOverweight = 25–29.9 \nObesity = BMI of 30 or greater", Toast.LENGTH_LONG).show();
            }
        });
    }
}