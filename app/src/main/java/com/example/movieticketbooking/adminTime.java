package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class adminTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_time);
    }
    public void displayPage(View view){
        Intent obj =new Intent(getApplicationContext(),adminDelete.class);
        startActivity(obj);
    }
    public void deletePage(View view){
        Intent obj =new Intent(getApplicationContext(),adminDelete.class);
        startActivity(obj);
    }
    public void insertPage(View view){
        Intent obj=new Intent(getApplicationContext(),adminInsert.class);
        startActivity(obj);
    }
    public void  updatePage(View view){
        Intent  obj=new Intent(getApplicationContext(),adminUpdate.class);
        startActivity(obj);
    }
    public void logoutPage(View view){
        Toast.makeText(getApplicationContext(),"....You are successfully logged out....",Toast.LENGTH_LONG).show();
        Intent obj=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(obj);
    }
}