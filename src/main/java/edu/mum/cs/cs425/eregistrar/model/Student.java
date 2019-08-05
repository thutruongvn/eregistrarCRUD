package edu.mum.cs.cs425.eregistrar.model;

import edu.mum.cs.cs425.eregistrar.model.validator.UniqueStudentNo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@UniqueStudentNo
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "* studentNo is required")
    @Column(name = "studentNo", nullable = false, unique = true)
    private String studentNumber;

    @NotBlank(message = "* Student First Name is required")
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @NotBlank(message = "* Student Last Name is required")
    @Column(name = "lastName", nullable = false)
    private String lastName;

    private String middleName;

    private double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    private Boolean isInternational;


    public Student() {
    }

    public Student(Integer studentId, String studentNumber, String firstName, String lastName,
                String middleName,Double cgpa,  LocalDate dateOfEnrollment, Boolean isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName=" + middleName +
                ", lastName='" + lastName + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", dateOfEnrollment='" + dateOfEnrollment + '\'' +
                ", isInternational=" + isInternational +
                '}';
    }
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }
}
