USE
intern_vnpt;

DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS members;


CREATE TABLE members
(
    user_id varchar(50) NOT NULL,
    pw      char(68)    NOT NULL,
    active  tinyint     NOT NULL,
    PRIMARY KEY (user_id)
);

INSERT INTO members
VALUES ('john', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1),
       ('mary', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1),
       ('susan', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 1);

CREATE TABLE roles
(
    user_id varchar(50) NOT NULL,
    role    varchar(50) NOT NULL,
    UNIQUE KEY role_id (user_id,role),
    CONSTRAINT role_id FOREIGN KEY (user_id) REFERENCES members (user_id)
);



INSERT INTO roles
VALUES ('john', 'ROLE_EMPLOYEE'),
       ('mary', 'ROLE_EMPLOYEE'),
       ('mary', 'ROLE_MANAGER'),
       ('susan', 'ROLE_EMPLOYEE'),
       ('susan', 'ROLE_MANAGER'),
       ('susan', 'ROLE_ADMIN');
