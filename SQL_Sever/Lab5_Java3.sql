DROP  DATABASE Lab_5_Java3
CREATE TABLE Sinh_Vien(
	id int IDENTITY(1,1) PRIMARY KEY,
	ma_sinh_vien varchar(20) null,
	ten_sinh_vien nvarchar(50) null,
	tuoi int null,
	ky_hoc int Null,
	nghanh_hoc nvarchar(100) null,
	diem_trung_binh float null,
	gioi_tinh bit null
)

go 
INSERT INTO Sinh_Vien 
(ma_sinh_vien, ten_sinh_vien, tuoi, ky_hoc, nghanh_hoc, diem_trung_binh, gioi_tinh)
values (N'HE130561', N'NGUYEN THUY HANG', 10, 1,N'KY THUAT PHAN MEM', 9.9, 0),
		(N'HE130562', N'NGUYEN huy hoang', 17, 2,N'IT', 8.9, 1),
		(N'HE130563', N'Le van Huy', 18, 3,N'MKT', 8.7, 1),
		(N'HE130564', N'Hoang  Thi Thao', 19, 4,N'IT', 8.6, 0),
		(N'HE130565', N'NGUYEN huy hoang', 20, 5,N'IT', 8.5, 1);

SELECT id, ma_sinh_vien, ten_sinh_vien, tuoi, ky_hoc, nghanh_hoc, diem_trung_binh, gioi_tinh FROM Sinh_Vien