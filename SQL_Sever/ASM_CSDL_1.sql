create database ASM_CSDL_1
go
use ASM_CSDL_1
go
--tạo table
create table theLoai(
	maTL nchar(10) not null primary key,
	tenTl nvarchar(50) null
);
go 

create table sach(
	maSach nchar(10) not null primary key,
	tieuDe nvarchar(50),
	nhaXB nvarchar(50),
	tacGia nvarchar(50),
	soLuongBS int,
	giaTien float,
	ngayNhapKho date,
	viTri nvarchar(50),
	soTrang int,
	nhanXet nvarchar(50),
	maTL nchar(10) not null foreign key references theLoai(maTL)
);
go

create table tacGia(
	maTG nchar(10) not null primary key,
	hoTen nvarchar(50),
	butDanh nvarchar(50),
	diaChi nvarchar(50),
	sdt nchar(10)
);
go

create table sach_tacGia(
	maSach nchar(10) not null foreign key references sach(maSach),
	maTG nchar(10) not null foreign key references tacGia(maTG),
	primary key(maSach, maTG)
);
go

create table nganhHoc(
	maNganh nchar(10) not null primary key,
	tenNganh nvarchar(50)
);
go

create table lop(
	maLop nchar(10) not null primary key,
	tenLop nvarchar(50),
	maNganh nchar(10) not null foreign key references nganhHoc(maNganh)
);
go

create table sinhVien(
	maSV nchar(10) not null primary key,
	maLop nchar(10) not null foreign key references lop(maLop),
	hoTen nvarchar(50),
	diaChi nvarchar(50),
	email nvarchar(50),
	sdt nchar(10),
	ngaySinh date,
	ngayHetHan date
);
go

create table phieuMuon(
	maPhieu nchar(10) not null primary key,
	maSV nchar(10) not null foreign key references sinhVien(maSV),
	ngayMuon date
);
go

create table CTPhieuMuon(
	maSach nchar(10) not null foreign key references sach(maSach),
	maPhieu nchar(10) not null foreign key references phieuMuon(maPhieu),
	soLuong int,
	primary key(maSach, maPhieu)
);
GO

INSERT INTO theLoai (maTL, tenTl) 
VALUES
    ('IT', 'Công nghệ thông tin'),
    ('ENG', 'Kỹ thuật'),
    ('LIT', 'Văn học');

INSERT INTO sach (maSach, tieuDe, nhaXB, tacGia, soLuongBS, giaTien, ngayNhapKho, viTri, soTrang, nhanXet, maTL) 
VALUES
    ('S001', 'SQL Mastery', 'NXB Trí Thức', 'Tac gia 1', 50, 250000, '2020-05-15', 'Kệ A3, Ngăn 1', 300, 'Thú vị', 'IT'),
    ('S002', 'Python Programming', 'NXB Giáo dục', 'Tac gia 2', 30, 180000, '2019-08-20', 'Kệ B2, Ngăn 3', 400, 'Hướng dẫn chi tiết', 'IT'),
    ('S003', ' Robot', 'NXB Khoa học', 'Tac gia 3', 25, 350000, '2021-02-10', 'Kệ A1, Ngăn 2', 250, 'Advanced robotics concepts', 'ENG'),
    ('S004', 'The Boys', 'NXB Văn học', 'Tac gia 4', 40, 120000, '2018-06-18', 'Kệ B3, Ngăn 1', 800, 'Epic historical novel', 'LIT'),
    ('S005', 'Data ', 'NXB Trí Thức', 'Tac gia 5', 60, 220000, '2022-04-22', 'Kệ A2, Ngăn 4', 350, 'Essential for programmers', 'IT');


INSERT INTO tacGia (maTG, hoTen, butDanh, diaChi, sdt) 
VALUES
    ('TG001', 'Tac gia 1', 'TG-1', 'HA NOI', '1234567890'),
    ('TG002', 'Tac gia 2', 'TG-2', 'HAI PHONG', '0987654321'),
    ('TG003', 'Tac gia 3', 'TG-3', 'DA NANG', '0123456789'),
    ('TG004', 'Tac gia 4', 'TG-4', 'HUE', '1122334455'),
    ('TG005', 'Tac gia 5', 'TG-5', 'NGA', '0369852147');

INSERT INTO sach_tacGia (maSach, maTG) 
VALUES
    ('S001', 'TG001'),
    ('S002', 'TG002'),
    ('S003', 'TG003'),
    ('S004', 'TG004'),
    ('S005', 'TG005');

