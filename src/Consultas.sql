CREATE TABLE IF NOT EXISTS tema(
	tem_nombre varchar,
	tem_cod int NOT NULL,
	PRIMARY KEY (tem_cod)
);

CREATE TABLE IF NOT EXISTS empleados(
	emp_nombre varchar,
	emp_salario int,
	emp_id int NOT NULL,
	PRIMARY KEY (emp_id)
);

CREATE TABLE IF NOT EXISTS proyectos(
	pro_titulo varchar,
	pro_descripcion varchar,
	pro_alcance varchar,
	pro_presupuesto int,
	fk_tem_cod int,
	pro_cod int NOT NULL,
	PRIMARY KEY (pro_cod),
	FOREIGN KEY (fk_tem_cod) REFERENCES tema(tem_cod)
);

CREATE TABLE IF NOT EXISTS administrativos(
	adm_id int NOT NULL,
	adm_area varchar,
	fk_pro_cod int,
	fk_emp_id int,
	PRIMARY KEY (adm_id),
	FOREIGN KEY (fk_pro_cod) REFERENCES proyectos(pro_cod),
	FOREIGN KEY (fk_emp_id) REFERENCES empleados(emp_id)
);

CREATE TABLE IF NOT EXISTS representante(
	repr_nombre varchar,
	repr_fechaNa date,
	repr_edad varchar,
	repr_id int NOT NULL,
	PRIMARY KEY (repr_id)
);

CREATE TABLE IF NOT EXISTS comunidades(
	com_cod int NOT NULL,
	com_nombre varchar,
	com_etnia varchar,
	com_cantidad int,
	fk_repr_id int,
	fk_pro_cod int,
	PRIMARY KEY (com_cod),
	FOREIGN KEY (fk_repr_id) REFERENCES representante(repr_id),
	FOREIGN KEY (fk_pro_cod) REFERENCES proyectos(pro_cod)
);

CREATE TABLE IF NOT EXISTS niños(
	niños_nombre varchar,
	niños_edad int,
	niños_fechaNac date,
	niños_id int NOT NULL,
	fk_com_cod int,
	PRIMARY KEY (niños_id),
	FOREIGN KEY (fk_com_cod) REFERENCES comunidades(com_cod)
);

CREATE TABLE IF NOT EXISTS Dcontacto_representante(
	dcont_correo varchar,
	dcont_dirreccion varchar,
	dcont_Ntelefono varchar,
	fk_repr_id int,
	dcont_id int NOT NULL,
	PRIMARY KEY (dcont_id),
	FOREIGN KEY (fk_repr_id) REFERENCES representante(repr_id)
);

CREATE TABLE IF NOT EXISTS evaluacion(
	eva_porcentaje int,
	eva_fecha date,
	eva_cod int NOT NULL,
	PRIMARY KEY (eva_cod)
);

CREATE TABLE IF NOT EXISTS objetivo(
	obj_fechaFinal date,
	obj_sechaInicio date ,
	obj_descripcion varchar,
	obj_cod int NOT NULL,
	fk_pro_cod int,
	fk_eva_cod int,
	PRIMARY KEY (obj_cod),
	FOREIGN KEY (fk_pro_cod) REFERENCES proyectos(pro_cod),
	FOREIGN KEY (fk_eva_cod) REFERENCES evaluacion(eva_cod)
);

CREATE TABLE IF NOT EXISTS profecionales(
	prof_especializacion varchar,
	prof_id int NOT NULL,
	fk_pro_cod int,
    fk_emp_id int,
	PRIMARY KEY (prof_id),
	FOREIGN KEY (fk_pro_cod) REFERENCES proyectos(pro_cod),
    FOREIGN KEY (fk_emp_id) REFERENCES empleados(emp_id)
);

CREATE TABLE IF NOT EXISTS participacion(
	par_tarea varchar,
	par_tiempo int,
	fk_pro_cod int,
	fk_prof_id int,
	par_cod int NOT NULL,
	PRIMARY KEY (par_cod),
	FOREIGN KEY (fk_pro_cod) REFERENCES proyectos(pro_cod),
	FOREIGN KEY (fk_prof_id) REFERENCES profecionales(prof_id)
);




