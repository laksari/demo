package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Employe {
	
	
	private int id;
	
	private int version;
	
	private String nom;
	private String prenom;
	
	private Collection<Projet> listePj;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@ManyToMany
	@JoinTable( name="EMP_PROJ",joinColumns=@JoinColumn(name="EMPLOYEE_ID"),
			inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
	public Collection<Projet> getListePj() {
		return  listePj;
	}
	public void setListePj(Collection<Projet> listePj) {
		this.listePj = listePj;
	}
	
	
	

}
