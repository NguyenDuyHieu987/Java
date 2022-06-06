CREATE DATABASE QuanlyKhachsan

DROP DATABASE QuanlyKhachsan

USE QuanlyKhachsan

CREATE TABLE DangNhap(
    TaiKhoan VARCHAR(30) NOT NULL,
    MatKhau VARCHAR(300) NOT NULL,
    CONSTRAINT Pr_key PRIMARY KEY (TaiKhoan,MatKhau),
    Quyen  VARCHAR(30),
    NhoMatKhau BIT
)


DROP TABLE DangNhap

SELECT * FROM DangNhap

INSERT INTO DangNhap(TaiKhoan, MatKhau, Quyen, NhoMatKhau) VALUES
    ('duyhieu', 'hvlKxczGhIC8bYRiUfesaA==', 'ADMIN', 0),
    ('nhanvien', '9Q8qqDCOK9jEZZyKmmi/MQ==', 'USER', 0);



CREATE TABLE NhanVien(
    MaNV VARCHAR(10) PRIMARY KEY,
    TenNV NVARCHAR(100),
    GioiTinh NVARCHAR(3),
    NgaySinh DATE,
    DiaChi NVARCHAR(100),
    SDT INT,
    CMND INT,
    Luong FLOAT
)

DROP TABLE NhanVien

SELECT * FROM NhanVien

INSERT INTO NhanVien(MaNV, TenNV, GioiTinh, NgaySinh, DiaChi, SDT, CMND, Luong) VALUES
    ('NV01', N'Nguyễn Duy Hiếu', N'Nam', '2002-11-07', N'Hà Nội', 123456789, 0924100592, 5000000),
    ('NV02', N'Nguyễn Duy Tâm', N'Nam', '1996-12-15', N'Hồ Chí Minh',987654321, 0956023497, 6000000),
    ('NV03', N'Nguyễn Thị Liên', N'Nữ', '2002-09-26', N'Hà Nội', 235455898, 0345474567, 7000000);

CREATE TABLE Phong(
    MaPhong VARCHAR(10) PRIMARY KEY,
    TenPhong NVARCHAR(100),
    DienTich VARCHAR(20),
    TienNghi NVARCHAR(300),
    Gia FLOAT,
    TrangThai NVARCHAR(20)
)

DROP TABLE Phong

SELECT * FROM Phong

