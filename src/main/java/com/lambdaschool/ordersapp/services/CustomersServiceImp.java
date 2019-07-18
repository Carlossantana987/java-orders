package com.lambdaschool.ordersapp.services;

import com.lambdaschool.ordersapp.Models.Customers;
import com.lambdaschool.ordersapp.Repos.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service( value = "customerService")
public class CustomersServiceImp implements CustomersService
{

    @Autowired
    private CustomersRepo customersRepo;

    @Override
    public List<Customers> findAll()
    {
        List<Customers> list = new ArrayList<>();
        customersRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustCodeById(long id)
    {
        return customersRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customers findByCUSTNAME(String custname)
    {
        Customers customers = customersRepo.findByCUSTNAME(custname);


        if (customers == null)
        {
            throw new EntityNotFoundException("Customer " + custname + " not found!");
        }

        return customers;
    }


    @Override
    public void delete(long id)
    {
        if(customersRepo.findById(id).isPresent())
        {
            customersRepo.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException((Long.toString(id)));
        }
    }

    @Transactional
    @Override
    public Customers save (Customers customers)
    {
        Customers newCustomers = new Customers();

        newCustomers.setCUSTNAME(customers.getCUSTNAME());
        newCustomers.setWORKINGAREA(customers.getWORKINGAREA());
        newCustomers.setCUSTCITY(customers.getCUSTCITY());
        newCustomers.setCUSTCOUNTRY(customers.getCUSTCOUNTRY());
        newCustomers.setGRADE(customers.getGRADE());
        newCustomers.setOPENINGAMET(customers.getOPENINGAMET());
        newCustomers.setRECEIVEAMT(customers.getRECEIVEAMT());
        newCustomers.setPAYMENTAMT(customers.getPAYMENTAMT());
        newCustomers.setOUTSTANDINGAMT(customers.getOUTSTANDINGAMT());
        newCustomers.setPHONE(customers.getPHONE());

        return customersRepo.save(newCustomers);
    }

    @Transactional
    @Override
    public Customers update(Customers customers, long id)
    {
        Customers currentAgents = customersRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customers.getCUSTNAME() != null)
        {
            currentAgents.setCUSTNAME(customers.getCUSTNAME());
        }

        if (customers.getWORKINGAREA() != null)
        {
            currentAgents.setWORKINGAREA(customers.getWORKINGAREA());
        }

        if (customers.getGRADE() != null)
        {
            currentAgents.setGRADE(customers.getGRADE());
        }

        if (customers.getOPENINGAMET() != 0)
        {
            currentAgents.setOPENINGAMET(customers.getOPENINGAMET());
        }

        if (customers.getRECEIVEAMT() != 0)
        {
            currentAgents.setRECEIVEAMT(customers.getRECEIVEAMT());
        }

        if (customers.getPAYMENTAMT() != 0)
        {
            currentAgents.setPAYMENTAMT(customers.getPAYMENTAMT());
        }

        if (customers.getOUTSTANDINGAMT() != 0)
        {
            currentAgents.setOUTSTANDINGAMT(customers.getOUTSTANDINGAMT());
        }

        if (customers.getCUSTCITY() != null)
        {
            currentAgents.setCUSTCITY(customers.getCUSTCITY());
        }

        if (customers.getPHONE() != null)
        {
            currentAgents.setPHONE(customers.getPHONE());
        }

        if (customers.getCUSTCOUNTRY() != null)
        {

            currentAgents.setCUSTCOUNTRY(customers.getCUSTCOUNTRY());
        }

        return customersRepo.save(currentAgents);
    }

}
