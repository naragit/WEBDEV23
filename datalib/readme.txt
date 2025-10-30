
setjdk21

mvn spring-boot:run --debug


--DB
 docker exec -it a5fded46c818 /bin/sh

 psql -d empuserdb -U empuser

 \d  -- Lists tables
 \d+ -- extended view

 comment on table users is 'Main User Table';
 comment on column users.city is 'emp location';
