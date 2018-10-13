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

    public GridViewAdapter (Context context,List<String> objects,int emptyButtonPosition) {
        super(context,R.layout.design,objects);
        this.objects = objects;
        this.context = context;
        this.emptyButtonPosition = emptyButtonPosition;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (v==null) {
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.design,null);
        }
        final Button button=(Button)v.findViewById(R.id.button);
        button.setText(objects.get(position));
        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.YELLOW);
        button.setTextSize(30);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp=button.getText().toString();
                objects.set(emptyButtonPosition,temp);
                objects.set(position,"");
                emptyButtonPosition=position;
                notifyDataSetChanged();
                Toast.makeText(context,"Position: "+String.valueOf(position)+" "+"Empty position: "+String.valueOf(emptyButtonPosition),Toast.LENGTH_SHORT).show();
            }
        });
            return v;
        }
    }
