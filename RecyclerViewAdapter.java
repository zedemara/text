package com.example.robottest3;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aldebaran.qi.sdk.object.conversation.Chat;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ChatViewHolder> {

    ArrayList<ChatElement> chat;

    public RecyclerViewAdapter (ArrayList<ChatElement> chat){
        this.chat = chat;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_custom_item, null, false);

        ChatViewHolder viewHolder = new ChatViewHolder(v);

        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        ChatElement current = chat.get(position);

        if(current.getUser() == "user"){

            holder.botBox.setVisibility(View.GONE);
            holder.userBox.setVisibility(View.VISIBLE);
            holder.userText.setText(current.getMessage());

        } else if (current.getUser() == "bot"){

            holder.userBox.setVisibility(View.GONE);
            holder.botBox.setVisibility(View.VISIBLE);
            holder.botText.setText(current.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return getItemCount();
    }

    //holder class for recycler view
    class ChatViewHolder extends RecyclerView.ViewHolder{
        View userBox;
        View botBox;
        TextView userText;
        TextView botText;
        public ChatViewHolder(View itemView) {
            super(itemView);

            userBox = itemView.findViewById(R.id.right_chat_view);
            userText = itemView.findViewById(R.id.right_chat_text_view);

            botBox = itemView.findViewById(R.id.left_chat_view);
            botText = itemView.findViewById(R.id.left_chat_text_view);

        }

    }

    public void addMessage(ChatElement message) {
        chat.add(message);
        notifyItemInserted(chat.size() - 1); // Notify that a new item is inserted at the end of the list
    }
}
