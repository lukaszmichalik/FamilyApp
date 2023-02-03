# in root folder -> ./family-spring-boot
mvn install

# then in the same directory ->this command will create and start containers
docker compose up

# in order to test api import file -> family_app_collection.json
# into Postman and send imported requests

# family-app uses port 8080
# family-member-app uses port 8081
# postgresql uses port 5432