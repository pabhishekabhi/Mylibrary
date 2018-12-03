package com.abhi.library;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.IOException;

public class HelperLibrary extends AppCompatActivity {

    public static boolean isNetworkAvailable(Context context) {
        boolean isConnected = false;
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        HttpGet httpGet = new HttpGet("https://www.google.com/");
        HttpParams httpParameters = new BasicHttpParams();

        int timeoutConnection = 5000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

        int timeoutSocket = 7000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        try {
            httpClient.execute(httpGet);
            isConnected = true;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!isConnected) {
            Toast.makeText(context, "No Internet Connection Available", Toast.LENGTH_SHORT).show();

        }
        return isConnected;
    }

}
