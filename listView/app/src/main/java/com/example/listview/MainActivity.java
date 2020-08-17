package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        ListView listView = (ListView) findViewById(R.id.list_view);
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(adapter);

    }
    public void initFruits(){
        for(int i = 0;i<10;i++){
            Fruit apple = new Fruit("apple",R.drawable.ic_launcher_background);
            fruitList.add(apple);
        }
    }
}