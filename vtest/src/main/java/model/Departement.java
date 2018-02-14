package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement {
	
	private int id;
	private String nom;
	
	private Collection<Personne> listePersonne;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@OneToMany(mappedBy="departement",fetch=FetchType.EAGER)
	public Collection<Personne> getListePersonne() {
		return listePersonne;
	}

	public void setListePersonne(Collection<Personne> listePersonne) {
		this.listePersonne = listePersonne;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", listePersonne=" + listePersonne + "]";
	}
	
	
	
	

}



