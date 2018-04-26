DELETE from role;
DELETE FROM weight;
DELETE FROM user;
INSERT INTO user VALUES (1,'jc123@gmail.com','supersecret1','jcoyne','Joe','Coyne',1,'53713','1964-04-01','5''2','M'),(2,'nightmareonelm@hotmail.com','supersecret2','fhensen','Fred','Hensen',1,'53706','1988-05-08','5''4','M'),(3,'curryman@yahoo.com','supersecret3','bcurry','Barney','Curry',4,'53704','1947-11-11','6''2','M'),(4,'mackattack@aol.com','supersecret4','kmack','Karen','Mack',3,'53594','1986-07-08','6''0','F'),(5,'calvinklein@gmail.com','supersecret5','dklein','Dianne','Klein',2,'53717','1991-09-22','5''8','F'),(6,'uptildawn@yahoo.com','supersecret6','dtillman','Dawn','Tillman',5,'53714','1979-08-3','6''4','F');
INSERT INTO role VALUES (1,'admin','jcoyne',1),(2,'buddy','fhensen',2),(3,'buddy','bcurry',3),(4,'buddy','kmack',4),(5,'buddy','dklein',5),(6,'buddy','dtillman',6);
