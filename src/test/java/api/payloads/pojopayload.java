package api.payloads;
//POJO - Plain Old java Object 
// sample request body to create a user
	/*{
		  "id": 0,
		  "username": "string",
		  "firstName": "string",
		  "lastName": "string",
		  "email": "string",
		  "password": "string",
		  "phone": "string",
		  "userStatus": 0
		}*/
	
	// generate getter and setter method from source
	// pojo means plain old java object

public class pojopayload {
 
	private int id;
	private String username;	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;	
	private int userStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	

}
