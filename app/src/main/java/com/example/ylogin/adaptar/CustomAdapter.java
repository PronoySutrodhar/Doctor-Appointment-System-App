package com.example.ylogin.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ylogin.R;
import com.example.ylogin.fragment.doctor_fragment;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String [] doctorCatagory;
    int [] pic;

    public CustomAdapter(Context context, String[] doctorCatagory, int[] pic) {
        this.context = context;
        this.doctorCatagory = doctorCatagory;
        this.pic=pic;
    }



    @Override
    public int getCount() {
        return doctorCatagory.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView callicon;


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.sample_view,parent,false);
        ImageView imageView=convertView.findViewById(R.id.imageviewpic);
        imageView.setImageResource(pic[position]);
           TextView textView= convertView.findViewById(R.id.textview);
           textView.setText(doctorCatagory[position]);
           callicon=convertView.findViewById(R.id.callicon);





        return convertView;
    }
}
