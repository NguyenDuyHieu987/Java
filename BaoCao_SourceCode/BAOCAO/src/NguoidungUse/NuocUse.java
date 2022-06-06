/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;


import Dao.NuocDao;
import Entity.DienObject;
import Entity.NuocObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NuocUse {
    NuocDao NcDao;
    
    public NuocUse()
    {
        NcDao = new NuocDao();
    }
    public List<NuocObject> getALL()
    {
        return NcDao.getALL();
    }
    public int CheckADD(String mahhnc)
    {
        return NcDao.CheckADD(mahhnc);
    }
    public List<NuocObject> getFromMonth(int month)
    {
        return NcDao.getALLFromMonth(month);
    }
    public List<NuocObject> getFromYear(int year)
    {
        return NcDao.getALLFromYear(year);
    }
    public NuocObject getOne(String mahdnc)
    {
        return NcDao.getOne(mahdnc);
    }
    public NuocObject getOnebyMahgd(String mahgd)
    {
        return NcDao.getOnebyMahgd(mahgd);
    }
    public void ThemHD(NuocObject nc)
    {
        NcDao.ThemHDNC(nc);
    }
    public void UpdateHD(NuocObject nc)
    {
        NcDao.UpdateNc(nc);
    }
    public void XoaHD(String mahdnc)
    {
        NcDao.XoaHDNC(mahdnc);
    }
}
