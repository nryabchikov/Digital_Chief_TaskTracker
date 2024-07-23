CREATE TABLE projects
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE tasks
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description TEXT,
    project_id  INTEGER NOT NULL,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
);