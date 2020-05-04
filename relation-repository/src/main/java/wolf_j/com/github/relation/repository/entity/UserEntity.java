/**
 * 
 */
package wolf_j.com.github.relation.repository.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author wolf-J
 *
 */

@Entity
@Table(name = "user")
public class UserEntity implements Serializable, UserDetails {
	private static final long serialVersionUID = 5113359539035265304L;
	@Id
	@GeneratedValue(strategy =  GenerationType.TABLE, generator = "user_sequence")
	@TableGenerator(name = "user_sequence", allocationSize = 1,table = "seq_table")
	@Column(unique = true, name = "id")
	private long id;

	@Column(name = "user_id", nullable = false, unique = true, length = 20)
	private String userId;

	@Column(name = "password", nullable = false, length = 100)
	private String passWord;

	@Column(name = "role")
	private String role;

	@Column(name = "create_time", nullable = false)
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	public UserEntity() {
	}

	public UserEntity(String userId, String passWord, String role) {

		this.setUserId(userId);
		this.setPassWord(passWord);
		this.setRole(role);

	}

	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(getRole()));
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId(String userId) {
		return this.userId;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isSameUserProperties(UserEntity user) {
		if (user.id == this.id && user.userId.equals(this.userId) && user.passWord.equals(this.passWord)
				&& user.role.equals(this.role))
			return true;
		return false;
	}
}
