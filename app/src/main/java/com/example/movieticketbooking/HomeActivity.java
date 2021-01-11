package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void userLogin(View view ){
        Intent obj= new Intent(getApplicationContext(),userLogin.class);
        startActivity(obj);
    }
    public void adminLogin(View view){
        Intent obj1= new Intent(getApplicationContext(),adminLogin.class);
        startActivity(obj1);
    }
}