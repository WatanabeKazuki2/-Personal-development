CREATE TABLE f_buy(
id SERIAL,
buy_user_id int NOT NULL,
exibit_user_id int NOT NULL,
total_price int NOT NULL,
delivery_method_id int NOT NULL,
item_status int NOT NULL,
create_date datetime NOT NULL
);

