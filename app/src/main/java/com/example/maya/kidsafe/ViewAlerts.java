package com.example.maya.kidsafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAlerts extends AppCompatActivity {
    private static List<Message> messageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlertsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alerts);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new AlertsAdapter(messageList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    public static void addMessage(Message message) {
        messageList.add(message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, AddWord.class));
        }
        if (id==R.id.refresh) {
            messageList = new ArrayList<Message>();
            startActivity(new Intent(this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
    public static void expandView(View v) {
        ViewParent parent = v.getParent();
        int index= ((ViewGroup) parent.getParent()).indexOfChild((View)parent);
        Message message = messageList.get(index);
        if (((TextView) v).getText().equals(message.getMessage()+"\nmessage from: "+message.getBully())) {
            ((TextView) v).setText(((message.isBullied())?"Your child received a message containing \"":
                    "Your child sent a message containing \"")+message.getBadWord()+"\"");
        }
        else {
            ((TextView) v).setText(message.getMessage()+"\nmessage from: "+message.getBully());
        }
    }
}

