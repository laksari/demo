package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;


@Entity
public class Projet {
	
    private int id;
	
	private int version;
	
	private String nom;
	
	private Collection<Employe> listeEmp;

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

	@ManyToMany(mappedBy="listePj")
	public Collection<Employe> getListeEmp() {
		return listeEmp;
	}

	public void setListeEmp(Collection<Employe> listeEmp) {
		this.listeEmp = listeEmp;
	}
	
	
	

}
