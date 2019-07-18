package com.lambdaschool.ordersapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ORDERNUM;

    @Column(unique = true,
            nullable = false)
    private double ORDAMOUNT;
    private double ADVANCEAMOUNT;
    private String ORDDESCRIPTION;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTCODE",
            nullable = false)
    @JsonIgnoreProperties({"orders", "HibernateLazyInitializer"})
    private Customers customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENTCODE", nullable = false)
    private Agents agents;

    public Orders()
    {
    }


    public Orders(double ORDAMOUNT, double ADVANCEAMOUNT, Customers customers, String ORDDESCRIPTION )
    {
        this.ORDAMOUNT = ORDAMOUNT;
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
        this.customers = customers;
        this.ORDDESCRIPTION = ORDDESCRIPTION;
    }

    public long getORDERNUM()
    {
        return ORDERNUM;
    }

    public void setORDERNUM(long ORDERNUM)
    {
        this.ORDERNUM = ORDERNUM;
    }

    public double getORDAMOUNT()
    {
        return ORDAMOUNT;
    }

    public void setORDAMOUNT(double ORDAMOUNT)
    {
        this.ORDAMOUNT = ORDAMOUNT;
    }

    public double getADVANCEAMOUNT()
    {
        return ADVANCEAMOUNT;
    }

    public void setADVANCEAMOUNT(double ADVANCEAMOUNT)
    {
        this.ADVANCEAMOUNT = ADVANCEAMOUNT;
    }

    public String getORDDESCRIPTION()
    {
        return ORDDESCRIPTION;
    }

    public void setORDDESCRIPTION(String ORDDESCRIPTION)
    {
        this.ORDDESCRIPTION = ORDDESCRIPTION;
    }

    public Customers getCustomers()
    {
        return customers;
    }

    public void setCustomers(Customers customers)
    {
        this.customers = customers;
    }

    public Agents getAgents()
    {
        return agents;
    }

    public void setAgents(Agents agents)
    {
        this.agents = agents;
    }

}
