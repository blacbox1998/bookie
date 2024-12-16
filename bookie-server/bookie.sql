SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;


CREATE SCHEMA bookie;


ALTER SCHEMA bookie OWNER TO pg_database_owner;


COMMENT ON SCHEMA bookie IS 'standard postgresdb schema';

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE SEQUENCE bookie.reservation_id_seq START 1;

CREATE TABLE bookie.address (
	id numeric(10) NOT NULL UNIQUE,
	email varchar(100) NOT NULL,
	phonenumber varchar(100),
	country varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
	street varchar(100) NOT NULL,
	streetnumber varchar(50) NOT NULL,
	latitude numeric(10,6) NOT NULL,
	longitude numeric(10,6) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bookie.customer (
	id numeric(10) NOT NULL UNIQUE,
	username varchar(50) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	active boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bookie.reservationstatus (
	code varchar(50) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	PRIMARY KEY (code)
);

CREATE TABLE bookie.reservationtype (
	code varchar(50) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	durationinminutes numeric(3) NOT NULL,
	PRIMARY KEY (code)
);

CREATE TABLE bookie.workingunit (
	id numeric(10) NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	address numeric(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bookie.resource (
	id numeric(10) NOT NULL UNIQUE,
	username varchar(50) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	workingunit numeric(10) NOT NULL,
    active boolean NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE bookie.reservation (
	id numeric(10) PRIMARY KEY,
	status varchar(50) NOT NULL,
	type varchar(50) NOT NULL,
	customer numeric(10) NOT NULL,
	resource numeric(10) NOT NULL,
	datetime timestamp NOT NULL,
	statusmodifiedat timestamp with time zone NOT NULL,
	statusmodifiedby varchar(50) NOT NULL,
	workingunit numeric(10) NOT NULL,
    CONSTRAINT reservation_ak1 UNIQUE (resource, datetime)
);

CREATE TABLE bookie.users (
	username varchar(50) NOT NULL UNIQUE,
	passwordhash varchar(100) NOT NULL,
	name varchar(100) NOT NULL,
	type varchar(50) NOT NULL,
	address numeric(10),
	PRIMARY KEY (username)
);

CREATE TABLE bookie.resourcereservationtype (
	id numeric(10) NOT NULL UNIQUE,
	resource numeric(10) NOT NULL,
	reservationtype varchar(50) NOT NULL,
	price numeric(6,2) NOT NULL,
	PRIMARY KEY (id)
);


ALTER TABLE bookie.workingunit ADD CONSTRAINT workingunit_fk2 FOREIGN KEY (address) REFERENCES bookie.address(id);
ALTER TABLE bookie.resource ADD CONSTRAINT resource_fk3 FOREIGN KEY (workingunit) REFERENCES bookie.workingunit(id);
ALTER TABLE bookie.reservation ADD CONSTRAINT reservation_fk1 FOREIGN KEY (status) REFERENCES bookie.reservationstatus(code);
ALTER TABLE bookie.reservation ADD CONSTRAINT reservation_fk2 FOREIGN KEY (type) REFERENCES bookie.reservationtype(code);
ALTER TABLE bookie.reservation ADD CONSTRAINT reservation_fk7 FOREIGN KEY (workingunit) REFERENCES bookie.workingunit(id);
ALTER TABLE bookie.reservation ADD CONSTRAINT reservation_fk8 FOREIGN KEY (resource) REFERENCES bookie.resource(id);
ALTER TABLE bookie.reservation ADD CONSTRAINT reservation_fk9 FOREIGN KEY (customer) REFERENCES bookie.customer(id);
ALTER TABLE bookie.users ADD CONSTRAINT users_fk4 FOREIGN KEY (address) REFERENCES bookie.address(id);