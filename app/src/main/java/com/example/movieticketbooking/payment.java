package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView tv=(TextView) findViewById(R.id.text8);
        int num=+(int)(Math.random()*(111111*999999));
    }
    public void logoutPage(View view){
        Toast.makeText(getApplicationContext(),"....You are successfully logged out....",Toast.LENGTH_LONG).show();
        Intent obj=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(obj);
    }
}