package com.example.jagma.login_screen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import android.content.Intent;

public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx){
        context = ctx;
    }


        @Override
        protected void onPreExecute() {
              alertDialog=new AlertDialog.Builder(context).create();
              alertDialog.setTitle("Login Status");

        }


         @Override
         protected String doInBackground(String... params) {

             String type = params[0];
             String login_url = "http://192.168.43.129/mytest/login.php";
             String submit_url = "http://192.168.43.129/mytest/Awareness.php";

             if (type.equals("login")) {
                 String UID = params[1];
                 String date = params[2];
                 try {

                     URL url = new URL(login_url);
                     HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setRequestMethod("POST");
                     httpURLConnection.setDoOutput(true);
                     OutputStream outputStream = httpURLConnection.getOutputStream();
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                     String data_string = URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(UID, "UTF-8") + "&" +
                             URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8");

                     bufferedWriter.write(data_string);
                     bufferedWriter.flush();
                     bufferedWriter.close();
                     outputStream.close();

                     InputStream inputStream = httpURLConnection.getInputStream();
                     BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                     String result="";
                     String line="";
                     while((line=bufferedReader.readLine())!=null){
                         result +=line;
                     }


                     bufferedReader.close();
                     inputStream.close();
                     httpURLConnection.disconnect();

                     return result;

                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }

            else if(type.equals("submit"))
             {
                 String attempt_status=params[1];
                 String activity=params[2];
                 String no_of_people=params[3];
                 String feedback=params[4];
                 String probs=params[5];
                 String suggestions=params[6];

                 try {

                     URL url = new URL(submit_url);
                     HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setRequestMethod("POST");
                     httpURLConnection.setDoOutput(true);
                     OutputStream outputStream = httpURLConnection.getOutputStream();
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                     String data_string = URLEncoder.encode("attempt_status", "UTF-8") + "=" + URLEncoder.encode(attempt_status, "UTF-8") + "&"
                             + URLEncoder.encode("activity", "UTF-8") + "=" + URLEncoder.encode(activity, "UTF-8") + "&"
                             + URLEncoder.encode("no_of_people", "UTF-8") + "=" + URLEncoder.encode(no_of_people, "UTF-8") + "&"
                             + URLEncoder.encode("feedback", "UTF-8") + "=" + URLEncoder.encode(feedback, "UTF-8") + "&"
                             + URLEncoder.encode("probs", "UTF-8") + "=" + URLEncoder.encode(probs, "UTF-8") + "&"
                             + URLEncoder.encode("suggestions", "UTF-8") + "=" + URLEncoder.encode(suggestions, "UTF-8");

                     bufferedWriter.write(data_string);
                     bufferedWriter.flush();
                     bufferedWriter.close();
                     outputStream.close();

                     InputStream inputStream = httpURLConnection.getInputStream();
                     BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                     String result="";
                     String line="";
                     while((line=bufferedReader.readLine())!=null){
                         result +=line;
                     }


                     bufferedReader.close();
                     inputStream.close();
                     httpURLConnection.disconnect();

                     return result;

                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }


             }

             return null;


         }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String result) {
            alertDialog.setMessage(result);
            alertDialog.show();
             if (result.equals("Login sucessfull")) {
            context.startActivity(new Intent(context, Main_task_page.class));
            ((Activity)context).finish();
        }

       else if(result.equals("Submition sucessfull")) {
                 context.startActivity(new Intent(context, Submit_screen.class));
                 ((Activity)context).finish();
             }
        }


    }