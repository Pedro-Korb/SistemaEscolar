CREATE TABLE professor (
    id_professor INT PRIMARY KEY AUTO_INCREMENT,
    nome_professor VARCHAR(45) NOT NULL,
    especialidade_professor VARCHAR(45) NOT NULL
);

CREATE TABLE disciplina (
    id_disciplina INT PRIMARY KEY AUTO_INCREMENT,
    nome_disciplina VARCHAR(45) NOT NULL
);

CREATE TABLE fase (
    id_fase INT PRIMARY KEY AUTO_INCREMENT,
    numero_fase INT not null
);

CREATE TABLE curso (
    id_curso INT PRIMARY KEY AUTO_INCREMENT,
    nome_curso VARCHAR(45)
);

CREATE TABLE aluno (
    id_aluno INT PRIMARY KEY AUTO_INCREMENT,
    id_curso INT,
    nome_aluno VARCHAR(45),
    FOREIGN KEY (id_curso) REFERENCES curso(id_curso) ON DELETE CASCADE
);

CREATE TABLE professor_disciplina (
    id_professor INT,
    id_disciplina INT,
    PRIMARY KEY (id_professor, id_disciplina),
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor) ON DELETE CASCADE,
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina) ON DELETE CASCADE
);

CREATE TABLE disciplina_fase (
    id_disciplina INT,
    id_fase INT,
    PRIMARY KEY (id_disciplina, id_fase),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina) ON DELETE CASCADE,
    FOREIGN KEY (id_fase) REFERENCES fase(id_fase) ON DELETE CASCADE
);

CREATE TABLE fase_curso ( 
    id_fase INT,
    id_curso INT,
    PRIMARY KEY (id_fase, id_curso),
    FOREIGN KEY (id_fase) REFERENCES fase(id_fase) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES curso(id_curso) ON DELETE CASCADE
);

CREATE TABLE disciplina_curso ( 
    id_disciplina_curso INT PRIMARY KEY AUTO_INCREMENT,
    id_disciplina INT,
    situacao_disciplina_curso VARCHAR(45),
    ano_semestre_disciplina_curso VARCHAR(45),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina) ON DELETE CASCADE
);

CREATE TABLE presenca_aluno ( 
    id_presenca_aluno INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    numero_presencas_presenca_aluno INT,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno) ON DELETE CASCADE
);

CREATE TABLE registro_academico ( 
    id_registro_academico INT PRIMARY KEY AUTO_INCREMENT,
    id_presenca_aluno INT,
    data_registro_academico varchar(15),
    numero_aulas_registro_academico INT,
    id_professor INT,
    FOREIGN KEY (id_presenca_aluno) REFERENCES presenca_aluno(id_presenca_aluno) ON DELETE CASCADE,
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor) ON DELETE CASCADE
);

CREATE TABLE registro_academico_disciplina_curso ( 
    id_registro_academico INT,
    id_disciplina_curso INT,
    PRIMARY KEY (id_registro_academico, id_disciplina_curso),
    FOREIGN KEY (id_registro_academico) REFERENCES registro_academico(id_registro_academico) ON DELETE CASCADE,
    FOREIGN KEY (id_disciplina_curso) REFERENCES disciplina_curso(id_disciplina_curso) ON DELETE CASCADE
);

CREATE TABLE registro_avaliacao ( 
    id_registro_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    nota_avaliacao DECIMAL(5,2),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno) ON DELETE CASCADE
);

CREATE TABLE avaliacao (
    id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    id_registro_avaliacao INT,
    data_avaliacao varchar(15),
    numeracao_avaliacao INT,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor) ON DELETE CASCADE,
    FOREIGN KEY (id_registro_avaliacao) REFERENCES registro_avaliacao(id_registro_avaliacao) ON DELETE CASCADE
);

CREATE TABLE avaliacao_disciplina_curso ( 
    id_avaliacao INT,
    id_disciplina_curso INT,
    PRIMARY KEY (id_avaliacao, id_disciplina_curso),
    FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id_avaliacao) ON DELETE CASCADE,
    FOREIGN KEY (id_disciplina_curso) REFERENCES disciplina_curso(id_disciplina_curso) ON DELETE CASCADE
);

CREATE TABLE disciplina_curso_aluno ( 
    id_disciplina_curso INT,
    id_aluno INT,
    PRIMARY KEY (id_disciplina_curso, id_aluno),
    FOREIGN KEY (id_disciplina_curso) REFERENCES disciplina_curso(id_disciplina_curso) ON DELETE CASCADE,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno) ON DELETE CASCADE
);

