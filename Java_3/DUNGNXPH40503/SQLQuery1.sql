CREATE DATABASE DUNGNXPH40503_LAB8
GO 

CREATE TABLE STUDEN (
	ID INT PRIMARY KEY,
	 GIOITINH BIT ,
	 DIACHI NVARCHAR(50),
	 PHONE NVARCHAR(20) ,
	 EMAIL NVARCHAR(40)
);

INSERT INTO STUDEN (ID, GIOITINH, DIACHI, PHONE, EMAIL)
VALUES 
	(1, 1 , 'HA NOI' ,'0123456789', 'dungnxph@gmail.com' ),
	(2, 0 , 'HA NOI' ,'1234567890', 'maillv@gmail.com' ),
	(3, 1 , 'HA NOI' ,'2345678912', 'huyhp@gmail.com' ),
	(4, 0 , 'HA NOI' ,'34567890123', 'anhhk@gmail.com' );

SELECT ID, GIOITINH, DIACHI, PHONE, EMAIL FROM STUDEN