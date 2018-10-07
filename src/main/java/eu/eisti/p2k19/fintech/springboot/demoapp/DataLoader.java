package eu.eisti.p2k19.fintech.springboot.demoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import eu.eisti.p2k19.fintech.springboot.entities.Pricing;
import eu.eisti.p2k19.fintech.springboot.repositories.PricingRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private PricingRepository pricingRepository;

    @Autowired
    public DataLoader(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public void run(ApplicationArguments args) {
    	pricingRepository.save(new Pricing(60, 120, 10000, 99999.99, 1.15));
    	pricingRepository.save(new Pricing(121, 180, 10000, 99999.99, 1.35));
    	pricingRepository.save(new Pricing(181, 240, 10000, 99999.99, 1.55));
    	pricingRepository.save(new Pricing(241, 300, 10000, 99999.99, 1.75));
    	pricingRepository.save(new Pricing(60, 120, 100000, 199999.99, 1.25));
    	pricingRepository.save(new Pricing(121, 180, 100000, 199999.99, 1.45));
    	pricingRepository.save(new Pricing(181, 240, 100000, 199999.99, 1.65));
    	pricingRepository.save(new Pricing(241, 300, 100000, 199999.99, 1.85));
    	pricingRepository.save(new Pricing(60, 120, 200000, 299999.99, 1.35));
    	pricingRepository.save(new Pricing(121, 180, 200000, 299999.99, 1.55));
    	pricingRepository.save(new Pricing(181, 240, 200000, 299999.99, 1.75));
    	pricingRepository.save(new Pricing(241, 300, 200000, 299999.99, 1.95));
    }
}