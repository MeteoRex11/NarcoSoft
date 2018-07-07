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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;*/

import java.io.FileNotFoundException;
import java.io.IOException;

public class Protection extends AppCompatActivity
{

    public static final int GET_FROM_GALLERY = 3;
    ImageView imageView;
    Uri selectedImage;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);


    }

    public void identification_vg(View view) {
        Intent i = new Intent(this, Vulnerable_Group_Identification.class);
        startActivity(i);
    }

    public void protection_vg(View view) {
        Intent i = new Intent(this, Vulnerable_Group_Protection.class);
        startActivity(i);
    }
}
