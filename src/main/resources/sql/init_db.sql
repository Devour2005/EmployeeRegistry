DROP TABLE IF EXISTS  public.employee;
DROP TABLE IF EXISTS  public.organization;
DROP TYPE IF EXISTS region CASCADE;

CREATE TYPE region AS ENUM ('EUROPE', 'ASIA', 'AMERICA', 'AFRICA', 'OCEANIA');

CREATE TABLE public.organization
(
   id bigserial NOT NULL PRIMARY KEY,
   org_name character varying(100) COLLATE pg_catalog."default",
   org_phone character varying(100) COLLATE pg_catalog."default",
   org_address character varying(100) COLLATE pg_catalog."default",
   country character varying(50) COLLATE pg_catalog."default",
   city character varying(50) COLLATE pg_catalog."default",
   is_active boolean,
   aria_of_activity character varying(100) COLLATE pg_catalog."default",
   number_of_offices integer,
   region region,
   UNIQUE(org_name, org_address, country, city, aria_of_activity, region)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.organization
    OWNER to postgres;

CREATE TABLE public.employee
(
   id bigserial NOT NULL PRIMARY KEY,
   org_id serial NOT NULL,
   first_name character varying(100) COLLATE pg_catalog."default",
   last_name character varying(100) COLLATE pg_catalog."default",
   emp_position character varying(100) COLLATE pg_catalog."default",
   is_married boolean,
   years_in_company double precision,
   UNIQUE(org_id, first_name, last_name, emp_position),
   FOREIGN KEY (org_id) REFERENCES
   public.organization (id) ON DELETE CASCADE ON UPDATE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee  OWNER to postgres;

