CREATE DATABASE TestKetNoi
go
CREATE TABLE SinhVien(
    ID INT NOT NULL PRIMARY KEY,
    NAME nvarchar(100)
)
INSERT INTO SinhVien(ID, NAME)
VALUES  (1, N'Trang'),
		(2,N'Trai'),
		(3,N'Tra'),
		(4,N'Duy'),
		(5,N'Dung')
SELECT*FROM SinhVien
--1.INSERT 
--DELETE , UPDATE, CHECK DL, CHECK TRUNG MA

--2.
DELETE FROM SinhVien WHERE ID =?

--3.Khong cho sua khoa chinh
UPDATE SinhVien set NAME=? WHERE id=?

--4 test trung ma
select ID,NAME FROM SinhVien where id=?

--5 
select ID,NAME FROM SinhVien where NAME like ?;
--6 sort
SELECT ID, NAME FORM SinhVien ODER BY NAME DESC