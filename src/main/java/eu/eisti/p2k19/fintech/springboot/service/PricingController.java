package eu.eisti.p2k19.fintech.springboot.service;

import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.eisti.p2k19.fintech.springboot.entities.Pricing;
import eu.eisti.p2k19.fintech.springboot.exceptions.PricingNotFoundException;
import eu.eisti.p2k19.fintech.springboot.repositories.PricingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/pricings")
@Api(value = "/pricings") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class PricingController {

	@GET
    @Path("/amount/{amount}/duration/{duration}")
	@ApiOperation(value = "Finds the rate for a given amount and duration")
	public double rateByAmountAndDuration(@PathParam("amount") final double amount, @PathParam("duration") final int duration) throws PricingNotFoundException {

		Iterator<Pricing> pricings = pricingRepository.findByAmountAndDuration(amount, duration).iterator();
//		Iterator<Pricing> pricings = pricingRepository.findAll().iterator();

		double bestRate;
		if(pricings.hasNext()) {
			Pricing pricing = pricings.next();
			bestRate = pricing.getRate();
		} else {
			throw new PricingNotFoundException();
		}
		
		while(pricings.hasNext()) {
			Pricing pricing = pricings.next();
			double newRate = pricing.getRate();
			if (newRate < bestRate) bestRate = newRate;
		}
		
		return bestRate;
	}

    @Autowired
    private PricingRepository pricingRepository;
}
