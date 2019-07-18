package com.lambdaschool.ordersapp.Repos;

import com.lambdaschool.ordersapp.Models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders, Long>
{

}
