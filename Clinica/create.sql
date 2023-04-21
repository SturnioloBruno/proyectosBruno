DROP TABLE IF EXISTS domicilios;
CREATE TABLE domicilios (ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE varchar(200) NOT NULL,
NUMERO INT NOT NULL,
LOCALIDAD varchar(100) NOT NULL,
PROVINCIA varchar(100) NOT NULL);

DROP TABLE IF EXISTS pacientes;
CREATE TABLE pacientes (ID INT AUTO_INCREMENT PRIMARY KEY,
APELLIDO varchar(100) NOT NULL,
NOMBRE varchar(100) NOT NULL,
EMAIL varchar(100) NOT NULL,
DNI INT NOT NULL,
FECHA_INGRESO DATE NOT NULL,
DOMICILIO_ID INT NOT NULL);

INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle A',474,'Cafayate','Salta');
INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES ('Calle B',7841,'Oran','Salta');

INSERT INTO pacientes (apellido, nombre, email,dni, fecha_ingreso, domicilio_id) VALUES ('Baspinero','Rodolfo','zxc@gmail.com',14576,'2022-03-01',1);
INSERT INTO pacientes (apellido, nombre, email,dni, fecha_ingreso, domicilio_id) VALUES ('Baspinero','Ezequiel','qwe@gmail.com',123456,'2022-03-10',2);

