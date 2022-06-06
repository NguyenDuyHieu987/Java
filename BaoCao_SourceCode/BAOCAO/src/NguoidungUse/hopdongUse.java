/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.HopdongDao;
import Entity.HopdongObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hopdongUse {
    
    private HopdongDao HDDao;
    
    public hopdongUse()
    {
        HDDao = new HopdongDao();
    }
    public int CheckADD(String mahd)
    {
        return HDDao.CheckADD(mahd);
    }
    public List<HopdongObject> GetALL()
    {
        return HDDao.getALL();
    }
    public HopdongObject getOne(String mahd)
    {
        return HDDao.getOne(mahd);
    }
    public HopdongObject getOnebymaHGD(String mahgd)
    {
        return HDDao.getOneByHGD(mahgd);
    }
    public void themHD(HopdongObject hd)
    {
        HDDao.themHD(hd);
    }
    public void UpdateHD(HopdongObject hd)
    {
        HDDao.updateHD(hd);
    }
    public void XoaHD(String mahd)
    {
        HDDao.XoaHD(mahd);
    }
}
