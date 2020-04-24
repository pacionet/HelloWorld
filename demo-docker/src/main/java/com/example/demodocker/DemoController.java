package com.example.demodocker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController
{
    @RequestMapping("/")
    public List<Customer> findAll()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "FORZA ROMA"));
        customerList.add(new Customer(2, "CIAO PIPPO"));
        customerList.add(new Customer(3, "MODIFICA FATTA SUL BRANCH"));
        return customerList;
    }
}