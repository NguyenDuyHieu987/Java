/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.QuanlyKhachsan;

import Interface.DangNhap;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ddom6
 */
public class QuanlyKhachsan {

    public static void main(String[] args) {
        try {
            DangNhap dangNhap = new DangNhap();
            dangNhap.setLocationRelativeTo(null);
            dangNhap.setVisible(true);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(QuanlyKhachsan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
