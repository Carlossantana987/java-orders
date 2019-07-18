package com.lambdaschool.ordersapp.Repos;

import com.lambdaschool.ordersapp.Models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<Customers, Long>
{
    Customers findByCUSTNAME(String custname);
}
