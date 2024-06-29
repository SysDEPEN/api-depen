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

-- tb_requerimentos
-- id
-- created_at
-- updated_at
-- id_user
-- id_requerimento_info (tabela dos campos)
-- id_documents (tabela dos anexos)

-- tb_requerimento_info:

-- ID
-- Nome do visitado
-- CPF/RNE
-- TIPO DE VISITAÇÃO
-- TELEFONE
-- ESTADO
-- CIDADE
-- BAIRRO
-- RUA
-- NUMERO DA CASA
-- ASSUNTO DO REQUERIMENTO
-- ID_USER

-- ----------------------------
-- tb_documents 
-- id
-- documents:
--   {
--    "identidade": "caminho do arquivo",
--    "cpf": "caminho do arquivo,,
--    "etc": "caminho do arquivo
--   }
-- created_at
-- updated_at

CREATE TABLE IF NOT EXISTS tb_requerimentos (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    id_user INTEGER NOT NULL,
    id_requerimento_info INTEGER NOT NULL,
    id_documents INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id),
    FOREIGN KEY (id_requerimento_info) REFERENCES tb_requerimento_info(id),
    FOREIGN KEY (id_documents) REFERENCES tb_documents(id)
);

CREATE TABLE IF NOT EXISTS tb_requerimento_info (
    id SERIAL PRIMARY KEY,
    nome_visitado VARCHAR(256) NOT NULL,
    cpf_rne VARCHAR(256) NOT NULL,
    tipo_visita VARCHAR(256) NOT NULL,
    telefone VARCHAR(256) NOT NULL,
    estado VARCHAR(256) NOT NULL,
    cidade VARCHAR(256) NOT NULL,
    bairro VARCHAR(256) NOT NULL,
    rua VARCHAR(256) NOT NULL,
    numero_casa VARCHAR NOT NULL,
    assunto_requerimento VARCHAR(256) NOT NULL,
    id_user INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);

CREATE TABLE IF NOT EXISTS tb_documents (
    id SERIAL PRIMARY KEY,
    identidade VARCHAR(256) NOT NULL,
    cpf VARCHAR(256) NOT NULL,
    grau_parentesco VARCHAR(256) NOT NULL,
    antecedentes_criminais VARCHAR(256) NOT NULL,
    comprovante_residencia VARCHAR(256) NOT NULL,
    foto VARCHAR(256) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    id_user INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES tb_user(id)
);
