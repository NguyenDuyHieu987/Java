CREATE DATABASE QuanlyKhachsan

USE QuanlyKhachsan

CREATE TABLE DangNhap(
    ID VARCHAR(10) PRIMARY KEY,
    TaiKhoan VARCHAR(30),
    MatKhau VARCHAR(30),
    Quyen  VARCHAR(30)
)

DROP TABLE DangNhap

SELECT * FROM DangNhap

INSERT INTO DangNhap(ID, TaiKhoan, MatKhau, Quyen) VALUES
    ('TK01', 'duyhieu', '123', 'ADMIN'),
    ('TK02', 'nhanvien', '234', 'USER');