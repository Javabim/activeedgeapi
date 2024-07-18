-- Create Table T1
CREATE TABLE T1 (
    id INT PRIMARY KEY,
    "name" VARCHAR(50),
    age INT
);

-- Insert Data into T1
INSERT INTO T1 (id, name, age) VALUES
(23, 'Tar', 46),
(12, 'Bar', 32),
(14, 'Foo', 70);

-- Create Table T2
CREATE TABLE T2 (
    id INT PRIMARY KEY,
    "name" VARCHAR(50),
    age INT
);

-- Insert Data into T2
INSERT INTO T2 (id, name, age) VALUES
(14, 'Foobar', 70),
(12, 'Bar', 32);

-- Query to Find Records in T1 Not in T2
SELECT T1.id, T1.name, T1.age
FROM T1
WHERE NOT EXISTS (
    SELECT 1
    FROM T2
    WHERE T1.id = T2.id
      AND T1.name = T2.name
      AND T1.age = T2.age
)
ORDER BY T1.id;

