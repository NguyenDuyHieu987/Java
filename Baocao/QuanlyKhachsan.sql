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




CREATE TABLE DichVu(
    TenDichVu NVARCHAR(100) PRIMARY KEY,
    GiaTrenGio FLOAT,
)

DROP TABLE DichVu

SELECT * FROM DichVu

INSERT INTO DichVu(TenDichVu, GiaTrenGio) VALUES
    (N'Karaoke', 50000),
    (N'Dặt ủi và dọn dẹp phòng', 50000),
    (N'Giữ trẻ', 50000);




CREATE TABLE DichVuDaThue(
    MaThue VARCHAR(10) NOT NULL,
    TenDichVu  NVARCHAR(100) NOT NULL,
	CONSTRAINT Fr_MaThue FOREIGN KEY (MaThue) REFERENCES ThuePhong(MaThue),
    CONSTRAINT Fr_TenDichVu FOREIGN KEY (TenDichVu) REFERENCES DichVu(TenDichVu),
    CONSTRAINT Pr_MaDVdathue PRIMARY KEY(MaThue, TenDichVu),
    SoGio INT,
    TongTien FLOAT
)

DROP TABLE DichVuDaThue

SELECT * FROM DichVuDaThue

-- INSERT INTO DichVuDaThue(MaThue, TenDichVu, SoGio, TongTien) VALUES


UPDATE DichVuDaThue SET SoGio =  SoGio + 10 WHERE MaThue = 'THUE01' AND TenDichVu = N'Giữ trẻ'

------- Cập nhật tổng tiền của dịch vụ đã thuê
GO

CREATE PROC CapNhatTongTienDichVu
@MaThue VARCHAR(10),
@TenDichVu  NVARCHAR(100) AS
BEGIN
    UPDATE DichVuDaThue
        SET TongTien = SoGio * (SELECT GiaTrenGio FROM DichVu WHERE TenDichVu = @TenDichVu)
        WHERE MaThue = @MaThue AND TenDichVu = @TenDichVu
    
    UPDATE ThuePhong 
        SET TongTien = TongTien + (SELECT SUM(TongTien) 
                                        FROM DichVuDaThue 
                                        WHERE MaThue = @MaThue)
        WHERE MaThue = @MaThue

END

EXEC CapNhatTongTienDichVu @MaThue = 'THUE01', @TenDichVu = 'Karaoke';

DROP PROC CapNhatTongTienDichVu




CREATE TABLE DoDungTrongPhong(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MaPhong VARCHAR(10) NOT NULL,
    CONSTRAINT Fr_MaPhong_DoDung FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong),
    TenDo NVARCHAR(100) NOT NULL,
    CONSTRAINT Fr_TenDo_DoDung FOREIGN KEY (TenDo) REFERENCES DoDung(TenDo),
    SoLuong INT
)

DROP TABLE DoDungTrongPhong

SELECT * FROM DoDungTrongPhong

INSERT INTO DoDungTrongPhong(MaPhong, TenDo, SoLuong) VALUES
    ('PH12', 'Tivi', 66);


CREATE TABLE DoDung (
    TenDo NVARCHAR(100) PRIMARY KEY,
    DonGia FLOAT,
)

DROP TABLE DoDung

SELECT * FROM DoDung

INSERT INTO DoDung(TenDo, DonGia) VALUES
    (N'Tivi', 5000000),
    (N'Tủ lạnh', 6000000),
    (N'Máy giặt', 4000000),
    (N'Bếp từ', 2000000),
    (N'Vòi sen', 300000),
    (N'Bồn cầu', 5000000),
    (N'Chăn', 700000),
    (N'Đệm', 1000000),
    (N'Gương trang điểm', 400000),
    (N'Gương nhà tắm', 500000),
    (N'Máy sấy', 450000),
    (N'Gối', 200000),
    (N'Cốc', 50000),
    (N'Ghế', 400000);


CREATE TABLE DoDungHongMat(
    MaThue VARCHAR(10) NOT NULL,
    TenDo  NVARCHAR(100) NOT NULL,
	CONSTRAINT Fr_MaThue2 FOREIGN KEY (MaThue) REFERENCES ThuePhong(MaThue),
    CONSTRAINT Fr_TenDo FOREIGN KEY (TenDo) REFERENCES DoDungTrongPhong(TenDo),
    CONSTRAINT Pr_MaDoHongMat PRIMARY KEY(MaThue, TenDo),
    SoLuong INT,
    TongTien FLOAT
)

DROP TABLE DoDungHongMat

SELECT * FROM DoDungHongMat

-- INSERT INTO DoDungHongMat(MaThue, TenDo, SoLuong, TongTien) VALUES


------- Cập nhật tổng tiền của đồ làm mất, hỏng
GO

CREATE PROC CapNhatTongTienDoMatHong
@MaThue VARCHAR(10),
@TenDo  NVARCHAR(100) AS
BEGIN
    UPDATE DoDungHongMat
        SET TongTien = SoLuong * (SELECT DonGia FROM DoDungTrongPhong WHERE TenDo = @TenDo)
        WHERE MaThue = @MaThue AND TenDo = @TenDo

        UPDATE ThuePhong
            SET TongTien = TongTien + (SELECT SUM(TongTien) 
                                                FROM DoDungHongMat 
                                                WHERE MaThue = @MaThue)
            WHERE MaThue = @MaThue
END



EXEC CapNhatTongTienDoMatHong @MaThue = 'THUE01', @TenDo = 'Ghế';

DROP PROC CapNhatTongTienDoMatHong

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
    
    DELETE FROM DichVuDaThue WHERE MaThue = @MaThue
    DELETE FROM DoDungHongMat WHERE MaThue = @MaThue

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
		WHERE MaThue = (SELECT MaThue FROM INSERTED)
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
		SET TongTien = TongTien + ( @Gia * (SELECT DATEDIFF(DAY, NgayBD, NgayKT)))
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

--- Xóa thuê phòng cập nhật khách hàng
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

-- INSERT INTO ThongKe (MaThongKe, TenThonKe, GhiChu, DoanhThu) VALUES

SELECT * FROM ThongKe

DROP TABLE ThongKe
