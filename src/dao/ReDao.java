package dao;

import model.Region;

import java.util.List;

public interface ReDao {
    public List<Region> getRListByPid(Integer pid);
}
