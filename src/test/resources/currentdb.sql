CREATE DATABASE `liftbuddytest` /*!40100 DEFAULT CHARACTER SET utf8 */
create table exercise_type
(
  Id int not null
    primary key,
  exercise_name varchar(255) null,
  reps int null,
  sets int null,
  weight int null,
  time time null
)
  engine=InnoDB
;

create table friends
(
  friendUserId int null
)
  engine=InnoDB
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
  roleId int not null
    primary key,
  role_name int null,
  userId int null
)
  engine=InnoDB
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
  gymId int null,
  location int null,
  dob date null,
  height varchar(255) null,
  sex varchar(1) null,
  constraint user_user_name_uindex
  unique (user_name)
)
  engine=InnoDB
;

create index user_gym_id_fk
  on user (gymId)
;

create table weight
(
  weightId int auto_increment
    primary key,
  weight int null,
  userId int not null
)
  engine=InnoDB
;

create table workout
(
  workoutId int auto_increment
    primary key,
  exercise int null
)
  engine=InnoDB
;

create table workout_exercise
(
  workoutId int null,
  exerciseId int null
)
  engine=InnoDB
;



