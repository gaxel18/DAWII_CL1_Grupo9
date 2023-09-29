CREATE TABLE Especialidad (
    idesp int PRIMARY KEY,
    nomesp VARCHAR(255),
    costo DECIMAL(10, 2)
);

CREATE TABLE Alumnos (
    idalumno INT PRIMARY KEY,
    nomalumno VARCHAR(255),
    apealumno VARCHAR(255),
    idesp int,
    proce VARCHAR(50),
    foreign key (idesp) references Especialidad(idesp)
);

CREATE TABLE Profesores (
    idprofesor INT PRIMARY KEY,
    nomprofesor VARCHAR(255),
    apeprofesor VARCHAR(255)
);

CREATE TABLE Cursos (
    idcurso INT PRIMARY KEY,
    nombrecurso VARCHAR(255),
    idesp INT,
    idprofesor INT,
    FOREIGN KEY (idesp) REFERENCES Especialidad(idesp),
    FOREIGN KEY (idprofesor) REFERENCES Profesores(idprofesor)
);

CREATE TABLE Notas (
    idnota INT PRIMARY KEY,
    idalumno INT,
    idcurso INT,
    calificacion DECIMAL(5, 2),
    fecha_examen DATE,
    FOREIGN KEY (idalumno) REFERENCES Alumnos(idalumno),
    FOREIGN KEY (idcurso) REFERENCES Cursos(idcurso)
);

CREATE TABLE Matriculas (
    idmatricula INT PRIMARY KEY,
    idalumno INT,
    idesp INT,
    fecha_matricula DATE,
    FOREIGN KEY (idalumno) REFERENCES Alumnos(idalumno),
    FOREIGN KEY (idesp) REFERENCES Especialidad(idesp)
);

