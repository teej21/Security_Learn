package org.example.security_learn.services;


import org.example.security_learn.entities.Account;
import org.example.security_learn.entities.Customer;
import org.example.security_learn.repositories.AccountRepository;
import org.example.security_learn.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewCustomer(Account account, Customer customer) {
        if (accountRepository.findByEmail(customer.getCus_email()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        Account newAccount = new Account();
        newAccount.setEmail(account.getEmail());
        newAccount.setPassword(passwordEncoder.encode(account.getPassword()));
        customer.setAccount(newAccount);
        customerRepository.save(customer);
    }


}
