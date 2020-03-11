package com.example.mum;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import android.util.SparseBooleanArray;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Autocomplete List
    private AppBarConfiguration mAppBarConfiguration;
    AutoCompleteTextView autocomplete;
    String[] ingredientList = {
            "Avocado",
            "Tomato",
            "Broccoli",
            "Onion",
            "Green Onion"};

    ListView listViewOptions;
    Button btnDeleteItems;

    List<String> selectionList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Auto-Complete List View Functionality
        autocomplete = findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_multiple_choice, ingredientList);
        autocomplete.setThreshold(0);
        autocomplete.setAdapter(adapter);
        autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                // here is your selected item
                System.out.println("You chose" + selectedItem);
            }
        });



        // List View Functionality
        listViewOptions = findViewById(R.id.list_view_ingredients);

        myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, selectionList);
        listViewOptions.setAdapter(adapter);

        btnDeleteItems = findViewById(R.id.deleteButton);
        btnDeleteItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionList = new ArrayList<>();
                SparseBooleanArray itemChecked = listViewOptions.getCheckedItemPositions();
                for (int i = 0; i < itemChecked.size(); i++) {
                    int key = itemChecked.keyAt(i);
                    boolean value = itemChecked.get(key);
                    if(value) {
                        selectionList.add((listViewOptions.getItemAtPosition(key).toString()));
                    }
                }

                if (selectionList.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nothing is there", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Checked Items: " + selectionList, Toast.LENGTH_SHORT).show();
                }
            }
        });









        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }











}
