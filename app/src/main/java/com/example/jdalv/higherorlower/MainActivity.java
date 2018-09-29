package com.example.jdalv.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber; // initialize integer variable that will contain the random number

    // method called to generate random number
    public void generateRandomNumber() {
        Random rand = new Random(); // initialize and declare the Random class object

        randomNumber = rand.nextInt(20) + 1; // set the random number between 1 and 20
    }

    // method called when the button is clicked
    public void guess(View view) {
        Log.i("Info", "Button pressed!"); // log button click to the Logcat

        Log.i("Random Number", Integer.toString(randomNumber)); // log generated random number to the Logcat

        EditText editText = (EditText) findViewById(R.id.editText); // initialize and declare input field component

        Log.i("Entered Number", editText.getText().toString()); // log input number to the Logcat

        int guessValue = Integer.parseInt(editText.getText().toString()); // initialize and declare inputted guess number by user

        String message; // initialize string variable that will contain custom message displayed to user

        if (guessValue > randomNumber) {
            message = "Go lower!";
        } else if (guessValue < randomNumber) {
            message = "Go higher!";
        } else {
            message = "Congratulations! You got it!";

            generateRandomNumber(); // calling method to generate new random number
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show(); // display toast with custom message



    }

    // method called when the app loads
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber(); // calling method to generate new random number

    }
}
