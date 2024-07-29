package main.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedEntityGraph(
		name = "user-with-category",
		attributeNodes = {
				@NamedAttributeNode("category")
		}
)
//@EqualsAndHashCode(of = "id")
public class User {
	Long id;
	//	String uid;
	String name;

	@ManyToOne(fetch = FetchType.LAZY)
	Caterogy category;
	@OneToMany(fetch = FetchType.LAZY)
	List<Role> roles;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return id == user.id && Objects.equals(name, user.name) && Objects.equals(category,
				user.category) && Objects.equals(roles, user.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, category, roles);
	}
}
