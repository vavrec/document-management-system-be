CREATE TABLE dms_user
(
    user_id    UUID PRIMARY KEY,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE ,
    CONSTRAINT email_check CHECK (email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
) );