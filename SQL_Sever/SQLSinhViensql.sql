CREATE DATABASE TestKetNoi
USE TestKetNoi

ALTER TABLE SinhVien(
	ID INT NOT NULL PRIMARY KEY,
	NAME nvarchar(100)
)
-- delete form SinhVien
INSERT INTO SinhVien(ID,NAME) values
(1,N'TÊN SV'),
(2,N'TRANG HAM'),
(3,N'TRANG GIA'),
(4,N'TRANG DANH DA')
select ID,NAME from SinhVien
SELECT ID, NAME FROM SinhVien WHERE NAME LIKE ?;
