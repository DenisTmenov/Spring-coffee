CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT, 
  code VARCHAR(200),
  name VARCHAR(50),
  brand VARCHAR(50),
  description VARCHAR(255),
  unit_price DECIMAL(10,2),
  quantity INT,
  is_active BOOLEAN,
  category_id INT,
  supplier_id INT,
  purchases INT DEFAULT 0,
  views INT DEFAULT 0,
  
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);	