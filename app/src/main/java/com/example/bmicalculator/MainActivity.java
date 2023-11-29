package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htft = Integer.parseInt(edtHeightFt.getText().toString());
                int htin = Integer.parseInt(edtHeightIn.getText().toString());

                double htMetres = (((htft * 12) + htin) * 2.53) / 100;
                double bmi = wt / (htMetres * htMetres);

                if(bmi > 25){
                    txtResult.setText("You're Overweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(bmi > 18 && bmi < 25){
                    txtResult.setText("You're Healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
                else{
                    txtResult.setText("You're Underweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
            }
        });
    }
}