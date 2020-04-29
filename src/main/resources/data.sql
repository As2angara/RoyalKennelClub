--S_USER table
insert into S_User (email, firstname, lastname, password)
values ("adrian.angara@gmail.com", "Adrian", "Angara", "passwordZZRUS");

--CONTESTANT table
insert into Contestant (name, owner_id, breed, dog_group, isMale, isSpecial)
values ("Scruffy", 1, "Hound", "Terrier", 1, 0);

--S_SHOW table
insert into S_Show (show_date, location, show_type)
values ('2020-11-06', "1495 Sandalwood Pkwy E, Brampton", "ALLBREED");
