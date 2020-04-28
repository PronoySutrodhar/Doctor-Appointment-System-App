package com.example.ylogin.Grid_doctor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ylogin.Client.Student;
import com.example.ylogin.R;

import java.util.List;

public class DoctorList extends ArrayAdapter<Doctor> {
    private Activity context;
    private List<Doctor> doctorList;

    public DoctorList(Activity context,  List<Doctor> doctorList) {
        super(context,R.layout.list_layout_doctor,doctorList);
        this.context = context;
        this.doctorList = doctorList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view2=inflater.inflate(R.layout.list_layout_doctor,null,true);
        TextView doctorname=view2.findViewById(R.id.tvdoctorname);
        TextView doctortype=view2.findViewById(R.id.tvdoctortype);
        TextView doctorqualification=view2.findViewById(R.id.tvdoctorqualification);
        TextView doctorduty=view2.findViewById(R.id.tvdoctorduty);
        Doctor doctor=doctorList.get(position);
        doctorname.setText(doctor.getName());
        doctortype.setText(doctor.getType());
        doctorqualification.setText(doctor.getQualification());
        doctorduty.setText(doctor.getDuty());
        return view2;
    }
}
