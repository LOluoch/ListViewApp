package com.lavineoluoch.myapplication.listviewapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lavineoluoch.myapplication.listviewapp.MainActivity;
import com.lavineoluoch.myapplication.listviewapp.Model.Cow;
import com.lavineoluoch.myapplication.listviewapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by USER on 9/8/2015.
 */
public class CustomAdapter extends BaseAdapter {

    /**
     *  @InjectView(R.id.cow_adtitle)TextView cow_adtitle;
     @InjectView(R.id.cow_breed)TextView cow_breed;
     @InjectView(R.id.cow_location)TextView cow_county;
     @InjectView(R.id.cow_price)TextView cow_price;
     *
      */


    private Context context;
    private List<Cow> cows;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, List<Cow> cows) {
        this.context = context;
        this.cows = cows;
    }

    @Override
    public int getCount() {
        return cows.size();
    }

    @Override
    public Object getItem(int position) {
        return cows.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv_adtitle,tv_breed,tv_county,tv_price;

        if (layoutInflater == null){
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_row,parent,false);
        }
            tv_adtitle = (TextView)convertView.findViewById(R.id.cow_adtitle);
            tv_breed =  (TextView)convertView.findViewById(R.id.cow_breed);
            tv_county = (TextView)convertView.findViewById(R.id.cow_location);
            tv_price = (TextView)convertView.findViewById(R.id.cow_price);

            Cow cow = cows.get(position);

            tv_adtitle.setText(cow.getCow_adtitle());
            tv_breed.setText(cow.getCow_breed());
            tv_county.setText(cow.getCow_county());
            tv_price.setText(cow.getCow_price());


        }
        return convertView;
    }
}
