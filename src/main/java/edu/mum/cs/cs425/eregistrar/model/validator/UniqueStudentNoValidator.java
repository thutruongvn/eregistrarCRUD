package edu.mum.cs.cs425.eregistrar.model.validator;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueStudentNoValidator implements ConstraintValidator<UniqueStudentNo, Student> {

    private StudentService studentService;

    public UniqueStudentNoValidator() {
    }

    @Autowired
    public UniqueStudentNoValidator(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void initialize(UniqueStudentNo constraintAnnotation) {
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext context) {
        boolean valid;
        if(studentService != null) {
            String stuNo = student.getStudentNumber();
            Integer stuId = student.getStudentId();
            if((stuId == null) && ( stuNo != null && !studentService.findByStudentNo(stuNo).isPresent())) {
                valid = true;
            } else if(stuNo != null && studentService.findByStudentNo(stuNo).isPresent()) {
                Student foundStudent = studentService.findByStudentNo(stuNo).get();
                valid = (foundStudent.getStudentId().equals(stuId) && foundStudent.getStudentNumber().equals(stuNo));
            } else {
                valid = false;
            }
        } else {
            valid = true;
        }
        return valid;
    }
}
