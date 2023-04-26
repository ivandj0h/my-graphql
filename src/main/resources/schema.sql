CREATE TABLE IF NOT EXISTS Country (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    emoji VARCHAR(255),
    currency VARCHAR(255),
    code VARCHAR(255),
    capital VARCHAR(255),
    PRIMARY KEY (id)
);