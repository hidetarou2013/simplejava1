package jp.co.eit.sample.simplejava1;


public class CustVehModel {
	private int customerCode;
	private int vehicleMgtNumber;
	private String orgCodeCust;
	private String orgCodeVehi;
	private String customerNameKana1;
	private boolean exist;

	public boolean isExist() {
		return exist;
	}
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public int getVehicleMgtNumber() {
		return vehicleMgtNumber;
	}
	public void setVehicleMgtNumber(int vehicleMgtNumber) {
		this.vehicleMgtNumber = vehicleMgtNumber;
	}
	public String getOrgCodeCust() {
		return orgCodeCust;
	}
	public void setOrgCodeCust(String orgCodeCust) {
		this.orgCodeCust = orgCodeCust;
	}
	public String getOrgCodeVehi() {
		return orgCodeVehi;
	}
	public void setOrgCodeVehi(String orgCodeVehi) {
		this.orgCodeVehi = orgCodeVehi;
	}
	public String getCustomerNameKana1() {
		return customerNameKana1;
	}
	public void setCustomerNameKana1(String customerNameKana1) {
		this.customerNameKana1 = customerNameKana1;
	}

}
