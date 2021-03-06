package com.ibm.qure.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ibm.qure.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, Object> {
	List<Doctor> findByAddress_City(Optional<String> city);

	List<Doctor> findBySpecialization(Optional<String> specialization);

	// List<Doctor> findByAddress_CityAndSpecialization(String city,String
	// specialization);
	// @Query("{'doctor.specialization' : ?0, doctor.address.city : ?1}")
	List<Doctor> findBySpecializationAndAddress_City(Optional<String> specialization, Optional<String> city);

	Doctor findByEmail(String email);

	Doctor findByDoctorId(String id);

}