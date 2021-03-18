package com.LeHuyHai.app_2021_03_18;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerListActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvCustomerList;
    EditText etNameSearch;

    AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        rvCustomerList = findViewById(R.id.rvCustomerList);
        etNameSearch = findViewById(R.id.etNameSearch);

        db = AppDatabase.getAppDatabase(this);
        String query = etNameSearch.getText().toString();

        List<CustomerEntity> customerList = query.equals("") ?
                db.customerDao().getAllCustomer() :
                db.customerDao().getCustomerByName(query);

        CustomerAdapter adapter = new CustomerAdapter(this, customerList);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setAdapter(adapter);
        rvCustomerList.setLayoutManager(manager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btSearchCustomer:
                break;
            default:
                break;
        }
    }
}
