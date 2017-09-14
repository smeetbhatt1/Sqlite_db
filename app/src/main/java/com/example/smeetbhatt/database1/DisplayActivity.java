package com.example.smeetbhatt.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView displayTV;
    DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        handler = new DatabaseHandler(this);
        displayTV = (TextView) findViewById(R.id.displayTV);
        display();

    }
    public void display(){
        String db = handler.getAllFruits();
        displayTV.setText(db);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.list);
        item.setVisible(false);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.update:
                startActivity(new Intent(this, UpdateActivity.class));
                return true;
            case R.id.delete:
                startActivity(new Intent(this, DeleteActivity.class));
                return true;
            case R.id.create:
                startActivity(new Intent(this, CreateActivity.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
