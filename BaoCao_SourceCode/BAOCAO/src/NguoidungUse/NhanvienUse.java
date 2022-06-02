/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguoidungUse;

import Dao.NhanvienDao;
import Entity.NhanvienObject;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanvienUse {
    NhanvienDao NVDao;
    
    public NhanvienUse()
    {
        NVDao = new NhanvienDao();
    }
    public int CheckADD(String manv)
    {
        return NVDao.CheckADD(manv);
    }
    public List<NhanvienObject> getALL()
    {
        return NVDao.getALL();
    }
    public NhanvienObject getOne(String manv)
    {
        return NVDao.GetOne(manv);
    }
    public void ThemNV(NhanvienObject nv)
    {
        NVDao.Themnv(nv);
    }
    public void UpdateNV(NhanvienObject nv)
    {
        NVDao.UpdateNV(nv);
    }
    public void XoaNV(String manv)
    {
        NVDao.XoaNV(manv);
    }
}
