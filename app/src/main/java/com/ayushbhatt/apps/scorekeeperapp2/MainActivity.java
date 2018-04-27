package com.ayushbhatt.apps.scorekeeperapp2;

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

    public void plusTeamOne(View view){
        scoreA++;
        displayforA(scoreA);
    }

    public void minusTeamOne(View view){
        scoreA--;
        displayforA(scoreA);
    }

    public void plusTeamTwo(View view){
        scoreB++;
        displayforB(scoreB);
    }

    public void minusTeamTwo(View view){
        scoreB++;
        displayforB(scoreB);
    }

    public void setTeamOne(View view){
        EditText teamANameEditText = findViewById(R.id.teamOneNameEditText);
        String teamAName = teamANameEditText.getText().toString();
        TextView teamOneText = findViewById(R.id.teamOneText);
        teamOneText.setText(teamAName);
    }

    public void  setTeamTwo(View view){
        EditText teamBNameEditText = findViewById(R.id.teamTwoNameEditText);
        String teamBName = teamBNameEditText.getText().toString();
        TextView teamTwoText = findViewById(R.id.teamTwoText);
        teamTwoText.setText(teamBName);
    }

    public void resetClick(View view){
        //EditText nameEditText = findViewById(R.id.userNameEditText);
        scoreA=0;
        scoreB=0;
        displayforA(scoreA);
        displayforB(scoreB);
    }

}
