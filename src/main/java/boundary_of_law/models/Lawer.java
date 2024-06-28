package boundary_of_law.models;

import javax.validation.constraints.NotEmpty;

public class Lawer {

	int id;
	@NotEmpty
	String name;
	@NotEmpty
	String email;
	@NotEmpty
	String password;
	@NotEmpty
	String NRC;
	@NotEmpty
	String phone;
	@NotEmpty
	String gender;
	@NotEmpty
	String current_state;
	
	double price;
	
	String photo;
	@NotEmpty
	String status;
	int case_type_id;
	String case_type_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNRC() {
		return NRC;
	}
	public void setNRC(String nRC) {
		NRC = nRC;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCurrent_state() {
		return current_state;
	}
	public void setCurrent_state(String current_state) {
		this.current_state = current_state;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCase_type_id() {
		return case_type_id;
	}
	public void setCase_type_id(int case_type_id) {
		this.case_type_id = case_type_id;
	}
	public String getCase_type_name() {
		return case_type_name;
	}
	public void setCase_type_name(String case_type_name) {
		this.case_type_name = case_type_name;
	}
	
	
	
}
