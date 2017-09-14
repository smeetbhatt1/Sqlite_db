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

public class DeleteActivity extends AppCompatActivity {

    EditText deleteET;
    Button deleteBTN;
    TextView deleteAck;
    DatabaseHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        handler = new DatabaseHandler(this);
        deleteET = (EditText) findViewById(R.id.deleteET);
        deleteBTN = (Button) findViewById(R.id.deleteButton);
        deleteAck = (TextView) findViewById(R.id.deleteAck);
    }


    public void setDeleteButton(View view){
        String id = deleteET.getText().toString();
        if(!id.equals("")){
            int result = handler.deleteFruit(id);
            if(result >0){
                deleteAck.setText("Deleted");
                deleteET.setText("");
            }
            else{
                deleteAck.setText("Failed");
            }
        }
        else {
            deleteAck.setText("Please enter Detail");
        }
    }





    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.delete);
        item.setVisible(false);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.update:
                startActivity(new Intent(this, UpdateActivity.class));
                return true;
            case R.id.create:
                startActivity(new Intent(this, CreateActivity.class));
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
