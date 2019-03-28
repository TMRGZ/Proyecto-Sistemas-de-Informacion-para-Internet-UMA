-- Generado por Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   en:        2019-03-26 18:13:14 CET
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g


CREATE TABLE becado
(
    codigo              VARCHAR2(20) NOT NULL,
    estado              VARCHAR2(30),
    beca                VARCHAR2(30),
    agente              VARCHAR2(30),
    foto                BLOB,
    fecha_nacimiento    DATE,
    fecha_acoes         DATE,
    proyecto            VARCHAR2(30),
    fecha_alta_proyecto DATE,
    fecha_salida_actua  DATE,
    fecha_alta          DATE,
    fecha_salida_acoes  DATE,
    grado_curso         VARCHAR2(30),
    colonia_procedencia VARCHAR2(30),
    colonia_actual      VARCHAR2(30),
    observaciones       VARCHAR2(80),
    socios_numero       NUMBER       NOT NULL
);

ALTER TABLE becado
    ADD CONSTRAINT becado_pk PRIMARY KEY (codigo);

CREATE TABLE beneficiario
(
    codigo              VARCHAR2(20) NOT NULL,
    identificador       VARCHAR2(30) NOT NULL,
    nombre              VARCHAR2(40) NOT NULL,
    tipo                VARCHAR2(30) NOT NULL,
    apellidos           VARCHAR2(40),
    observaciones       VARCHAR2(80),
    numero_cuenta       NUMBER,
    beneficiario_codigo VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX beneficiario__idx ON
    beneficiario (
                  beneficiario_codigo
                  ASC);

ALTER TABLE beneficiario
    ADD CONSTRAINT beneficiario_pk PRIMARY KEY (codigo);

CREATE TABLE proyecto
(
    codigo        NUMBER       NOT NULL,
    nombre        VARCHAR2(50) NOT NULL,
    presupuesto   NUMBER,
    combustible   NUMBER,
    mantenimiento NUMBER,
    contenedor    NUMBER,
    descripcion   VARCHAR2(80)
);

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_pk PRIMARY KEY (codigo);

CREATE TABLE relation_3
(
    proyecto_codigo     NUMBER       NOT NULL,
    beneficiario_codigo VARCHAR2(20) NOT NULL
);

ALTER TABLE relation_3
    ADD CONSTRAINT relation_3_pk PRIMARY KEY (proyecto_codigo,
                                              beneficiario_codigo);

CREATE TABLE socios
(
    numero             NUMBER NOT NULL,
    nombre             VARCHAR2(30),
    apellidos          VARCHAR2(30),
    estado             VARCHAR2(30),
    nif                VARCHAR2(30),
    direccion          VARCHAR2(40),
    poblacion          VARCHAR2(40),
    codigo_postal      NUMBER,
    provincia          VARCHAR2(30),
    telefono           NUMBER,
    telefono_movil     NUMBER,
    correo_electronico VARCHAR2(40),
    agente             VARCHAR2(40),
    relacion           VARCHAR2(40),
    certificado        VARCHAR2(40),
    sector             VARCHAR2(40),
    fecha_alta         DATE,
    fecha_baja         DATE,
    observaciones      VARCHAR2(80)
);

ALTER TABLE socios
    ADD CONSTRAINT socios_pk PRIMARY KEY (numero);

CREATE TABLE usuario
(
    id_usuario          NUMBER       NOT NULL,
    nombre_usuario      VARCHAR2(40) NOT NULL,
    contrasena          VARCHAR2(40) NOT NULL,
    beneficiario_codigo VARCHAR2(20) NOT NULL,
    socios_numero       NUMBER       NOT NULL
);

CREATE UNIQUE INDEX usuario__idx ON
    usuario (
             socios_numero
             ASC);

CREATE UNIQUE INDEX usuario__idxv1 ON
    usuario (
             beneficiario_codigo
             ASC);

ALTER TABLE usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id_usuario);

ALTER TABLE becado
    ADD CONSTRAINT becado_beneficiario_fk FOREIGN KEY (codigo)
        REFERENCES beneficiario (codigo);

ALTER TABLE becado
    ADD CONSTRAINT becado_socios_fk FOREIGN KEY (socios_numero)
        REFERENCES socios (numero);

ALTER TABLE beneficiario
    ADD CONSTRAINT beneficiario_beneficiario_fk FOREIGN KEY (beneficiario_codigo)
        REFERENCES beneficiario (codigo);

ALTER TABLE relation_3
    ADD CONSTRAINT relation_3_beneficiario_fk FOREIGN KEY (beneficiario_codigo)
        REFERENCES beneficiario (codigo);

ALTER TABLE relation_3
    ADD CONSTRAINT relation_3_proyecto_fk FOREIGN KEY (proyecto_codigo)
        REFERENCES proyecto (codigo);

ALTER TABLE usuario
    ADD CONSTRAINT usuario_beneficiario_fk FOREIGN KEY (beneficiario_codigo)
        REFERENCES beneficiario (codigo);

ALTER TABLE usuario
    ADD CONSTRAINT usuario_socios_fk FOREIGN KEY (socios_numero)
        REFERENCES socios (numero);



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             3
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
