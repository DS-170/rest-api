CREATE TABLE IF NOT EXISTS USERS
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    creation_date DATE
);

CREATE TABLE IF NOT EXISTS QUOTES
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255) NOT NULL,
    creation_date DATE,
    votes INT NOT NULL,
    author BIGINT,
    FOREIGN KEY (author) REFERENCES USERS(id)
);

CREATE INDEX idx_votes ON QUOTES(votes);