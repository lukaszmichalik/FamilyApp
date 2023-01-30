CREATE TABLE family_db.family(
    id integer PRIMARY KEY,
    family_name text,
    nr_of_infants integer,
    nr_of_children integer,
    nr_of_adults integer
);

CREATE SEQUENCE family_db.family_id_seq
AS integer
START WITH 1
INCREMENT BY 1;