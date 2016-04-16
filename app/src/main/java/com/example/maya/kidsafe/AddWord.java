package com.example.maya.kidsafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddWord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
    }

    public void sendRapidAPI(View v) {
        EditText et = (EditText) findViewById(R.id.input);
        String phrase = et.getText().toString().toLowerCase();
        QuickstartPreferences.phrase = phrase;
        CallToRapidAPI.sendRequest();
        startActivity(new Intent(this, MainActivity.class));
    }
}
