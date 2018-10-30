package jp.org.web.login.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Entity
public class MloginUser implements java.io.Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String loginUserId;
	
	@Getter
	@Setter
	private String password;

    public MloginUser() {
    }
	    
}
