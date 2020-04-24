package com.example.demodocker.http;


import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.TrustStrategy;

public class HttpManager {
	
	public CloseableHttpClient getClient() throws Exception {
		
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
		poolingConnManager.setDefaultMaxPerRoute(5);
		poolingConnManager.setMaxTotal(30);
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(2000)
				.setConnectionRequestTimeout(2000)
				.setSocketTimeout(10000)
				.build();

		
		CloseableHttpClient client = HttpClients.custom().setSSLContext(getSSLContext())
				.setSSLHostnameVerifier(getHostnameVerifier())
				.setConnectionManager(poolingConnManager)
				.setDefaultRequestConfig(requestConfig)
				.build();
		
		return client;
				
	}
	
	
	public static SSLContext getSSLContext() throws Exception {
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

		return org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
	}
	
	public static HostnameVerifier getHostnameVerifier() {

		HostnameVerifier hostnameVerifier = new HostnameVerifier() {

			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		};
		return hostnameVerifier;
	}
	

}
