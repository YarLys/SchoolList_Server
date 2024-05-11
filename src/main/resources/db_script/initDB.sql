/*
-- Database name:
CREATE DATABASE School_List;

USE School_List;
*/

-- Teacher table structure:
CREATE TABLE IF NOT EXISTS teachers
(
    /*Почему-то при создании из кода не задаются ограничения на поля (not null, unique)
    В связи с этим этот файл можно, конечно, использовать, но пока что я создал таблицу вручную,
    чтобы не было других более неприятных ситуаций из-за этого.*/

    id int PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    last_name VARCHAR(30),
    phone VARCHAR(15) NOT NULL,  /*CHECK(phone != ' ')*/
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    unique(email, phone)
    /*created_at TIMESTAMP,
    updated_at TIMESTAMP*/
);