INSERT INTO nganhHoc (maNganh, tenNganh) 
VALUES
    ('CNTT', 'Công nghệ thông tin'),
    ('QTKD', 'Quản trị kinh doanh'),
    ('NNAnh', 'Ngôn ngữ Anh'),
    ('VCH', 'Văn hóa học'),
    ('KTD', 'Kỹ thuật điện');

INSERT INTO lop (maLop, tenLop, maNganh)
VALUES
    ('CTT01', 'CNTT1', 'CNTT'),
    ('QTKD01', 'QTKD1', 'QTKD'),
    ('NNAnh01', 'NNAnh1', 'NNAnh'),
    ('VCH01', 'VCH1', 'VCH'),
    ('KTD01', 'KTD1', 'KTD');

INSERT INTO sinhVien (maSV, maLop, hoTen, diaChi, email, sdt, ngaySinh, ngayHetHan) 
VALUES
    ('SV001', 'CTT01', 'Nguyễn Văn Anh', 'Hà Nội', 'vana@gmail.com', '0987654321', '2000-01-15', '2024-01-15'),
    ('SV002', 'QTKD01', 'Trần Thị Bưởi', 'Hồ Chí Minh', 'tranb@gmail.com', '0912345678', '2000-02-20', '2024-02-20'),
    ('SV003', 'NNAnh01', 'Lê Văn Cao', 'Đà Nẵng', 'lec@gmail.com', '0987123456', '2000-03-25', '2024-03-25'),
    ('SV004', 'VCH01', 'Phạm Thị Dương', 'Hà Nội', 'phamd@gmail.com', '0978234567', '2000-04-10', '2024-04-10'),
    ('SV005', 'KTD01', 'Hoàng Văn Đạt', 'TP HCM', 'hoange@gmail.com', '0912378965', '2000-05-05', '2024-05-05');

INSERT INTO phieuMuon (maPhieu, maSV, ngayMuon) 
VALUES
    ('PM001', 'SV001', '2017-01-15'),
    ('PM002', 'SV002', '2017-01-18'),
    ('PM003', 'SV003', '2017-01-20'),
    ('PM004', 'SV004', '2017-01-22'),
    ('PM005', 'SV005', '2017-01-25');

INSERT INTO CTPhieuMuon (maSach, maPhieu, soLuong) 
VALUES
    ('S001', 'PM001', 21),
    ('S002', 'PM001', 31),
    ('S003', 'PM002', 13),
    ('S004', 'PM002', 24),
    ('S005', 'PM003', 19);

SELECT * FROM theLoai
SELECT * FROM sach
SELECT * FROM tacGia
SELECT * FROM sach_tacGia
SELECT * FROM nganhHoc
SELECT * FROM lop
SELECT * FROM sinhVien
SELECT * FROM phieuMuon
SELECT * FROM CTPhieuMuon

--6.1 Liệt kê tất cả thông tin của các đầu sách gồm tên sách, mã sách, giá tiền, tác giả thuộc loại sách có mã “IT”.
	SELECT s.tieuDe, s.maSach, s.giaTien, s.tacGia
	FROM sach s
	JOIN theLoai tl ON s.maTL = tl.maTL
	WHERE tl.maTL = 'IT';

--6.2 Liệt kê các phiếu mượn gồm các thông tin mã phiếu mượn, mã sách, ngày mượn, mã sinh viên có ngày mượn trong tháng 01/2017.
	SELECT phieuMuon.maPhieu, maSach, ngayMuon, maSV 
	FROM phieuMuon
	JOIN CTPhieuMuon on phieuMuon.maPhieu = CTPhieuMuon.maPhieu
	WHERE MONTH(ngayMuon)= 1 AND YEAR(ngayMuon)=2017


--6.3 Liệt kê các phiếu mượn chưa trả sách cho thư viện theo thứ tự tăng dẫn của ngày mượn sách.
	SELECT phieuMuon.maPhieu, sinhVien.hoTen, phieuMuon.ngayMuon
	FROM phieuMuon phieuMuon
	JOIN sinhVien sinhVien 
	ON phieuMuon.maSV = sinhVien.maSV
	WHERE phieuMuon.maPhieu 
	NOT IN (SELECT maPhieu FROM CTPhieuMuon)
	ORDER BY phieuMuon.ngayMuon;

--6.4 Liệt kê tổng số đầu sách của mỗi loại sách (gồm mã loại sách, tên loại sách, tổng số lượng sách mỗi loại).
	SELECT SACH.MATL, TENTL, SUM(soLuongBS) AS TONGSL
	FROM THELOAI INNER JOIN SACH
	ON THELOAI.MATL = SACH.MATL
	GROUP BY SACH.MATL, TENTL

