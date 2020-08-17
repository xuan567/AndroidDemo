package com.example.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class another_right_fragment extends Fragment {
    @Override
    public onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.another_right_fragment,container,false);
        return view;
    }
}
