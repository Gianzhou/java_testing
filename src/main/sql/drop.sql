START TRANSACTION;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS point;
DROP TABLE IF EXISTS group_member;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS users;

SET foreign_key_checks = 1;
COMMIT;