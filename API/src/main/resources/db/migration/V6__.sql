ALTER TABLE review
    ADD content VARCHAR(255) NULL;

ALTER TABLE review
    ADD rating DOUBLE NULL;

ALTER TABLE review
    DROP COLUMN password;

ALTER TABLE review
    DROP COLUMN username;