package top.microiot.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 系统用户类。
 *
 * @author 曹新宇
 */
@JsonSerialize(using = UserSerializer.class)
@Document
public class User {
	public enum Status{
		pending(0), enable(1);
		private int status;
		Status(int status){
			this.status = status;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		
	}
	@Id
    private String id;
	@Indexed(unique=true)
	private String username;
	private String password;
	private Status status;
	private String email;
    private List<Role> roles;
    @DBRef
    private List<Site> area;
    @Transient
    private boolean showPassword = false;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.status = Status.enable;
	}

	public User(String username, String password, String email, List<Role> roles, List<Site> area) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.area = area;
		this.status = Status.enable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean hasRole(Role role){
		if(roles != null){
			for(Role r : roles) {
				if(r.equals(role))
					return true;
			}
		}
		return false;
	}
	public boolean isSystem(){
		return hasRole(Role.SYSTEM);
	}
	public boolean isDevice(){
		return hasRole(Role.DEVICE);
	}

	public boolean isArea() {
		return hasRole(Role.AREA);
	}

	public List<Site> getArea() {
		return area;
	}

	public void setArea(List<Site> area) {
		this.area = area;
	}

	public boolean isShowPassword() {
		return showPassword;
	}

	public void setShowPassword(boolean showPassword) {
		this.showPassword = showPassword;
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User && ((User)obj).getUsername().equals(username))
			return true;
		else
			return false;
	}
}
