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

import org.w3c.dom.Text;

public class UpdateActivity extends AppCompatActivity {

    DatabaseHandler handler;
    EditText updateOn, updateTo;
    Button updateButton;
    TextView updateAckTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        handler = new DatabaseHandler(this);
        updateOn = (EditText) findViewById(R.id.updateOnId);
        updateTo = (EditText) findViewById(R.id.updateToFruitET);
        updateButton = (Button) findViewById(R.id.updateButton);
        updateAckTV = (TextView) findViewById(R.id.updateAckTV);

    }
    public void setUpdateButton(View view) {
        String a = updateOn.getText().toString();
        String newName = updateTo.getText().toString();

        if (!a.equals("") && !newName.equals("")) {
            boolean result = handler.updateFruit(a, newName);
            if (result) {
                updateAckTV.setText("Updated");
                updateOn.setText("");
                updateTo.setText("");
            } else {
                updateAckTV.setText("Not such id");
            }
        }
        else{
            updateAckTV.setText("Please enter Details");
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.update);
        item.setVisible(false);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.create:
                startActivity(new Intent(this, CreateActivity.class));
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
