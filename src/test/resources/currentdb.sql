create database liftbuddytest;
use liftbuddytest;

create table exercise_type
(
  id int not null
    primary key,
  exercise_name varchar(255) null,
  reps int null,
  sets int null,
  weight int null,
  time time null,
  workout_id int null
)
  engine=InnoDB
;

create index exercise_type_workout_workout_id_fk
  on exercise_type (workout_id)
;

create table friends
(
  friend_user_id int null
)
  engine=InnoDB
;

create index friends_user_id_fk
  on friends (friend_user_id)
;

create table gym
(
  id int auto_increment
    primary key,
  gym_name varchar(255) null
)
  engine=InnoDB
;

create table role
(
  role_id int not null
    primary key,
  role_name varchar(255) null,
  user_name varchar(255) null,
  user_id int null
)
  engine=InnoDB
;

create index role_user_id_fk
  on role (user_id)
;

create table user
(
  id int auto_increment
    primary key,
  email varchar(255) null,
  password varchar(255) not null,
  user_name varchar(255) null,
  first_name varchar(255) null,
  last_name varchar(255) null,
  gym_id int null,
  location int null,
  dob date null,
  height varchar(255) null,
  sex varchar(1) null,
  constraint user_user_name_uindex
  unique (user_name),
  constraint user_gym_id_fk
  foreign key (gym_id) references gym (id)
)
  engine=InnoDB
;

create index user_gym_id_fk
  on user (gym_id)
;

alter table friends
  add constraint friends_user_id_fk
foreign key (friend_user_id) references user (id)
;

alter table role
  add constraint role_user_id_fk
foreign key (user_id) references user (id)
;

create table weight
(
  weight_id int auto_increment
    primary key,
  weight int null,
  user_id int null,
  constraint weight_user_id_fk
  foreign key (user_id) references user (id)
)
  engine=InnoDB
;

create index weight_user_id_fk
  on weight (user_id)
;

create table workout
(
  workout_id int auto_increment
    primary key,
  exercise int null,
  user_id int null,
  constraint workout_user_id_fk
  foreign key (user_id) references user (id)
)
  engine=InnoDB
;

create index workout_user_id_fk
  on workout (user_id)
;

alter table exercise_type
  add constraint exercise_type_workout_workout_id_fk
foreign key (workout_id) references workout (workout_id)
;

INSERT INTO gym VALUES (1,'YMCA'),(2,'Anytime Fitness'),(3,'Princeton Club'),(4,'Planet Fitness'),(5,'Other'),(6,'None');
INSERT INTO user VALUES (1,'jc123@gmail.com','supersecret1','jcoyne','Joe','Coyne',1,'53713','1964-04-01','5''2','M'),(2,'nightmareonelm@hotmail.com','supersecret2','fhensen','Fred','Hensen',1,'53706','1988-05-08','5''4','M'),(3,'curryman@yahoo.com','supersecret3','bcurry','Barney','Curry',4,'53704','1947-11-11','6''2','M'),(4,'mackattack@aol.com','supersecret4','kmack','Karen','Mack',3,'53594','1986-07-08','6''0','F'),(5,'calvinklein@gmail.com','supersecret5','dklein','Dianne','Klein',2,'53717','1991-09-22','5''8','F'),(6,'uptildawn@yahoo.com','supersecret6','dtillman','Dawn','Tillman',5,'53714','1979-08-3','6''4','F');
INSERT INTO weight VALUES (1,140,1),(2,130,1),(3,200,6),(4,130,2),(5,125,3),(6,135,4),(7,145,5),(8,155,1),(9,170,1);
INSERT INTO role VALUES (1, 'admin', 'jcoyne', 1);
