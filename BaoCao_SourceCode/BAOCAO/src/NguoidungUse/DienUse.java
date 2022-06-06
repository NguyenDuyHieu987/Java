/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.DienDao;
import Entity.DienObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DienUse {
    DienDao DDao;
    
    public DienUse()
    {
        DDao = new DienDao();
    }
    public int CheckADD(String mahhd)
    {
        return DDao.CheckADD(mahhd);
    }
    public List<DienObject> getALL()
    {
        return DDao.getALL();
    }
    public List<DienObject> GetFromMonth(int month)
    {
        return DDao.getALLFromMonth(month);
    }
    public List<DienObject> GetFromYear(int Year)
    {
        return DDao.getALLFromYear(Year);
    }
    public DienObject getOne(String mahddien)
    {
        return DDao.getOne(mahddien);
    }
    public DienObject getOnebyMahgd(String mahgd)
    {
        return DDao.getOnebyMahgd(mahgd);
    }
    public void ThemHD(DienObject dien)
    {
        DDao.ThemHDDien(dien);
    }
    public void UpdateHD(DienObject dien)
    {
        DDao.UpdateDien(dien);
    }
    public void XoaHD(String mahddien)
    {
        DDao.XoaHDDien(mahddien);
    }
}
