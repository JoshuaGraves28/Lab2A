package com.example.lab2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Weapon player;
    Weapon computer;
    TextView winner = (TextView) findViewById(R.id.winText);
    TextView playerWeapon = (TextView) findViewById(R.id.playerWeapon);
    TextView computerWeapon = (TextView) findViewById(R.id.computerWeapon);
    TextView score = (TextView) findViewById(R.id.scoreText);
    private Button rButton;

    private Weapon randomWeapon() {
        int pick = new Random().nextInt(Weapon.values().length);
        return Weapon.values()[pick];
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        score.setText("Player: , Computer: ");
        playerWeapon.setText("Player Weapon: ");
        computerWeapon.setText("Computer Weapon: ");
        winner.setText("");
        rButton = findViewById(R.id.buttonRock);
        rButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRock:

                player = Weapon.ROCK;
                playerWeapon.setText("Player Weapon:" + player);
                computer = randomWeapon();
                computerWeapon.setText("Computer Weapon: " + computer);
                winner.setText(whoWins());
                score.setText("Player: "+ playerScore() +" , Computer: "+ computerScore());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) {
            message = msg;
        }

        @Override
        public String toString() {
            return message;
        }

    }

    public int isWin() {
        int win;
        if ( player = Weapon.ROCK; && computer = Weapon.SCISSORS;){

            win =1;
                    //"Player wins ...  Rock crushes Scissors!";

        }
        if ( player.equals(Weapon.PAPER); && computer.equals(Weapon.ROCK);){

            win =2;
        //"Player wins ... Paper covers Rock!";

        }
        if(player = Weapon.SCISSORS; && computer=Weapon.PAPER;){
            win=5;
        }
        if (player == computer) {
            win = 3;
            //"Its a Draw!";

        }


        else {

            win =4;
            //"Computer player Wins!";

        }

        return win;


    }
    public String whoWins(){
        String whoWins = null;

        switch(isWin()){
            case 1:
                whoWins="Player wins ...  Rock crushes Scissors!";
                break;
            case 2:
                whoWins="Player wins ... Paper covers Rock!";
                break;
            case 3:
                whoWins="It is a Draw!";
                break;
            case 4:
                whoWins="Computer player Wins!";
                break;
            case 5:
                whoWins=" Player wins.... Scissors cuts Paper"
        }

        return whoWins;

    }
    public int playerScore(){
        isWin();
        int pScore =0;

        if(isWin() == 1){
            ++pScore;
        }
        if(isWin() == 2){
            ++pScore;
        }
        return pScore;
    }
    public int computerScore(){
        isWin();
        int cScore =0;

        if(isWin() == 4) {
            ++cScore;
        }
        return cScore;
    }
}



