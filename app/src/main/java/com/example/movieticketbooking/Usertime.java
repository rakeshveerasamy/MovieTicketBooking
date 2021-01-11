package com.example.movieticketbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Usertime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertime);
    }
    public void displayMovie(View view) {
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.getAllMovies();
        if(c.getCount()==0)
        {
            display("Error","Nothing Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("Id :"+c.getString(0)+"\n");
            buffer.append("Name :"+c.getString(1)+"\n");
            buffer.append("Date :"+c.getString(2)+"\n");
            buffer.append("Timings :"+c.getString(3)+"\n");
            buffer.append("Language :"+c.getString(4)+"\n\n");
        }
        display("List of Movie Shows",buffer.toString());
        db.close();
    }
    public void display(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    public void display(Cursor c)
    {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(Usertime.this);
        builder.setTitle("List of Movies")
                .setMessage("Id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Date: " + c.getString(2) + "\n" +
                        "Timings: " + c.getString(3)+"\n"+ "Language:" + c.getString(4))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    public void searchMovie(View view)
    {
        EditText txt =(EditText)findViewById(R.id.editText3);
        String query = "";
        int rowId;
        query = txt.getText().toString();
        rowId = Integer.parseInt(query);
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.searchMovie(rowId);
        if (c.moveToFirst())
            display(c);
        else
            Toast.makeText(this, "No movie found", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void bookMovie(View view){
        Intent obj = new Intent(getApplicationContext(),ticketBooking.class);
        startActivity(obj);
    }
}