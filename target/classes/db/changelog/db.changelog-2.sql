-- liquibase formatted sql

-- changeset lucas.silva: 2.0 dbms:mysql
INSERT INTO Company (vacancies, name, document, site)
VALUES (1, "Empresa 1", "123456789", "www.empresa1.com.br");

INSERT INTO Company (vacancies, name, document, site)
VALUES (4, "Empresa 2", "3215468789", "www.empresa2.com.br");

INSERT INTO Company (vacancies, name, document, site)
VALUES (1, "Empresa 3", "87454512135", "www.empresa3.com.br");

INSERT INTO Company (vacancies, name, document, site)
VALUES (5, "Empresa 4", "987512231", "www.empresa4.com.br");

INSERT INTO Company (vacancies, name, document, site)
VALUES (10, "Empresa 5", "231545689", "www.empresa5.com.br");

-- changeset lucas.silva: 2.1 dbms:mysql
INSERT INTO User (name, document, age, login, password, company_id, salary)
VALUES("Usuário 1", "6544848956", 20, "user1", "user1", 1, 2000.00);

INSERT INTO User (name, document, age, login, password, company_id, salary)
VALUES("Usuário 2", "54532454353", 23, "user2", "user2", 2, 2430.10);

INSERT INTO User (name, document, age, login, password, company_id, salary)
VALUES("Usuário 3", "12421342134", 54, "user3", "user3", 5, 5000.00);

INSERT INTO User (name, document, age, login, password, company_id, salary)
VALUES("Usuário 4", "2312342423", 32, "user4", "user4", 4, 4030.80);

INSERT INTO User (name, document, age, login, password, company_id, salary)
VALUES("Usuário 5", "656346431", 33, "user5", "user5", 5, 5340.50);
