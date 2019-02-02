package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int minNumber = 1;
    private int maxNumber = 6;

    // Widgets
    private TextView resultTextView = null;
    private EditText minEditText = null;
    private EditText maxEditText = null;
    private Button generateButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize widgets.
        this.resultTextView = (TextView) findViewById(R.id.textViewResult);
        this.minEditText = (EditText) findViewById(R.id.editTextMin);
        this.maxEditText = (EditText) findViewById(R.id.editTextMax);

        // Set the default fields.
        setDefaultMinMax();

        // Generate random number button callback.
        this.generateButton = (Button) findViewById(R.id.generateButton);
        this.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchValuesFromFields();    // Fetch the field values first.
                generateRandomNumber();     // Generate and display random number.
            }
        });
    }

    private void setDefaultMinMax() {
        // Convert integer to string to set edit text fields.
        minEditText.setText(Integer.toString(minNumber));
        maxEditText.setText(Integer.toString(maxNumber));
    }

    private void fetchValuesFromFields() {
        // Fetches the values set in the min and max text field. Save to class variables.
        // Convert fetched strings to ints.
        this.minNumber =  Integer.parseInt(this.minEditText.getText().toString());
        this.maxNumber =  Integer.parseInt(this.maxEditText.getText().toString());
    }

    private void generateRandomNumber() {
        int randomNum = getRandomInt(minNumber, maxNumber); // Get a random int from bounds.
        String randomNumStr = Integer.toString(randomNum);  // Convert number from int to String.

        resultTextView.setText(randomNumStr);               // Set the result text field.
    }

    private int getRandomInt(int min, int max) {
        // Generate a random number between min and max.
        Random rand = new Random();
        return rand.nextInt(max) + min;
    }
}

