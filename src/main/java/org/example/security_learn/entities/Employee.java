package org.example.security_learn.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.security_learn.enums.Gender;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;


    private String emp_name;


    private Gender emp_gender;


    private String emp_email;

    private String emp_phone;

    private String emp_address;

    @OneToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Account account;

    public Employee() {

    }

    //builder pattern
    public Employee build() {
        return new Employee(emp_id, emp_name, emp_gender, emp_email, emp_phone, emp_address, account    );
    }
}
