CREATE TABLE family_member(
    id SERIAL PRIMARY KEY,
    given_name text,
    family_name text,
    age integer,
    family_id integer,
    FOREIGN KEY (family_id) REFERENCES family(id)
)