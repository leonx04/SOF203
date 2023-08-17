CREATE TABLE XeMay(
	MaKhungXe VARCHAR(50) PRIMARY KEY,
	TenLoaiXe NVARCHAR(50),
	SoPhanKhoi INT,
	GiaBan FLOAT,
	MauXe	NVARCHAR(30)
);

INSERT INTO XeMay (MaKhungXe, TenLoaiXe, SoPhanKhoi, GiaBan, MauXe )
VALUES ('A001', 'HonDa', 125, 20000000, 'RED'),
		('A002', 'Yamaha', 150, 30000000, 'BLUE'),
		('A003', 'Kawasaki', 200, 400000000, 'GREEN'),
		('A004', 'DatBike', 150, 60000000, 'Yellow');

SELECT * FROM XeMay
SELECT MaKhungXe, TenLoaiXe,SoPhanKhoi, GiaBan,MauXe FROM XeMay