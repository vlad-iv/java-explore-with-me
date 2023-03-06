package ewm.main.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Caterogy {
	@Id
	Long id;

	String name;
}
