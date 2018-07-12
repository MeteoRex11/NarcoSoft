package com.example.jagma.login_screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Awareness_Activity extends AppCompatActivity {

    EditText no_of_peopleet,feedbacket,probet,suggestionet;
    RadioGroup radioGroup1,radioGroup2;
    RadioButton radioButton01,radioButton02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness_);

        no_of_peopleet=findViewById(R.id.a_a3);
        feedbacket=findViewById(R.id.a_a4);
        probet=findViewById(R.id.a_a5);
        suggestionet=findViewById(R.id.a_a6);
        radioGroup1=findViewById(R.id.RGrp1);
        radioGroup2=findViewById(R.id.RGrp2);


    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int select_attemptID=radioGroup1.getCheckedRadioButtonId();
                        int select_activityID=radioGroup2.getCheckedRadioButtonId();
                        radioButton01=findViewById(select_attemptID);
                        radioButton02=findViewById(select_activityID);
                        String str_attempt_status=radioButton01.getText().toString();
                        String str_no_of_people=no_of_peopleet.getText().toString();

                        String str_probs=probet.getText().toString();
                        String str_activity=radioButton02.getText().toString();
                        String str_feedback=feedbacket.getText().toString();
                        String str_suggestion=suggestionet.getText().toString();

                        String type="submit";
                        BackgroundWorker backgroundWorker=new BackgroundWorker(Awareness_Activity.this);
                        backgroundWorker.execute(type,str_attempt_status,str_activity,str_no_of_people,str_feedback,str_probs,str_suggestion);


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
