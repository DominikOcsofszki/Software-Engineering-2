package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<StudentDTO> getAlleStudenten() {
        return studentRepository
                .findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    public void saveStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        studentRepository.save(student);
    }
}
