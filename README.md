## Running the Application

- In the root folder of the application -> `/family-spring-boot`

run:

```bash
$ mvn install
```

- In order to create and run docker containers containing `database`, `family-app` and `family-mmember-app`, run following command in the same directory (`/family-spring-boot`):

```bash
$ docker compose up
```
Note: `maven`, `docker` and `docker compose` must be installed and the `docker daemon` must be running.

## Testing API

- In order to test api import file -> `family_app_collection.json` into Postman.

## Accessing PostgreSQL database

Accesing database allows to check the contents of database after api testing.

- In new command prompt run:

```bash
$ docker exec -it family-spring-boot-database-1 psql -U postgres
```
- Once connected to the PostgreSQL container, use `\c` to connect to `family_database`. Run following command:

```sql
postgres=# \c family_database
```

- Check the contens of family table:

```sql
family_database=# SELECT * FROM family_db.family;
```

- Check the contens of family_member table:

```sql
family_database=# SELECT * FROM family_member_db.family_member;
```

## Stoping and Removing docker containers

- In order to stop and remove running containers, you can run following command in the root directory of application (`\family-spring-boot`):

```bash
$ docker compose down
```
