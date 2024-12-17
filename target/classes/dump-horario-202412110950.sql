
INSERT INTO areatrabajo (descripcion) VALUES
	 ('alfa'),
	 ('beta'),
	 ('gama');

INSERT INTO cabecerapuesto (idunidadmobil,puesto) VALUES
	 (1,6),
	 (2,5),
	 (3,NULL),
	 (4,NULL),
	 (5,NULL),
	 (6,NULL),
	 (NULL,NULL);

	INSERT INTO cargo (nombrecargo) VALUES
     	 ('concutor'),
     	 ('operador'),
     	 ('sin cargo');

    	INSERT INTO categoria (descripcioncategoria,nombrecategoria) VALUES
    	 ('moto','sn'),
    	 ('camioneta','sn'),
    	 ('persona','sn');

    	 INSERT INTO estado (nombreestado,categoria) VALUES
         	 ('disponible',3),
         	 ('franco',3),
         	 ('ocupado',3),
         	 ('uumm ocupada',NULL),
         	 ('uumm disponible',NULL);

         	 INSERT INTO grado (nombregrado) VALUES
             	 ('S3'),
             	 ('S2'),
             	 ('S1'),
             	 ('ST3'),
             	 ('ST2');

             	 INSERT INTO pnp (cargo,grado,idareatrabajo,idcabecerapuesto,idestado,apellido,cip,nombre) VALUES
                 	 (2,2,1,NULL,1,'lala','3025022','lali'),
                 	 (2,2,3,NULL,1,'Gomez','31941086','Carlos'),
                 	 (1,2,2,NULL,1,'Rodriguez','31941087','Ana'),
                 	 (2,2,2,NULL,1,'Lopez','31941088','Marta'),
                 	 (1,3,2,NULL,1,'Martinez','31941089','Pedro'),
                 	 (2,3,3,NULL,1,'Garcia','31941090','Lucia'),
                 	 (2,3,3,NULL,1,'Fernandez','31941092','Miguel'),
                 	 (2,4,2,NULL,1,'Sanchez','31941094','Daniela'),
                 	 (1,4,1,83,3,'Morales','31941095','Roberto'),
                 	 (2,4,1,NULL,1,'Torres','31941096','Elena');

                 INSERT INTO pnp (cargo,grado,idareatrabajo,idcabecerapuesto,idestado,apellido,cip,nombre) VALUES
                 	 (2,5,2,NULL,1,'Ramos','31941098','Ester'),
                 	 (1,5,2,NULL,1,'Castillo','31941099','Francisco'),
                 	 (2,5,1,NULL,1,'Vargas','31941100','Laura'),
                 	 (2,1,1,NULL,1,'matu','gggg','jorge'),
                 	 (1,1,2,NULL,1,'bautisra','vvv','jaime'),
                 	 (1,1,1,83,3,'romeo','vvv11','roma'),
                 	 (2,3,2,NULL,1,'suasveer','s','jorge'),
                 	 (1,4,3,NULL,1,'Guarniz','75812785','Kiara'),
                 	 (2,3,1,NULL,1,'poquemon','123123','picachu'),
                 	 (2,1,1,NULL,1,'marco ','sss','aurelio');

                 INSERT INTO pnp (cargo,grado,idareatrabajo,idcabecerapuesto,idestado,apellido,cip,nombre) VALUES
                 	 (1,1,3,NULL,1,'pirco','lalito','tontin'),
                 	 (1,1,2,NULL,1,'loa','losasl','dende'),
                 	 (1,2,3,NULL,1,'Perez','31941001','piolin'),
                 	 (2,2,2,NULL,1,'asas','00012','ssss'),
                 	 (2,1,2,NULL,1,'Rodriguez','000123','simon'),
                 	 (2,1,2,NULL,1,'caceres','000120','maria'),
                 	 (2,2,2,NULL,1,'lusmila','000121','alajandra'),
                 	 (1,1,1,83,3,'jaime','432345','peña'),
                 	 (2,1,1,NULL,1,'magno','090099','carlos'),
                 	 (2,1,3,NULL,1,'jorje','676776','mujica');


INSERT INTO puesto (descripcionpuesto) VALUES
	 ('Callao centro'),
	 ('C. Bellavista'),
	 ('C Pescador'),
	 ('C.Sarita'),
	 ('Callao centro'),
	 ('Callao barracones'),
	 ('Bellavista'),
	 ('C. ciudad pescador'),
	 ('La legua-c');

INSERT INTO unidadmobil (categoriamobil,descripcion,estadomobil) VALUES
	 (2,'PL 19551',4),
	 (2,'PL 20005',4),
	 (2,'PL 20032',4),
	 (2,'PL 20006',4),
	 (2,'PL19552',4),
	 (2,'PL 19565',4),
	 (2,'PL 1111',5);





