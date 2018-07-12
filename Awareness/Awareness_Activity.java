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

   EditText a_a3, a_a4, a_a5, a_a6;
   String radioText, radioText2;
    RadioButton radioButton01,radioButton02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awareness_);

        RadioGroup a_RB1 = (RadioGroup) findViewById(R.id.a_RB1);
        int rbt1 = a_RB1.getCheckedRadioButtonId();
        radioButton01 = findViewById(rbt1);
        radioText = radioButton01.getText().toString();

       RadioGroup RGrp = (RadioGroup) findViewById(R.id.RGrp);
       int rbt2 = RGrp.getCheckedRadioButtonId();
        radioButton02 = findViewById(rbt2);
        radioText2 = radioButton02.getText().toString();




        a_a3 = findViewById(R.id.a_a3);
        a_a4 = findViewById(R.id.a_a4);
        a_a5 = findViewById(R.id.a_a5);
        a_a6 = findViewById(R.id.a_a6);

    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        Intent i=new  Intent(Awareness_Activity.this,Submit_screen.class);
                        startActivityForResult(i,4);
                        finish();

                         String Awareness_Activity_Status = radioText;
                         String Awareness_Activity = radioText2;
                         String Activity_Audience = a_a3.getText().toString();
                         String Audience_Feedback = a_a4.getText().toString();
                         String Problems= a_a5.getText().toString();
                         String Suggestions = a_a6.getText().toString();
                         String type="awareness";
                         BackgroundWorker backgroundWorker = new BackgroundWorker(Awareness_Activity.this);
                         backgroundWorker.execute(type, Awareness_Activity_Status, Awareness_Activity, Activity_Audience, Audience_Feedback, Problems, Suggestions);
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
