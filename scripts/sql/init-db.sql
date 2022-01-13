CREATE DATABASE bankoss;
CREATE USER 'bankoss'@'localhost' IDENTIFIED BY 'bankoss';
GRANT ALL PRIVILEGES ON bankoss.* TO 'bankoss'@'localhost';
