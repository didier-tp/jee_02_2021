package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean //ManagedBean de JSF
@SessionScoped
public class LoginMBean {
	
	private Long numClient; //ou Integer
	private String password;
	
	public String login() {
		String suite=null;
		//simulation test mot de passe :
		if(password.equals("pwd" + numClient)) {
			//ex: numClient=1 et pwd=pwd1 ok
		    suite="comptes"; //pour naviguer vers comptes.xhtml si login ok
		}
		return suite;
	}
	
	public LoginMBean() {
		super();
	}
	
	public Long getNumClient() {
		return numClient;
	}
	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
