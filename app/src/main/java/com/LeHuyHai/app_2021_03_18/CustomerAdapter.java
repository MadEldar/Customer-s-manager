package com.LeHuyHai.app_2021_03_18;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<CustomerEntity> customerEntityList;

    public CustomerAdapter(Activity activity, List<CustomerEntity> customerList) {
        this.activity = activity;
        this.customerEntityList = customerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomerEntity model = customerEntityList.get(position);
        CustomerViewHolder vh =  (CustomerViewHolder) holder;
        vh.tvName.setText(model.name);
        vh.tvEmail.setText(model.email);
        vh.tvPhone.setText(model.phone);
        vh.tvGender.setText(model.gender);
    }

    @Override
    public int getItemCount() {
        return customerEntityList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvPhone, tvGender;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvGender = itemView.findViewById(R.id.tvGender);
        }
    }
}
