package com.example.movieticketbooking;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    String id,name,date,time,language;
    Dialog(String id,String name,String date,String time,String language)
    {
        this.id = id;
        this.name =name;
        this.date = date;
        this.time = time;
        this.language = language;
    }
    public AlertDialog onCreateDialog(String id, String name, String date, String time, String language)
    {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("List of Movies")
                .setMessage("Id: " + id + "\n" +
                        "Name: " + name + "\n" +
                        "Date: " + date + "\n" +
                        "Timings: " + time +"\n"+ "Language:" + language)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
