drop database CSDL_LAB_5

CREATE  database CSDL_LAB_5
GO

CREATE TABLE NhanVien (
    MaSoNhanVien NVARCHAR(20) PRIMARY KEY,
    Ten NVARCHAR(255)
);

CREATE TABLE VanPhong (
    MaSoVanPhong NVARCHAR(20) PRIMARY KEY,
    DiaDiem NVARCHAR(255),
    TruongVanPhong NVARCHAR(20),
    FOREIGN KEY (TruongVanPhong) REFERENCES NhanVien(MaSoNhanVien)
);

CREATE TABLE NhanThan (
    MaSoNhanThan NVARCHAR(20) PRIMARY KEY,
    Ten NVARCHAR(255),
    NgaySinh DATE,
    MoiLienHe NVARCHAR(255),
    MaSoNhanVien NVARCHAR(20),
    FOREIGN KEY (MaSoNhanVien) REFERENCES NhanVien(MaSoNhanVien)
);

CREATE TABLE ChuSoHuu (
    MaSoChuSoHuu NVARCHAR(20) PRIMARY KEY,
    Ten NVARCHAR(255),
    DiaChi NVARCHAR(255),
    SoDienThoai NVARCHAR(20),
    MaSoBDS NVARCHAR(20)
);

CREATE TABLE SanPhamBatDongSan (
    MaSoBDS NVARCHAR(20) PRIMARY KEY,
    DiaChi NVARCHAR(255),
    MaSoVanPhong NVARCHAR(20),
    MaSoChuSoHuu NVARCHAR(20),
    FOREIGN KEY (MaSoVanPhong) REFERENCES VanPhong(MaSoVanPhong),
    FOREIGN KEY (MaSoChuSoHuu) REFERENCES ChuSoHuu(MaSoChuSoHuu)
);

INSERT INTO NhanVien (MaSoNhanVien, Ten)
VALUES
    ('NV01', 'Nguyen Van An'),
    ('NV02', 'Tran Thi Bao'),
    ('NV03', 'Le Van Cao'),
    ('NV04', 'Pham Thi Duong'),
    ('NV05', 'Hoang Van Em'),
    ('NV06', 'Vo Thi Mai'),
    ('NV07', 'Do Van Giang'),
    ('NV08', 'Nguyen Thi Huong'),
    ('NV09', 'Tran Van Kiet'),
    ('NV10', 'Le Thi Huyen');

INSERT INTO VanPhong (MaSoVanPhong, DiaDiem, TruongVanPhong)
VALUES
    ('VP01', 'HA NOI', 'NV01'),
    ('VP02', 'NGHE AN', 'NV02'),
    ('VP03', 'DA NANG', 'NV03'),
    ('VP04', 'HA NAM', 'NV04'),
    ('VP05', 'HAI DUONG', 'NV05'),
    ('VP06', 'CA MAU', 'NV06'),
    ('VP07', 'HA DONG', 'NV07'),
    ('VP08', 'MY DINH', 'NV08'),
    ('VP09', 'CO NHUE', 'NV09'),
    ('VP10', 'BAC KAN', 'NV10');

INSERT INTO NhanThan (MaSoNhanThan, Ten, NgaySinh, MoiLienHe, MaSoNhanVien)
VALUES
    ('NT01', 'Nhan than 1', '2000-01-01', 'Cha', 'NV01'),
    ('NT02', 'Nhan than 2', '1998-05-15', 'Con', 'NV02'),
    ('NT03', 'Nhan than 3', '1995-12-20', 'Me', 'NV03'),
    ('NT04', 'Nhan than 4', '1997-08-10', 'Cha', 'NV04'),
    ('NT05', 'Nhan than 5', '2002-03-25', 'Con', 'NV05'),
    ('NT06', 'Nhan than 6', '1993-11-05', 'Me', 'NV06'),
    ('NT07', 'Nhan than 7', '1999-07-18', 'Cha', 'NV07'),
    ('NT08', 'Nhan than 8', '2001-09-30', 'Con', 'NV08'),
    ('NT09', 'Nhan than 9', '1994-02-12', 'Me', 'NV09'),
    ('NT10', 'Nhan than 10', '1996-06-08', 'Me', 'NV10');

INSERT INTO ChuSoHuu (MaSoChuSoHuu, Ten, DiaChi, SoDienThoai, MaSoBDS)
VALUES
    ('KH001', 'Chu so huu 1', 'Dia chi A', '1234567890', '1'),
    ('KH002', 'Chu so huu 2', 'Dia chi B', '9876543210', '2'),
    ('KH003', 'Chu so huu 3', 'Dia chi C', '4567891230', '3'),
    ('KH004', 'Chu so huu 4', 'Dia chi D', '7891234560', '4'),
    ('KH005', 'Chu so huu 5', 'Dia chi E', '5678901234', '5'),
    ('KH006', 'Chu so huu 6', 'Dia chi F', '0123456789', '6'),
    ('KH007', 'Chu so huu 7', 'Dia chi G', '5432109876', '7'),
    ('KH008', 'Chu so huu 8', 'Dia chi H', '2345678901', '8'),
    ('KH009', 'Chu so huu 9', 'Dia chi I', '8901234567', '9'),
    ('KH010', 'Chu so huu 10', 'Dia chi K', '6789012345', '10');

INSERT INTO SanPhamBatDongSan (MaSoBDS, DiaChi, MaSoVanPhong, MaSoChuSoHuu)
VALUES
    ('1', 'Dia chi BDS 1', 'VP01', 'KH001'),
    ('2', 'Dia chi BDS 2', 'VP02', 'KH002'),
    ('3', 'Dia chi BDS 3', 'VP03', 'KH003'),
    ('4', 'Dia chi BDS 4', 'VP04', 'KH004'),
    ('5', 'Dia chi BDS 5', 'VP05', 'KH005'),
    ('6', 'Dia chi BDS 6', 'VP06', 'KH006'),
    ('7', 'Dia chi BDS 7', 'VP07', 'KH007'),
    ('8', 'Dia chi BDS 8', 'VP08', 'KH008'),
    ('9', 'Dia chi BDS 9', 'VP09', 'KH009'),
    ('10', 'Dia chi BDS 10', 'VP10', 'KH010');

SELECT * FROM NhanVien
SELECT * FROM VanPhong
SELECT * FROM NhanThan
SELECT * FROM ChuSoHuu
SELECT * FROM  SanPhamBatDongSan

--Bài 1
--a
SELECT * FROM ChuSoHuu
--b
SELECT MaSoChuSoHuu, Ten, DiaChi, SoDienThoai FROM ChuSoHuu



