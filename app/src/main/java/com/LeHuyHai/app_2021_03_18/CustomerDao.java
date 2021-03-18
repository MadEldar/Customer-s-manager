package com.LeHuyHai.app_2021_03_18;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomer(CustomerEntity customerEntity);

    @Update
    void updateCustomer(CustomerEntity customerEntity);

    @Query("select * from Customer where id = :id")
    CustomerEntity getCustomerById(int id);

    @Query("select * from Customer")
    List<CustomerEntity> getAllCustomer();

    @Delete
    void deleteCustomer(CustomerEntity customerEntity);

    @Query("delete from Customer")
    void deleteAllCustomer();
}
