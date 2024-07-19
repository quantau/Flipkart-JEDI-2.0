package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    List<Customer> customerList = new ArrayList<>();

    public void registerCustomer(String username, String password, String email, String phoneNumber, String cardNumber) {
        Customer newCustomer = new Customer(Integer.toString(customerList.size()+1), username,email,password,phoneNumber,cardNumber);
        customerList.add(newCustomer);

    }

    public Customer getCustomerById(String username){
        for (Customer customer : customerList) {
            if (customer.getUserName().equals(username)) {
                return customer;
            }
        }
        return null;

    }

    public boolean checkCustomerDetails(String username, String password) {
        for (Customer customer : customerList) {
            if (customer.getUserName().equals(username)
                    && customer.getPassword().equals(password))
                return true;
        }
        return false;
    }
}