/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.CanhoDao;
import Entity.canhoOject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CanhoSevice {
    private final CanhoDao canhoDao;
    
    public CanhoSevice()
    {
        canhoDao = new CanhoDao();
    }
    public int CheckADD(String mach)
    {
        return canhoDao.CheckADD(mach);
    }
    public List<canhoOject> getALLCH()
    {
        return canhoDao.getALL();
    }
    public canhoOject getONE(String mach)
    {
        return canhoDao.getOne(mach);
    }
    public void themCH(canhoOject ch) 
    {
        canhoDao.themCH(ch);
    }
    public void xoaCH(String mach)
    {
        canhoDao.XoaCH(mach);
    }
    public void updateCH(canhoOject ch)
    {
        canhoDao.UpdatCH(ch);
    }
}
