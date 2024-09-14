CREATE DATABASE social_service;
USE social_service;

CREATE TABLE Post
(
	Id BIGINT AUTO_INCREMENT,
    AuthorId BIGINT NOT NULL,
    CreateTime DATE NOT NULL,
    Content VARCHAR(2000),
    MediaLink VARCHAR(200),
    PRIMARY KEY (ID)
);

CREATE TABLE Likes
(
	Id BIGINT AUTO_INCREMENT,
    UserId BIGINT NOT NULL,
    PostId BIGINT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (PostId) REFERENCES Post(Id) ON DELETE CASCADE
);

CREATE TABLE Comments
(
	Id BIGINT AUTO_INCREMENT,
    UserId BIGINT NOT NULL,
    PostId BIGINT NOT NULL,
    Content VARCHAR(1000),
    PRIMARY KEY (ID),
    FOREIGN KEY (PostId) REFERENCES Post(Id) ON DELETE CASCADE
)