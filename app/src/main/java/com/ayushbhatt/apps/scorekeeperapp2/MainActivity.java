package com.ayushbhatt.apps.scorekeeperapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Initializing global variables scoreA, scoreB
    int scoreA = 0;
    int scoreB = 0;

    //displaying score for first team
    public void displayforA(int scoreA){
        TextView teamOneGoal = findViewById(R.id.teamOneGoals);
        teamOneGoal.setText(NumberFormat.getInstance().format(scoreA));
    }

    //displaying score for second team
    public void displayforB(int scoreB) {
        TextView teamTwoGoal = findViewById(R.id.teamTwoGoals);
        teamTwoGoal.setText(NumberFormat.getInstance().format(scoreB));
    }

    //adding one goal to team one
    public void plusTeamOne(View view){
        scoreA++;
        displayforA(scoreA);
    }

    //removing one goal from team one
    public void minusTeamOne(View view){
        if(scoreA==0){
            return;
        }
        scoreA--;
        displayforA(scoreA);
    }

    //adding one goal to team two
    public void plusTeamTwo(View view){
        scoreB++;
        displayforB(scoreB);
    }

    //removing one goal from team two
    public void minusTeamTwo(View view){
        if(scoreB==0){
            return;
        }
        scoreB--;
        displayforB(scoreB);
    }

    //setting the name team one to name by user input
    public void setTeamOne(View view){
        EditText teamANameEditText = findViewById(R.id.teamOneNameEditText);
        String teamAName = teamANameEditText.getText().toString();
        TextView teamOneText = findViewById(R.id.teamOneText);
        teamOneText.setText(teamAName);
    }

    //setting team two name to name by user input
    public void  setTeamTwo(View view){
        EditText teamBNameEditText = findViewById(R.id.teamTwoNameEditText);
        String teamBName = teamBNameEditText.getText().toString();
        TextView teamTwoText = findViewById(R.id.teamTwoText);
        teamTwoText.setText(teamBName);
    }

    //resetting scores
    public void resetClick(View v){
        scoreA=0;
        scoreB=0;
        displayforA(scoreA);
        displayforB(scoreB);
    }

    //intent of sharing your score to any app that uses EXTRA_SUBJECT and/or EXTRA_TEXT
    public void shareClick(View view) {
        EditText userNameEditText = findViewById(R.id.userNameEditText);
        String userName = userNameEditText.getText().toString();

        EditText teamANameEditText = findViewById(R.id.teamOneNameEditText);
        String teamAName = teamANameEditText.getText().toString();

        EditText teamBNameEditText = findViewById(R.id.teamTwoNameEditText);
        String teamBName = teamBNameEditText.getText().toString();

        String subject = userName + ", your report is ready!";
        String message = teamAName + "'s score is: " + scoreA;
        message += "\n" + teamBName + "'s score is: " + scoreB;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
