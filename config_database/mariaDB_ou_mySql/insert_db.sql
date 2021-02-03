

USE myDB;

#########################  INSERT INTO   #####################################


INSERT INTO User(id,nom,password) VALUES (1,'titi','pwd');
INSERT INTO User(id,nom,password) VALUES (2,'toto','pwd');
    
INSERT INTO Compte(numero,label,solde) VALUES (1,'compte 1',600);
INSERT INTO Compte(numero,label,solde) VALUES (2,'compte 2',500);
INSERT INTO Compte(numero,label,solde) VALUES (3,'compte 3',200);

    

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM User;
SELECT * FROM Compte;



