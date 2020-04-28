create table S_User {
    id bigint PRIMARY KEY Auto_increment,
    email VARCHAR(255),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    password VARCHAR(255)
}

CREATE TABLE Contestant(
    id BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    owner_id bigint,
    breed VARCHAR(255),
    dog_group VARCHAR(255),
    isMale bit,
    isSpecial bit
);

alter table Contestant
    add foreign key (owner_id) references S_User(id);

create table Show {
    id bigint PRIMARY KEY Auto_increment,
    show_date DATE,
    location VARCHAR(255),
    show_type VARCHAR(255)
}

create table Show_Contestant {
    show_id bigint,
    contestant_id bigint
}

alter table Show_Contestant
    add foreign key (show_id) references Show(id);
alter table Show_Contestant
    add foreign key (contestant) references Contestant(id);
