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
import android.widget.Toast;


public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx){
        context = ctx;
    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("");

    }


    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "http://192.168.43.64/login_screen/login.php";
        String awareness_url = "http://192.168.1.6/login_screen/Awareness.php";
        String positive_activity_url = "http://192.168.1.6/login_screen/positive_activity.php";
        String deaddiction_identification_url = "http://192.168.43.64/login_screen/deaddiction_identification.php";
        String deaddiction_motivation_url = "http://192.168.1.6/login_screen/deaddiction_motivation.php";
        String deaddiction_facilitation_url = "http://192.168.1.6/login_screen/deaddiction_facilitation.php";
        String vg_identification_url = "http://192.168.1.6/login_screen/Identification_VG.php";
        String vg_protection_url = "http://192.168.1.6/login_screen/Protection_VG.php";

        if (type.equals("login")) {
            String UID = params[1];
            String mobno = params[2];
            try {

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(UID, "UTF-8") + "&" +
                        URLEncoder.encode("Mobile_Number", "UTF-8") + "=" + URLEncoder.encode(mobno, "UTF-8");

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
            String User_Name = params[2];
            String User_Address = params[3];
            String Narcotics_Type = params[4];
            String Narcotics_Price =  params[5];
            String Drug_Abuse_Reason = params[6];
            String Drug_Abuse_Hotspot = params[7];
            String Drug_Abusers_Gathering_Areas = params[8];
            String Supply_Time = params[9];
            String Supplier_Name = params[10];
            String Supplier_Address = params[11];
            String Abuse_Time = params[12];
            String Place_Of_Purchase = params[13];
            String Suggestions = params[14];
            String ID = params[15];

            try {

                URL url = new URL(deaddiction_identification_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number_of_Narcotics_Users", "UTF-8") + "=" + URLEncoder.encode(Users, "UTF-8") + "&"
                        + URLEncoder.encode("Names_Of_Users", "UTF-8") + "=" + URLEncoder.encode(User_Name, "UTF-8") + "&"
                        + URLEncoder.encode("Addresses_of_Users", "UTF-8") + "=" + URLEncoder.encode(User_Address, "UTF-8") + "&"
                        + URLEncoder.encode("Type_of_Drugs_Used", "UTF-8") + "=" + URLEncoder.encode(Narcotics_Type, "UTF-8") + "&"
                        + URLEncoder.encode("Price_of_Drugs", "UTF-8") + "=" + URLEncoder.encode(Narcotics_Price, "UTF-8") + "&"
                        + URLEncoder.encode("Reason_for_Drug_Abuse", "UTF-8") + "=" + URLEncoder.encode(Drug_Abuse_Reason, "UTF-8") + "&"
                        + URLEncoder.encode("Drug_Abuse_Prone_Area", "UTF-8") + "=" + URLEncoder.encode(Drug_Abuse_Hotspot, "UTF-8") + "&"
                        + URLEncoder.encode("Gathering_Area_for_Abuser", "UTF-8") + "=" + URLEncoder.encode(Drug_Abusers_Gathering_Areas, "UTF-8") + "&"
                        + URLEncoder.encode("Time_of_Supply", "UTF-8") + "=" + URLEncoder.encode(Supply_Time, "UTF-8")+ "&"
                        + URLEncoder.encode("Name_of Supplier", "UTF-8") + "=" + URLEncoder.encode(Supplier_Name, "UTF-8")+ "&"
                        + URLEncoder.encode("Address_of_Supplier", "UTF-8") + "=" + URLEncoder.encode( Supplier_Address, "UTF-8")+ "&"
                        + URLEncoder.encode("Time_of_Consumption", "UTF-8") + "=" + URLEncoder.encode(Abuse_Time , "UTF-8")+ "&"
                        + URLEncoder.encode("Place_of_Purchase", "UTF-8") + "=" + URLEncoder.encode(Place_Of_Purchase, "UTF-8")+ "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")+ "&"
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");

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
            String Victims_Approached = params[1];
            String Approach_Method = params[2];
            String Victim_Approach_Problems =params[3];;
            String Family_Friends_Approach_Problems =  params[4];
            String Arguments = params[5];
            String Convincing_Factor = params[6];
            String Victim_Attitude = params[7];
            String Revisit_Needed = params[8];
            String Suggestions = params[9];
            String ID = params[10];

            try {

                URL url = new URL(deaddiction_motivation_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number_of_Victims_Approached_Monthly", "UTF-8") + "=" + URLEncoder.encode(Victims_Approached, "UTF-8") + "&"
                        + URLEncoder.encode("Method_of_Approach", "UTF-8") + "=" + URLEncoder.encode(Approach_Method, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Regarding_Victims", "UTF-8") + "=" + URLEncoder.encode(Victim_Approach_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Regarding_Victims_Families", "UTF-8") + "=" + URLEncoder.encode(Family_Friends_Approach_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Arguments_given_by_them", "UTF-8") + "=" + URLEncoder.encode(Arguments, "UTF-8") + "&"
                        + URLEncoder.encode("Convincing_Factor_Given", "UTF-8") + "=" + URLEncoder.encode(Convincing_Factor, "UTF-8") + "&"
                        + URLEncoder.encode("Attitude_of_Victims", "UTF-8") + "=" + URLEncoder.encode(Victim_Attitude, "UTF-8")+ "&"
                        + URLEncoder.encode("Victims_Needing_Revisit", "UTF-8") + "=" + URLEncoder.encode(Revisit_Needed, "UTF-8")+ "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");

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

            String Linked_To_Centres = params[1];
            String Centre_Contacted =  params[2];
            String Centre_Issues = params[3];
            String Drop_Outs = params[4];
            String Dropout_Reason = params[5];
            String Successfully_Being_Treated =  params[6];
            String Problems = params[7];
            String Suggestions = params[8];
            String ID = params[9];

            try {

                URL url = new URL(deaddiction_facilitation_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number_of_Appoached_Victims_Linked_to_an_OOAT_Centre", "UTF-8") + "=" + URLEncoder.encode(Linked_To_Centres, "UTF-8") + "&"
                        + URLEncoder.encode("Centre_Contacted", "UTF-8") + "=" + URLEncoder.encode(Centre_Contacted , "UTF-8") + "&"
                        + URLEncoder.encode("Issues_with_Centre_Linking", "UTF-8") + "=" + URLEncoder.encode(Centre_Issues, "UTF-8") + "&"
                        + URLEncoder.encode("Treatment_Drop_Outs", "UTF-8") + "=" + URLEncoder.encode(Drop_Outs, "UTF-8") + "&"
                        + URLEncoder.encode("Reasons_For_Drop_Out", "UTF-8") + "=" + URLEncoder.encode(Dropout_Reason, "UTF-8") + "&"
                        + URLEncoder.encode("Victims_Continuing_Treatment", "UTF-8") + "=" + URLEncoder.encode(Successfully_Being_Treated, "UTF-8")+ "&"
                        + URLEncoder.encode("Other_Problems", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8")+ "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");


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
            String Vulnerables_Identified = params[1];
            String Vulnerables_Counseled = params[2];
            String Problems = params[3];
            String Suggestions =  params[4];
            String ID = params[5];

            try {

                URL url = new URL(vg_identification_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Number_of_Vulnerable_Individuals_or_Groups_Identified", "UTF-8") + "=" + URLEncoder.encode(Vulnerables_Identified, "UTF-8") + "&"
                        + URLEncoder.encode("Number_of_Vulnerable_Individuals_or_Groups_Counseled", "UTF-8") + "=" + URLEncoder.encode(Vulnerables_Counseled, "UTF-8") + "&"
                        + URLEncoder.encode("Problems", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");


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
            String People_Counseled = params[3];
            String Expert_Counselling_Advised =  params[4];
            String Counselling_Problems = params[5];
            String VG_Acceptance_Problems = params[6];
            String Other_VG_Problems = params[7];
            String Suggestions =  params[8];
            String ID = params[9];

            try {

                URL url = new URL(vg_protection_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Efforts_Made_for_Protection_of_Vulnerable_Groups", "UTF-8") + "=" + URLEncoder.encode(Efforts_For_Protection, "UTF-8") + "&"
                        + URLEncoder.encode("Vulnerable_Individuals_Counseled", "UTF-8") + "=" + URLEncoder.encode(People_Counseled, "UTF-8") + "&"
                        + URLEncoder.encode("Individuals_Recommended_for_Specific_Expert_Counselling", "UTF-8") + "=" + URLEncoder.encode(Expert_Counselling_Advised, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Regarding_Counselling_Arrangement", "UTF-8") + "=" + URLEncoder.encode(Counselling_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Regarding_Acceptance_of_a_Need_of_Protection", "UTF-8") + "=" + URLEncoder.encode(VG_Acceptance_Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Other_Problems", "UTF-8") + "=" + URLEncoder.encode( Other_VG_Problems, "UTF-8")+ "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");

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
            String ID = params[7];

            try {

                URL url = new URL(awareness_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Awareness_Activity_Completion", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("$Activity_Performed_for_Awareness", "UTF-8") + "=" + URLEncoder.encode(Awareness_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Activity_Audience", "UTF-8") + "=" + URLEncoder.encode(Activity_Audience, "UTF-8") + "&"
                        + URLEncoder.encode("Audience_Feedback", "UTF-8") + "=" + URLEncoder.encode(Audience_Feedback, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Faced", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8") + "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");

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
            String ID = params[17];


            try {

                URL url = new URL(positive_activity_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("Positive_Activity_Completion", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity_Status, "UTF-8") + "&"
                        + URLEncoder.encode("Positive_Activity_Performed", "UTF-8") + "=" + URLEncoder.encode(Positive_Activity, "UTF-8") + "&"
                        + URLEncoder.encode("Activity_Venue", "UTF-8") + "=" + URLEncoder.encode(Activity_Venue, "UTF-8") + "&"
                        + URLEncoder.encode("Time_at_Which_Activity_Was_Performed", "UTF-8") + "=" + URLEncoder.encode(Activity_Time, "UTF-8") + "&"
                        + URLEncoder.encode("Activity_Duration", "UTF-8") + "=" + URLEncoder.encode(Activity_Duration, "UTF-8") + "&"
                        + URLEncoder.encode("Number_of_People_Invited_to_Participate", "UTF-8") + "=" + URLEncoder.encode(Potential_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Actual_Number_of_Participants", "UTF-8") + "=" + URLEncoder.encode(Actual_Participants_Number, "UTF-8") + "&"
                        + URLEncoder.encode("Participants", "UTF-8") + "=" + URLEncoder.encode(Participants, "UTF-8")+ "&"
                        + URLEncoder.encode("Availability_of_an_Official", "UTF-8") + "=" + URLEncoder.encode(Official_Availability, "UTF-8")+ "&"
                        + URLEncoder.encode("Identity_of_the_Official", "UTF-8") + "=" + URLEncoder.encode(Official_Identity, "UTF-8")+ "&"
                        + URLEncoder.encode("Existence_of_Problem", "UTF-8") + "=" + URLEncoder.encode(Problem_Status, "UTF-8")+ "&"
                        + URLEncoder.encode("Problem", "UTF-8") + "=" + URLEncoder.encode(Problems, "UTF-8")+ "&"
                        + URLEncoder.encode("Existing_Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Existing_Infrastructure, "UTF-8")+ "&"
                        + URLEncoder.encode("Changes_Made_in_Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Changes, "UTF-8") + "&"
                        + URLEncoder.encode("Problems_Faced_Regarding_Infrastructure", "UTF-8") + "=" + URLEncoder.encode(Infrastructure_Problems, "UTF-8")  + "&"
                        + URLEncoder.encode("Suggestions", "UTF-8") + "=" + URLEncoder.encode(Suggestions, "UTF-8")
                        + URLEncoder.encode("UID", "UTF-8") + "=" + URLEncoder.encode(ID, "UTF-8");

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
    protected void onPostExecute(String result)
    {
        alertDialog.setMessage(result);
        alertDialog.show();

        if (result.equals("Login Successful"))
        {

            context.startActivity(new Intent(context, Main_task_page.class));
            ((Activity)context).finish();
        }

        else if(result.equals("Submission Successful"))
        {
            context.startActivity(new Intent(context, Submit_screen.class));
            ((Activity)context).finish();
        }
    }


}
