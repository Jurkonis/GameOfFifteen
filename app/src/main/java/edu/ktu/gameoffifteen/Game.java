package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    private String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};
    private String[] array1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};
    private String[] array2 = {"", "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
    private int emptyButtonPosition = 15;
    private int count = 0;
    private Context context = this;
    private List<String> buttons = new ArrayList<>();
    private CountDownTimer countDownTimer;
    private GridViewAdapter adapter;
    private TextView timer;
    private GridView gridView;
    private int counter=0;
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        scramble();
        setUpList();
        gridView = (GridView) findViewById(R.id.gridView);
        timer = (TextView) findViewById(R.id.timer);
        adapter = new GridViewAdapter(this, buttons, emptyButtonPosition);
        for (int i = 0; i < array.length; i++)
            if (array1[i] == buttons.get(i))
                count++;
        if (count == 16)
            runGame();
        count = 0;
        for (int i = 0; i < array.length; i++)
            if (array2[i] == buttons.get(i))
                count++;
        if (count == 16)
            runGame();
        gridView.setAdapter(adapter);
        startTimer();
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            if (temp.equals(""))
                emptyButtonPosition = i;
        }
    }

    private void setUpList() {
        for (String item : array)
            buttons.add(item);
    }

    public void runGame() {
        Intent intent = new Intent(context, Menu.class);
        context.startActivity(intent);
    }

    View.OnClickListener startGame = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            runGame();
        }
    };

    public void startTimer()
    {
        countDownTimer=new CountDownTimer(600000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //timer.setText(String.valueOf(counter));
                updateTimer();
                counter++;
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void updateTimer()
    {
        int minutes=(int) counter/60;
        int seconds =(int) counter%60;

        String timeLeftText;
        timeLeftText=""+minutes;
        timeLeftText+=":";
        if(seconds<10) timeLeftText+="0";
        timeLeftText+=seconds;

        timer.setText(timeLeftText);
    }
}
