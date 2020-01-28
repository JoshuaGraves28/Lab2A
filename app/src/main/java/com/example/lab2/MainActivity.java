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

public class MainActivity extends AppCompatActivity {
    final Button buttonRock = (Button) findViewById(R.id.buttonRock);
    final Button buttonPaper = (Button) findViewById(R.id.buttonPaper);
    final Button buttonScissors = (Button) findViewById(R.id.buttonScissors);
    int user;
    int computer;






    OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView t = (TextView) findViewById(R.id.playerWeapon);
            int opponet;
            int choice;

            if (v.equals(buttonRock)) {

                t.setText("Player's Weapon: Rock");
                user = 1;
                choice = (int) (Math.random() * (3 - 1) + 1) + 1;
                opponet = opponet.computerChoice(choice);
                computeWin(opponent, 1);


                if (v.equals(buttonPaper)) {
                    t.setText("Player's Weapon: Paper");
                    user = 2;
                    choice = (int) (Math.random() * (3 - 1) + 1) + 1;
                    opponet = opponet.computerChoice(choice);
                    computeWin(opponent, 2);
                }
                if (v.equals(buttonScissors)) {
                    t.setText("Player's Weapon: Scissor");
                    user = 3;
                    choice = (int) (Math.random() * (3 - 1) + 1) + 1;
                    opponet = opponet.computerChoice(choice);
                    computeWin(opponent, 3);
                } else {
                    user = 0;
                }
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}
