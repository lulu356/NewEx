package com.example.newex.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newex.HotelDB.Message;
import com.example.newex.R;
import com.example.newex.chat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.auth.User;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class MessAdapterlist extends ArrayAdapter<Message> {
    public MessAdapterlist(@NonNull chat chat, ArrayList<Message> listMess) {
        super(chat, R.layout.mess_item,(List<Message>) listMess);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Message mess = getItem(position);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.mess_item, parent, false);
        }

        TextView commentAuthorName = convertView.findViewById(R.id.MessUser);
        TextView commentText = convertView.findViewById(R.id.MessText);
        TextView dateOfSend = convertView.findViewById(R.id.MessTime);





        commentAuthorName.setText(mess.UserId);
        commentText.setText(mess.TextMessage);
        dateOfSend.setText(mess.MessageTime);

        return convertView;
    }
}
