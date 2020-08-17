package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }
    public class TitleLayout extends LinearLayout {
        public TitleLayout(Context context, AttributesSet attrs) {
            super(Context,attrs);
            LayoutInflater.from(context).inflate((R.layout.title,this));
        }
    }
}