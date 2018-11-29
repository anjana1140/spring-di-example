CREATE TABLE ANJANA.STUDENT
        (student_id NUMBER(10) NOT NULL,
        student_Name VARCHAR(20) NOT NULL,
        standard VARCHAR(10),
        section VARCHAR(10),
        school VARCHAR(10),
        city VARCHAR(10),
        pincode NUMBER(10),
        CONSTRAINT student_pk PRIMARY KEY(student_id)
        );