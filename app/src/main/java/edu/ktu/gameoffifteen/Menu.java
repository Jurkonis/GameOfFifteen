package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    private Button play;
    private Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        play=(Button) findViewById(R.id.play);
        play.setOnClickListener(startGame);
    }

    public void runGame(){
        Intent intent = new Intent(context,Game.class);
        context.startActivity(intent);
    }

    View.OnClickListener startGame =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            runGame();
        }
    };

}
