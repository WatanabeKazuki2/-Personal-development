CREATE TABLE user_info(
user_id int PRIMARY KEY AUTO_INCREMENT,
login_id varchar(40) UNIQUE NOT NULL,
user_name varchar(40) NOT NULL,
password varchar(40) NOT NULL,
birth_date date NOT NULL,
mail_address varchar(255) NOT NULL,
street_address varchar(255) NOT NULL,
create_date datetime NOT NULL,
update_date datetime NOT NULL
);
