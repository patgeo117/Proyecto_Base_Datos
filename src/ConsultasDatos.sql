--Para la tabla "TEMA":

INSERT INTO TEMA (tem_cod, tem_nombre)
VALUES (101, 'Tecnología');

INSERT INTO TEMA (tem_cod, tem_nombre)
VALUES (102, 'Salud');

INSERT INTO TEMA (tem_cod, tem_nombre)
VALUES (103, 'Educación');

INSERT INTO TEMA (tem_cod, tem_nombre)
VALUES (104, 'Medio Ambiente');

INSERT INTO TEMA (tem_cod, tem_nombre)
VALUES (105, 'Arte y Cultura');

--Para la tabla "EMPLEADOS":

INSERT INTO EMPLEADOS (emp_id, emp_nombre, emp_salario)
VALUES (1001, 'Juan', 2500);

INSERT INTO EMPLEADOS (emp_id, emp_nombre, emp_salario)
VALUES (1002, 'María', 3000);

INSERT INTO EMPLEADOS (emp_id, emp_nombre, emp_salario)
VALUES (1003, 'Carlos', 2800);

INSERT INTO EMPLEADOS (emp_id, emp_nombre, emp_salario)
VALUES (1004, 'Pedro', 2700);

INSERT INTO EMPLEADOS (emp_id, emp_nombre, emp_salario)
VALUES (1005, 'Laura', 3200);

--Para la tabla "PROYECTOS":

INSERT INTO PROYECTOS (pro_cod, pro_titulo, pro_descripcion, pro_alcance, pro_presupuesto, fk_tem_cod)
VALUES (01, 'Proyecto A', 'Descripción A', 'Alcance A', 10000, 101);

INSERT INTO PROYECTOS (pro_cod, pro_titulo, pro_descripcion, pro_alcance, pro_presupuesto, fk_tem_cod)
VALUES (02, 'Proyecto B', 'Descripción B', 'Alcance B', 15000, 102);

INSERT INTO PROYECTOS (pro_cod, pro_titulo, pro_descripcion, pro_alcance, pro_presupuesto, fk_tem_cod)
VALUES (03, 'Proyecto C', 'Descripción C', 'Alcance C', 12000, 105);

INSERT INTO PROYECTOS (pro_cod, pro_titulo, pro_descripcion, pro_alcance, pro_presupuesto, fk_tem_cod)
VALUES (04, 'Proyecto D', 'Descripción D', 'Alcance D', 8000, 103);

INSERT INTO PROYECTOS (pro_cod, pro_titulo, pro_descripcion, pro_alcance, pro_presupuesto, fk_tem_cod)
VALUES (05, 'Proyecto E', 'Descripción E', 'Alcance E', 12000, 104);

--Para la tabla "ADMINISTRATIVOS":

INSERT INTO ADMINISTRATIVOS (adm_id, adm_area, fk_pro_cod, fk_emp_id)
VALUES (2001, 'Administración', 01, 1001);

INSERT INTO ADMINISTRATIVOS (adm_id, adm_area, fk_pro_cod, fk_emp_id)
VALUES (2002, 'Finanzas', 02, 1002);

INSERT INTO ADMINISTRATIVOS (adm_id, adm_area, fk_pro_cod, fk_emp_id)
VALUES (2003, 'Recursos Humanos', 03, 1003);

INSERT INTO ADMINISTRATIVOS (adm_id, adm_area, fk_pro_cod, fk_emp_id)
VALUES (2004, 'Logística', 05, 1004);

INSERT INTO ADMINISTRATIVOS (adm_id, adm_area, fk_pro_cod, fk_emp_id)
VALUES (2005, 'Comunicaciones', 04, 1005);

--Para la tabla "REPRESENTANTE":

INSERT INTO REPRESENTANTE (repr_id, repr_nombre, repr_fechaNa, repr_edad)
VALUES (201, 'Ana', '1990-01-01', 33);

INSERT INTO REPRESENTANTE (repr_id, repr_nombre, repr_fechaNa, repr_edad)
VALUES (202, 'Luis', '1985-05-10', 38);

