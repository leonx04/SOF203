CREATE TABLE TaiKhoan (
	MaTaiKhoan NVARCHAR(20) PRIMARY KEY,
	TenTaiKhoan NVARCHAR(50) NOT NULL,
	MatKhau NVARCHAR (30) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	PhanQuyen NVARCHAR(30) NOT NULL
);
GO 
CREATE TABLE HoaDon(
	MaHoaDon NVARCHAR(20) PRIMARY KEY,
	MaTaiKhoan NVARCHAR(20) NOT NULL,
	NgayDatHang DATE NOT NULL,
	TongTien MONEY,
	FOREIGN KEY (MaTaiKhoan)  REFERENCES TaiKhoan(MaTaiKhoan)
);
GO
CREATE TABLE HoaDonCT (
	MaHoaDon NVARCHAR(20) NOT NULL,
	MaSanPham NVARCHAR(20)  PRIMARY KEY,
	SoLuong INT ,
	DonGia MONEY ,
	FOREIGN KEY (MaHoaDon)  REFERENCES HoaDon(MaHoaDon)
);
GO
--2
INSERT INTO  TaiKhoan (MaTaiKhoan,TenTaiKhoan,MatKhau,HoTen,PhanQuyen)
VALUES
		('TK01','nguyenvananh','12345','Nguyen Van Anh','PHANUYEN1'),
		('TK02','levanbao','6789','Le Van Bao','PHANUYEN2'),
		('TK03','tranvancuong','abcdx','Tran Van Cuong','PHANUYEN3');
GO
INSERT INTO HoaDon (MaHoaDon,MaTaiKhoan,NgayDatHang,TongTien)
VALUES 
		('HD01','TK01','2009-03-11',1000),
		('HD02','TK02','2023-04-12',2000),
		('HD03','TK03','2023-04-13',3000);
GO
INSERT INTO HoaDonCT(MaHoaDon,MaSanPham,SoLuong,DonGia)
VALUES
		('HD01','SP01',1000,11000),
		('HD02','SP02',2000,12000),
		('HD03','SP03',300,13000);

GO
--3
--SELECT * FROM TaiKhoan
--SELECT * FROM HoaDon
--SELECT * FROM HoaDonCT

SELECT TenTaiKhoan, MatKhau, PhanQuyen FROM TaiKhoan
GO

--4
SELECT * FROM HoaDon
WHERE MONTH(NgayDatHang) = 4 
AND YEAR(NgayDatHang) = 2023;

--5
UPDATE TaiKhoan
SET PhanQuyen = 'PhanQuyen4'
WHERE MaTaiKhoan = 'TK03'
GO

SELECT * FROM TaiKhoan
GO

--6
DELETE FROM HoaDon
WHERE NgayDatHang < '2010'

--7
--SELECT HD.MaHoaDon, HD.NgayDatHang,MaSanPham ,SoLuong,
--ThanhTien =(HoaDonCT.SoLuong*DonGia)
--JOIN HoaDon HD ON HoaDonCT.MaSanPham = HD.MaHoaDon
--JOIN HoaDonCT ON 
--FROM HoaDonCT

