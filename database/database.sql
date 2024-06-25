CREATE TABLE IF NOT EXISTS tb_user (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(256) NOT NULL,
    documento VARCHAR(14) NOT NULL UNIQUE,
    sexo VARCHAR(254),
    data_nasc DATE,
    email VARCHAR(256),
    senha VARCHAR(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_admin (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(256) NOT NULL,
    documento VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(256),
    senha VARCHAR(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_login (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(256) NOT NULL,
    documento VARCHAR(14) NOT NULL UNIQUE,
    senha VARCHAR(256) NOT NULL,
    role SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    id_user INTEGER,
    id_admin INTEGER,
    FOREIGN KEY (id_user) REFERENCES tb_user(id),
    FOREIGN KEY (id_admin) REFERENCES tb_admin(id)
);

CREATE TABLE IF NOT EXISTS tb_subject_inmost_visit (
    id SERIAL PRIMARY KEY,
    cumplice BOOLEAN NOT NULL,
    vitima BOOLEAN NOT NULL,
    gravida BOOLEAN NOT NULL,
    tempo_gravidez SMALLINT,
    id_user INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);

CREATE TABLE IF NOT EXISTS tb_subject (
    id SERIAL PRIMARY KEY,
    subject VARCHAR(256),
    id_user INTEGER NOT NULL,
    id_inmost_visit INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id),
    FOREIGN KEY (id_inmost_visit) REFERENCES tb_subject_inmost_visit(id)
);

CREATE TABLE IF NOT EXISTS tb_documents (
    id SERIAL PRIMARY KEY,
    documentos VARCHAR(256),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    id_user INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);

CREATE TABLE IF NOT EXISTS tb_address (
    id SERIAL PRIMARY KEY,
    cep VARCHAR(9) NOT NULL,
    pais VARCHAR(256) NOT NULL,
    UF VARCHAR(2) NOT NULL,
    cidade VARCHAR(256) NOT NULL,
    bairro VARCHAR(256) NOT NULL,
    rua VARCHAR(256) NOT NULL,
    numero_casa VARCHAR(256) NOT NULL,
    id_user INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);

CREATE TABLE IF NOT EXISTS protocolos (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    id_user INTEGER NOT NULL,
    id_user_editor INTEGER,
    FOREIGN KEY (id_user) REFERENCES tb_user(id),
    FOREIGN KEY (id_user_editor) REFERENCES tb_admin(id)
);
