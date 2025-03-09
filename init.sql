

SHOW config_file;
SELECT set_config('log_statement', 'all', true);
SELECT pg_current_logfile();

SELECT * FROM pg_extension;

select extname from pg_extension;

create table accounts (
 user_id serial PRIMARY KEY,
 user_name VARCHAR(50),
 created_on TIMESTAMP
);

insert into accounts(user_name, created_on) values ('John',CURRENT_TIMESTAMP);
insert into accounts(user_name, created_on) values ('Dee',CURRENT_TIMESTAMP);

CREATE SCHEMA IF NOT EXISTS liquibase_db 

