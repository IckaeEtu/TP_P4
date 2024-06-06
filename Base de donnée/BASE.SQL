drop table if exists JOUEUR;
drop table if exists SKIN;
CREATE TABLE JOUEUR(
    idjoueur varchar(50),
    mdpjoueur varchar(50),
    nomjoueur varchar(50),
    nbrwin int(10),
    winstreak int(10),
    nbrpartie int(10),
    skin varchar(50),
    primary key ('idjoueur')
);
CREATE TABLE SKIN(
    idjoueur varchar(50),
    nomskin varchar(50),
    FOREIGN KEY (idjoueur) REFERENCES JOUEUR(idjoueur)
);
