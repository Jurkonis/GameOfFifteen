package edu.ktu.gameoffifteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] array={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
    int emptyButtonPosition=15;
    List<String> buttons=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scramble();
        setUpList();
        GridView gridView=(GridView)findViewById(R.id.gridView);
        GridViewAdapter adapter =new GridViewAdapter(this,buttons, emptyButtonPosition);
        gridView.setAdapter(adapter);
    }

    private void scramble() {
        int index;
        String temp;
        Random random=new Random();

        for(int i =array.length-1;i>0;i--)
        {
            index=random.nextInt(i+1);
            temp=array[index];
            array[index]=array[i];
            array[i]=temp;
            if (temp=="")
                emptyButtonPosition =i;
        }
    }

    private void setUpList() {
        for (String item:array)
            buttons.add(item);
    }


}
