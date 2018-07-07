package com.example.abc.narcosoft2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class Submit_Screen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_screen);

        final Button MoreEntriesButton = (Button) findViewById(R.id.MoreEntriesButton);
        final Button SubmitButton = (Button) findViewById(R.id.SubmitButton);

    }
    public void MoreEntries(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
