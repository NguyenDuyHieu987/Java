/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.HoadonDao;
import Entity.HoadonObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoadonUse {
    private HoadonDao hdDao;
    
    public HoadonUse()
    {
        hdDao = new HoadonDao();
    }
    public List<HoadonObject> getALL()
    {
        return hdDao.getALL();
    }
    public List<HoadonObject> GetWMonth(int month)
    {
        return hdDao.getALLwMoth(month);
    }
    public List<HoadonObject> GetWYear(int year)
    {
        return hdDao.getALLwYear(year);
    }
    public void ThemHD(HoadonObject hd)
    {
        hdDao.ThemHD(hd);
    }
}
