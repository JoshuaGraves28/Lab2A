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

    TextView winner;
    TextView playerWeapon;
    TextView computerWeapon;
    TextView score;

    private Button rButton;
    private Button pButton;
    private Button sButton;

   private Weapon randomWeapon() {
        int pick = new Random().nextInt(Weapon.values().length);
        return Weapon.values()[pick];
    }
    int pScore=0;
    int cScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        rButton = findViewById(R.id.buttonRock);
        rButton.setOnClickListener(this);
        pButton = findViewById(R.id.buttonPaper);
        pButton.setOnClickListener(this);
        sButton = findViewById(R.id.buttonScissors);
        sButton.setOnClickListener(this);

        winner = (TextView) findViewById(R.id.winText);
        playerWeapon = (TextView) findViewById(R.id.playerWeapon);
        computerWeapon = (TextView) findViewById(R.id.computerWeapon);
        score = (TextView) findViewById(R.id.scoreText);

        score.setText("Player: , Computer:");
        playerWeapon.setText("Player Weapon: ");
        computerWeapon.setText("Computer Weapon:");
        winner.setText("");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonRock:

                player = Weapon.ROCK;
                playerWeapon.setText("Player Weapon: "+ player.toString());

                computer = randomWeapon();
                computerWeapon.setText("Computer Weapon: "+ computer.toString());
                if (isDraw()==true){
                    winner.setText("It is a Draw!");
                }
                else if((isPlayerWin()==true)&& (isDraw()==false)){
                    winner.setText("Player wins...Rock crumbles Scissors");
                    ++pScore;
                }
                else if((isPlayerWin()==false)&& (isDraw()==false)){
                    winner.setText("Computer wins...Paper Wraps Rock");
                    ++cScore;
                }

                score.setText("Player: "+ pScore +" , Computer: "+ cScore);
                break;


            case R.id.buttonPaper:
                player = Weapon.PAPER;
                playerWeapon.setText("Player Weapon: "+ player.toString());

                computer = randomWeapon();
                computerWeapon.setText("Computer Weapon: "+ computer.toString());
                if (isDraw()==true){
                    winner.setText("It is a Draw!");
                }

                else if((isPlayerWin()==true)&& (isDraw()==false)){
                    winner.setText("Player wins...Paper Wraps Rock");
                    ++pScore;
                }
                else if((isPlayerWin()==false)&& (isDraw()==false)){
                    winner.setText("Computer wins...Scissors cuts Paper!");
                    ++cScore;
                }

                score.setText("Player: "+ pScore +" , Computer: "+ cScore);
                break;


            case R.id.buttonScissors:
                player = Weapon.SCISSORS;
                playerWeapon.setText("Player Weapon: "+ player.toString());

                computer = randomWeapon();
                computerWeapon.setText("Computer Weapon: "+ computer.toString());
                if (isDraw()==true){
                    winner.setText("It is a Draw!");
                }
                else if((isPlayerWin()==true)&& (isDraw()==false)){
                    winner.setText("Player wins...Scissors cuts Paper!");
                    ++pScore;
                }
                else if((isPlayerWin()==false)&& (isDraw()==false)){
                    winner.setText("Computer wins...Rock crumbles Scissors!");
                    ++cScore;
                }

                score.setText("Player: "+ pScore +" , Computer: "+ cScore);

                break;
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

        public Weapon getRandomWeapon(){
            Weapon[] values = Weapon.values();
            Random r = new Random();
            return (values[r.nextInt(values.length)]);

        }

    };


    public boolean isPlayerWin() {
        boolean playerwin = false;

        switch (player){
            case ROCK:
                if(computer==Weapon.SCISSORS){
                    playerwin=true;
                }
                break;
            case PAPER:
                if(computer==Weapon.ROCK){
                    playerwin=true;
                }

            case SCISSORS:
                if(computer==Weapon.PAPER){
                    playerwin=true;
                }

        }
       return playerwin;


    }
    public boolean isDraw(){
        boolean draw = false;

        switch(player){
            case ROCK:
                if(computer==Weapon.ROCK){
                    draw=true;
                }
                break;
            case PAPER:
                if(computer==Weapon.PAPER){
                    draw=true;
                }

            case SCISSORS:
                if(computer==Weapon.SCISSORS){
                    draw=true;
                }

        }

        return draw;
    }


}



