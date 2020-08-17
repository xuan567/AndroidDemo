package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
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