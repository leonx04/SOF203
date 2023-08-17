CREATE DATABASE LAB_5

CREATE TABLE VanPhong (
  MaSoVanPhong INT PRIMARY KEY,
  DiaDiemTruSo VARCHAR(255)
);

CREATE TABLE NhanVien (
  MaSoNhanVien INT PRIMARY KEY,
  MaSoVanPhong INT,
  TenNhanVien VARCHAR(255),
  FOREIGN KEY (MaSoVanPhong) REFERENCES VanPhong(MaSoVanPhong)
);
CREATE TABLE TruongPhong(
	MaTruongPhong INT PRIMARY KEY,
	Ten NVARCHAR(40) NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	FOREIGN KEY (MaTruongPhong) REFERENCES VanPhong(MaSoVanPhong) 
)
CREATE TABLE ThanNhan (
  MaSoThanNhan INT PRIMARY KEY,
  MaSoNhanVien INT,
  TenThanNhan VARCHAR(255),
  NgaySinh DATE,
  MoiLienHe VARCHAR(255),
  FOREIGN KEY (MaSoNhanVien) REFERENCES NhanVien(MaSoNhanVien)
);

CREATE TABLE BatDongSan (
  MaSoBDS INT PRIMARY KEY,
  MaSoVanPhong INT,
  DiaChi VARCHAR(255),
  FOREIGN KEY (MaSoVanPhong) REFERENCES VanPhong(MaSoVanPhong)
);

CREATE TABLE ChuSoHuu (
  MaSoChuSoHuu INT PRIMARY KEY,
  TenChuSoHuu VARCHAR(255),
  DiaChi VARCHAR(255),
  SoDienThoai VARCHAR(20),
  MaSoBDS INT,
  FOREIGN KEY (MaSoBDS) REFERENCES BatDongSan(MaSoBDS)
);


INSERT INTO VanPhong (MaSoVanPhong, DiaDiemTruSo)
VALUES 
(1, 'Ha Noi'),
(2, 'HCM'), 
(3, 'Da Nang'),
(4, 'Hai Phong'),
(5, 'Can Tho');

INSERT INTO NhanVien (MaSoNhanVien, MaSoVanPhong, TenNhanVien)
VALUES
(1, 1, 'Nhan Vien A'),
(2, 2, 'Nhan Vien B'),
(3, 3, 'Nhan Vien C'),  
(4, 4, 'Nhan Vien D'),
(5, 5, 'Nhan Vien E');

INSERT INTO TruongPhong (MaTruongPhong, Ten, DiaChi)
VALUES
(1, 'Truong Phong A', 'Ha Noi'),
(2, 'Truong Phong B', 'HCM'),
(3, 'Truong Phong C', 'Da Nang'),
(4, 'Truong Phong D', 'Hai Phong'), 
(5, 'Truong Phong E', 'Can Tho');

INSERT INTO ThanNhan (MaSoThanNhan, MaSoNhanVien, TenThanNhan, NgaySinh, MoiLienHe)
VALUES
(1, 1, 'Than Nhan A', '1990-01-01', 'Con'),
(2, 2, 'Than Nhan B', '1992-03-15', 'Em'),
(3, 3, 'Than Nhan C', '1995-07-20', 'Anh'),
(4, 4, 'Than Nhan D', '1988-09-12', 'Chi'),
(5, 5, 'Than Nhan E', '2000-12-25', 'Chau');

INSERT INTO BatDongSan (MaSoBDS, MaSoVanPhong, DiaChi)
VALUES
(1, 1, 'Ha Noi'), 
(2, 2, 'HCM'),
(3, 3, 'Da Nang'),  
(4, 4, 'Hai Phong'),
(5, 5, 'Can Tho');

INSERT INTO ChuSoHuu (MaSoChuSoHuu, TenChuSoHuu, DiaChi, SoDienThoai, MaSoBDS)
VALUES
(1, 'Chu A', 'Ha Noi', '0123456789', 1),
(2, 'Chu B', 'HCM', '0987654321', 2),
(3, 'Chu C', 'Da Nang', '02468101214', 3), 
(4, 'Chu D', 'Hai Phong', '13579111315', 4),
(5, 'Chu E', 'Can Tho', '192021222324', 5);

SELECT * FROM ChuSoHuu

 SELECT TOP 3 MaSoChuSoHuu, TenChuSoHuu, DiaChi, SoDienThoai, MaSoBDS
 FROM ChuSoHuu
 
