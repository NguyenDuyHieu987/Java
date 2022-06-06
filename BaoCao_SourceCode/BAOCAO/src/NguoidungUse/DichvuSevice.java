/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.DichvuDao;
import Entity.DichvuObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DichvuSevice {
    private DichvuDao dichVuDao;
    
    public  DichvuSevice()
    {
        dichVuDao = new DichvuDao();
    }
    public int CheckADD(String madv)
    {
        return dichVuDao.CheckADD(madv);
    }
    public List<DichvuObject> getALL()
    {
        return dichVuDao.getALL();
    }
    public List<DichvuObject> getALLbyID(String tendv)
    {
        return dichVuDao.getDVbyID(tendv);
    }
    public DichvuObject getOne(String mdv)
    {
        return dichVuDao.getOne(mdv);
    }
    public void ThemDV(DichvuObject dv)
    {
        dichVuDao.themCH(dv);
    }
    public void XoaDv(String madv)
    {
        dichVuDao.XoaCH(madv);
    }
    public void UpdateDv(DichvuObject dv)
    {
        dichVuDao.UpdatCH(dv);
    }
}
