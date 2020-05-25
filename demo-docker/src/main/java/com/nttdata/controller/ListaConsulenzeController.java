package com.nttdata.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.be.apigw.listaconsulenze.ListaConsulenzeBeResponse;
import com.nttdata.fe.listaconsulenze.FeConsulenza;
import com.nttdata.fe.listaconsulenze.ListaConsulenzeFeResponse;
import com.nttdata.http.HttpManager;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerSpan;
import io.jaegertracing.internal.JaegerTracer;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import springfox.documentation.annotations.ApiIgnore;


@RestController
public class ListaConsulenzeController
{
	
	@Autowired
    Environment env;
	
	private final static Logger log = LoggerFactory.getLogger(ListaConsulenzeController.class);
	
	private static JaegerTracer tracer = getTracer();
	
	@Bean
	public static JaegerTracer getTracer() {
	    Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
	    Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
	    Configuration config = new Configuration("ListaConsulenze").withSampler(samplerConfig).withReporter(reporterConfig);
	    return config.getTracer();
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
	    return new TimedAspect(registry);
	}

	
    @RequestMapping(value="/listaConsulenze",method = { RequestMethod.GET })
    @Timed(description = "listaConsulenze")
    public ListaConsulenzeFeResponse listaConsulenze()
    {
    	ListaConsulenzeFeResponse listaConsulenzeFeResponse = new ListaConsulenzeFeResponse();
    	
    	JaegerSpan span = tracer.buildSpan("test").start();
    	
    	HttpManager httpManager = new HttpManager();
    	CloseableHttpClient httpClient = null;
    	
    	log.info("property=" + env.getProperty("hello.world"));
    	
    	try {
			httpClient = httpManager.getClient();
		} catch (Exception e) {
			log.error("Eccezione=" + e);
		}
    	
    	HttpGet httpGet = new HttpGet("http://localhost:8080/mockBe");
		CloseableHttpResponse response = null;
		String responseString = null;
		try {
			response= httpClient.execute(httpGet);
			responseString =  EntityUtils.toString(response.getEntity());			

		}
		 catch (Exception e) {
			log.error("Eccezione" + e);
		}
        ObjectMapper objectMapper = new ObjectMapper();

		
        ListaConsulenzeBeResponse[] beResponse=null;
        try {
        	beResponse = objectMapper.readValue(responseString, ListaConsulenzeBeResponse[].class);
        } catch (Exception e) {
			log.error("Eccezione" + e);
		}

        ArrayList<FeConsulenza> list = new ArrayList<FeConsulenza>();
        if (beResponse != null) {
        	for (ListaConsulenzeBeResponse item : beResponse) {
        		FeConsulenza cons = new FeConsulenza();
        		cons.setDataScadenza(item.getDataScadenza());
        		cons.setId(item.getId());
        		cons.setStato(item.getStato());
        		list.add(cons);
        	}
        	listaConsulenzeFeResponse.setList(list);
        }
        
        
        span.finish();
        
        return listaConsulenzeFeResponse;
    }
    
    @ApiIgnore
    @RequestMapping(value="/mockBe",method = { RequestMethod.GET })
    public ListaConsulenzeBeResponse[] mockBe() throws Exception
    {
    	Resource resource = new ClassPathResource("listaConsulenzeMock.json");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream);
        log.debug("file content " + content );
        ObjectMapper objectMapper = new ObjectMapper();
        ListaConsulenzeBeResponse[] listaConsulenzeBeResponse = objectMapper.readValue(content, ListaConsulenzeBeResponse[].class); 
    	return listaConsulenzeBeResponse;
    	
    }
}