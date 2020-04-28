package com.example.ylogin.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ylogin.Client.Student;
import com.example.ylogin.R;
import com.example.ylogin.Client.Serial;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.example.ylogin.price;
//import com.example.ylogin.price;


public class medicaltest_fragment extends Fragment {
    Button buttonprice,buttonSubmit,buttonSerial;
    EditText etpname,etpage,etpdoctor,etpcontact;
    DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_medicaltest,null);
        databaseReference= FirebaseDatabase.getInstance().getReference("client");
        buttonprice=view.findViewById(R.id.buttonPrice);
        buttonSubmit=view.findViewById(R.id.buttonSubmit);
        buttonSerial=view.findViewById(R.id.buttonSerial);
        etpname=view.findViewById(R.id.pName);
        etpage=view.findViewById(R.id.pAge);
        etpdoctor=view.findViewById(R.id.pDoctorCatagory);
        etpcontact=view.findViewById(R.id.pContact);

        buttonprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), pricetest.class);
                startActivity(intent);
             }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        buttonSerial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Serial.class);
                startActivity(intent);
            }
        });

        return view ;
    }

    public void saveData()
    {
        String name="",age="",doctor="",contact="";
        boolean Error=false;
        if(etpname.getText().toString().trim().isEmpty()){
            etpname.setError("Insert Name");
            Error=true;
        }
        else {
            name=etpname.getText().toString().trim();
        }
        if(etpage.getText().toString().trim().isEmpty()){
            etpage.setError("Insert Name");
            Error=true;
        }
        else {
            age=etpage.getText().toString().trim();
        }

        if(etpdoctor.getText().toString().trim().isEmpty()){
            etpdoctor.setError("Insert Doctor");
            Error=true;
        }
        else {
            doctor=etpdoctor.getText().toString().trim();
        }
        if(etpcontact.getText().toString().trim().isEmpty()){
            etpcontact.setError("Inser Contact no");
            Error=true;
        }
        else {
            contact=etpname.getText().toString().trim();
        }

        //String contact=etpcontact.getText().toString().trim();
        String key=databaseReference.push().getKey();
        if(Error==false) {
            Student student = new Student(name, age, doctor, contact);
            databaseReference.child(key).setValue(student);
            Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity(), "Put all Information", Toast.LENGTH_SHORT).show();
        }

        etpname.setText("");
        etpage.setText("");
        etpdoctor.setText("");
        etpcontact.setText("");

    }
}
