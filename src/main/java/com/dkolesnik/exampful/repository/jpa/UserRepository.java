package com.dkolesnik.exampful.repository.jpa;

import com.dkolesnik.exampful.model.jpa.entity.Users;
import com.dkolesnik.exampful.repository.jpa.core.CoreRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CoreRepository<Users, Long> {

	Optional<Users> findById(Long id);

	Users findByEmail(String email);

	Optional<Users> findFirstByEmailIgnoreCase(String email);

//	Optional<Users> findFirstByEmailAndOrganization(String email, Organizations organization);

//	Optional<Users> findFirstByEmailIgnoreCaseAndOrganization(String email, Organizations organization);

//	Optional<Users> findFirstByFullNameAndOrganization(String fullName, Organizations organization);

	Optional<Users> findFirstByEmailAndIdIsNotIn(String email, Collection<Long> excludeIds);

	List<Users> findByEmailIsLike(String email);

	List<Users> findAllByEmailIgnoreCase(String email);

}
