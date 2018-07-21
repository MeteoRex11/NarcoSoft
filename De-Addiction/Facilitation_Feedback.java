package com.example.jagma.login_screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class Facilitation_Feedback extends AppCompatActivity {

    EditText d_f_a1, d_f_a2, d_f_a3, d_f_a4, d_f_a5, d_f_a6, d_f_a7, d_f_a8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilitation__feedback);

        d_f_a1 = findViewById(R.id.d_f_a1);
        d_f_a2 = findViewById(R.id.d_f_a2);
        d_f_a3 = findViewById(R.id.d_f_a3);
        d_f_a4 = findViewById(R.id.d_f_a4);
        d_f_a5 = findViewById(R.id.d_f_a5);
        d_f_a6 = findViewById(R.id.d_f_a6);
        d_f_a7 = findViewById(R.id.d_f_a7);
        d_f_a8 = findViewById(R.id.d_f_a8);
    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new  Intent(Facilitation_Feedback.this,Submit_screen.class);
                        startActivityForResult(i,2);
                        finish();


                        String Victims_Linked_To_Centres = d_f_a1.getText().toString();
                        String Centre_Contacted =  d_f_a2.getText().toString();
                        String Centre_Issues = d_f_a3.getText().toString();
                        String Drop_Outs = d_f_a4.getText().toString();
                        String Dropout_Reason = d_f_a5.getText().toString();
                        String Successfully_Treated =  d_f_a6.getText().toString();
                        String Problems =  d_f_a7.getText().toString();
                        String Suggestions = d_f_a8.getText().toString();

                        String type="deaddiction facilitation";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Facilitation_Feedback.this);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Facilitation_Feedback.this);
                        String ID =sharedPreferences.getString("ID","unknown");

                        backgroundWorker.execute(type, Victims_Linked_To_Centres, Centre_Contacted, Centre_Issues, Drop_Outs,Dropout_Reason,
                                Successfully_Treated, Problems, Suggestions, ID);




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
