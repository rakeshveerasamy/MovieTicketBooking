package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class userLogin extends AppCompatActivity {
    EditText uname,pw;
    String user,passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        uname=(EditText)findViewById(R.id.editText1);
        pw=(EditText)findViewById(R.id.editText2);
    }
    public void loginSuccess(View view) {
        user=uname.getText().toString();
        passwd=pw.getText().toString();
        if (user.isEmpty() || passwd.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter UserName and Password", Toast.LENGTH_LONG).show();
        }
        else if(user.equals("user") && passwd.equals("user1234")){
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
            Intent obj1=new Intent(getApplicationContext(),Usertime.class);
            startActivity(obj1);
        }
        else{
            Toast.makeText(getApplicationContext(), "Login Unsuccessful : Please enter the correct details ",
                    Toast.LENGTH_LONG).show();

        }
    }
}