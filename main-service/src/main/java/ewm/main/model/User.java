package ewm.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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
	Category category;
	@OneToMany(fetch = FetchType.LAZY)
	List<Role> roles;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User user)) return false;
		return id == user.id && Objects.equals(name, user.name) && Objects.equals(category,
				user.category) && Objects.equals(roles, user.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, category, roles);
	}
}
