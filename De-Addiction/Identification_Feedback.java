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

public class Identification_Feedback extends AppCompatActivity {

    EditText d_i_a1, d_i_a2, d_i_a3, d_i_a4, d_i_a5, d_i_a6, d_i_a7, d_i_a8, d_i_a9, d_i_a10, d_i_a11, d_i_a12, d_i_details1, d_i_details2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification__feedback);

        d_i_a1 =  findViewById(R.id.d_i_a1);
        d_i_a2 =  findViewById(R.id.d_i_a2);
        d_i_a3 =  findViewById(R.id.d_i_a3);
        d_i_a4 =  findViewById(R.id.d_i_a4);
        d_i_a5 =  findViewById(R.id.d_i_a5);
        d_i_a6 =  findViewById(R.id.d_i_a6);
        d_i_a7 =  findViewById(R.id.d_i_a7);
        d_i_a8 =  findViewById(R.id.d_i_a8);
        d_i_a9 =  findViewById(R.id.d_i_a9);
        d_i_a10 =  findViewById(R.id.d_i_a10);
        d_i_a11 =  findViewById(R.id.d_i_a11);
        d_i_a12 =  findViewById(R.id.d_i_a12);
        d_i_details1 = findViewById(R.id.d_i_details1);
        d_i_details2 = findViewById(R.id.d_i_details2);
    }

    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String Users = d_i_a1.getText().toString();
                        String User_Name = d_i_details1.getText().toString();
                        String User_Address = d_i_a2.getText().toString();
                        String Narcotics_Quantity = d_i_a3.getText().toString();
                        String Narcotics_Price =  d_i_a4.getText().toString();
                        String Drug_Abuse_Reason = d_i_a5.getText().toString();
                        String Drug_Abuse_Hotspot = d_i_a6.getText().toString();
                        String Drug_Abusers_Gathering_Areas = d_i_a7.getText().toString();
                        String Supply_Time =  d_i_a8.getText().toString();
                        String Supplier_Name = d_i_details2.getText().toString();
                        String Supplier_Address = d_i_a9.getText().toString();
                        String Abuse_Time =  d_i_a10.getText().toString();
                        String Place_Of_Purchase = d_i_a11.getText().toString();
                        String Suggestions = d_i_a12.getText().toString();

                        String type="deaddiction identification";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Identification_Feedback.this);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Identification_Feedback.this);
                        String ID =sharedPreferences.getString("ID","unknown");

                        backgroundWorker.execute(type, Users, User_Name, User_Address, Narcotics_Quantity, Narcotics_Price,
                                Drug_Abuse_Reason, Drug_Abuse_Hotspot, Drug_Abusers_Gathering_Areas, Supply_Time,
                                Supplier_Name, Supplier_Address, Abuse_Time, Place_Of_Purchase, Suggestions, ID );



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
