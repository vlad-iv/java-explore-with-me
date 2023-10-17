package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Caterogy {
	@Id
	Long id;

	String name;
}
