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

public class Vulnerable_Group_Protection extends AppCompatActivity {

    EditText p_p_a1,  p_p_a2,  p_p_a3, p_p_a4, p_p_a5, p_p_a6, p_p_a7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulnerable__group__protection);

        p_p_a1 = findViewById(R.id.p_p_a1);
        p_p_a2 = findViewById(R.id.p_p_a2);
        p_p_a3 = findViewById(R.id.p_p_a3);
        p_p_a4 = findViewById(R.id.p_p_a4);
        p_p_a5 = findViewById(R.id.p_p_a5);
        p_p_a6 = findViewById(R.id.p_p_a6);
        p_p_a7 = findViewById(R.id.p_p_a7);

    }
    public void Proceed(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to submit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new  Intent(Vulnerable_Group_Protection.this,Submit_screen.class);
                        startActivityForResult(i,2);
                        finish();

                        String Efforts_For_Protection = p_p_a1.getText().toString();
                        String People_Counseled = p_p_a2.getText().toString();
                        String Expert_Counselling_Advised =  p_p_a3.getText().toString();
                        String Counselling_Problems = p_p_a4.getText().toString();
                        String VG_Acceptance_Problems = p_p_a5.getText().toString();
                        String Other_VG_Problems = p_p_a6.getText().toString();
                        String Suggestions =  p_p_a7.getText().toString();

                        String type="vg protection";
                        BackgroundWorker backgroundWorker = new BackgroundWorker(Vulnerable_Group_Protection.this);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(Vulnerable_Group_Protection.this);
                        String ID =sharedPreferences.getString("ID","unknown");

                        backgroundWorker.execute(type, Efforts_For_Protection, People_Counseled,Expert_Counselling_Advised,
                                                    Counselling_Problems, VG_Acceptance_Problems, Other_VG_Problems, Suggestions, ID);



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
