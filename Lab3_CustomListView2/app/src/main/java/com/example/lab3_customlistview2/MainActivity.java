package com.example.lab3_customlistview2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayList<Users> arrayList = new ArrayList<>();

        arrayList.add(new Users(R.drawable.pele, R.drawable.brazil,
                "Pele", "October 23, 1940 (age 72)"));
        arrayList.add(new Users(R.drawable.maradona, R.drawable.arg,
                "Diego Maradona", "October 30, 1960 (age 52)"));
        arrayList.add(new Users(R.drawable.johan, R.drawable.holland,
                "Johan Cruyff", "April 25, 1947 (age 65)"));
        arrayList.add(new Users(R.drawable.ronaldo, R.drawable.brazil,
                "Ronaldo De Lima", "September 22, 1976 (age 36)"));
        arrayList.add(new Users(R.drawable.m10, R.drawable.arg,
                "Lionel Messi", "June 24, 1987 (age 36)"));
        arrayList.add(new Users(R.drawable.cr7, R.drawable.portugal,
                "Cristiano Ronaldo", "February 5, 1985 (age 38)"));

        UserAdapter legendAdapter = new UserAdapter(this, R.layout.list_row, arrayList);

        listView.setAdapter(legendAdapter);

    }
}