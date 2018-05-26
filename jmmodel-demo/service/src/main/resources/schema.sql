-- pet store
CREATE TABLE category(
    id INT AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    description VARCHAR(255) NOT NULL,
    imageurl VARCHAR(55),
    PRIMARY KEY (id)
);

CREATE TABLE product (
 id INT AUTO_INCREMENT,
 category_id INT NOT NULL,
 name VARCHAR(25) NOT NULL,
 description VARCHAR(255) NOT NULL,
 imageurl VARCHAR(55),
 PRIMARY KEY (id),
 FOREIGN KEY (category_id) REFERENCES category(id)
);