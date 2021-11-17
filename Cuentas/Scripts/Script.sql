DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario ("alias" TEXT, "nombre" TEXT, "genero" TEXT, "f_nacimiento" TEXT, "f_registro" TEXT,
	PRIMARY KEY("alias")
);

DROP TABLE IF EXISTS publicacion;
CREATE TABLE publicacion ("id" INTEGER, "creador" TEXT, "contenido" TEXT, "f_publicacion" TEXT, "visitas" INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
);

DROP TABLE IF EXISTS favoritos;
CREATE TABLE favoritos ("u_nombre" TEXT, "p_id" INTEGER);


INSERT INTO usuario (alias, nombre, genero, f_nacimiento, f_registro) VALUES 
    ('alej85', 'Alenjandro McCreary', 'no informado', '1985-07-16 01:19:29', '2019-02-15 05:52:29'),
    ('juan', 'Juan Steers', 'no informado', '1984-06-13 13:03:10', '2020-11-15 12:57:51'),
    ('arkwrightJuan2', 'Juan Pablo Arkwright', 'no informado', '1999-08-27 06:06:08', '2019-12-25 17:25:18'),
    ('matute77', 'Matias Nethercott', 'masculino', '1977-09-24 09:30:36', '2019-02-20 04:08:31'),
    ('ann11', 'Juana Petras', 'femenino', '2009-07-25 20:10:12', '2020-12-11 09:02:03'),
    ('ariel_p', 'Ariel Placidi', 'no informado', '2007-07-07 15:49:46', '2019-04-18 12:13:38'),
    ('assonFJ', 'Fernando Juan Asson', 'masculino', '2008-02-08 21:38:35', '2019-11-22 22:34:17'),
    ('alric', 'Alex Ricarde', 'no informado', '1984-06-13 14:52:15', '2019-03-22 12:59:16'),
    ('cprobate8', 'Cindee Probate', 'masculino', '1991-08-23 19:54:32', '2019-09-05 08:48:18'),
    ('pblampy9', 'Pietrek Blampy', 'femenino', '1991-08-18 16:18:38', '2019-04-28 20:50:10'),
    ('jaz', 'Jazmin Scoffins', 'femenino', '2005-04-14 18:07:40', '2021-02-08 17:27:08'),
    ('luis91', 'Luis Gilbart', 'masculino', '1991-07-22 19:55:25', '2020-04-06 03:47:20'),
    ('mica78', 'Micaela Ropking', 'femenino', '1978-02-26 16:44:58', '2019-05-18 04:54:13'),
    ('luchi', 'Lucia Schulze', 'femenino', '1990-06-15 18:48:00', '2020-03-07 07:34:48'),
    ('rr76', 'Roberto Rottcher', 'no informado', '1976-12-12 18:13:25', '2020-05-01 19:24:24');

INSERT INTO publicacion (id, creador, contenido, f_publicacion, visitas) VALUES 
    (1, 'alej85', 'Muy lejos, más allá de las montañas de palabras, alejados de los países de las vocales y las consonantes', '2020-12-29 17:41:14', 685),
    (2, 'juan', 'viven los textos simulados. Viven aislados en casas de letras', '2021-09-23 02:02:37', 109),
    (3, 'alej85', 'en la costa', '2020-12-13 21:12:46', 315),
    (4, 'arkwrightJuan2', 'un gran océano', '2020-06-30 09:35:34', 388),
    (5, 'juan', 'Un riachuelo llamado Pons fluye por su pueblo y los abastece con las normas necesarias.', '2021-08-21 16:59:23', 999),
    (6, 'alej85', 'Hablamos de un país paraisomático en el que a uno le caen pedazos de frases asadas en la boca.', '2021-07-19 23:33:00', 533),
    (7, 'arkwrightJuan2', 'Ni siquiera los todopoderosos signos de puntuación dominan a los textos simulados', '2021-01-09 03:20:11', 291),
    (8, 'juan', 'una vida', '2019-08-31 23:17:23', 112),
    (9, 'matute77', 'Pero un buen día, una pequeña línea de texto simulado', '2020-10-03 12:29:26', 219),
    (10, 'matute77', 'llamada Lorem Ipsum, decidió aventurarse y salir al vasto mundo de la gramática', '2020-04-07 09:34:16', 40),
    (11, 'matute77', 'El gran Oxmox le desanconsejó hacerlo', '2019-04-22 20:15:59', 659),
    (12, 'jaz', 'ya que esas tierras estaban llenas de comas malvadas', '2021-09-05 18:15:15', 868),
    (13, 'jaz', 'signos de interrogación salvajes y puntos y coma traicioneros', '2021-05-23 06:33:34', 58),
    (14, 'alric', 'pero el texto simulado no se dejó atemorizar', '2019-12-23 16:29:18', 379),
    (15, 'jaz', 'Empacó sus siete versales, enfundó su inicial en el cinturón y se puso en camino', '2021-01-27 20:24:47', 172),
    (16, 'pblampy9', 'Cuando ya había escalado las primeras colinas de las montañas cursivas', '2020-09-24 23:32:28', 591),
    (17, 'luchi', 'se dio media vuelta para dirigir su mirada por última vez', '2020-01-19 22:50:39', 934),
    (18, 'pblampy9', 'hacia su ciudad', '2019-08-01 23:43:10', 57),
    (19, 'luchi', 'el encabezamiento del pueblo Alfabeto y el subtítulo de su propia calle', '2021-02-08 00:12:08', 574),
    (20, 'arkwrightJuan2', 'la calle del renglón. Una pregunta retórica se le pasó por la mente y le puso melancólico', '2021-07-05 08:48:58', 32);

INSERT INTO favoritos (u_nombre, p_id) VALUES ('alej85', 2),
    ('alej85', 5),
    ('alej85', 2),
    ('alej85', 20),
    ('juan', 15),
    ('juan', 12),
    ('arkwrightJuan2', 1),
    ('arkwrightJuan2', 3),
    ('matute77', 4),
    ('matute77', 6),
    ('matute77', 7),
    ('ann11', 2),
    ('alric', 20),
    ('juan', 15),
    ('assonFJ', 12),
    ('arkwrightJuan2', 1),
    ('assonFJ', 3),
    ('mica78', 4),
    ('luchi', 6),
    ('mica78', 7),
    ('luchi', 2);