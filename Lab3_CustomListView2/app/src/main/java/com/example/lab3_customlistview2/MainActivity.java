package com.example.lab3_customlistview2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listUser;
    ArrayList<Users> arrUser;
    UserAdapter adapter;
    EditText txtName, txtDescription;
    ImageView avatar, flag;
    Button btnAdd, btnUpdate, btnDelete;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View();
        adapter = new UserAdapter(this, R.layout.list_row, arrUser);
        listUser.setAdapter(adapter);


        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        avatar = findViewById(R.id.image);
        flag = findViewById(R.id.flag);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


//        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                selectedPosition = position;
//                Users user = arrUser.get(position);
//                txtName.setText(user.getName());
//                txtDescription.setText(user.getDescription());
//                avatar.setImageResource(user.getAvatar());
//                flag.setImageResource(user.getFlag());
//            }
//        });
    }

    private void View() {
        listUser = findViewById(R.id.listView);
        arrUser = new ArrayList<>();
//        arrUser.add(new Users(R.drawable.pele,R.drawable.brazil,"Pele","h"));
        arrUser.add(new Users(R.drawable.pele, R.drawable.brazil,
                "Pele", "October 23, 1940 (age 72)"));
        arrUser.add(new Users(R.drawable.maradona, R.drawable.arg,
                "Diego Maradona", "October 30, 1960 (age 52)"));
        arrUser.add(new Users(R.drawable.johan, R.drawable.holland,
                "Johan Cruyff", "April 25, 1947 (age 65)"));
        arrUser.add(new Users(R.drawable.ronaldo, R.drawable.brazil,
                "Ronaldo De Lima", "September 22, 1976 (age 36)"));
        arrUser.add(new Users(R.drawable.m10, R.drawable.arg,
                "Lionel Messi", "June 24, 1987 (age 36)"));
        arrUser.add(new Users(R.drawable.cr7, R.drawable.portugal,
                "Cristiano Ronaldo", "February 5, 1985 (age 38)"));
    }
}
