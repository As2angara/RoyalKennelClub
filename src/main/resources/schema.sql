CREATE TABLE Contestant(
    id BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    ownerName VARCHAR(255),
    breed VARCHAR(255),
    dog_group VARCHAR(255),
    isMale bit,
    isSpecial bit
);
