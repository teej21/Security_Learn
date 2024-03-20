use intern_vnpt;

CREATE TABLE `Accounts` (
                            `acc_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                            `email` VARCHAR(255) NOT NULL UNIQUE,
                            `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `Customers` (
                             `cus_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                             `cus_fname` VARCHAR(255) NOT NULL,
                             `cus_lname` VARCHAR(255) NOT NULL,
                             `cus_email` VARCHAR(255) NOT NULL,
                             `cus_address` VARCHAR(255),
                             `cus_phone` VARCHAR(20),
                             `cus_gender` CHAR(1),
                             `acc_id` BIGINT,
                             FOREIGN KEY (`acc_id`) REFERENCES `Accounts`(`acc_id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `Employees` (
                             `emp_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                             `emp_name` VARCHAR(255) NOT NULL,
                             `emp_gender` CHAR(1),
                             `emp_email` VARCHAR(255) NOT NULL,
                             `emp_phone` VARCHAR(20),
                             `emp_address` VARCHAR(255),
                             `acc_id` BIGINT,
                             FOREIGN KEY (`acc_id`) REFERENCES `Accounts`(`acc_id`) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE `Roles` (
                         `role` VARCHAR(255) NOT NULL,
                         `acc_id` BIGINT NOT NULL,
                         PRIMARY KEY (`role`, `acc_id`),
                         FOREIGN KEY (`acc_id`) REFERENCES `Accounts`(`acc_id`) ON DELETE CASCADE ON UPDATE CASCADE
);
-- Inserting accounts for employees and customers
-- pass test1234
INSERT INTO Accounts (email, password) VALUES ('admin@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('manager@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('employee1@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('employee2@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('employee3@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('customer1@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('customer2@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('customer3@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('customer4@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');
INSERT INTO Accounts (email, password) VALUES ('customer5@example.com', '{bcrypt}$2a$12$tH1d3NoDkdk9TpHxkVOo2Ole3G/HG9VVWGF0fhy4Di0IdhPn1hirm');

-- Inserting roles for those accounts
INSERT INTO Roles (role, acc_id) VALUES ('admin', 1);
INSERT INTO Roles (role, acc_id) VALUES ('manager', 2);
INSERT INTO Roles (role, acc_id) VALUES ('employee', 3);
INSERT INTO Roles (role, acc_id) VALUES ('employee', 4);
INSERT INTO Roles (role, acc_id) VALUES ('employee', 5);
INSERT INTO Roles (role, acc_id) VALUES ('customer', 6);
INSERT INTO Roles (role, acc_id) VALUES ('customer', 7);
INSERT INTO Roles (role, acc_id) VALUES ('customer', 8);
INSERT INTO Roles (role, acc_id) VALUES ('customer', 9);
INSERT INTO Roles (role, acc_id) VALUES ('customer', 10);

-- Inserting employees
INSERT INTO Employees (emp_name, emp_gender, emp_email, emp_phone, emp_address, acc_id)
VALUES ('John Admin', 'M', 'admin@example.com', '1234567890', '123 Admin St', 1),
       ('Sally Manager', 'F', 'manager@example.com', '2345678901', '234 Manager St', 2),
       ('Emp One', 'M', 'employee1@example.com', '3456789012', '345 Employee St', 3),
       ('Emp Two', 'F', 'employee2@example.com', '4567890123', '456 Employee St', 4),
       ('Emp Three', 'M', 'employee3@example.com', '5678901234', '567 Employee St', 5);

-- Inserting customers
INSERT INTO Customers (cus_fname, cus_lname, cus_email, cus_address, cus_phone, cus_gender, acc_id)
VALUES ('Cus One', 'Lastname', 'customer1@example.com', '678 Customer St', '6789012345', 'M', 6),
       ('Cus Two', 'Lastname', 'customer2@example.com', '789 Customer St', '7890123456', 'F', 7),
       ('Cus Three', 'Lastname', 'customer3@example.com', '890 Customer St', '8901234567', 'M', 8),
       ('Cus Four', 'Lastname', 'customer4@example.com', '901 Customer St', '9012345678', 'F', 9),
       ('Cus Five', 'Lastname', 'customer5@example.com', '012 Customer St', '0123456789', 'M', 10);