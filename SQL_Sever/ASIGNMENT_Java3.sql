
CREATE TABLE users(
	username  NVARCHAR(20)  PRIMARY KEY,
	password INT not null,
	role nvarchar(20)
)


CREATE  TABLE students(
	masinhvien  nvarchar(40)  primary  key ,
	hoten nvarchar(50),
	email  nvarchar(50),
	sodienthoai  int ,
	gioitinh nvarchar(20),
	diachi nvarchar(50),
	hinh image
)

CREATE TABLE  grade(
	id NVARCHAR(20)  primary key,
	masinhvien nvarchar(40)  foreign key  references students(masinhvien),
	tienganh  nvarchar(50) ,
	tinhoc  nvarchar(50),
	giaoducthechat nvarchar(50)
)