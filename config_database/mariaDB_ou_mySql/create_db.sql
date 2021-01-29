
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;

DROP TABLE IF EXISTS User;

CREATE TABLE User(
    id integer auto_increment,
	nom VARCHAR(64),
	password VARCHAR(64),
	PRIMARY KEY(id));	 