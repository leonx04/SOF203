CREATE TABLE VanPhong (
  MaSoVanPhong INT PRIMARY KEY,
  DiaDiemTruSo VARCHAR(255)
);

CREATE TABLE NhanVien (
  MaSoNhanVien INT PRIMARY KEY,
  MaSoVanPhong INT,
  TenNhanVien VARCHAR(255),
  FOREIGN KEY (MaSoVanPhong) REFERENCES VanPhong(MaSoVanPhong)
);
CREATE TABLE TruongPhong(
	MaTruongPhong INT PRIMARY KEY,
	Ten NVARCHAR(40) NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	FOREIGN KEY (MaTruongPhong) REFERENCES VanPhong(MaSoVanPhong) 
)
CREATE TABLE ThanNhan (
  MaSoThanNhan INT PRIMARY KEY,
  MaSoNhanVien INT,
  TenThanNhan VARCHAR(255),
  NgaySinh DATE,
  MoiLienHe VARCHAR(255),
  FOREIGN KEY (MaSoNhanVien) REFERENCES NhanVien(MaSoNhanVien)
);

CREATE TABLE BatDongSan (
  MaSoBDS INT PRIMARY KEY,
  MaSoVanPhong INT,
  DiaChi VARCHAR(255),
  FOREIGN KEY (MaSoVanPhong) REFERENCES VanPhong(MaSoVanPhong)
);

CREATE TABLE ChuSoHuu (
  MaSoChuSoHuu INT PRIMARY KEY,
  TenChuSoHuu VARCHAR(255),
  DiaChi VARCHAR(255),
  SoDienThoai VARCHAR(20),
  MaSoBDS INT,
  FOREIGN KEY (MaSoBDS) REFERENCES BatDongSan(MaSoBDS)
);
