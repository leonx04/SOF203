-- Tạo bảng LoaiSach
CREATE TABLE LoaiSach (
  MaLoaiSach INT PRIMARY KEY,
  TenLoaiSach NVARCHAR(100) NOT NULL
);

-- Tạo bảng Lop
CREATE TABLE Lop (
  MaLop INT PRIMARY KEY,
  TenLop NVARCHAR(100) NOT NULL
);

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
  MaSinhVien INT PRIMARY KEY,
  TenSinhVien NVARCHAR(100) NOT NULL,
  NgayHetHan DATE,
  ChuyenNganhHoc NVARCHAR(100),
  MaLop INT,
  Email NVARCHAR(100),
  SoDienThoai NVARCHAR(15),
  UNIQUE (Email),
  UNIQUE (SoDienThoai),
  FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);

-- Tạo bảng Sach
CREATE TABLE Sach (
  MaSach INT PRIMARY KEY,
  TieuDe NVARCHAR(100) NOT NULL,
  NhaXuatBan NVARCHAR(100),
  TacGia NVARCHAR(100),
  SoTrang INT CHECK (SoTrang > 5),
  SoLuongBanSao INT CHECK (SoLuongBanSao > 1),
  GiaTien DECIMAL(10, 2) CHECK (GiaTien > 0),
  NgayNhapKho DATE,
  ViTriDatSach NVARCHAR(100),
  MaLoaiSach INT,
  FOREIGN KEY (MaLoaiSach) REFERENCES LoaiSach(MaLoaiSach)
);

-- Tạo bảng PhieuMuonSach
CREATE TABLE PhieuMuonSach (
  SoPhieu INT PRIMARY KEY,
  NgayMuon DATE,
  TenSinhVien NVARCHAR(100) NOT NULL,
  MaSinhVien INT,
  MaLop INT,
  MaSach INT,
  TieuDeSach NVARCHAR(100),
  NhaXuatBan NVARCHAR(100),
  GhiChu NVARCHAR(500),
  FOREIGN KEY (MaSinhVien) REFERENCES SinhVien(MaSinhVien),
  FOREIGN KEY (MaSach) REFERENCES Sach(MaSach),
  FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
);
