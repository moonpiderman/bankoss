CREATE DATABASE housekeepingbook;
CREATE USER 'housekeepingbook'@'localhost' IDENTIFIED BY 'housekeepingbook';
GRANT ALL PRIVILEGES ON housekeepingbook.* TO 'housekeepingbook'@'localhost';