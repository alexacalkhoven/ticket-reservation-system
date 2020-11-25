# ticket-reservation-system

ENSF 480 Final Proj

Compile:
javac *.java

Run:
java filename1 filename2 ...

Connecting to the Database:
- In MySQL Shell type the following commands:
1. \c root@localhost:3306 (may have to adjust based on your server settings which you can view on MySQL Workbench)
2. \sql
3. create database ensf480;
- Then, construct a DBController object; this will create the tables in the ensf480 database based on the schema in resources/init.sql
