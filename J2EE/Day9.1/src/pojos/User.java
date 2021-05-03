package pojos;

import java.time.LocalDate;
import javax.persistence.*;

//Integer ,name,email,password,role(enum),confirmPassword, regAmount;
//LocalDate/Date regDate;byte[] image;

//mandatory rule for hibernate pojo : pojo's ID property must be serialized
@Entity //madatory
@Table(name="users_tbl")
public class User 
{
	private Integer userId;///mandatory unique id property: must implement java.io.serializable i/f
	private String name,email,password;
	private Role userRole;
	private String confirmPassword;
	private Double regAmount;
	private LocalDate regDate;
	private byte[] image;
	//Mandatory to provide argless default ctor
	public User()
	{
		System.out.println("in user ctor");
	}

	public User(String name, String email, String password, Role userRole, String confirmPassword, Double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id //mandatory // Primary key constraint
//	@GeneratedValue //automatic id generation by hibernate : native DB scheme
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//:auto increment (best suited for mysql)
	@Column(name="user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length = 20)//varchar(20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20 , unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 50 , nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)//varchar => constant name
	@Column(length = 30 , name = "User_role")
	public Role getUserRole() {
		return userRole;
	}
	
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Transient //Skipped from persistence(No col generation for this property)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name = "Registration_amt")
	public Double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(Double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Lob //=> db col type: longBlob : mySql
	public byte[] getImage() {
		return image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	//must supply all setters and getters
}
