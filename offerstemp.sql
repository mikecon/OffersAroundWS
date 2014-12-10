DROP DATABASE IF EXISTS offersaround;
CREATE DATABASE offersaround;
USE offersaround;

CREATE TABLE offerstemp (
	businessID SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	businessName VARCHAR (25) NOT NULL DEFAULT "-",
	latitude FLOAT NOT NULL DEFAULT "0",
	longitude FLOAT NOT NULL DEFAULT "0",
	offer VARCHAR (50) NOT NULL DEFAULT "-"
			);
			
CREATE TABLE stores (
    store_id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (25) NOT NULL DEFAULT "-",
    latitude VARCHAR (15) NOT NULL DEFAULT "-",
    longitude VARCHAR (15) NOT NULL DEFAULT "-",
	address VARCHAR (25) NOT NULL DEFAULT "-",
	telephone INT (10) NOT NULL DEFAULT "0",
	postal_code INT (5) NOT NULL DEFAULT "0",
	email VARCHAR (25) NOT NULL DEFAULT "-",
	site VARCHAR (25) NOT NULL DEFAULT "-"
            );

CREATE TABLE offers (
	offer_id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	store_id SMALLINT NOT NULL,
    product VARCHAR (25) NOT NULL DEFAULT "-",
    price FLOAT NOT NULL DEFAULT "0",
    begin_date DATE,
    end_date DATE NOT NULL DEFAULT "9999-12-31",
	FOREIGN KEY (store_id) REFERENCES stores(store_id)
            );
			
SET GLOBAL event_scheduler="ON";
DROP EVENT IF EXISTS end_date_delete;
CREATE EVENT end_date_delete
ON SCHEDULE EVERY 1 DAY
DO DELETE FROM offers WHERE end_date<CURRENT_DATE;

DROP TRIGGER IF EXISTS begin_date_insert;
CREATE TRIGGER begin_date_insert
BEFORE INSERT ON offers FOR EACH ROW
SET NEW.begin_date=IFNULL(NEW.begin_date,CURRENT_DATE);

DROP TRIGGER IF EXISTS begin_date_update;
CREATE TRIGGER begin_date_update
BEFORE UPDATE ON offers FOR EACH ROW
SET NEW.begin_date=IFNULL(NEW.begin_date,CURRENT_DATE);
			
INSERT INTO offerstemp
VALUES  ( 1, "Masoutis", "41.07743", "23.55846", "Milk 2Euros"),
        ( 2, "Mikel",  "41.07821", "23.55486", "Coffee 1Euro"),
        ( 3, "Admiral", "41.07776", "23.55022", "Shoes 20Euros"),
        ( 4, "Goodys", "41.07345", "23.55044", "Burger 1.5Euros"),
        ( 5, "Multirama", "41.07349", "23.55829", "USB Stick 16gb 8Euros");
		
INSERT INTO stores 
VALUES  ( 1, "Masoutis", "41.07743", "23.55846", "-", 0, 0, "-", "-"),
        ( 2, "Mikel",  "41.07821", "23.55486", "-", 0, 0, "-", "-"),
        ( 3, "Admiral", "41.07776", "23.55022", "-", 0, 0, "-", "-"),
        ( 4, "Goodys", "41.07345", "23.55044", "-", 0, 0, "-", "-"),
        ( 5, "Multirama", "41.07349", "23.55829", "-", 0, 0, "-", "-");

INSERT INTO offers 
VALUES  ( 1, 1, "Milk", 2, "2014-11-23", "2014-11-30"),
        ( 2, 2, "Coffee",  1, "2014-11-23", "2014-11-28"),
        ( 3, 3, "Shoes", 20, "2014-11-24", "2014-12-01"),
        ( 4, 4, "Burger", 1.5, "2014-11-30", "2014-12-07"),
        ( 5, 5, "USB Stick 16gb", 8, "2014-12-08", "2014-12-13");