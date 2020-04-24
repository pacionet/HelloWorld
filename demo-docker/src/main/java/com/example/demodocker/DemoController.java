package com.example.demodocker;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demodocker.http.HttpManager;


@RestController
public class DemoController
{
    @RequestMapping("/")
    public List<Customer> findAll()
    {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1, "FORZA ROMA"));
        customerList.add(new Customer(2, "CIAO PIPPO"));
        return customerList;
    }
    
    @RequestMapping("/testHttp")
    public String testHttp() throws Exception
    {
    	HttpManager httpManager = new HttpManager();
    	CloseableHttpClient httpClient = httpManager.getClient();
    	
    	HttpGet httpGet = new HttpGet("https://www.google.it");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		return EntityUtils.toString(response.getEntity());
    	
    	
    }
}