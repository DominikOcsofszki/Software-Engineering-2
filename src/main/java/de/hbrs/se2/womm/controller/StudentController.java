package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(
                studentService.getAlleStudenten(),
                HttpStatus.OK
        );
    }

    @GetMapping("students/nutzer/id")
    public ResponseEntity<StudentDTO> getByNutzerId(@PathVariable Long id){
        return new ResponseEntity<StudentDTO>(studentService.getStudentByNutzerId(id),HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return studentService.getById(id)
                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("students")
    public ResponseEntity<Void> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    private ResponseEntity<StudentDTO> getStudentByNutzerId(@PathVariable Long id) {
//        return new ResponseEntity<>(studentService.getStudentByNutzerId(id), HttpStatus.OK);
//                .map(studentDTO -> new ResponseEntity<>(studentDTO, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
//    }

}
