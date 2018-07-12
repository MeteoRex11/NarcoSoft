package com.example.jagma.login_screen;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Facilitation_Activity extends AppCompatActivity {

    EditText pa_a3, pa_a4, pa_a5, pa_a6, pa_a7, pa_a8, pa_a10, pa_a12, pa_a13, pa_a14, pa_a15, pa_a16;
    RadioGroup pa_RB1, pa_RB2, pa_RB3, pa_RB4;
    RadioButton radiobt1, radiobt2, radiobt3, radiobt4;
    String pa_radioText1, pa_radioText2, pa_radioText3, pa_radioText4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.positive_activities);


        pa_RB1 = findViewById(R.id.pa_RB1);
        pa_RB2 = findViewById(R.id.pa_RB2);
        pa_RB3 = findViewById(R.id.pa_RB3);
        pa_RB4 = findViewById(R.id.pa_RB4);


        int rbt1 = pa_RB1.getCheckedRadioButtonId();
        radiobt1 = findViewById(rbt1);
        pa_radioText1 = radiobt1.getText().toString();

        int rbt2 = pa_RB2.getCheckedRadioButtonId();
        radiobt2 = findViewById(rbt2);
        pa_radioText2 = radiobt2.getText().toString();

        int rbt3 = pa_RB3.getCheckedRadioButtonId();
        radiobt3 = findViewById(rbt3);
        pa_radioText3 = radiobt3.getText().toString();

        int rbt4 = pa_RB4.getCheckedRadioButtonId();
        radiobt4 = findViewById(rbt4);
        pa_radioText4 = radiobt4.getText().toString();

         pa_a3 =  findViewById(R.id.pa_a3);
         pa_a4 =  findViewById(R.id.pa_a4);
         pa_a5 =  findViewById(R.id.pa_a5);
         pa_a6 =  findViewById(R.id.pa_a6);
         pa_a7 =  findViewById(R.id.pa_a7);
         pa_a8 =  findViewById(R.id.pa_a8);
         pa_a10 =  findViewById(R.id.pa_a10);
         pa_a12 =  findViewById(R.id.pa_a12);
         pa_a13 =  findViewById(R.id.pa_a13);
         pa_a14 =  findViewById(R.id.pa_a14);
         pa_a15 =  findViewById(R.id.pa_a15);
         pa_a16 =  findViewById(R.id.pa_a16);

    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new  Intent(Facilitation_Activity.this,Submit_screen.class);
                        startActivityForResult(i,3);
                        finish();

                        String Positive_Activity_Status = pa_radioText1;
                        String Positive_Activity = pa_radioText2;
                        String Activity_Venue = pa_a3.getText().toString();
                        String Activity_Time =  pa_a4.getText().toString();
                        String Activity_Duration = pa_a5.getText().toString();
                        String Potential_Participants_Number = pa_a6.getText().toString();
                        String Actual_Participants_Number = pa_a7.getText().toString();
                        String Participants =  pa_a8.getText().toString();
                        String Official_Availability = pa_radioText3;
                        String Official_Identity = pa_a10.getText().toString();
                        String Problem_Status = pa_radioText4;
                        String Problems =  pa_a12.getText().toString();
                        String Existing_Infrastructure = pa_a13.getText().toString();
                        String Infrastructure_Changes = pa_a14.getText().toString();
                        String Infrastructure_Problems= pa_a15.getText().toString();
                        String Suggestions =  pa_a16.getText().toString();


                        String type="positive activity";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Facilitation_Activity.this);
                        backgroundWorker.execute(type, Positive_Activity_Status,Positive_Activity, Activity_Venue, Activity_Time,
                                Activity_Duration, Potential_Participants_Number, Actual_Participants_Number, Participants,
                                Official_Availability, Official_Identity, Problem_Status, Problems, Existing_Infrastructure, Infrastructure_Changes,
                                Infrastructure_Problems, Suggestions );
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
