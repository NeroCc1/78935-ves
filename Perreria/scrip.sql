Create database mascotas;
Use mascotas;

Show tables;

create user 'yo'@'localhost' identified by '123';

create user 'yo'@'127.0.0.1' identified by '123';

grant all privileges  on saludos.* to  'yo'@'localhost';

grant all privileges  on saludos.* to  'yo'@'127.0.0.1';

Flush privileges;
