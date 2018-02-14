package metier;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Secu {
	
	@Id
	private int id;
	
	@OneToOne
	private Eleve eleve;

}
