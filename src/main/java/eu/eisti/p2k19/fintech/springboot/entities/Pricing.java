package eu.eisti.p2k19.fintech.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pricing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private int minDuration;
    private int maxDuration;
    
    private double minAmount;
    private double maxAmount;
    
    private double rate;
    
    protected Pricing() {}

	public Pricing(int minDuration, int maxDuration, double minAmount, double maxAmount, double rate) {
		super();
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.rate = rate;
	}

	public int getMinDuration() {
		return minDuration;
	}

	public void setMinDuration(int minDuration) {
		this.minDuration = minDuration;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	public double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
    
}
