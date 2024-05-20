package com.example.lab3_customlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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
    EditText txtName,txtDescription;
    ImageView imageView;
    Button btnAdd, btnUpdate, btnDelete;
    int selectedPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View();
        adapter = new FruitAdapter(this,R.layout.fruit,arrFruits);
        ListFruit.setAdapter(adapter);

        txtName = (EditText) findViewById(R.id.txtName);
        txtDescription = (EditText) findViewById(R.id.txtDescription);
        imageView = (ImageView) findViewById(R.id.image);

        ListFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                Fruits fruit = arrFruits.get(position);
                txtName.setText(fruit.getName());
                txtDescription.setText(fruit.getDescription());
                imageView.setImageResource(fruit.getImage());
                btnAdd = (Button) findViewById(R.id.btnAdd);
                btnUpdate = (Button) findViewById(R.id.btnUpdate);
                btnDelete = (Button) findViewById(R.id.btnDelete);

//                btnAdd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        addFruit();
//                    }
//                });

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateFruit();
                    }
                });

                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteFruit();
                    }
                });
            }
        });
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

//    private void addFruit() {
//        String name = txtName.getText().toString();
//        String description = txtDescription.getText().toString();
//        if (name.isEmpty() || description.isEmpty()) {
//            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        arrFruits.add(new Fruits(name, description, R.drawable.placeholder));  // Replace with a placeholder image
//        adapter.notifyDataSetChanged();
//        txtName.setText("");
//        txtDescription.setText("");
//    }

    private void updateFruit() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a fruit to update", Toast.LENGTH_SHORT).show();
            return;
        }
        String name = txtName.getText().toString();
        String description = txtDescription.getText().toString();
        if (name.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please enter both name and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Fruits fruit = arrFruits.get(selectedPosition);
        fruit.setName(name);
        fruit.setDescription(description);
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        selectedPosition = -1;
    }

    private void deleteFruit() {
        if (selectedPosition == -1) {
            Toast.makeText(this, "Please select a fruit to delete", Toast.LENGTH_SHORT).show();
            return;
        }
        arrFruits.remove(selectedPosition);
        adapter.notifyDataSetChanged();
        txtName.setText("");
        txtDescription.setText("");
        imageView.setImageResource(R.drawable.tran);
        selectedPosition = -1;
    }
}