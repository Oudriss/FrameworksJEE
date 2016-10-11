package utils;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import uh1.ac.ma.metier.entities.Utilisateur;

@Component
@Scope("session")
public class SessionBean {

	private final String id = UUID.randomUUID().toString();
    private String role;
    private Utilisateur utilisateur;
    
    
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getId() {
		return id;
	}
    
    
    
}
