package edu.ktu.gameoffifteen;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<String> {
    List<String> objects;
    Context context;
    int emptyButtonPosition;
    int up;
    int down;
    int left;
    int right;
    String[] array1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};
    String[] array2={"","15","14","13","12","11","10","9","8","7","6","5","4","3","2","1"};

    public GridViewAdapter(Context context, List<String> objects, int emptyButtonPosition) {
        super(context, R.layout.design, objects);
        this.objects = objects;
        this.context = context;
        this.emptyButtonPosition = emptyButtonPosition;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.design, null);
        }
        final Button button = (Button) v.findViewById(R.id.button);
        if(emptyButtonPosition==position) {
            button.setBackgroundResource(R.drawable.ic_android_black_24dp);
            button.setText("");
        }
        else{
        button.setText(objects.get(position));
        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.YELLOW);
        button.setTextSize(30);}
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up = position + 4;
                down = position - 4;
                if(position!=0&&position!=4&& position!=8&&position!=12)
                left = position - 1;
            else
            	left = position;
           		if(position!=3&& position!=7&&position!=11&&position!=15)
                right = position + 1;
            else
            	right = position;
                if (emptyButtonPosition == up || emptyButtonPosition == down || emptyButtonPosition == left || emptyButtonPosition == right) {
                    String temp = button.getText().toString();
                    objects.set(emptyButtonPosition, temp);
                    objects.set(position, "");
                    emptyButtonPosition = position;
                    notifyDataSetChanged();
                }
                // Toast.makeText(context,"Position: "+String.valueOf(position)+" "+"Empty position: "
                //        +String.valueOf(emptyButtonPosition),Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
