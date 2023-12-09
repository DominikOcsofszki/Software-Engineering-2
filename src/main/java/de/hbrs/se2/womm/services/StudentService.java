package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.mapper.StudentMapper;
import de.hbrs.se2.womm.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IServicegetDTObyPrimaryKey{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAlleStudenten() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::studentToStudentDto)
                .toList();
    }

    public Optional<StudentDTO> getById(Long id) {
        return studentRepository
                .findById(id)
                .map(studentMapper::studentToStudentDto);
    }

    public void saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.studentDtoToStudent(studentDTO);
        studentRepository.save(student);
    }

    public StudentDTO getStudentByNutzerId(Long id) {
        Student student =  studentRepository.findStudentByNutzer_NutzerId(id);
        System.out.println(student);
        System.out.println("Inside StudentService");
        return studentMapper.studentToStudentDto(student);
    }

    @Override
    public List<? extends AbstractDTO> getDTOListbyPrimaryKey(long primaryKey) {
        return (List.of(getStudentByNutzerId(primaryKey)));
    }
}
