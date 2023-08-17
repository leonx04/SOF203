CREATE TABLE QLDS (
	ID INT IDENTITY(1,1) PRIMARY KEY,
	MaDD NVARCHAR(30),
	Ten NVARCHAR (50) ,
	DIACHI  NVARCHAR(50) ,
	TUOI INT ,
	CONGVIEC  NVARCHAR(40),
	GIOITINH BIT 
);
GO
INSERT INTO QLDS (MaDD, Ten, DIACHI, TUOI, CONGVIEC, GIOITINH)
VALUES 
	('A001', 'NGUYEN VAN HAO' , 'HA NOI', 18, 'TAXI' , 1 ),
	('A002',  ' HOANG THI THAO' , 'NGHE AN' ,19, 'CAFE', 0),
	('A003',  ' LE VAN ANH' , 'NGHE AN' ,20, 'IT', 1),
	('A004',  ' TRAN ANH TONG' , 'NGHE AN' ,21, 'DS', 1);

SELECT MaDD, Ten, DIACHI, TUOI, CONGVIEC, GIOITINH FROM QLDS