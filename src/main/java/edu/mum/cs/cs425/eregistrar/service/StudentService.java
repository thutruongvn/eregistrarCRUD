package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface StudentService {
    public abstract Iterable<Student> getAllStudents();
    public abstract Page<Student> getAllStudentsPaged(int pageNo);
    public abstract Student saveStudent(Student book);
    public abstract Student getStudentById(Integer bookId);
    public abstract void deleteStudentById(Integer bookId);
    public abstract Optional<Student> findByStudentNo(String studentNo);

}

