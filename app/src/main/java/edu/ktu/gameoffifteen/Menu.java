package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Button play;
    private Button scoreboard;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menudesign);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(startGame);
        scoreboard=(Button)findViewById(R.id.scoreboard);
        scoreboard.setOnClickListener(score);
    }

    public void showScore()
    {
        Intent intent = new Intent(context, Scoreboard.class);
        context.startActivity(intent);
    }
    public void runGame() {
        Intent intent = new Intent(context, Game.class);
        context.startActivity(intent);
    }

    View.OnClickListener startGame = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            runGame();
        }
    };

    View.OnClickListener score = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showScore();
        }
    };
}
