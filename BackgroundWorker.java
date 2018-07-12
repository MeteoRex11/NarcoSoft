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

        else if(type.equals("awareness"))
        {
            String Awareness_Activity_Status = params[1];
            String Awareness_Activity = params[2];
            String Activity_Audience = params[3];
            String Audience_Feedback = params[4];
            String Problems = params[5];
            String Suggestions = params[6];

            try {

                URL url = new URL(submit_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Awareness Activity Completion", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("Awareness Activity", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Audience", "UTF-8") + "=" + URLEncoder.encode(Activity_Audience, "UTF-8") + "&"
                        + URLEncoder.encode("Audience Feedback", "UTF-8") + "=" + URLEncoder.encode(Audience_Feedback, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Faced", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8");

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

        else if(type.equals("positive activity"))
        {
            String Positive_Activity_Status = params[1];
            String Positive_Activity = params[2];
            String Activity_Venue = params[3];
            String Activity_Time = params[4];
            String Activity_Duration = params[5];
            String Potential_Participants_Number = params[6];
            String Actual_Participants_Number = params[7];
            String Participants = params[8];
            String Official_Availability = params[9];
            String Official_Identity = params[10];
            String Problem_Status = params[11];
            String Problems = params[12];
            String Existing_Infrastructure = params[13];
            String Infrastructure_Changes = params[14];
            String Infrastructure_Problems = params[15];
            String Suggestions = params[16];


            try {

                URL url = new URL(submit_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Positive Activity Completion", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("Positive Activity", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Venue", "UTF-8") + "=" + URLEncoder.encode(Activity_Venue, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Time", "UTF-8") + "=" + URLEncoder.encode(Activity_Time, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Duration", "UTF-8") + "=" + URLEncoder.encode(Activity_Duration, "UTF-8") + "&"
                        + URLEncoder.encode("Number of People Invited", "UTF-8") + "=" + URLEncoder.encode(Potential_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Number of Participants", "UTF-8") + "=" + URLEncoder.encode(Actual_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Participants", "UTF-8") + "=" + URLEncoder.encode(Participants, "UTF-8")+ "&"
                        + URLEncoder.encode("Official's Availability", "UTF-8") + "=" + URLEncoder.encode(Official_Availability, "UTF-8")+ "&"
                        + URLEncoder.encode("Official's Identity", "UTF-8") + "=" + URLEncoder.encode(Official_Identity, "UTF-8")+ "&"
                        + URLEncoder.encode("Problem Existence", "UTF-8") + "=" + URLEncoder.encode(Problem_Status, "UTF-8")+ "&"
                        + URLEncoder.encode("Problem", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8")+ "&"
                        + URLEncoder.encode("Existing Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Existing_Infrastructure, "UTF-8")+ "&"
                        + URLEncoder.encode("Changes made in Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Changes, "UTF-8") + "&"
                        + URLEncoder.encode("Problems faced regarding Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Problems, "UTF-8")  + "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8");

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

        else if(type.equals("deaddiction identification"))
        {
            String Users = params[1];
            String Narcotics_Type = params[2];;
            String Narcotics_Quantity = params[3];;
            String Narcotics_Price =  params[4];;
            String Drug_Abuse_Reason = params[5];;
            String Drug_Abuse_Hotspot = params[6];;
            String Drug_Abusers_Gathering_Areas = params[7];;
            String Supply_Time = params[8];;
            String Abuse_Time = params[9];;
            String Place_Of_Purchase = params[10];;
            String Suggestions = params[11];;

            try {

                URL url = new URL(submit_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number of Narcotics Users", "UTF-8") + "=" + URLEncoder.encode(Users, "UTF-8") + "&"
                        + URLEncoder.encode("Type of Drug Used", "UTF-8") + "=" + URLEncoder.encode(Narcotics_Type, "UTF-8") + "&"
                        + URLEncoder.encode("Quantity of Drugs Used", "UTF-8") + "=" + URLEncoder.encode(Narcotics_Quantity, "UTF-8") + "&"
                        + URLEncoder.encode("Price of Drugs", "UTF-8") + "=" + URLEncoder.encode(Narcotics_Price, "UTF-8") + "&"
                        + URLEncoder.encode("Reason for Drug Abuse", "UTF-8") + "=" + URLEncoder.encode(Drug_Abuse_Reason, "UTF-8") + "&"
                        + URLEncoder.encode("Drug Abuse Prone Area", "UTF-8") + "=" + URLEncoder.encode(Drug_Abuse_Hotspot, "UTF-8") + "&"
                        + URLEncoder.encode("Gathering Area for Abusers", "UTF-8") + "=" + URLEncoder.encode(Drug_Abusers_Gathering_Areas, "UTF-8") + "&"
                        + URLEncoder.encode("Time of Supply", "UTF-8") + "=" + URLEncoder.encode(Supply_Time, "UTF-8")+ "&"
                        + URLEncoder.encode("Time of Consumption", "UTF-8") + "=" + URLEncoder.encode(Abuse_Time , "UTF-8")+ "&"
                        + URLEncoder.encode("Place of Purchase", "UTF-8") + "=" + URLEncoder.encode(Place_Of_Purchase, "UTF-8")+ "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8");

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
        if (result.equals("Login Successful")) {
            context.startActivity(new Intent(context, Main_task_page.class));
            ((Activity)context).finish();
        }

        else if(result.equals("Submission Successful")) {
            context.startActivity(new Intent(context, Submit_screen.class));
            ((Activity)context).finish();
        }
    }


}
