package com.example.ylogin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.ylogin.R;
import com.example.ylogin.adaptar.CustomAdapter;
import com.example.ylogin.Grid_doctor.griddoctor;

public class doctor_fragment extends Fragment {
    GridView gridView;
    String []doctorCatagory;
    int [] pic={R.drawable.alzheimer,R.drawable.bacteria,R.drawable.cancer,R.drawable.ear,
            R.drawable.heart,R.drawable.hiv,R.drawable.healthcare,R.drawable.osteoporosis,R.drawable.doctor,
            R.drawable.toothbrush, R.drawable.stethoscope,R.drawable.pills,R.drawable.bloodpressure,
            R.drawable.molarcrown,R.drawable.dentistchair,R.drawable.pills};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_doctor,null);
        gridView=view.findViewById(R.id.gridview);
       doctorCatagory=getResources().getStringArray(R.array.doctor_catagory);
        CustomAdapter adapter=new CustomAdapter(getActivity(),doctorCatagory,pic);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), griddoctor.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "process", Toast.LENGTH_SHORT).show();
            }
        });

        return view ;
    }
}
