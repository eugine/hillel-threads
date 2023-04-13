DROP TABLE IF EXISTS students;
CREATE TABLE students
(
    id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name       VARCHAR(50)         NOT NULL,
    age        INTEGER             NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    major      VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

INSERT INTO students (name, email, age, major) VALUES ('John Doe', 'johndoe@example.com', 20, 'Computer Science');
INSERT INTO students (name, email, age, major) VALUES ('Mary Smith', 'marysmith@example.com', 21, 'Business');
INSERT INTO students (name, email, age, major) VALUES ('David Lee', 'davidlee@example.com', 19, 'Engineering');
INSERT INTO students (name, email, age, major) VALUES ('Emily Wang', 'emilywang@example.com', 20, 'Biology');
INSERT INTO students (name, email, age, major) VALUES ('Kevin Kim', 'kevinkim@example.com', 22, 'Political Science');
INSERT INTO students (name, email, age, major) VALUES ('Sophie Johnson', 'sophiejohnson@example.com', 19, 'Psychology');
INSERT INTO students (name, email, age, major) VALUES ('Tom Brown', 'tombrown@example.com', 21, 'Mathematics');
INSERT INTO students (name, email, age, major) VALUES ('Grace Chen', 'gracechen@example.com', 20, 'Economics');
INSERT INTO students (name, email, age, major) VALUES ('Michael Davis', 'michaeldavis@example.com', 19, 'History');
INSERT INTO students (name, email, age, major) VALUES ('Jessica Kim', 'jessicakim@example.com', 21, 'English');
INSERT INTO students (name, email, age, major) VALUES ('Andrew Park', 'andrewpark@example.com', 20, 'Communications');
INSERT INTO students (name, email, age, major) VALUES ('Lily Jones', 'lilyjones@example.com', 22, 'Art');
INSERT INTO students (name, email, age, major) VALUES ('Daniel Lee', 'daniellee@example.com', 19, 'Chemistry');
INSERT INTO students (name, email, age, major) VALUES ('Sophia Kim', 'sophiakim@example.com', 21, 'Physics');
INSERT INTO students (name, email, age, major) VALUES ('Oliver Wang', 'oliverwang@example.com', 20, 'Music');
INSERT INTO students (name, email, age, major) VALUES ('Catherine Chen', 'catherinechen@example.com', 19, 'Sociology');
INSERT INTO students (name, email, age, major) VALUES ('Ethan Kim', 'ethankim@example.com', 22, 'Engineering');
INSERT INTO students (name, email, age, major) VALUES ('Isabella Davis', 'isabelladavis@example.com', 20, 'Geology');
INSERT INTO students (name, email, age, major) VALUES ('Samuel Park', 'samuelpark@example.com', 21, 'Marketing');
INSERT INTO students (name, email, age, major) VALUES ('Hannah Brown', 'hannahbrown@example.com', 19, 'Environmental Science');
