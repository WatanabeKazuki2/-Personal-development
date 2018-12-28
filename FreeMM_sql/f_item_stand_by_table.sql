CREATE TABLE f_item_stand_by(
id SERIAL,
buy_user_id int NOT NULL,
exibit_user_id int NOT NULL,
total_price int NOT NULL,
delivery_method_id int NOT NULL,
item_status int NOT NULL
);
