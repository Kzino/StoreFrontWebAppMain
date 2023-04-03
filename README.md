# StoreFrontWebApp
 
# How to create a user on mysql work bench and give permission
Install MySQL workbench 

CREATE USER 'kwame'@'*' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON * . * TO 'kwame'@'localhost';
FLUSH PRIVILEGES;

Then run the mysql workbench by pressing the lightning button/run query button

Then test connection on mysqlwork bench
with username:kwame
and password:root

# How to start the project
cd into frontend
then type npm install
then type npm start

cd into backend
then type mvn spring-boot:run

Make sure you have docker installed and set up and running
then type docker compose up