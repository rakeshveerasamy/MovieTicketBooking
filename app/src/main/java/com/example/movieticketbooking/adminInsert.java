package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class adminInsert extends AppCompatActivity {
    TextView  clockSelectedTime,clockselecteddate;
    Button spinnerbtn , clockbtn;
    TimePicker spinnertimepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_insert);

    }
    public void buttonDate(View view)
    {
        clockselecteddate = (TextView)findViewById(R.id.text23);
        clockbtn = (Button)findViewById(R.id.button24);
        clockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(adminInsert.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        clockselecteddate.setText(dayOfMonth+"."+(month+1)+"."+year);
                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });
    }
    public void button(View view)
    {
        clockSelectedTime = (TextView)findViewById(R.id.text21);
        spinnerbtn = (Button)findViewById(R.id.button22);
        spinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Calendar mcurrenttime = Calendar.getInstance();
               int hour = mcurrenttime.get(Calendar.HOUR_OF_DAY);
               int minutes = mcurrenttime.get(Calendar.MINUTE);
               TimePickerDialog mTimePicker;
               mTimePicker = new TimePickerDialog(adminInsert.this, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       String am_pm;
                       if(hourOfDay>12)
                       {
                           am_pm = "PM";
                           hourOfDay=hourOfDay-12;
                       }
                       else
                       {
                           am_pm ="AM";
                       }
                       clockSelectedTime.setText(hourOfDay+":"+minute+" "+am_pm);
                   }
               },hour,minutes,true);
               mTimePicker.setTitle("Select Time");
               mTimePicker.show();
            }
        });
    }
    public void insertMovie(View view)
    {
        DBAdapter db = new DBAdapter(this);
        db.open();
        EditText txt1,txt3;
        String str1, str2,str3,str4;

        txt1 = (EditText)findViewById(R.id.editText16);
        txt3 = (EditText)findViewById(R.id.editText19);
        str1 = txt1.getText().toString();
        str2 = clockSelectedTime.getText().toString();
        str3 = txt3.getText().toString();
        str4 = clockselecteddate.getText().toString();


        long id = db.insertMovie(str1,str4, str2,str3);
        if(id != 0)
            Toast.makeText(getApplicationContext(),"Data Inserted Successfully ",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Data could not be inserted ",Toast.LENGTH_LONG).show();
        db.close();
        txt1.setText("");
        clockSelectedTime.setText("Selected time");
        txt3.setText("");
        clockselecteddate.setText("Selected date");
        txt3.clearFocus();
    }
    public void Back(View view){
        Intent obj=new Intent(getApplicationContext(),adminTime.class);
        startActivity(obj);
    }
}