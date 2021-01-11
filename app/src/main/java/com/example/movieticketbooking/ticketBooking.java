package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ticketBooking extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);
    }
    public void ticketBooking(View view){
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        String str1,str2;
        int p;
        str1=e1.getText().toString();
        str2=e2.getText().toString();
        if(str1.isEmpty() || str2.isEmpty() ){
            Toast.makeText(getApplicationContext(),"The above fields should not be empty",Toast.LENGTH_LONG).show();
        }
        else{
            p = Integer.parseInt(str1);
            if(p>10)
            {
                Toast.makeText(getApplicationContext(),"Booking of 10 seats only allowed on a single transaction",Toast.LENGTH_LONG).show();
            }
            else {
                Intent obj = new Intent(getApplicationContext(), bookingConfirmation.class);
                obj.putExtra(bookingConfirmation.str,str1);
                startActivity(obj);
            }
        }
    }
}