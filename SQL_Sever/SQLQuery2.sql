create database ASM_JAVA3_DUNGNXPH
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Students](
	[MaSV] [nvarchar](50) NOT NULL,
	[TenSV] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Sdt] [int] NULL,
	[gioitinh] [bit] NULL,
	[diachi] [nvarchar](50) NULL,
	[hinhanh] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Users](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[roles] [nvarchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Grade](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[MaSV] [nvarchar](50) NOT NULL,
	[TinHoc] [float] NULL,
	[GDTC] [float] NULL,
	[tienganh] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Grade]  WITH CHECK ADD  CONSTRAINT [FK_Grade_Students] FOREIGN KEY([MaSV])
REFERENCES [dbo].[Students] ([MaSV])
GO

ALTER TABLE [dbo].[Grade] CHECK CONSTRAINT [FK_Grade_Students]
GO

INSERT INTO Students(MaSV, TenSV, Email, Sdt, gioitinh, diachi, hinhanh)
VALUES ('SV001', 'NGUYEN XUAN DUNG', 'dungnx@gmail.com','0123456789',1,'NGHE AN', 'Anh1.jpg'),
		('SV002', 'LE VAN LUONG ', 'luonglv@gmail.com','0234567891',1,'HA NOI', 'Anh2.jpg'),
		('SV003', 'HOANG THI THAO', 'thaoht@gmail.com','0345678912',0,'NGHE AN', 'Anh3.jpg'),
		('SV004', 'TRAN VAN ANH', 'anhtv@gmail.com','0456789123',1,'NGHE AN', 'Anh4.jpg'),
		('SV005', 'NGUYEN  THU PHUONG', 'phuongnt@gmail.com','0567891234',0,'THAI BINH', 'Anh5.jpg');

INSERT INTO Users(username , password, roles)
VALUES	('nguyenxuandung', '12345',N'Giảng Viên'),
		('levanluong', '45678',N'đào tạo'),
		('hoangthithao', 'abcde',N'Giảng Viên'),
		('tranhvananh', '12345',N'Giảng Viên'),
		('admin', '12345',N'đào tạo');
INSERT INTO Grade(MaSV, TinHoc,  GDTC, tienganh)
VALUES	('SV001' , 9, 9,9),
		('SV002' , 7, 7,7),
		('SV003' , 8, 8, 8),
		('SV004' , 6, 6, 6),
		('SV005' , 10, 10, 10);