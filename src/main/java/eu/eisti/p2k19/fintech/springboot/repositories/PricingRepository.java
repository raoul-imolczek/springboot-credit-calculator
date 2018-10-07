package eu.eisti.p2k19.fintech.springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import eu.eisti.p2k19.fintech.springboot.entities.Pricing;

public interface PricingRepository extends CrudRepository<Pricing, Long>{

	List<Pricing> findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndMinDurationLessThanEqualAndMaxDurationGreaterThanEqualOrderByRateAsc(double minAmount, double maxAmount, int minDuration, int maxDuration);

	default List<Pricing> findByAmountAndDuration(double amount, int duration) {
	    return findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndMinDurationLessThanEqualAndMaxDurationGreaterThanEqualOrderByRateAsc(amount, amount, duration, duration);
	}
	
}