INSERT INTO Phong(MaPhong, TenPhong, DienTich, TienNghi, Gia, TrangThai) VALUES
    ('PH01', N'Phòng 01', '30m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tivi, Máy giặt', 300000, N'Chưa thuê'),
    ('PH02', N'Phòng 02', '30m2', N'Điều hòa, Nóng lạnh, Tivi, Tủ lạnh, Máy giặt', 300000, N'Chưa thuê'),
    ('PH03', N'Phòng 03', '40m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tủ lạnh, Máy giặt', 400000, N'Chưa thuê'),
    ('PH04', N'Phòng 04', '35m2', N'Điều hòa, Nóng lạnh, Tủ lạnh, Máy giặt', 350000, N'Chưa thuê'),
    ('PH05', N'Phòng 05', '30m2', N'Điều hòa, Nóng lạnh, Tivi,  Máy giặt', 300000, N'Chưa thuê'),
    ('PH06', N'Phòng 06', '40m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 400000, N'Chưa thuê'),
    ('PH07', N'Phòng 07', '35m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 400000, N'Chưa thuê'),
    ('PH08', N'Phòng 08', '30m2', N'Điều hòa, Nóng lạnh, Tivi, Tủ lạnh, Máy giặt', 300000, N'Chưa thuê'),
    ('PH09', N'Phòng 09', '30m2', N'Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 300000, N'Chưa thuê'),
    ('PH10', N'Phòng 10', '30m2', N'Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 350000, N'Chưa thuê'),
    ('PH11', N'Phòng 11', '35m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 450000, N'Chưa thuê'),
    ('PH12', N'Phòng 12', '40m2', N'Điều hòa, Nóng lạnh, Bồn ngâm, Tivi, Tủ lạnh, Máy giặt', 500000, N'Chưa thuê');

CREATE TABLE KhachHang(
    MaKH VARCHAR(10) PRIMARY KEY,
    TenKH NVARCHAR(100),
    SDT INT,
    DiaChi NVARCHAR(100),
    GioiTinh NVARCHAR(3)
)

DROP TABLE KhachHang

SELECT * FROM KhachHang

INSERT INTO KhachHang(MaKH, TenKH, SDT, DiaChi, GioiTinh) VALUES
    ('KH01', N'Nguyễn Duy Hiếu', 11111111, N'Hà Nội', N'Nam');

CREATE TABLE ThuePhong(
    MaThue VARCHAR(10) PRIMARY KEY,
    MaPhong VARCHAR(10) NOT NULL,
    MaKH VARCHAR(10) NOT NULL,
    CONSTRAINT Fr_Maphong FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
	CONSTRAINT Fr_MaKH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    NgayBD DATE,
    NgayKT DATE,
    TongTien FLOAT,
    TrangThai NVARCHAR(20)
)

DROP TABLE ThuePhong

SELECT * FROM ThuePhong

INSERT INTO ThuePhong(MaThue, MaPhong, MaKH, NgayBD, NgayKT, TongTien, TrangThai) VALUES
    ('THUE01', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Chưa thanh toán'),
    ('THUE02', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Chưa thanh toán'),
    ('THUE03', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Chưa thanh toán'),
    ('THUE04', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Đã thanh toán'),
    ('THUE05', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Đã thanh toán'),
    ('THUE06', 'PH12', 'KH01',  '2022-06-01', '2022-06-11', 0, N'Đã thanh toán');

SELECT SUM()

SELECT KhachHang.* 
    FROM ThuePhong, KhachHang 
    WHERE KhachHang.MaKH = ThuePhong.MaKH
    AND ThuePhong.TrangThai = N'Chưa thanh toán';

SELECT KhachHang.* 
    FROM ThuePhong, KhachHang 
    WHERE KhachHang.MaKH = ThuePhong.MaKH
    AND ThuePhong.MaThue = 'THUE05';

SELECT ThuePhong.* 
    FROM ThuePhong, KhachHang 
    WHERE KhachHang.MaKH = ThuePhong.MaKH
    AND KhachHang.MaKH = 'KH01';

SELECT ThuePhong.* 
    FROM ThuePhong, Phong 
    WHERE ThuePhong.MaPhong = Phong.MaPhong 
    AND Phong.MaPhong = 'KH01';

SELECT KhachHang.MaKH 
    FROM ThuePhong, Phong, KhachHang
    WHERE ThuePhong.MaPhong = Phong.MaPhong AND KhachHang.MaKH = ThuePhong.MaKH
    AND ThuePhong.MaPhong = 'KH01';

DELETE FROM ThuePhong WHERE MaThue = 'THUE01';

GO
--- Trả phòng cập nhật trạng thái trả tiền, trạng thái phòng



CREATE PROC TraPhong
@MaThue VARCHAR(10) AS
BEGIN
    UPDATE ThuePhong
        SET TrangThai = N'Đã thanh toán'
        WHERE MaThue = @MaThue
	UPDATE Phong 
		SET TrangThai = N'Chưa thuê'
		WHERE MaPhong = (SELECT MaPhong FROM ThuePhong WHERE MaThue = @MaThue)
END

EXEC TraPhong @MaThue = 'THUE01';

DROP PROC TraPhong

GO
--- Thuê phòng cập nhật trạng thái phòng, tổng tiền

CREATE TRIGGER Trigger_Insert_Phong ON ThuePhong FOR INSERT 
AS 
BEGIN
    DECLARE @TongTien FLOAT;
    SELECT @TongTien = Gia FROM Phong WHERE MaPhong = (SELECT MaPhong FROM INSERTED)

	UPDATE Phong 
		SET TrangThai = N'Đã thuê'
		WHERE MaPhong = (SELECT MaPhong FROM INSERTED)

    UPDATE ThuePhong 
		SET TongTien = @TongTien * (SELECT DATEDIFF(DAY, NgayBD, NgayKT) FROM INSERTED)
		WHERE MaPhong = (SELECT MaPhong FROM INSERTED)
END

DROP TRIGGER Trigger_Insert_Phong


--- Sửa phòng cập nhật thuê phòng
GO

CREATE PROC CapNhatGia_Phong
@TenPhong NVARCHAR(100),
@DienTich  VARCHAR(20),
@TienNghi  NVARCHAR(300),
@Gia FLOAT,
@TrangThai  NVARCHAR(20),
@MaPhong VARCHAR(10) AS
BEGIN
    UPDATE Phong 
		SET TenPhong = @TenPhong , DienTich = @DienTich , TienNghi = @TienNghi,
         Gia = @Gia, TrangThai = @TrangThai
        WHERE MaPhong = @MaPhong;

	UPDATE ThuePhong 
		SET TongTien = @Gia
		WHERE MaPhong = @MaPhong
END

DROP PROC CapNhatGia_Phong

--- Sửa thuê cập nhật phòng, khách hàng
GO

CREATE PROC CapNhatPhong_KhiSua
@MaPhong_new  VARCHAR(10),
@MaPhong_old VARCHAR(10),
@NgayBD DATE,
@NgayKT DATE,
@MaThue VARCHAR(10) AS
BEGIN
    UPDATE ThuePhong 
        SET MaPhong = @MaPhong_new, NgayBD = @NgayBD, NgayKT = @NgayKT
        WHERE MaThue = @MaThue

    UPDATE Phong 
        SET TrangThai = N'Chưa thuê'
        WHERE MaPhong = @MaPhong_old

    UPDATE Phong 
        SET TrangThai = N'Đã thuê'
        WHERE MaPhong = @MaPhong_new
END

DROP PROC CapNhatPhong_KhiSua

EXEC CapNhatPhong_KhiSua @MaPhong_new = 'PH01', @NgayBD ='2022-06-01', @NgayKT ='2022-06-11', @MaThue='THUE01';

--- Xóa thuê cập nhật khách hàng
GO

CREATE TRIGGER Trigger_Delete_ThuePhong ON ThuePhong FOR DELETE 
AS 
BEGIN

	DECLARE @MaKH VARCHAR(10);

	SELECT @MaKH = MaKH FROM DELETED

        DELETE FROM KhachHang WHERE MaKH = @MaKH
END

DROP TRIGGER Trigger_Delete_ThuePhong


-------------------------------------------------
CREATE TABLE ThongKe(
    MaThongKe VARCHAR(10) PRIMARY KEY,
    -- MaThue VARCHAR(10) NOT NULL ,
    -- CONSTRAINT Fr_MaThue FOREIGN KEY (MaThue) REFERENCES ThuePhong(MaThue),
    TenThongKe NVARCHAR(100),
    GhiChu NVARCHAR(1000),
    DoanhThu FLOAT,
)

SELECT SUM(TongTien)
	From ThuePhong
	WHERE MONTH(NgayBD) = 6 AND  MONTH(NgayKT) = 6 AND TrangThai = N'Đã thanh toán';

SELECT SUM(TongTien)
	From ThuePhong
	WHERE YEAR(NgayBD) = 2022 AND  YEAR(NgayKT) = 2022 AND TrangThai = N'Đã thanh toán';

INSERT INTO ThongKe (MaThongKe, TenThonKe, GhiChu, DoanhThu) VALUES

SELECT * FROM ThongKe

DROP TABLE ThongKe
