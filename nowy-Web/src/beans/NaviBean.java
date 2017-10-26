package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NaviBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382281304360697531L;

	public String toLogin() {
		return "/logowanie.xhtml?faces-redirect=true";
	}

	public String toWelcome() {
		return "/secured/listaAut.xhtml?faces-redirect=true";
	}
	
	public String toRegistration() {
		return "/rejestracja.xhtml?faces-redirect=true";
	}
}
