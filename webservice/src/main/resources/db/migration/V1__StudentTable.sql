CREATE TABLE student(
    id UUID NOT NULL PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    course VARCHAR(100) NOT NULL
)