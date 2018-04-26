package com.cbt.demo.album;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: DemoAlbumApplication</p>
 * <p>Description: Application class for Album Service.</p>
 *
 * @author Rachna Aggarwal
 * @version 1.0
 */
@SpringBootApplication
public class DemoAlbumApplication extends SpringBootServletInitializer
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
        return application.sources(DemoAlbumApplication.class);
    }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException
	{
		/* Skip the SSL Certificate Verification */
		TrustStrategy acceptingStrategy = (X509Certificate[] chain, String authType) -> true;
		
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingStrategy).build();
		
		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
		
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
	    
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		
		return restTemplate;
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(DemoAlbumApplication.class, args);
	}

}