package edu.ktu.gameoffifteen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    private ListView myList;
    private ListAdapter adapter;
    private Button menu;
    private Context context=this;
    private Intent mIntent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboarddesign);
        List<ListItem> items = new ArrayList<>();
        myList = (ListView) findViewById(R.id.scoreList);
        menu = (Button) findViewById(R.id.again);
        int in = R.drawable.ic_arrow_downward_black_24dp;
        mIntent= getIntent();
        items.add(new ListItem("Jack", in, "1:40"));
        items.add(new ListItem("Jane", in, "2:00"));
        items.add(new ListItem("Bob", in, "0:49"));
        adapter = new ListAdapter(this, items);
        myList.setAdapter(adapter);
        if(mIntent.hasExtra("name") && mIntent.hasExtra("time"))
        {
            items.add(new ListItem(mIntent.getStringExtra("name"), in, mIntent.getStringExtra("time")));
        }
        menu.setOnClickListener(menuScreen);
    }

    public void showMenu()
    {
        Intent intent = new Intent(context, Menu.class);
        intent.putExtras(mIntent);
        context.startActivity(intent);
    }

    View.OnClickListener menuScreen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showMenu();
        }
    };
}
