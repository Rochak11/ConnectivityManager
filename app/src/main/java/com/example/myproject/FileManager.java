package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FileManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
final Button b1= findViewById(R.id.b1);
        final Button b2= findViewById(R.id.b2);
        final Button b3= findViewById(R.id.b3);
        final Button b4= findViewById(R.id.b4);
        final Button b5= findViewById(R.id.b5);


        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                b1.setText("Pressed");
            }
        });
final ListView lv = findViewById(R.id.lv);
final TextAdapter textAdapter1 = new TextAdapter();
lv.setAdapter(textAdapter1);
List<String> example = new ArrayList<>();

for(int i=0; i<100; i++){
    example.add(String.valueOf(i));
}
textAdapter1.setData(example);
        }
        static class TextAdapter extends BaseAdapter{
private final List<String> data = new ArrayList<>();

public void setData(List<String>data){
    if(data !=null){
        this.data.clear();
        if(data.size()>0){
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }
}
            @Override
            public int getCount() {
               return data.size();
            }

            @Override
            public Object getItem(int position) {
                return data.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               if(convertView==null){
                   convertView = LayoutInflater. from(parent.getContext()).inflate(R.layout.item, parent, false);
                    convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.textItem)));
               }
               ViewHolder holder = (ViewHolder) convertView.getTag();
                final String item = (String) getItem(position);
                holder.info.setText(item);
                return convertView;

            }
           static class ViewHolder{
    TextView info;

    ViewHolder(TextView info){
        this.info = info;
    }
            }
        }
    }
