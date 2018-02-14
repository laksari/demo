package metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Eleve {
	
	@Id
	private int id;
	
	private String nom;
	
	
	
	@ManyToMany
	private List<Formateur> formateurs ;
	

	
	
	
}
