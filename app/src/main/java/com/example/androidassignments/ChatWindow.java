package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "ChatWindowActivity";

    ListView list;
    EditText editor;
    Button sendButton;
    ArrayList<String> chat = new ArrayList<>();
    ChatAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        list = findViewById(R.id.list);
        editor = findViewById(R.id.editor);
        sendButton = findViewById(R.id.sendButton);

        messageAdapter = new ChatAdapter(this);
        list.setAdapter(messageAdapter);

    }


    public void send(View view) {
        Log.i(ACTIVITY_NAME, String.valueOf(view));
       String content =  editor.getText().toString();
       chat.add(content);
       messageAdapter.notifyDataSetChanged();
       editor.setText("");


    }


    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(Context ctx){
            super(ctx,0);
        }

        public int getCount(){
            return chat.size();
        }
        public String getItem(int position){
            return chat.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflator = ChatWindow.this.getLayoutInflater();

            View result = null;

            if(position%2==0){
                result = inflator.inflate(R.layout.chat_row_incoming,null);
            }
            else{
                result = inflator.inflate(R.layout.chat_row_outgoing,null);
            }

            TextView message = result.findViewById(R.id.messageText);
            message.setText(getItem(position));
            return result;

        }

    }
}