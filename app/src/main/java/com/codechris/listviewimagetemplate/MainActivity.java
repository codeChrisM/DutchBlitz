package com.codechris.listviewimagetemplate;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] CharTitles;
    String[] CharDescriptions;
    int[] images = {R.drawable.character1,R.drawable.character2,R.drawable.character3,R.drawable.character4,R.drawable.character5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res=getResources();

        res.getStringArray(R.array.titles);
        CharTitles = res.getStringArray(R.array.titles);
        CharDescriptions =res.getStringArray(R.array.descriptions);

        list= (ListView) findViewById(R.id.listView);
        VivzAdapter adapter = new VivzAdapter(this, CharTitles, images, CharDescriptions);
        list.setAdapter(adapter);

    }
}

class VivzAdapter extends ArrayAdapter<String>{

    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;


    VivzAdapter(Context c, String[] titles, int imgs[], String[] desc){
        super(c, R.layout.single_row, R.id.textView, titles);
        this.context = c;
        this.images= imgs;
        this.titleArray = titles;
        this.descriptionArray= desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myTitle = (TextView) row.findViewById(R.id.textView);
        TextView myDescription = (TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descriptionArray[position]);

        return row;
    }
}
