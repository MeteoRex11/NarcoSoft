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

public class Vulnerable_Group_Identification extends AppCompatActivity {

    EditText p_i_a1, p_i_a2, p_i_a3, p_i_a4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulnerable__group__identification);

        p_i_a1 = findViewById(R.id.d_f_a1);
        p_i_a2 = findViewById(R.id.d_f_a2);
        p_i_a3 = findViewById(R.id.d_f_a3);
        p_i_a4 = findViewById(R.id.d_f_a4);
    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new  Intent(Vulnerable_Group_Identification.this,Submit_screen.class);
                        startActivityForResult(i,2);
                        finish();

                        String Vulnerables_Identified = p_i_a1.getText().toString();
                        String Vulnerables_Counseled = p_i_a2.getText().toString();
                        String Problems = p_i_a3.getText().toString();
                        String Suggestions =  p_i_a4.getText().toString();


                        String type="vg identification";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Vulnerable_Group_Identification.this);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Vulnerable_Group_Identification.this);
                        String ID =sharedPreferences.getString("ID","unknown");

                        backgroundWorker.execute(type, Vulnerables_Identified, Vulnerables_Counseled, Problems, Suggestions, ID );


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
