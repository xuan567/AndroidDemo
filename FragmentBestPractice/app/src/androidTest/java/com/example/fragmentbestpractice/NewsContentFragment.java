package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class NewsContentFragment implements Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View = inflater(R.layout.new_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,String newsContent){

    }
}
