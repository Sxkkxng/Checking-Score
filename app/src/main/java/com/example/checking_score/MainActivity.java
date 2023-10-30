package com.example.checking_score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etScore;
    Button btnCheck, btnClear;
    TextView txtDisplay, txtResult;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etScore = findViewById(R.id.etScore);
        btnCheck = findViewById(R.id.btnCheck);
        btnClear = findViewById(R.id.btnClear);
        txtDisplay = findViewById(R.id.txtDisplay);
        txtResult = findViewById(R.id.txtResult);

        txtDisplay.setVisibility(View.GONE);
        txtResult.setVisibility(View.GONE);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etScore.setText("");
                txtDisplay.setVisibility(View.GONE);
                txtResult.setVisibility(View.GONE);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = Integer.parseInt(etScore.getText().toString());
                // Create a DecimalFormat object with the desired format
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                // Use the format() method to convert the number to a formatted string
                String formattedNumber = decimalFormat.format(score);
                txtDisplay.setText("Your Score is : "+formattedNumber + "");

                //Conditions
                if (score <= 30) {
                    //Clear etScore
                    etScore.setText("");
                    //Display Grade
                    txtResult.setText(" Your grade is : F");

                } else if (score <= 49) {
                    etScore.setText("");
                    txtResult.setText("Your grade is : D");
                } else if (score <= 79) {
                    etScore.setText("");
                    txtResult.setText("Your grade is : C");
                } else if (score <= 89) {
                    etScore.setText("");
                    txtResult.setText("Your grade is : B");
                } else if (score <=100) {
                    etScore.setText("");
                    txtResult.setText("Your grade is : A");
                }else {
                    // Clear etScore
                    etScore.setText("");
                    // Display Validation
                    txtDisplay.setText("You can only enter the score between 0-100!!!");
                    txtResult.setText("");
                }
                //Show txtView
                txtDisplay.setVisibility(View.VISIBLE);
                txtResult.setVisibility(View.VISIBLE);
            }
        });
    }


}