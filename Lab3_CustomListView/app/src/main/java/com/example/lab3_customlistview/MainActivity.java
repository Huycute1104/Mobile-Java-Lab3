package com.example.lab3_customlistview;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ListFruit;
    ArrayList<Fruits> arrFruits;
    FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View();
        adapter = new FruitAdapter(this,R.layout.fruit,arrFruits);
        ListFruit.setAdapter(adapter);

    }

    private void View() {
        ListFruit = findViewById(R.id.listViewFruit);
        arrFruits = new ArrayList<>(0);
        arrFruits .add(new Fruits("Apple","A sweet, crisp fruit, commonly red, green, or yellow",R.drawable.apple));
        arrFruits .add(new Fruits("Avocado","A creamy, green fruit with a large pit and buttery flavor",R.drawable.avocado));
        arrFruits .add(new Fruits("Orange","A juicy, sweet citrus fruit with a bright orange peel.",R.drawable.orange));
        arrFruits .add(new Fruits("Durian","A spiky fruit known for its strong odor and creamy flesh.",R.drawable.saurieng));
        arrFruits .add(new Fruits("Watermelon","A large, juicy fruit with a green rind and sweet, red flesh.",R.drawable.watermelon));
        arrFruits .add(new Fruits("Strawberry","A sweet, crisp fruit, commonly red, green, or yellow",R.drawable.strawberry));
        arrFruits .add(new Fruits("Pomegranate","A creamy, green fruit with a large pit and buttery flavor",R.drawable.pomegranates));
        arrFruits .add(new Fruits("Grape","A juicy, sweet citrus fruit with a bright orange peel.",R.drawable.grape));
        arrFruits .add(new Fruits("Blueberry","A spiky fruit known for its strong odor and creamy flesh.",R.drawable.blueberry));
    }
}