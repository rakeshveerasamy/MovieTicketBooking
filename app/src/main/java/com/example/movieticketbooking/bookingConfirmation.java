package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bookingConfirmation extends AppCompatActivity {
    public static String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);
        Intent i = getIntent();
        str = i.getStringExtra(str);
        int  price;
        int Ticketprice;
        Ticketprice=Integer.parseInt(str);
        price=Ticketprice*150;
        TextView tv = (TextView)findViewById(R.id.text10);
        tv.setText("Price for your booking is" +price );
    }
    public void paymentMode(View view){
        Intent obj=new Intent(getApplicationContext(),payment.class);
        startActivity(obj);
    }
}