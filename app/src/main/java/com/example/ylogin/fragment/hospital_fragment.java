package com.example.ylogin.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ylogin.Emnai;
import com.example.ylogin.Googlemap;
import com.example.ylogin.R;

public class hospital_fragment extends Fragment {
    Button button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hospital,null);
        button=view.findViewById(R.id.buttonid);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), Emnai.class);
               startActivity(intent);
           }
        });
        return view ;



    }



}
