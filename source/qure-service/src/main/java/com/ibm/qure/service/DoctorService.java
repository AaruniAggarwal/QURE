package com.ibm.qure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.qure.exceptions.ApplicationException;
import com.ibm.qure.model.Doctor;
import com.ibm.qure.repository.DoctorRepository;



@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository docRepo;

	public DoctorService() {
	}

	public boolean create(Doctor doctor) throws ApplicationException {
		try {
			docRepo.save(doctor);
			return true;
		} catch (Exception e) {
			throw new ApplicationException("Server Error. Please try after sometime. Cause: " + e.getMessage(), e);
		}
	}

	public Doctor get(String id) {
		return docRepo.findById(id).get();
	}

	public List<Doctor> getAll() {
		return docRepo.findAll();
	}

	public boolean update(Doctor doctor) {
		docRepo.save(doctor);
		return true;
	}

	public boolean delete(String id) {
		docRepo.deleteById(id);
		return true;
	}
	

}