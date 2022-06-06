/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.HGDDao;
import Entity.HGDObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HGDsevice {
    private HGDDao dDao ;
    
    public HGDsevice()
    {
        dDao = new HGDDao();
    }
    public int CheckADD(String mahgd)
    {
        return dDao.CheckADD(mahgd);
    }
    public List<HGDObject> getALL()
    {
        return dDao.getALL();
    }
    public List<HGDObject> getALLBYID(String mahgd)
    {
        return dDao.getALLByID(mahgd);
    }
    public HGDObject getBYID(String mahgd)
    {
        return dDao.getOne(mahgd);
    }
    public void ThemHGD(HGDObject hgd)
    {
        dDao.ThemHGD(hgd);
    }
    public void XoaHGD(String mahgd)
    {
        dDao.XOaHGD(mahgd);
    }
    public void UpdateHGD(HGDObject hgd)
    {
        dDao.UpdateHGD(hgd);
    }
}
