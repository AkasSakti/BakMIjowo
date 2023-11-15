package com.example.bakmijowo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            float bmi = calculateBMIValue(weight, height);
            displayResult(bmi);
        } else {
            textViewResult.setText("Please enter weight and height");
        }
    }

    private float calculateBMIValue(float weight, float height) {
        return weight / (height * height);
    }

    private void displayResult(float bmi) {
        String result;

        if (bmi < 18.5) {
            result = "Kurang Lemu";
        } else if (bmi < 25) {
            result = "Normal";
        } else if (bmi < 30) {
            result = "Lemu";
        } else {
            result = "Kelemon";
        }

        textViewResult.setText("BMI Result: " + bmi + "\nCategory: " + result);
    }
}
