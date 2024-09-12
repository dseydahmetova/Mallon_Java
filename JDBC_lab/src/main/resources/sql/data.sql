DROP TABLE accounts IF EXISTS;

CREATE TABLE accounts (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    balance DECIMAL(10, 2)
);

INSERT INTO accounts(name, balance) VALUES ('Claire', 240.54);
INSERT INTO accounts(name, balance) VALUES ('Poppy', 4450.99);