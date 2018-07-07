package com.example.jagma.login_screen;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Submit_screen extends AppCompatActivity{



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_screen);

    }

    public void MoreEntries(View v)
    {
        if (getCallingActivity().getClassName().equals(Facilitation_Activity.class.getName())) {
            Intent i = new Intent(this, Facilitation_Activity.class);
            startActivity(i);
            finish();
        }
        else if(getCallingActivity().getClassName().equals(Awareness_Activity.class.getName())){
            Intent i = new Intent(this, Awareness_Activity.class);
            startActivity(i);
            finish();
        }
        else if(getCallingActivity().getClassName().equals(Protection.class.getName())){
            Intent i = new Intent(this, Protection.class);
            startActivity(i);
            finish();
        }
        else if(getCallingActivity().getClassName().equals(Identification_Feedback.class.getName())){
            Intent i = new Intent(this, Identification_Feedback.class);
            startActivity(i);
            finish();
        }
        else if(getCallingActivity().getClassName().equals(Motivation_feedback.class.getName())){
            Intent i = new Intent(this, Motivation_feedback.class);
            startActivity(i);
            finish();
        }
        else if(getCallingActivity().getClassName().equals(Facilitation_Feedback.class.getName())){
            Intent i = new Intent(this, Facilitation_Feedback.class);
            startActivity(i);
            finish();
        }


    }

    public void Finish(View v){
        Toast.makeText(getApplicationContext(),"Thanks For Your Feedback!!",Toast.LENGTH_LONG).show();
        Intent i=new  Intent(this,Main_task_page.class);
        startActivity(i);
        finish();
    }

}
