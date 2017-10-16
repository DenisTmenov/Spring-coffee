CREATE TABLE user_detail (
  id INT AUTO_INCREMENT, 
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  role VARCHAR(50),
  enabled BOOLEAN,
  password VARCHAR(50),
  email VARCHAR(100),
  contact_number VARCHAR(15),
    
  CONSTRAINT pk_user_id PRIMARY KEY (id)
) ;