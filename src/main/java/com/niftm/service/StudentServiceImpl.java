package com.niftm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niftm.dto.StudentRequest;
import com.niftm.entity.City;
import com.niftm.entity.College;
import com.niftm.entity.Course;
import com.niftm.entity.State;
import com.niftm.entity.Student;
import com.niftm.repository.CityRepo;
import com.niftm.repository.CollegeRepo;
import com.niftm.repository.CourseRepo;
import com.niftm.repository.StateRepo;
import com.niftm.repository.StudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepo stdRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private CourseRepo crsRepo;
	
	@Autowired
	private StateRepo stRepo;
	
	@Autowired
	private CollegeRepo clgrepo;
	
	
	@Override
	public Student saveStudentDtls(StudentRequest student) {
		City ctt = cityRepo.findById(student.getCityId()).orElse(null);
		Course crs = crsRepo.findById(student.getCourseId()).orElse(null);
		State stt = stRepo.findById(student.getStateId()).orElse(null);
		College clg = clgrepo.findById(student.getClgId()).orElse(null);
		
		Student stud = new Student();
		stud.setStudentName(student.getStudentName());
		stud.setFatherName(student.getFatherName());
		stud.setMotherName(student.getMotherName());
		stud.setStudentAddress(student.getAddress());
		stud.setMobileNo(student.getMobileNo());
		stud.setEmailId(student.getEmailId());
		
		stud.setCourse(crs);
		stud.setCollege(clg);
		stud.setCity(ctt);
		stud.setState(stt);
		
		return stdRepo.save(stud);
	}

	@Override
	public List<Student> getAllStudent() {
		return stdRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> findById = stdRepo.findById(id);
		if(findById.isPresent()) {
			Student st = findById.get();
			return st;
		}
		return null;
	}

	@Override
	public Boolean deleteStudentById(Long id) {
		stdRepo.deleteById(id);
		return true;
	}

	@Override
	public Student updateStudentDtls(Student std) {
		Student existingStudent = stdRepo.findById(std.getId()).orElse(null);
		existingStudent.setMobileNo(std.getMobileNo());
		existingStudent.setEmailId(std.getEmailId());
		existingStudent.setStudentAddress(std.getStudentAddress());
		return stdRepo.save(existingStudent);
	}

}
