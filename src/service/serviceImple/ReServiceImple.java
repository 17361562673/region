/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:ReServiceImple
 * Time:2019/10/1711:38
 * Description:
 */
package service.serviceImple;

import dao.ReDao;
import dao.daoImple.ReDaoImple;
import model.Region;
import service.ReService;

import java.util.List;

public class ReServiceImple implements ReService {
    ReDao dao=new ReDaoImple();
    @Override
    public List<Region> getRListByPid(Integer pid) {
        return dao.getRListByPid(pid);
    }
}