--6.5 Đếm xem có bao nhiêu lượt sinh viên đã mượn sách.
	SELECT COUNT(DISTINCT maSV) AS soLuotMuon
	FROM phieuMuon;

--6.6 Hiển thị tất cả các quyển sách có tiêu đề chứa từ khoá “SQL”.
	SELECT maSach, tieuDe
	FROM sach
	WHERE tieuDe LIKE '%SQL%';

--6.7 Hiển thị thông tin mượn sách gồm các thông tin: mã sinh viên, tên sinh viên, mã phiếu mượn, tiêu đề sách, ngày mượn, ngày trả. Sắp xếp thứ tự theo ngày mượn sách.
	SELECT SINHVIEN.MASV, SINHVIEN.HOTEN, PHIEUMUON.MAPHIEU, SACH.TIEUDE, PHIEUMUON.NGAYMUON,
	GETDATE() AS NGAYTRA
	FROM SINHVIEN 
	INNER JOIN PHIEUMUON
	ON SINHVIEN.MASV = PHIEUMUON.MASV
	INNER JOIN CTPHIEUMUON 
	ON PHIEUMUON.MAPHIEU = CTPHIEUMUON.MAPHIEU
	INNER JOIN SACH 
	ON SACH.MASACH = CTPHIEUMUON.MASACH
	ORDER BY  NGAYMUON

--6.8 Liệt kê các đầu sách có lượt mượn lớn hơn 20 lần.
	SELECT MASACH, COUNT(MASACH) AS LUOTMUON
	FROM CTPHIEUMUON
	GROUP BY MASACH
	HAVING COUNT(MASACH) >= 1

--6.9 Viết câu lệnh cập nhật lại giá tiền của các quyển sách có ngày nhập kho trước năm 2014 giảm 30%.
	UPDATE sach
	SET giaTien = giaTien * 0.7
	WHERE YEAR(ngayNhapKho) < 2014;

	SELECT * FROM sach
--6.10 Viết câu lệnh cập nhật lại trạng thái đã trả sách cho phiếu mượn của sinh viên có mã sinh viên SV001

-- thêm cột vào bảng CTphieuMuon
	ALTER TABLE CTPhieuMuon
	ADD daTraSach bit DEFAULT 0;

	UPDATE CTPhieuMuon
	SET daTraSach = 1
	WHERE maPhieu 
	IN (
	SELECT maPhieu 
	FROM phieuMuon
	WHERE maSV = 'SV001');

	SELECT * FROM CTPhieuMuon

-- 6.11 Lập danh sách các phiếu mượn quá hạn chưa trả trước ngày 2017-01-22 gồm các thông tin: mã phiếu mượn, tên sinh viên, email, danh sách các sách đã mượn, ngày mượn.
SELECT * FROM phieuMuon


--6.12 Viết câu lệnh cập nhật lại số lượng bản sao tăng lên 5 đơn vị đối với các đầu sách có lượt mượn lớn hơn 10.
	UPDATE sach
	SET soLuongBS = soLuongBS + 5
	WHERE maSach IN (
		SELECT maSach
		FROM (
			SELECT CT.maSach, COUNT(CT.maSach) 
			AS soLuotMuon
			FROM CTPhieuMuon CT
			GROUP BY CT.maSach
		) AS LuotMuon
		WHERE LuotMuon.soLuotMuon > 10
	);

	SELECT * FROM sach
--6.13 Viết câu lệnh xoá các phiếu mượn có ngày mượn và ngày trả trước 2017-01-20
---XOA FK TRUOC PK SAU

-- Xoá bản ghi từ bảng chi tiết phiếu mượn (CTPhieuMuon) dựa trên các phiếu mượn có ngày trước 2017-01-20
DELETE FROM CTPhieuMuon
WHERE maPhieu IN (
    SELECT maPhieu
    FROM phieuMuon
    WHERE ngayMuon < '2017-01-20'
);

-- Xoá bản ghi từ bảng phiếu mượn (phieuMuon) dựa trên ngày mượn và ngày trả trước 2017-01-20
DELETE FROM phieuMuon
WHERE ngayMuon < '2017-01-20';

-- Sau khi thực hiện xoá, bạn có thể kiểm tra dữ liệu còn lại trong các bảng
SELECT * FROM phieuMuon;
SELECT * FROM CTPhieuMuon;
