package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.Models.Customers;

import java.util.List;

public interface CustomersService
{
    List<Customers> findAll();

    Customers findCustCodeById(long id);

    Customers findByCUSTNAME(String custname);

    void delete(long id);

    Customers save(Customers customer);

    Customers update(Customers customer, long id);
}
