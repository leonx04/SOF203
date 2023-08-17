CREATE TABLE Thuvien (
    MaThuVien INT PRIMARY KEY,
    TenThuVien VARCHAR(100) NOT NULL,
    DiaChi VARCHAR(200),
    SoDienThoai VARCHAR(20)
);
CREATE TABLE LoaiSach (
    MaLoaiSach INT PRIMARY KEY,
    TenLoaiSach VARCHAR(100) NOT NULL
);
CREATE TABLE Sach (
    MaSach INT PRIMARY KEY,
    TieuDe VARCHAR(200) NOT NULL,
    NhaXuatBan VARCHAR(100),
    TacGia VARCHAR(100),
    SoTrang INT ,
    SoLuong INT ,
    GiaTien DECIMAL,
    NgayNhapKho DATE,
    ViTriDatSach VARCHAR(50),
    MaLoaiSach INT,
    FOREIGN KEY (MaLoaiSach) REFERENCES LoaiSach(MaLoaiSach)
);
CREATE TABLE SinhVien (
    MaSinhVien INT PRIMARY KEY,
    TenSinhVien VARCHAR(100) NOT NULL,
    NgayHetHan DATE,
    ChuyenNganhHoc VARCHAR(100),
    Email VARCHAR(100),
    SoDienThoai VARCHAR(20),
);
CREATE TABLE PhieuMuon (
    SoPhieu INT PRIMARY KEY,
    NgayMuon DATE,
    NgayHetHan DATE,
    MaSinhVien INT,
    FOREIGN KEY (MaSinhVien) REFERENCES SinhVien(MaSinhVien)
);
CREATE TABLE ChiTietPhieuMuon (
    SoPhieu INT,
	MaThuVien INT,
    MaSach INT,
    MaLop VARCHAR(50),
    GhiChu VARCHAR(200),
    PRIMARY KEY (SoPhieu, MaSach),
	FOREIGN KEY (MaThuVien) REFERENCES Thuvien(MaThuVien),
    FOREIGN KEY (SoPhieu) REFERENCES PhieuMuon(SoPhieu),
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)
);

