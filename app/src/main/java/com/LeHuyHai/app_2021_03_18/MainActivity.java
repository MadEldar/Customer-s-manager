package com.LeHuyHai.app_2021_03_18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etEmail, etPhone;
    RadioGroup rgGender;
    Button btAddCustomer, btSearchCustomer;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        btAddCustomer = findViewById(R.id.btAddCustomer);
        btSearchCustomer = findViewById(R.id.btSearchCustomer);

        db.customerDao().deleteAllCustomer();

        if (db.customerDao().getAllCustomer().isEmpty()) {
            db.customerDao().insertCustomer(
                new CustomerEntity("Mark", "mark@gmail.com", "0937891234", CustomerEntity.GenderMale)
            );
            db.customerDao().insertCustomer(
                new CustomerEntity("Sarah", "sarah@gmail.com", "0939874321", CustomerEntity.GenderFemale)
            );
            db.customerDao().insertCustomer(
                new CustomerEntity("Jane", "jane@gmail.com", "0939871234", CustomerEntity.GenderFemale)
            );
            db.customerDao().insertCustomer(
                new CustomerEntity("Peter", "peter@gmail.com", "0937894321", CustomerEntity.GenderMale)
            );
            db.customerDao().insertCustomer(
                new CustomerEntity("Bruce", "bruce@gmail.com", "0937893456", CustomerEntity.GenderMale)
            );
            db.customerDao().insertCustomer(
                new CustomerEntity("Selina", "selina@gmail.com", "0937896543", CustomerEntity.GenderFemale)
            );
        }

        for (CustomerEntity customer :
                db.customerDao().getAllCustomer()) {
            Log.d("Debug", customer.toString());
        }

        btAddCustomer.setOnClickListener(this);
        btSearchCustomer.setOnClickListener(this);
    }

    private void addCustomer() {
        RadioButton radio = (RadioButton) findViewById(rgGender.getCheckedRadioButtonId());

        if (checkEmpty(etName) || checkEmpty(etEmail) || checkEmpty(etPhone)) {
            Toast.makeText(this, "Please fill out all input boxes", Toast.LENGTH_SHORT).show();
            return;
        }

        CustomerEntity customer = new CustomerEntity(
                etName.getText().toString(),
                etEmail.getText().toString(),
                etPhone.getText().toString(),
                radio.getText().toString()
                );
        Log.d("Debug", customer.toString());
        db.customerDao().insertCustomer(customer);
    }

    private boolean checkEmpty(EditText et) {
        return et.getText().toString().equals("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btAddCustomer:
                Log.d("Debug", "clicked");
                addCustomer();
                break;
            default:
                break;
        }
    }
}