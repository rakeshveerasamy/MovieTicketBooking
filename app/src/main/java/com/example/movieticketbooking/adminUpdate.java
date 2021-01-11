package com.example.movieticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class adminUpdate extends AppCompatActivity {
    TextView clockSelectedTime,clockselecteddate;
    Button spinnerbtn, clockbtn;
    TimePicker spinnertimepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);
    }
    public void buttonDate(View view)
    {
        clockselecteddate = (TextView)findViewById(R.id.text24);
        clockbtn = (Button)findViewById(R.id.button25);
        clockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(adminUpdate.this, new DatePickerDialog.OnDateSetListener() {
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
        clockSelectedTime = (TextView)findViewById(R.id.text22);
        spinnerbtn = (Button)findViewById(R.id.button23);
        spinnerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrenttime = Calendar.getInstance();
                int hour = mcurrenttime.get(Calendar.HOUR_OF_DAY);
                int minutes = mcurrenttime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(adminUpdate.this, new TimePickerDialog.OnTimeSetListener() {
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
    public void updateMovie(View view)
    {
        DBAdapter db = new DBAdapter(this);
        db.open();

        EditText txt1, txt2, txt3,txt4,txt5;
        String str1, str2,str3,str4;
        String query = "";
        long rowId;

        txt1 = (EditText)findViewById(R.id.editText11);
        txt2 = (EditText)findViewById(R.id.editText12);
        txt4 =(EditText)findViewById(R.id.editText15);


        str1 = txt2.getText().toString();
        str2 = clockSelectedTime.getText().toString();
        str3 = txt4.getText().toString();
        str4 = clockselecteddate.getText().toString();

        query = txt1.getText().toString();
        rowId = Integer.parseInt(query);

        if (db.updateMovie(rowId, str1,str4, str2,str3))
            Toast.makeText(this, "Update successful ", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Update failed ", Toast.LENGTH_LONG).show();
        db.close();
        clockSelectedTime.setText("Selected time");
        clockselecteddate.setText("Selected date");

    }
    public void Back(View view){
        Intent obj=new Intent(getApplicationContext(),adminTime.class);
        startActivity(obj);
    }
}