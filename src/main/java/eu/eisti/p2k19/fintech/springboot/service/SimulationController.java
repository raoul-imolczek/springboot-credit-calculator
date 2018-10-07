package eu.eisti.p2k19.fintech.springboot.service;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.eisti.p2k19.fintech.fbo.credit.model.CreditImmobilier;
import eu.eisti.p2k19.fintech.fbo.credit.model.CreditPasRemboursableException;
import eu.eisti.p2k19.fintech.fbo.credit.model.TauxUsureException;
import eu.eisti.p2k19.fintech.springboot.model.SimulationResult;
import eu.eisti.p2k19.fintech.springboot.repositories.PricingRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/simulation")
@Api(value = "/simulation") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class SimulationController {

	@GET
    @Path("/amount/{amount}/contribution/{contribution}/duration/{duration}/rate/{rate}")
	@ApiOperation(value = "Simulates the loan for a given amount, duration and rate")
	public SimulationResult simulationByAmountAndDurationAndRate(@PathParam("amount") final double amount, @PathParam("contribution") final double contribution, @PathParam("duration") final int duration, @PathParam("rate") final double rate) throws TauxUsureException, CreditPasRemboursableException {
		SimulationResult result = new SimulationResult();
		
		CreditImmobilier credit = new CreditImmobilier(contribution, amount, duration, rate, 0, 0, LocalDate.now());
		result.setMonthlyInstallment(credit.getMensualite());
		result.setTaeg(credit.getTaeg());
		
		return result;
	}

    @Autowired
    private PricingRepository pricingRepository;
}
