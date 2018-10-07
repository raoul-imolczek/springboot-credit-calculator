package eu.eisti.p2k19.fintech.springboot.model;


public class SimulationResult {
	
	private double monthlyInstallment;
	private double taeg;

	public double getMonthlyInstallment() {
		return monthlyInstallment;
	}
	
	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}
	
	public double getTaeg() {
		return taeg;
	}
	
	public void setTaeg(double taeg) {
		this.taeg = taeg;
	}
	
}
