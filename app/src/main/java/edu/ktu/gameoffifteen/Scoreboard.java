package edu.ktu.gameoffifteen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard extends AppCompatActivity {

    private ListView myList;
    private ListAdapter adapter;
    private Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboarddesign);
        List<ListItem> items = new ArrayList<>();
        myList = (ListView) findViewById(R.id.scoreList);
        int in = R.drawable.ic_arrow_downward_black_24dp;
        items.add(new ListItem("Jack", in, "1:40"));
        items.add(new ListItem("Jane", in, "2:00"));
        items.add(new ListItem("Bob", in, "0:49"));
        adapter = new ListAdapter(this, items);
        myList.setAdapter(adapter);
    }
}
