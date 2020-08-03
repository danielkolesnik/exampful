package com.dkolesnik.exampful.repository.jpa;

import com.dkolesnik.exampful.model.jpa.entity.Roles;
import com.dkolesnik.exampful.repository.jpa.core.CoreRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends CoreRepository<Roles, Long> {

	@Query(value = "SELECT r.* FROM roles r INNER JOIN user_roles ur ON ur.role_id=r.id " +
		"INNER JOIN users u ON ur.user_id = u.id WHERE UPPER(u.email) = UPPER(:email)", nativeQuery = true)
	List<Roles> getUserRolesByEmail(@Param("email") String email);

	@Query(value = "SELECT r FROM Roles r WHERE UPPER(r.name) LIKE (CONCAT(UPPER(:name), '%')) AND r.id > 2")
	List<Roles> getRolesByNameForNonAdmin(@Param("name") String name, Pageable pageable);

	@Query(value = "SELECT count(r) FROM Roles r WHERE UPPER(r.name) LIKE (CONCAT(UPPER(:name), '%')) AND r.id > 2")
	Long getCountRolesByNameForNonAdmin(@Param("name") String name);

	Optional<Roles> findById(Long id);

	Roles findOneByName(String name);

	Roles findOneByNameIgnoreCase(String name);

}
