CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    creation_date datetime NOT NULL,
    author VARCHAR(100),
    course VARCHAR(100),
    answers VARCHAR(100),
    primary key (id)
);