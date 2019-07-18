package com.lambdaschool.ordersapp.Controllers;

import com.lambdaschool.ordersapp.Models.Customers;
import com.lambdaschool.ordersapp.services.CustomersService;
//import com.lambdaschool.ordersapp.services.CustomersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomersService customersService;



    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customers> list = customersService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @GetMapping(value = "/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(@PathVariable String custname)
    {
        Customers r = customersService.findByCustName(custname);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


    @PostMapping(value = "/customers", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customers newCustomer)
    {
        newCustomer = customersService.save(newCustomer);
        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}").buildAndExpand(newCustomer.getCUSTCODE()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }



    @PutMapping(value = "/customers/{custcode}", consumes = {"application/json"})
    public ResponseEntity<?> updateCustomerById(@RequestBody Customers updateCustomer, @PathVariable long custcode)
    {
        customersService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @DeleteMapping(value = "/customers/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customersService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

