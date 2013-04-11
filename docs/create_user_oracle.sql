SET ECHO OFF
SET TERMOUT OFF
CLEAR COLUMNS;


COLUMN c_nome_instancia NOPRINT NEW_VALUE c_Nom_Instance

SELECT  instance_name c_nome_instancia
FROM    v$instance;

-- The first dot in the spool command below is 
-- the SQL*Plus concatenation character

DEFINE spool_file = create_user.log
SPOOL &spool_file

REM =======================================================
REM cleanup section
REM =======================================================

DROP USER aluno CASCADE;

REM =======================================================
REM create user
REM three separate commands, so the create user command 
REM will succeed regardless of the existence of the 
REM DEMO and TEMP tablespaces 
REM =======================================================

CREATE USER aluno IDENTIFIED BY aluno;

ALTER USER aluno DEFAULT TABLESPACE users
              QUOTA UNLIMITED ON users;

ALTER USER aluno TEMPORARY TABLESPACE temp;

GRANT CREATE SESSION, CREATE VIEW, ALTER SESSION, CREATE SEQUENCE TO aluno;
GRANT CREATE SYNONYM, CREATE DATABASE LINK, RESOURCE TO aluno;

REM =======================================================
REM grants from sys schema
REM =======================================================

GRANT execute ON sys.dbms_stats TO aluno;

REM =======================================================
REM create aluno schema objects
REM =======================================================

CONNECT aluno/aluno@&c_Nom_Instance
ALTER SESSION SET NLS_LANGUAGE=American;
ALTER SESSION SET NLS_TERRITORY=America;

spool off

SET TERMOUT ON
PROMPT Criacao usuario aluno finalizada...
