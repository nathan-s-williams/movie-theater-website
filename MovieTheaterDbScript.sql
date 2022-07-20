/*
DROP TABLE Movie;
DROP TABLE Theater;
DROP TABLE Showtimes;

Check tables:
SELECT *
FROM Showtimes s
INNER JOIN Movie m ON s.movieId = m.movieId
INNER JOIN Theater t ON s.theaterId = t.theaterId
*/

CREATE TABLE Movie (
    movieId             CHAR(8)             PRIMARY KEY,
    title               VARCHAR(100),
    description         VARCHAR(500)
);

CREATE TABLE Theater (
    theaterId           CHAR(8)             PRIMARY KEY,
    theaterName         VARCHAR(100),    
    zipcode             INT
);

CREATE TABLE Showtimes (
    theaterId           CHAR(8),
    movieId             CHAR(8),
    price               INT,
    showtime            TIMESTAMP,
    CONSTRAINT pk_showtimes PRIMARY KEY(theaterId, movieId),
    FOREIGN KEY(theaterId)  REFERENCES Theater,
    FOREIGN KEY(movieId)    REFERENCES Movie    
);

CREATE TABLE Payment (
    theaterId           CHAR(8),
    movieId             CHAR(8),
    firstName           VARCHAR(100),
    lastName            VARCHAR(100),
    seatNumber          CHAR(3),
    ticketsPurchased    INT,
    creditcard          INT,
    CONSTRAINT pk_payment PRIMARY KEY(theaterId, movieId, firstName, lastName, creditcard),
    FOREIGN KEY(theaterId, movieId)  REFERENCES Showtimes
);

-- Movie data mined from themoviedb.org
INSERT INTO Movie VALUES('1','Thor: Love and Thunder','After his retirement is interrupted by Gorr the God Butcher, a galactic killer who seeks the extinction of the gods, Thor enlists the help of King Valkyrie, Korg, and ex-girlfriend Jane Foster, who now inexplicably wields Mjolnir as the Mighty Thor. Together they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.');
INSERT INTO Movie VALUES('2','Lightyear','Legendary Space Ranger Buzz Lightyear embarks on an intergalactic adventure alongside a group of ambitious recruits and his robot companion Sox.');
INSERT INTO Movie VALUES('3','Jurassic World Dominion','Four years after Isla Nublar was destroyed, dinosaurs now live—and hunt—alongside humans all over the world. This fragile balance will reshape the future and determine, once and for all, whether human beings are to remain the apex predators on a planet they now share with history’s most fearsome creatures.');

INSERT INTO Theater VALUES('1','AMC DINE-IN Grapevine Mills 30',76051);
INSERT INTO Theater VALUES('2','AMC DINE-IN Stonebriar 24',75034);
INSERT INTO Theater VALUES('3','Alamo Drafthouse Cinema Richardson',75080);

INSERT INTO Showtimes VALUES('1','1',10,'2022-07-18 18:30:00');
INSERT INTO Showtimes VALUES('1','2',10,'2022-07-18 20:00:00');
INSERT INTO Showtimes VALUES('1','3',10,'2022-07-18 22:30:00');
INSERT INTO Showtimes VALUES('2','1',10,'2022-07-18 15:30:00');
INSERT INTO Showtimes VALUES('2','2',10,'2022-07-18 19:45:00');
INSERT INTO Showtimes VALUES('2','3',10,'2022-07-18 22:00:00');
INSERT INTO Showtimes VALUES('3','1',10,'2022-07-18 20:30:00');
INSERT INTO Showtimes VALUES('3','3',10,'2022-07-18 22:45:00');

