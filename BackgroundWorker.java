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
        String awareness_url = "http://192.168.43.129/mytest/Awareness.php";
        String positive_activity_url = "http://192.168.43.129/mytest/Awareness.php";
        String deaddiction_identification_url = "http://192.168.43.129/mytest/Awareness.php";
        String deaddiction_motivation_url = "http://192.168.43.129/mytest/Awareness.php";
        String deaddiction_facilitation_url = "http://192.168.43.129/mytest/Awareness.php";
        String vg_identification_url = "http://192.168.43.129/mytest/Awareness.php";
        String vg_protection_url = "http://192.168.43.129/mytest/Awareness.php";

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

                URL url = new URL(awareness_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Awareness Activity Completion", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Performed for Awareness", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity, "UTF-8") + "&"
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

                URL url = new URL(positive_activity_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Positive Activity Completion", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("Positive Activity Performed", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Venue", "UTF-8") + "=" + URLEncoder.encode(Activity_Venue, "UTF-8") + "&"
                        + URLEncoder.encode("Time at Which Activity Was Performed", "UTF-8") + "=" + URLEncoder.encode(Activity_Time, "UTF-8") + "&"
                        + URLEncoder.encode("Activity Duration", "UTF-8") + "=" + URLEncoder.encode(Activity_Duration, "UTF-8") + "&"
                        + URLEncoder.encode("Number of People Invited to Participate", "UTF-8") + "=" + URLEncoder.encode(Potential_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Actual Number of Participants", "UTF-8") + "=" + URLEncoder.encode(Actual_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Participants", "UTF-8") + "=" + URLEncoder.encode(Participants, "UTF-8")+ "&"
                        + URLEncoder.encode("Availability of an Official", "UTF-8") + "=" + URLEncoder.encode(Official_Availability, "UTF-8")+ "&"
                        + URLEncoder.encode("Identity of the Official", "UTF-8") + "=" + URLEncoder.encode(Official_Identity, "UTF-8")+ "&"
                        + URLEncoder.encode("Existence of Problem", "UTF-8") + "=" + URLEncoder.encode(Problem_Status, "UTF-8")+ "&"
                        + URLEncoder.encode("Problem", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8")+ "&"
                        + URLEncoder.encode("Existing Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Existing_Infrastructure, "UTF-8")+ "&"
                        + URLEncoder.encode("Changes Made in Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Changes, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Faced Regarding Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Problems, "UTF-8")  + "&"
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

                URL url = new URL(deaddiction_identification_url);
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

        else if(type.equals("deaddiction motivation"))
        {
            String Approach_Place = params[1];
            String Approach_Method = params[2];
            String Victim_Approach_Problems =params[3];;
            String Family_Approach_Problems =  params[4];
            String Arguments = params[5];
            String Convincing_Factor = params[6];
            String Victim_Attitude = params[7];
            String Suggestions = params[8];

            try {

                URL url = new URL(deaddiction_motivation_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Place of Approach", "UTF-8") + "=" + URLEncoder.encode(Approach_Place, "UTF-8") + "&"
                        + URLEncoder.encode("Method of Approach", "UTF-8") + "=" + URLEncoder.encode(Approach_Method, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Regarding Victims", "UTF-8") + "=" + URLEncoder.encode(Victim_Approach_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Regarding Victims' Families", "UTF-8") + "=" + URLEncoder.encode(Family_Approach_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Arguments given by them", "UTF-8") + "=" + URLEncoder.encode(Arguments, "UTF-8") + "&"
                        + URLEncoder.encode("Convincing Factor Given", "UTF-8") + "=" + URLEncoder.encode(Convincing_Factor, "UTF-8") + "&"
                        + URLEncoder.encode("Attitude of Victims", "UTF-8") + "=" + URLEncoder.encode(Victim_Attitude, "UTF-8")+ "&"
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

        else if(type.equals("deaddiction facilitation"))
        {
            String Victims_Approached = params[1];
            String Revisit_Needed = params[2];
            String Linked_To_Centres = params[3];
            String Centre_Contacted =  params[4];
            String Centre_Issues = params[5];
            String Drop_Outs = params[6];
            String Dropout_Reason = params[7];
            String Successfully_Treated =  params[8];
            String Behavioural_Changes = params[9];
            String Problems = params[10];
            String Suggestions = params[11];

            try {

                URL url = new URL(deaddiction_facilitation_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number of Victims Approached (Monthly)", "UTF-8") + "=" + URLEncoder.encode(Victims_Approached, "UTF-8") + "&"
                        + URLEncoder.encode("Number of Victims Needed to be Revisited for Convincing", "UTF-8") + "=" + URLEncoder.encode(Revisit_Needed, "UTF-8") + "&"
                        + URLEncoder.encode("Number of Victims Linked to an OAAT/De-Addiction Centre", "UTF-8") + "=" + URLEncoder.encode(Linked_To_Centres, "UTF-8") + "&"
                        + URLEncoder.encode("Price of Drugs", "UTF-8") + "=" + URLEncoder.encode(Centre_Contacted , "UTF-8") + "&"
                        + URLEncoder.encode("Reason for Drug Abuse", "UTF-8") + "=" + URLEncoder.encode(Centre_Issues, "UTF-8") + "&"
                        + URLEncoder.encode("Drug Abuse Prone Area", "UTF-8") + "=" + URLEncoder.encode(Drop_Outs, "UTF-8") + "&"
                        + URLEncoder.encode("Gathering Area for Abusers", "UTF-8") + "=" + URLEncoder.encode(Dropout_Reason, "UTF-8") + "&"
                        + URLEncoder.encode("Time of Supply", "UTF-8") + "=" + URLEncoder.encode(Successfully_Treated, "UTF-8")+ "&"
                        + URLEncoder.encode("Time of Consumption", "UTF-8") + "=" + URLEncoder.encode(Behavioural_Changes , "UTF-8")+ "&"
                        + URLEncoder.encode("Place of Purchase", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8")+ "&"
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

        else if(type.equals("vg identification"))
        {
            String VulnerableGroups_Identified = params[1];
            String VulnerableGroups_Counseled = params[2];
            String Problems = params[3];
            String Suggestions =  params[4];

            try {

                URL url = new URL(vg_identification_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number of Vulnerable Groups Identified", "UTF-8") + "=" + URLEncoder.encode(VulnerableGroups_Identified, "UTF-8") + "&"
                        + URLEncoder.encode("Number of Vulnerable Groups Counseled", "UTF-8") + "=" + URLEncoder.encode(VulnerableGroups_Counseled, "UTF-8") + "&"
                        + URLEncoder.encode("Problems", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8") + "&"
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

        else if(type.equals("vg protection"))
        {
            String Efforts_For_Protection = params[1];
            String Activities_Promoted = params[2];
            String Vulnerable_Individuals_Linked_To_Positive_Activity = params[3];
            String Expert_Counselling_Advised =  params[4];
            String Counselling_Problems = params[5];
            String VG_Acceptance_Problems = params[6];
            String Other_VG_Problems = params[7];
            String Suggestions =  params[8];

            try {

                URL url = new URL(vg_protection_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Efforts Made for Protection of Vulnerable Groups", "UTF-8") + "=" + URLEncoder.encode(Efforts_For_Protection, "UTF-8") + "&"
                        + URLEncoder.encode("Activities Promoted for Protection of Vulnerable Groups", "UTF-8") + "=" + URLEncoder.encode(Activities_Promoted, "UTF-8") + "&"
                        + URLEncoder.encode("Vulnerable Individuals Linked to a Positive Activity", "UTF-8") + "=" + URLEncoder.encode(Vulnerable_Individuals_Linked_To_Positive_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Individuals Recommended for Specific Expert Counselling", "UTF-8") + "=" + URLEncoder.encode(Expert_Counselling_Advised, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Regarding Counselling Arrangement", "UTF-8") + "=" + URLEncoder.encode(Counselling_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Problems Regarding Acceptance of a Need of Protection", "UTF-8") + "=" + URLEncoder.encode(VG_Acceptance_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Other Problems", "UTF-8") + "=" + URLEncoder.encode( Other_VG_Problems, "UTF-8")+ "&"
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
