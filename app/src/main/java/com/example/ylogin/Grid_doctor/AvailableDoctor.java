package com.example.ylogin.Grid_doctor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ylogin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AvailableDoctor extends AppCompatActivity {
    ListView listViewavailableDoctor;
    List<Doctor> doctorList;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_doctor);
        databaseReference= FirebaseDatabase.getInstance().getReference("doctor");
        listViewavailableDoctor=findViewById(R.id.listviewAvailableDoctor);
        doctorList=new ArrayList<>();
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                doctorList.clear();
                for (DataSnapshot doctorSnapshot : dataSnapshot.getChildren()) {
                    Doctor doctor = doctorSnapshot.getValue(Doctor.class);
                    doctorList.add(doctor);
                }
                DoctorList adaptar=new DoctorList(AvailableDoctor.this,doctorList);
                listViewavailableDoctor.setAdapter(adaptar);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
