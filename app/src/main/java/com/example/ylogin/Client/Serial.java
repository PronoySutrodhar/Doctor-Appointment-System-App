package com.example.ylogin.Client;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ylogin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Serial extends AppCompatActivity {
    ListView listViewitem;
    List<Student> studentList;
    DatabaseReference databaseReference;
    ImageView callicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        databaseReference= FirebaseDatabase.getInstance().getReference("client");
        listViewitem=findViewById(R.id.listviewSerial);
        studentList=new ArrayList<>();


    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();
                for (DataSnapshot studentSnapshot : dataSnapshot.getChildren()) {
                    Student student = studentSnapshot.getValue(Student.class);
                    studentList.add(student);
                }
                StudentList adaptar=new StudentList(Serial.this,studentList);
                listViewitem.setAdapter(adaptar);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
