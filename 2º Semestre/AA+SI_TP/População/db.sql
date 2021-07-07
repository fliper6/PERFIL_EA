# Roles
SET SQL_SAFE_UPDATES = 0;
insert into mydb.roles values(0,"admin","admin");
insert into mydb.roles values(1,"Professor(a)","Universidade do Minho");
insert into mydb.roles values(2,"Professor(a) Auxiliar","Universidade do Minho");
insert into mydb.roles values(3,"Aluno(a) de Mestrado","Universidade do Minho");
insert into mydb.roles values(4,"Aluno(a) de Licenciatura","Universidade do Minho");
insert into mydb.roles values(5,"Empregado(a)","Bosch");
insert into mydb.roles values(6,"Empregado(a)","Primavera");

# Users
insert into mydb.users values (0,"Admin","admin@uminho.pt", "admin", "admin", '2021-01-10 23:59:59', "Sou admin do sistema", "picture", false, 0);
insert into mydb.users values (1,"Válter Carvalho","1@uminho.pt", "1", "produtor", '2021-02-10 11:20:53', "Sou Aluno de MiEI", "picture", false, 3);
insert into mydb.users values (2,"João Cunha","2@uminho.pt", "2", "produtor", '2021-02-10 19:00:13', "Sou Aluno de MiEI", "picture", false, 3);
insert into mydb.users values (3,"Filipa Santos","3@uminho.pt", "3", "produtor", '2021-01-02 21:30:01', "Sou Aluna de MiEI", "picture", false, 3);
insert into mydb.users values (4,"Hugo Cardoso","4@uminho.pt", "4", "produtor", '2021-02-01 14:59:29', "Sou Aluno de MiEI", "picture", false, 3);
insert into mydb.users values (5,"Carlinhos Adelaide","5@uminho.pt", "5", "produtor", '2021-02-10 12:32:50', "Sou Aluno de Biologia", "picture", true, 4);
insert into mydb.users values (6,"Fernanda Urbano","6@uminho.pt", "6", "produtor", '2021-02-01 13:23:23', "Sou Aluno de Bioquímica", "picture", false, 4);
insert into mydb.users values (7,"Glória Amália","7@uminho.pt", "7", "produtor", '2021-02-13 17:22:50', "Sou Aluno de Sociologia", "picture", false, 4);
insert into mydb.users values (8,"Ademar Marta","8@uminho.pt", "8", "produtor", '2021-02-15 12:24:50', "Sou empregado full-time", "picture", true, 5);
insert into mydb.users values (9,"Adelina Lena","9@uminho.pt", "9", "produtor", '2021-02-21 19:21:24', "Sou empregado part-time", "picture", false, 6);
insert into mydb.users values (10,"Serafina Renato","10@uminho.pt", "10", "produtor", '2021-02-26 17:21:27', "Sou empregado e trabalho em modo remoto", "picture", false, 5);
insert into mydb.users values (11,"Maria Prisma","11@uminho.pt", "11", "produtor", '2021-01-26 11:21:10', "Sou empregado e trabalho em modo remoto", "picture", false, 5);
insert into mydb.users values (12,"Diana Brás","12@uminho.pt", "12", "produtor", '2021-02-14 09:12:32', "Sou empregado e trabalho no escritório", "picture", true, 5);
insert into mydb.users values (13,"Paulina Osvaldo","13@uminho.pt", "13", "produtor", '2021-02-11 07:12:52', "Sou professor há 3 anos", "picture", false, 2);
insert into mydb.users values (14,"Efigénia Cardoso","14@uminho.pt", "14", "produtor", '2021-01-21 18:22:21', "Sou professor apenas este ano", "picture", true, 2);
insert into mydb.users values (15,"Rafael Norberto","15@uminho.pt", "15", "produtor", '2021-01-11 11:21:22', "Sou professor há 30 anos", "picture", true, 1);

# Posts