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

public class Motivation_feedback extends AppCompatActivity {

    EditText d_m_a1, d_m_a3, d_m_a4, d_m_a5, d_m_a6, d_m_a7, d_m_a8;
    RadioButton radiobt;
    RadioGroup ApproachMethod;
    String d_m_radioText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_feedback);

        int rbt = ApproachMethod.getCheckedRadioButtonId();
        radiobt = findViewById(rbt);
        d_m_radioText = radiobt.getText().toString();
        
        d_m_a1 = findViewById(R.id.d_m_a1);
        d_m_a3 = findViewById(R.id.d_m_a3);
        d_m_a4 = findViewById(R.id.d_m_a4);
        d_m_a5 = findViewById(R.id.d_m_a5);
        d_m_a6 = findViewById(R.id.d_m_a6);
        d_m_a7 = findViewById(R.id.d_m_a7);
        d_m_a8 = findViewById(R.id.d_m_a8);
    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new  Intent(Motivation_feedback.this,Submit_screen.class);
                        startActivityForResult(i,2);
                        finish();

                        String Approach_Place = d_m_a1.getText().toString();
                        String Approach_Method = d_m_radioText;;
                        String Victim_Approach_Problems = d_m_a3.getText().toString();;
                        String Family_Approach_Problems =  d_m_a4.getText().toString();;
                        String Arguments = d_m_a5.getText().toString();;
                        String Convincing_Factor = d_m_a6.getText().toString();;
                        String Victim_Attitude = d_m_a7.getText().toString();;
                        String Suggestions =  d_m_a8.getText().toString();;

                        String type="deaddiction motivation";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Motivation_feedback.this);
                        backgroundWorker.execute(type, Approach_Place, Approach_Method, Victim_Approach_Problems, Family_Approach_Problems,
                                Arguments, Convincing_Factor, Victim_Attitude, Suggestions );
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
