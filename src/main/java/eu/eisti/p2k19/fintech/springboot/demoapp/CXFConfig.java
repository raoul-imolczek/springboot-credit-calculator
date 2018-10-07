package eu.eisti.p2k19.fintech.springboot.demoapp;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.eisti.p2k19.fintech.springboot.service.PricingController;

@Configuration
class CXFConfig {
	
  @Autowired
  private Bus bus;

  @Bean
  public Server rsServer() {
      final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
      endpoint.setProvider(new JacksonJsonProvider());
      endpoint.setBus(bus);
      endpoint.setAddress("/");
      endpoint.setServiceBeans(Arrays.<Object>asList(userController()));
      endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
      return endpoint.create();
  }

  @Bean
  public PricingController userController() {
      return new PricingController();
  }
}