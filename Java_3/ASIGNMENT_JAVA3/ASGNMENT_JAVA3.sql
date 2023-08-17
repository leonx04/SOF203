DROP DATABASE Asignment_Java3
CREATE DATABASE Asignment_Java3


CREATE TABLE NguoiDung(
	UserName NVARCHAR(40) PRIMARY KEY,
	PassWord VARCHAR(30),
	Role VARCHAR(50)
);

CREATE TABLE SinhVien (
	MaSV VARCHAR(50) PRIMARY KEY,
	HoTen NVARCHAR(50) ,
	Email VARCHAR(50) NULL,
	SDT VARCHAR(15) NULL,
	GioiTinh BIT NULL,
	DiaChi NVARCHAR(100) NULL,
	HinhAnh VARCHAR(50) NULL
);

CREATE TABLE DIEM(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	MaSV VARCHAR(50) ,
	TiengAnh INT NULL,
	TinHoc INT NULL,
	GDTC INT NULL
	FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV)
);
GO
INSERT INTO NguoiDung(UserName , PassWord, Role)
VALUES	('nguyenxuandung', '12345',N'Giảng Viên'),
		('levanluong', '45678',N'đào tạo'),
		('hoangthithao', 'abcde',N'Giảng Viên'),
		('tranhvananh', '12345',N'Giảng Viên'),
		('admin', '12345',N'đào tạo');

INSERT INTO SinhVien(MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh)
VALUES	('SV001', 'NGUYEN XUAN DUNG', 'dungnx@gmail.com','0123456789',1,'NGHE AN', 'Anh1.jpg'),
		('SV002', 'LE VAN LUONG ', 'luonglv@gmail.com','0234567891',1,'HA NOI', 'Anh2.jpg'),
		('SV003', 'HOANG THI THAO', 'thaoht@gmail.com','0345678912',0,'NGHE AN', 'Anh3.jpg'),
		('SV004', 'TRAN VAN ANH', 'anhtv@gmail.com','0456789123',1,'NGHE AN', 'Anh4.jpg'),
		('SV005', 'NGUYEN  THU PHUONG', 'phuongnt@gmail.com','0567891234',0,'THAI BINH', 'Anh5.jpg');

INSERT INTO DIEM(MaSV, TiengAnh, TinHoc, GDTC)
VALUES	('SV001' , 9, 9,9),
		('SV002' , 7, 7,7),
		('SV003' , 8, 8, 8),
		('SV004' , 6, 6, 6),
		('SV005' , 10, 10, 10);
GO
SELECT UserName , PassWord FROM NguoiDung
SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM SinhVien
SELECT MaSV, TiengAnh, TinHoc, GDTC FROM DIEM
GO
--
SELECT MaSV, TiengAnh, TinHoc, GDTC FROM DIEM where id=?
--
SELECT MaSV, HoTen, Email, SDT, GioiTinh, DiaChi, HinhAnh FROM Students where MaSV = ?
--
SELECT * FROM NguoiDung WHERE UserName = ? AND PassWord = ?

--SELECT TOP 3


SELECT  TOP 3      SinhVien.MaSV, SinhVien.HoTen, DIEM.TiengAnh, DIEM.TinHoc, DIEM.GDTC, ( DIEM.TiengAnh + DIEM.TinHoc + DIEM.GDTC)/3 AS DIEMTB 
FROM SinhVien INNER JOIN
 DIEM ON SinhVien.MaSV = DIEM.MaSV
 ORDER BY DIEMTB DESC 

