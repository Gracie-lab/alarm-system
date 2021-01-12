drop user if exists 'alarmdb'@'localhost';
create user'alarmsystem'@'localhost' identified by 'alarm123';
grant all privileges on alarmdb.* to 'alarmsystem'@'localhost';
flush privileges;

drop database if exists alarmdb;
create database alarmdb;