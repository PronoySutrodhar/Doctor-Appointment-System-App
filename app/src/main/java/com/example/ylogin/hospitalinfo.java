package com.example.ylogin;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.ylogin.adaptar.ViewPagerAdaptar;
import com.example.ylogin.fragment.hospital_fragment;
import com.example.ylogin.fragment.doctor_fragment;
import com.example.ylogin.fragment.medicaltest_fragment;

public class hospitalinfo extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalinfo);
        toolbar=findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        setDatatoViewpager();
      //  button=findViewById(R.id.buttonid);

    }
    private void setDatatoViewpager() {
        ViewPagerAdaptar adaptar=new ViewPagerAdaptar(getSupportFragmentManager());
        adaptar.addFragment(new hospital_fragment(),"Hospital Info");
        adaptar.addFragment(new doctor_fragment(),"Doctor Info");
        adaptar.addFragment(new medicaltest_fragment(),"Appointment");
        viewPager.setAdapter(adaptar);
        tabLayout.setupWithViewPager(viewPager);

    }


}