INSERT INTO REPRESENTANTE (repr_id, repr_nombre, repr_fechaNa, repr_edad)
VALUES (203, 'Julia', '1995-12-15', 28);

INSERT INTO REPRESENTANTE (repr_id, repr_nombre, repr_fechaNa, repr_edad)
VALUES (204, 'Mario', '1982-09-15', 41);

INSERT INTO REPRESENTANTE (repr_id, repr_nombre, repr_fechaNa, repr_edad)
VALUES (205, 'Sofía', '1998-03-20', 25);

--Para la tabla "COMUNIDADES":

INSERT INTO COMUNIDADES (com_cod, com_nombre, com_etnia, com_cantidad, fk_repr_id, fk_pro_cod)
VALUES (21, 'Comunidad A', 'Etnia A', 100, 201, 01);

INSERT INTO COMUNIDADES (com_cod, com_nombre, com_etnia, com_cantidad, fk_repr_id, fk_pro_cod)
VALUES (22, 'Comunidad B', 'Etnia B', 150, 202, 02);

INSERT INTO COMUNIDADES (com_cod, com_nombre, com_etnia, com_cantidad, fk_repr_id, fk_pro_cod)
VALUES (23, 'Comunidad C', 'Etnia C', 200, 203, 03);

INSERT INTO COMUNIDADES (com_cod, com_nombre, com_etnia, com_cantidad, fk_repr_id, fk_pro_cod)
VALUES (24, 'Comunidad D', 'Etnia D', 80, 204, 04);

INSERT INTO COMUNIDADES (com_cod, com_nombre, com_etnia, com_cantidad, fk_repr_id, fk_pro_cod)
VALUES (25, 'Comunidad E', 'Etnia E', 120, 205, 05);

--Para la tabla "NIÑOS":

INSERT INTO NIÑOS (niños_id, niños_nombre, niños_edad, niños_fechaNac, fk_com_cod)
VALUES (1, 'Niño A', 8, '2015-06-20', 21);

INSERT INTO NIÑOS (niños_id, niños_nombre, niños_edad, niños_fechaNac, fk_com_cod)
VALUES (2, 'Niño B', 6, '2017-02-15', 22);

INSERT INTO NIÑOS (niños_id, niños_nombre, niños_edad, niños_fechaNac, fk_com_cod)
VALUES (3, 'Niño C', 9, '2014-11-05', 23);

INSERT INTO NIÑOS (niños_id, niños_nombre, niños_edad, niños_fechaNac, fk_com_cod)
VALUES (4, 'Niño D', 7, '2016-08-10', 24);

INSERT INTO NIÑOS (niños_id, niños_nombre, niños_edad, niños_fechaNac, fk_com_cod)
VALUES (5, 'Niño E', 5, '2018-01-05', 25);

--Para la tabla "DCONTACTO_REPRESENTANTE":

INSERT INTO DCONTACTO_REPRESENTANTE (dcont_id, dcont_correo, dcont_direccion, dcont_Ntelefono, fk_repr_id)
VALUES (301, 'ana@example.com', 'Calle A, Ciudad A', '123456789', 201);

INSERT INTO DCONTACTO_REPRESENTANTE (dcont_id, dcont_correo, dcont_direccion, dcont_Ntelefono, fk_repr_id)
VALUES (302, 'luis@example.com', 'Calle B, Ciudad B', '987654321', 202);

INSERT INTO DCONTACTO_REPRESENTANTE (dcont_id, dcont_correo, dcont_direccion, dcont_Ntelefono, fk_repr_id)
VALUES (303, 'julia@example.com', 'Calle C, Ciudad C', '567890123', 203);

INSERT INTO DCONTACTO_REPRESENTANTE (dcont_id, dcont_correo, dcont_direccion, dcont_Ntelefono, fk_repr_id)
VALUES (304, 'mario@example.com', 'Calle D, Ciudad D', '987654321', 204);

INSERT INTO DCONTACTO_REPRESENTANTE (dcont_id, dcont_correo, dcont_direccion, dcont_Ntelefono, fk_repr_id)
VALUES (305, 'sofia@example.com', 'Calle E, Ciudad E', '123456789', 205);

