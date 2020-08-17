package com.example.deom2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    public void initFruits(){
        Fruit apple = new Fruit("apple",R.drawable.ic_launcher_background);
        fruitList.add(apple);
        Fruit banana = new Fruit("apple",R.drawable.ic_launcher_background);
        fruitList.add(banana);
        Fruit aaa = new Fruit("aaa",R.drawable.ic_launcher_background);
        fruitList.add(aaa);
        Fruit bbb = new Fruit("bbb",R.drawable.ic_launcher_background);
        fruitList.add(bbb);
        Fruit ccc = new Fruit("ccc",R.drawable.ic_launcher_background);
        fruitList.add(ccc);
        Fruit ddd = new Fruit("ddd",R.drawable.ic_launcher_background);
        fruitList.add(ddd);
        Fruit eee = new Fruit("eee",R.drawable.ic_launcher_background);
        fruitList.add(eee);
    }
}