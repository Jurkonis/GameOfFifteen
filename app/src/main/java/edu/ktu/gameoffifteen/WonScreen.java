package edu.ktu.gameoffifteen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WonScreen extends AppCompatActivity {

    private Button submit;
    private TextView time;
    private EditText name;
    private String timeLeftText;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wonscreendesign);
        Intent intent = getIntent();
        submit = (Button) findViewById(R.id.submit);
        time = (TextView) findViewById(R.id.time);
        name = (EditText) findViewById(R.id.name);
        timeLeftText=intent.getStringExtra("time");
        time.setText(timeLeftText);
    }
}
