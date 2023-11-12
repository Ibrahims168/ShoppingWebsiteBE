
CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     first_name VARCHAR(300) NOT NULL DEFAULT '',
     last_name VARCHAR(300) NOT NULL DEFAULT '',
     email VARCHAR(300) NOT NULL DEFAULT '',
     phone_number VARCHAR(20) NOT NULL DEFAULT '',
     address VARCHAR(300) NOT NULL DEFAULT '',
     username varchar(20) NOT NULL DEFAULT '',
     password varchar(20) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

CREATE TABLE item (
    item_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_title VARCHAR(300) NOT NULL DEFAULT '',
    item_img VARCHAR(300) NOT NULL DEFAULT '',
    item_price INT NOT NULL,
    item_stock INT NOT NULL,
    PRIMARY KEY (item_id)
);