create table S_User (
    id bigint PRIMARY KEY Auto_increment,
    email VARCHAR(255),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    password VARCHAR(255)
);

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

create table S_Show (
    id bigint PRIMARY KEY Auto_increment,
    show_date DATE,
    location VARCHAR(255),
    show_type VARCHAR(255)
);

create table Show_Contestant (
    show_id bigint,
    contestant_id bigint
);

alter table Show_Contestant
    add foreign key (show_id) references S_Show(id);
alter table Show_Contestant
    add foreign key (contestant_id) references Contestant(id);


create table Breeds_Pic (
    id bigint,
    pic_url VARCHAR(255)
);

create table S_Event (
    id bigint PRIMARY KEY Auto_increment,
    name VARCHAR(255)
);

ALTER TABLE S_Show
ADD event_id bigint;

alter table S_Show
    add foreign key (event_id) references S_Event(id);
