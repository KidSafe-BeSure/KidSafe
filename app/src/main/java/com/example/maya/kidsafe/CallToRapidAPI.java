package com.example.maya.kidsafe;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CallToRapidAPI {

    private static final String TAG = CallToRapidAPI.class.getSimpleName();
    public static final String SERVER_URL = "http://caring-siberiantiger-ocof.rapidapi.io/add-word";
    public static void sendRequest() {new AsyncTask<Void, Void, Void>() {
        OkHttpClient client = new OkHttpClient();
        @Override
        protected Void doInBackground(Void... params) {
            try {
                RequestBody formBody = new FormBody.Builder().add("word", QuickstartPreferences.phrase).build();
                Request request = new Request.Builder().url(SERVER_URL).post(formBody).build();
                Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected Code: " + response);
                    } else {
                        Log.d(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.d(TAG, e.toString(), e.getCause());
                }
            return null;
            }
        }.execute();
    }
}