--Para la tabla "EVALUACION":

INSERT INTO EVALUACION (eva_cod, eva_porcentaje, eva_fecha)
VALUES (001, 80, '2023-05-01');

INSERT INTO EVALUACION (eva_cod, eva_porcentaje, eva_fecha)
VALUES (002, 75, '2023-05-02');

INSERT INTO EVALUACION (eva_cod, eva_porcentaje, eva_fecha)
VALUES (003, 90, '2023-05-03');

INSERT INTO EVALUACION (eva_cod, eva_porcentaje, eva_fecha)
VALUES (004, 85, '2023-05-04');

INSERT INTO EVALUACION (eva_cod, eva_porcentaje, eva_fecha)
VALUES (005, 70, '2023-05-05');

--Para la tabla "OBJETIVO":

INSERT INTO OBJETIVO (obj_cod, obj_fechaFinal, obj_fechaInicio, obj_descripcion, fk_pro_cod, fk_eva_cod)
VALUES (0001, '2023-06-30', '2023-06-01', 'Descripción A', 01, 001);

INSERT INTO OBJETIVO (obj_cod, obj_fechaFinal, obj_fechaInicio, obj_descripcion, fk_pro_cod, fk_eva_cod)
VALUES (0002, '2023-07-31', '2023-07-01', 'Descripción B', 02, 002);

INSERT INTO OBJETIVO (obj_cod, obj_fechaFinal, obj_fechaInicio, obj_descripcion, fk_pro_cod, fk_eva_cod)
VALUES (0003, '2023-08-31', '2023-08-01', 'Descripción C', 03, 003);

INSERT INTO OBJETIVO (obj_cod, obj_fechaFinal, obj_fechaInicio, obj_descripcion, fk_pro_cod, fk_eva_cod)
VALUES (0004, '2023-09-30', '2023-09-01', 'Descripción D', 04, 004);

INSERT INTO OBJETIVO (obj_cod, obj_fechaFinal, obj_fechaInicio, obj_descripcion, fk_pro_cod, fk_eva_cod)
VALUES (0005, '2023-10-31', '2023-10-01', 'Descripción E', 05, 005);

--Para la tabla "PROFECIONALES":

INSERT INTO PROFECIONALES (prof_id, prof_especializacion, fk_pro_cod, fk_emp_id)
VALUES (3001, 'Especialización A', 01, 1001);

INSERT INTO PROFECIONALES (prof_id, prof_especializacion, fk_pro_cod, fk_emp_id)
VALUES (3002, 'Especialización B', 02, 1002);

INSERT INTO PROFECIONALES (prof_id, prof_especializacion, fk_pro_cod, fk_emp_id)
VALUES (3003, 'Especialización C', 03, 1003);

INSERT INTO PROFECIONALES (prof_id, prof_especializacion, fk_pro_cod, fk_emp_id)
VALUES (3004, 'Especialización D', 04, 1004);

INSERT INTO PROFECIONALES (prof_id, prof_especializacion, fk_pro_cod, fk_emp_id)
VALUES (3005, 'Especialización E', 05, 1005);

--Para la tabla "PARTICIPACION":

INSERT INTO PARTICIPACION (par_cod, par_tarea, par_tiempo, fk_pro_cod, fk_prof_id)
VALUES (4001, 'Tarea A', 10, 01, 3001);

INSERT INTO PARTICIPACION (par_cod, par_tarea, par_tiempo, fk_pro_cod, fk_prof_id)
VALUES (4002, 'Tarea B', 8, 02, 3002);

INSERT INTO PARTICIPACION (par_cod, par_tarea, par_tiempo, fk_pro_cod, fk_prof_id)
VALUES (4003, 'Tarea C', 12, 03, 3003);

INSERT INTO PARTICIPACION (par_cod, par_tarea, par_tiempo, fk_pro_cod, fk_prof_id)
VALUES (4004, 'Tarea D', 9, 04, 3004);

INSERT INTO PARTICIPACION (par_cod, par_tarea, par_tiempo, fk_pro_cod, fk_prof_id)
VALUES (4005, 'Tarea E', 6, 05, 3005);