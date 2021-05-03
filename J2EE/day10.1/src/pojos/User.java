package pojos;
/*
 *  userId (PK) ,name,email,password,role(enum),confirmPassword, regAmount;
	 LocalDate/Date ;
	 byte[] image;
 */

import java.time.LocalDate;
import javax.persistence.*;
@Entity //MUST
@Table(name="users_tbl")
public class User {
	//Mandatory : MUST define unique id property : MUST implement java.io.Serializable i/f
	private Integer userId;//int will also work!
	private String name,email,password;
	private Role userRole;
	private String confirmPassword;
	private double regAmount;
	private LocalDate regDate;
	private byte[] image;
	//MAndatory : supply arg-less def constr
	public User() {
		System.out.println("in user constr");
	}
	public User(String name, String email, String password, Role userRole, String confirmPassword, double regAmount,
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
	public User(String name, double regAmount,	LocalDate regDate) {
		super();
		this.name = name;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	//MUST : supply all getters n setters
	@Id //MUST => PK constraint
//	@GeneratedValue => strategy for id generation : auto => as per native DB
	@GeneratedValue(strategy = GenerationType.IDENTITY) //most suitable for Mysql => auto_increment
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length = 25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20,unique = true,nullable = false)//UNIQUE n NOT NULL constraint
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 20,nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)//col type : varchar : enum const name
	@Column(length = 20,name="user_role")
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Transient //=> no corresponding col in db(no persistence)
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Column(name="reg_amount")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Column(name="reg_date")
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	@Lob //=>MySql : db col type : longblob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}
	

}
