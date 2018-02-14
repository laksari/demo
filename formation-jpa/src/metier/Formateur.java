package metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Formateur {
	
	@Id
	private int id;
	
	
	private String name;
	
	
	@ManyToMany(mappedBy="formateurs")
	private List<Eleve> eleves;
	

}
