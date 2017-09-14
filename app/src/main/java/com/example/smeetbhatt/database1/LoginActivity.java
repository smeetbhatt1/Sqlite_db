package com.example.smeetbhatt.database1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button b;
    EditText unEditText,upeditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        testUpload();

        b = (Button) findViewById(R.id.buttonLogin);
        unEditText = (EditText) findViewById(R.id.unEditText);
        upeditText = (EditText) findViewById(R.id.upEditText);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unEditText.getText().toString().equals("test_user") && upeditText.getText().toString().equals("test_pass")){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    submit();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void submit(){
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
    }

    public void testUpload(){
        int i = 1+1;
        Log.i("Test Upload ",String.valueOf(i));
        int ii = i+1;
        Log.i("Test Upload ",String.valueOf(ii));
    }

}
