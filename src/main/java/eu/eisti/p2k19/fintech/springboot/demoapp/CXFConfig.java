package eu.eisti.p2k19.fintech.springboot.demoapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import eu.eisti.p2k19.fintech.springboot.service.PricingController;
import eu.eisti.p2k19.fintech.springboot.service.SimulationController;

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
      
      List<Object> serviceBeans = new ArrayList<Object>();
      serviceBeans.add(pricingController());
      serviceBeans.add(simulationController());
      
      endpoint.setServiceBeans(serviceBeans);
      endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
      return endpoint.create();
  }

  @Bean
  public PricingController pricingController() {
      return new PricingController();
  }

  @Bean
  public SimulationController simulationController() {
      return new SimulationController();
  }

}