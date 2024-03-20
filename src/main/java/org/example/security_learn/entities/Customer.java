package org.example.security_learn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.security_learn.enums.Gender;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cus_id;

    private String cus_fname;

    private String cus_lname;

    private String cus_email;

    private String cus_address;

    private String cus_phone;

    private Gender cus_gender;

    @OneToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Account account;

    public Customer() {

    }

    //    builder pattern
    public Customer build() {
        return new Customer(cus_id, cus_fname, cus_lname, cus_email, cus_address, cus_phone, cus_gender, account);
    }

}
