package com.raissa.chatfirebase;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;


public class MessageChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> mListOfFireChat;

    public MessageChatAdapter(List<String> listOfFireChats) {
        mListOfFireChat=listOfFireChats;
    }

    @Override
    public int getItemViewType(int position) {
       return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewSender = inflater.inflate(R.layout.sender_message, viewGroup, false);
        viewHolder= new ViewHolderSender(viewSender);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolderSender viewHolderSender=(ViewHolderSender)viewHolder;
        configureSenderView(viewHolderSender, position);



    }

    private void configureSenderView(ViewHolderSender viewHolderSender, int position) {

        viewHolderSender.getSenderMessageTextView().setText(mListOfFireChat.get(position));
    }



    @Override
    public int getItemCount() {
        return mListOfFireChat.size();
    }


    public void refillAdapter(String newFireChatMessage){

        /*add new message chat to list*/
        mListOfFireChat.add(newFireChatMessage);

        /*refresh view*/
        notifyDataSetChanged();
    }

    public void refillFirsTimeAdapter(List<String> newFireChatMessage){

        /*add new message chat to list*/
        mListOfFireChat.clear();
        mListOfFireChat.addAll(newFireChatMessage);
        /*refresh view*/
        notifyItemInserted(getItemCount()-1);
    }

    public void cleanUp() {
        mListOfFireChat.clear();
    }


    /*==============ViewHolder===========*/

    /*ViewHolder for Sender*/

    public class ViewHolderSender extends RecyclerView.ViewHolder {

        private TextView mSenderMessageTextView;

        public ViewHolderSender(View itemView) {
            super(itemView);
            mSenderMessageTextView=(TextView)itemView.findViewById(R.id.senderMessage);
        }

        public TextView getSenderMessageTextView() {
            return mSenderMessageTextView;
        }

        public void setSenderMessageTextView(TextView senderMessage) {
            mSenderMessageTextView = senderMessage;
        }
    }


}