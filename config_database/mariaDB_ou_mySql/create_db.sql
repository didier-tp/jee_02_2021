
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;

DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Compte;

CREATE TABLE User(
    id integer auto_increment,
	nom VARCHAR(64),
	password VARCHAR(64),
	PRIMARY KEY(id));

CREATE TABLE Compte(
    numero integer auto_increment,
	label VARCHAR(64),
	solde double,
	PRIMARY KEY(numero));	