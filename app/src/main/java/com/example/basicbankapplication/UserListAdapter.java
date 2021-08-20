package com.example.basicbankapplication;

import android.content.Intent;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private ArrayList<User> userArrayList;

    public UserListAdapter(ViewAllUsers viewAllUsers, ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(userArrayList.get(position));
        holder.userName.setText(userArrayList.get(position).getName());
        holder.userAccountBalance.setText(String.format("%d", userArrayList.get(position).getBalance()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ViewUserDetails.class);
                intent.putExtra("ACCOUNT_NO", userArrayList.get(position).getAccountNumber());
                intent.putExtra("NAME", userArrayList.get(position).getName());
                intent.putExtra("EMAIL", userArrayList.get(position).getEmail());
                intent.putExtra("IFSC_CODE", userArrayList.get(position).getIfscCode());
                intent.putExtra("PHONE_NO", userArrayList.get(position).getPhoneNumber());
                intent.putExtra("BALANCE", String.valueOf(userArrayList.get(position).getBalance()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName, userAccountBalance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // still to be implemented
                }
            });
        }
    }
}
