-- GROCERIES
INSERT INTO groceries (name, region, description, url, price)
VALUES ('PEACHES', 'Zug', 'Fresh and juicy',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVyev8C9YtjDzT12GI4C5nvL0o1QISW3CewQ&s', 3.50);
-- ROLES
INSERT INTO role (role_id, role_name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

-- AUTHORITIES
INSERT INTO authority (authority_id, authority_name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE');

-- ADMIN-CRUD, USER-R
INSERT INTO role_authorities (id_authority, id_role)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (1, 2);

INSERT INTO users (first_name, password, id_role)
VALUES ('ADMIN', '1234', 1),
       ('USER', '1234', 2);