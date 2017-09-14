package com.example.smeetbhatt.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    DatabaseHandler handler;
    EditText addFruitET;
    Button addFruitBTN;
    TextView displayAckTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        handler = new DatabaseHandler(this);
        addFruitET = (EditText) findViewById(R.id.addFruitET);
        addFruitBTN = (Button) findViewById(R.id.addFruitBTN);
        displayAckTV = (TextView) findViewById(R.id.displayAckTV);
    }

    public void setAddFruitBTN(View v) {
        String fruit = addFruitET.getText().toString();
        if (!fruit.equals("")) {
            boolean result = handler.addFruit(new Fruit(fruit));
            if (result) {
                displayAckTV.setText("Added");
                addFruitET.setText("");
            }
            else {
                displayAckTV.setText("Failed");
                addFruitET.setText("");
            }
        }
        else {
            displayAckTV.setText("Please enter Details");
        }
    }

    //-----

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.create);
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
            case R.id.list:
                startActivity(new Intent(this, DisplayActivity.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
