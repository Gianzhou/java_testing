CREATE TABLE users
(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL
);

CREATE TABLE groups
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE group_member
(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  group_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  color BIGINT NOT NULL,
  FOREIGN KEY (group_id) REFERENCES groups (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE point
(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  group_member_id BIGINT NOT NULL,
  group_id BIGINT NOT NULL,
  latitude DOUBLE NOT NULL,
  longitude DOUBLE NOT NULL,
  date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL,
  FOREIGN KEY (group_member_id) REFERENCES group_member (id),
  FOREIGN KEY (group_id) REFERENCES groups (id)
);
