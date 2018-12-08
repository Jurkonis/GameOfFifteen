package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Button play;
    private Button scoreboard;
    private Button guide;
    private Context context = this;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menudesign);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(startGame);
        scoreboard=(Button)findViewById(R.id.scoreboard);
        scoreboard.setOnClickListener(score);
        guide=(Button) findViewById(R.id.guide);
        guide.setOnClickListener(showGuide);
        mIntent=getIntent();
    }

    public void showScore()
    {
        Intent intent = new Intent(context, Scoreboard.class);
        intent.putExtras(mIntent);
        context.startActivity(intent);
    }
    public void runGame() {
        Intent intent = new Intent(context, Game.class);
        //intent.putExtras(mIntent);
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

    View.OnClickListener showGuide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, HowTo.class);
            context.startActivity(intent);
        }
    };
}
