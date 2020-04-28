package com.example.ylogin.Grid_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ylogin.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class griddoctor extends AppCompatActivity {
    EditText doctorname,doctortype,doctorqualification,doctorduty;
    Button addDoctor,availableDoctor;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference= FirebaseDatabase.getInstance().getReference("doctor");
        setContentView(R.layout.activity_griddoctor);
        doctorname=findViewById(R.id.doctorname);
        doctortype=findViewById(R.id.doctortype);
        doctorqualification=findViewById(R.id.doctorqualification);
        doctorduty=findViewById(R.id.doctordutytime);
        addDoctor=findViewById(R.id.addDoctor);
        availableDoctor=findViewById(R.id.availableDoctor);
        addDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDoctor();
            }
        });
        availableDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(griddoctor.this, AvailableDoctor.class);
                startActivity(intent);
                Toast.makeText(griddoctor.this, "Available Doctor", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void addDoctor(){
        boolean Error=false;
        String name="",type="",qualification="",duty="";

        if(doctorname.getText().toString().trim().isEmpty()){
            doctorname.setError("Insert DoctorName");
            Error=true;
        }
        else{

            name=doctorname.getText().toString().trim();
        }
       // String name=doctorname.getText().toString().trim();
        if(doctortype.getText().toString().trim().isEmpty()){
            doctortype.setError("Insert DoctorType");
            Error=true;
        }
        else{

            type=doctortype.getText().toString().trim();
        }
         // String type=doctortype.getText().toString().trim();
        if(doctorqualification.getText().toString().trim().isEmpty()){
            doctorqualification.setError("Insert DoctorQualification");
            Error=true;
        }
        else{

            qualification=doctorqualification.getText().toString().trim();
        }
        if(doctorduty.getText().toString().trim().isEmpty()){
            doctorduty.setError("Insert DoctorQualification");
            Error=true;
        }
        else{

            duty=doctorduty.getText().toString().trim();
        }


        String key=databaseReference.push().getKey();

        if(Error==false){
            Doctor doctor=new Doctor(name,type,qualification,duty);
            databaseReference.child(key).setValue(doctor);
            Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
        }

      //  Doctor doctor=new Doctor(name,type,qualification,duty);
        //databaseReference.child(key).setValue(doctor);
        //Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Insert All Data Field", Toast.LENGTH_SHORT).show();

        }

        doctorname.setText("");
        doctortype.setText("");
        doctorqualification.setText("");
        doctorduty.setText("");
    }

}
