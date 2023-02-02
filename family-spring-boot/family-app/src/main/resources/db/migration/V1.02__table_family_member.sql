CREATE SCHEMA family_member_db;
CREATE TABLE family_member_db.family_member(
    id integer PRIMARY KEY,
    given_name text,
    family_name text,
    age integer,
    family_id integer,
    FOREIGN KEY (family_id) REFERENCES family_db.family(id)
);

CREATE SEQUENCE family_member_db.family_member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1;