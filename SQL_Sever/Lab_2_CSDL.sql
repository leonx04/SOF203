CREATE DATABASE LAB_2_CSDL
GO
USE LAB_2_CSDL
GO
-- Tạo bảng KHACHHANG
CREATE TABLE KHACHHANG (
    MAKH NVARCHAR(25) PRIMARY KEY,
    HoTenLot NVARCHAR(50),
    TEN NVARCHAR(50),
    DIACHI NVARCHAR(50),
    EMAIL NVARCHAR(50),
    DIENTHOAI NVARCHAR(30)
);

-- Tạo bảng SANPHAM
CREATE TABLE SANPHAM (
    MASP INT PRIMARY KEY,
    MOTA NVARCHAR(50),
    SOLUONG INT,
    DONGIA MONEY,
    TENSP NVARCHAR(50)
);

-- Tạo bảng HOADON
CREATE TABLE HOADON (
    MAHD INT PRIMARY KEY,
    NGAYMUA DATE,
    MAKH NVARCHAR(25) REFERENCES KHACHHANG(MAKH),
    TRANGTHAI NVARCHAR(50)
);

-- Tạo bảng HOADONCHITIET
CREATE TABLE HOADONCHITIET (
    MAHDCT INT PRIMARY KEY,
    MAHD INT REFERENCES HOADON(MAHD),
    MASP INT REFERENCES SANPHAM(MASP),
    SOLUONG INT,
    CONSTRAINT FK_HDCT_HD FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD),
    CONSTRAINT FK_HDCT_SP FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP)
);

go 

INSERT INTO KHACHHANG (MAKH, HoTenLot, TEN, DIACHI, EMAIL, DIENTHOAI)
VALUES ('KH001', N'Nguyễn Văn', N'A', N'Hà Nội', 'nguyenvana@gmail.com', '0123456789'),
       ('KH002', N'Trần Thị', N'B', N'Hồ Chí Minh', 'tranthib@gmail.com', '0987654321'),
       ('KH003', N'Lê Văn', N'C', N'Đà Nẵng', 'levanc@gmail.com', '0245678912'),
       ('KH004', N'Phạm Thị', N'D', N'Cần Thơ', 'phamthid@gmail.com', '0345678912'), 
       ('KH005', N'Hoàng Văn', N'E', N'Huế', 'hoangvane@gmail.com', '0456678912'),
       ('KH006', N'Bùi Thị', N'F', N'Hải Phòng', 'buithif@gmail.com', '0556789123'),
       ('KH007', N'Trương Văn', N'G', N'Bình Dương', 'truongvang@gmail.com', '0667789123'),  
       ('KH008', N'Ngô Thị', N'H', N'Bắc Ninh', 'ngothih@gmail.com', '0777789123'),
       ('KH009', N'Lý Văn', N'I', N'Quảng Ninh', 'lyvani@gmail.com', '0887789123'),
       ('KH010', N'Hồ Thị', N'K', N'Thanh Hóa', 'hothik@gmail.com', '0997789123');

INSERT INTO SANPHAM (MASP, MOTA, SOLUONG, DONGIA, TENSP)  
VALUES (1, N'Điện thoại', 100, 500000, N'Iphone 13'),
       (2, N'Máy tính', 50, 10000000 , N'Macbook Pro'),
       (3, N'Đồng hồ', 200, 2000000, N'Rolex'),
       (4, N'Tivi', 80, 7000000, N'Samsung'),
       (5, N'Tủ lạnh', 150, 4000000, N'Panasonic'),
       (6, N'Máy giặt', 250, 3000000, N'Toshiba'), 
       (7, N'Máy lọc nước', 80, 2000000, N'Kangaroo'),
       (8, N'Lò vi sóng', 120, 1000000, N'Sanyo'),
       (9, N'Máy sấy tóc', 300, 500000, N'Philips'),  
       (10,N'Máy hút bụi', 200, 2000000, N'Dyson');

INSERT INTO HOADON (MAHD, NGAYMUA, MAKH, TRANGTHAI)
VALUES (1, '2023-02-01', 'KH001', N'Đã giao'),
       (2, '2023-02-05', 'KH002', N'Đang giao'),
       (3, '2023-02-10', 'KH003', N'Đã hủy'),
       (4, '2023-02-15', 'KH004', N'Đã giao'),  
       (5, '2023-02-20', 'KH005', N'Đang giao'),
       (6, '2023-02-25', 'KH006', N'Đã hủy'),
       (7, '2023-03-01', 'KH007', N'Đã giao'),
       (8, '2023-03-05', 'KH008', N'Đang giao'),
       (9, '2023-03-10', 'KH009', N'Đã hủy'),
       (10,'2023-03-15', 'KH010', N'Đã giao');
       
INSERT INTO HOADONCHITIET (MAHDCT, MAHD, MASP, SOLUONG)
VALUES (1, 1, 1, 2), 
       (2, 2, 2, 1),
       (3, 3, 3, 5),
       (4, 4, 4, 1),
       (5, 5, 5, 3),
       (6, 6, 6, 2),
       (7, 7, 7, 1),
       (8, 8, 8, 4),
       (9, 9, 9, 7),
       (10,10,10, 2);

--Bai 1

--a
SELECT * FROM KHACHHANG
--b
SELECT MAKH, HoTenLot, TEN, DIACHI, EMAIL, DIENTHOAI 
FROM KHACHHANG
--c
SELECT MASP, TENSP, DONGIA*SOLUONG AS 'Tong tien ton kho'
FROM SANPHAM
--d
SELECT
MAKH,
HoTenLot + ' ' + TEN AS 'hoVaTen',
DIACHI
FROM
KHACHHANG
WHERE
TEN LIKE 'H%'
--e
SELECT *
FROM KHACHHANG
WHERE DIACHI LIKE N'%Đà Nẵng%';
--f
SELECT * 
FROM SANPHAM
WHERE SOLUONG 
BETWEEN 100 AND 500;
--g
SELECT *
FROM HOADON
WHERE TRANGTHAI = N'Chưa thanh toán' 
AND YEAR(NGAYMUA) = 2016
--h
SELECT *
FROM HOADON
WHERE MAKH IN ('KH001', 'KH003', 'KH006')

--Bai 2

--a
SELECT COUNT(*) FROM KHACHHANG
--b
SELECT MAX(DONGIA) as MaxDonGia
FROM SANPHAM
--c
SELECT MIN(SOLUONG) as MinDonGia
FROM SANPHAM
--d
SELECT SUM(SOLUONG) as TongDonGia
FROM SANPHAM
--e
SELECT COUNT(*)
FROM HOADON
WHERE MONTH(NGAYMUA) = 12 
AND YEAR(NGAYMUA) = 2016 
AND TRANGTHAI = N'Chưa thanh toán'
--f
SELECT MAHD,
COUNT(DISTINCT MASP)
AS SOLOAISANPHAM
FROM HOADONCHITIET
GROUP BY MAHD
--g

--h
SELECT MAHD, NGAYMUA, MAKH
FROM HOADON
ORDER BY NGAYMUA DESC