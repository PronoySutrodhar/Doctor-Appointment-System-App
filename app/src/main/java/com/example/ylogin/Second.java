package com.example.ylogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Second extends AppCompatActivity {
    Button buttongo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mAuth = FirebaseAuth.getInstance();
        buttongo=findViewById(R.id.Buttongo);
        buttongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Second.this,hospitalinfo.class);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.signout){

            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent =new Intent(Second.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }
}
