package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class WonScreen extends AppCompatActivity {

    private Button submit;
    private TextView time;
    private EditText name;
    private String timeLeftText;
    private Context context = this;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wonscreendesign);
        mIntent = getIntent();
        submit = (Button) findViewById(R.id.submit);
        time = (TextView) findViewById(R.id.time);
        name = (EditText) findViewById(R.id.name);
        timeLeftText=mIntent.getStringExtra("time");
        time.setText(timeLeftText);
        submit.setOnClickListener(score);
    }

    public void showScore()
    {
        Intent intent = new Intent(context, Scoreboard.class);
        if(time.getText()!= null && name.getText()!= null) {
            intent.putExtra("time", timeLeftText);
            intent.putExtra("name", name.getText().toString());
        }
        //intent.putExtras(mIntent);
        context.startActivity(intent);
    }

    View.OnClickListener score = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showScore();
        }
    };
}
