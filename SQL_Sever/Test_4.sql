CREATE TABLE LoaiSach (
    MaLoaiSach INT PRIMARY KEY,
    TenLoaiSach VARCHAR(255) NOT NULL
);

CREATE TABLE Sach (
    MaSach INT PRIMARY KEY,
    TieuDe VARCHAR(255) NOT NULL,
    NhaXuatBan VARCHAR(255) NOT NULL,
    TacGia VARCHAR(255) NOT NULL,
    SoTrang INT CHECK (SoTrang > 5),
    SoLuong INT CHECK (SoLuong > 1),
    GiaTien DECIMAL(10, 2) CHECK (GiaTien > 0),
    NgayNhap DATE,
    ViTri VARCHAR(100),
    MaLoaiSach INT,
    FOREIGN KEY (MaLoaiSach) REFERENCES LoaiSach(MaLoaiSach)
);

CREATE TABLE TheSinhVien (
    MaThe INT PRIMARY KEY,
    TenSinhVien VARCHAR(255) NOT NULL,
    MaSinhVien VARCHAR(10) NOT NULL,
    NgayHetHan DATE,
    ChuyenNganhHoc VARCHAR(100),
    Email VARCHAR(255),
    SoDienThoai VARCHAR(15)
);

CREATE TABLE PhieuMuonSach (
    SoPhieu INT PRIMARY KEY,
    NgayMuon DATE,
    MaThe INT,
    MaLop VARCHAR(10),
    MaSach INT,
    GhiChu VARCHAR(255),
    FOREIGN KEY (MaThe) REFERENCES TheSinhVien(MaThe),
    FOREIGN KEY (MaSach) REFERENCES Sach(MaSach)
);
