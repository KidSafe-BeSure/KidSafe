package com.example.maya.kidsafe;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.MyViewHolder> {
    private List<Message> messageList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView alertText;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            alertText = (TextView) view.findViewById(R.id.alertText);
            image = (ImageView) view.findViewById(R.id.image);
            //more = (Button) view.findViewById(R.id.more);
        }
    }


    public AlertsAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.alertText.setText(((message.isBullied())?"Your child received a message containing \"":
                "Your child sent a message containing \"")+message.getBadWord()+"\"");
        if (message.isBullied()) {
            holder.image.setImageResource(R.drawable.alert_red);
        }
        else {
            holder.image.setImageResource(R.drawable.alert_yellow );
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
