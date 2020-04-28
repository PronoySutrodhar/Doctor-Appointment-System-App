package com.example.ylogin.Client;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ylogin.R;

import java.util.List;

public class StudentList extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentList;

    public StudentList(Activity context, List<Student> studentList) {
        super(context, R.layout.list_layout,studentList);
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView callicon;
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.list_layout,null,true);
        TextView t1=view.findViewById(R.id.tvpname);
        TextView t2=view.findViewById(R.id.tvpage);
        TextView t3=view.findViewById(R.id.tvpdoctor);
        TextView t4=view.findViewById(R.id.tvpcontact);
        Student student=studentList.get(position);
        t1.setText(student.getName());
        t2.setText(student.getAge());
        t3.setText(student.getDoctor());
        t4.setText(student.getContact());
        callicon=view.findViewById(R.id.callicon);
        callicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "tel:" + studentList.get(position).getContact().trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
