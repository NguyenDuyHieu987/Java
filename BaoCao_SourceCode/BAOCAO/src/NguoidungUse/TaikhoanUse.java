/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.TaikhoanDao;
import Entity.TaikhoanObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TaikhoanUse {
    TaikhoanDao TKDao;
    
    public TaikhoanUse()
    {
        TKDao = new TaikhoanDao();
    }
    public int CheckADD(int ID)
    {
        return TKDao.CheckADD(ID);
    }
    public List<TaikhoanObject> getALL()
    {
        return TKDao.getALL();
    }
    public TaikhoanObject getOne(int ID)
    {
        return TKDao.getOne(ID);
    }
    public List<TaikhoanObject> GetTKMK(String tendn, String mk)
    {
        return TKDao.GetTK(tendn, mk);
    }
    public void themTK(TaikhoanObject tk)
    {
        TKDao.themTK(tk);
    }
    public void Update(TaikhoanObject tk)
    {
        TKDao.UpdateTK(tk);
    }
    public void XoaTK(String manv)
    {
        TKDao.XoaTK(manv);
    }
}
