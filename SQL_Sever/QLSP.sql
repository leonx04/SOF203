CREATE DATABASE QLSP_SD18322

CREATE TABLE LOAISANPHAM(
	MALOAI VARCHAR(20) PRIMARY KEY,
	TENLOAI NVARCHAR(50) NOT NULL,
);

CREATE TABLE SANPHAM(
	MASANPHAM VARCHAR(20) PRIMARY KEY,
	TENSANPHAM NVARCHAR(30) NOT NULL,
	MALOAI VARCHAR(20),
	FOREIGN KEY (MALOAI) REFERENCES  LOAISANPHAM(MALOAI)
);
GO 
INSERT INTO LOAISANPHAM (MALOAI, TENLOAI)
VALUES 
		('A001', 'LOAI 1'),
		('A002', 'LOAI 2'),
		('A003', 'LOAI 3'),
		('A004', 'LOAI 4'),
		('A005', 'LOAI 5');

INSERT INTO SANPHAM (MASANPHAM, TENSANPHAM,MALOAI)
VALUES 
		('SP001', 'CAO QUA', 'A001'),
		('SP002', 'LAO ', 'A002'),
		('SP003', 'HOANG ANH', 'A003'),
		('SP004', 'LE MAI', 'A004'),
		('SP005', 'CAO QUA', 'A005');


SELECT MALOAI, TENLOAI FROM LOAISANPHAM 

SELECT MASANPHAM, TENSANPHAM, LOAISANPHAM.MALOAI,TENLOAI 
FROM SANPHAM JOIN LOAISANPHAM ON SANPHAM.MALOAI=LOAISANPHAM.MALOAI