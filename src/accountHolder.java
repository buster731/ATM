public class accountHolder{
	
	private int pin;
	private String name;
	private String dob;
	private String address;
	
	public accountHolder(int pin, String name, String dob, String address){
		this.pin = pin;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}
	
	public int getPin() {
		return pin;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPIN(int pin) {
		this.pin = pin;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}