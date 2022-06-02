/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.ThanhvienDao;
import Entity.ThanhvienObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Thanhviensevice {
    ThanhvienDao thanhvienDao;
    
    public Thanhviensevice()
    {
        thanhvienDao = new ThanhvienDao();
    }
    public int CheckADD(String matv)
    {
        return thanhvienDao.CheckADD(matv);
    }
    public List<ThanhvienObject> getALL()
    {
        return thanhvienDao.getALL();
    }
    public List<ThanhvienObject> getOnebyMHGD(String mhgd)
    {
        return thanhvienDao.getOnebyMHGD(mhgd);
    }
    public ThanhvienObject getOneByID(String tentv)
    {
        return thanhvienDao.getTVbyID(tentv);
    }
    public ThanhvienObject getOne(String matv)
    {
        return thanhvienDao.getOne(matv);
    }
    public void themTV(ThanhvienObject tv)
    {
        thanhvienDao.themTV(tv);
    }
    public void XoaTV(String matv)
    {
        thanhvienDao.XoaTV(matv);
    }
    public void updateTV(ThanhvienObject tv)
    {
        thanhvienDao.UpdatTV(tv);
    }
}
