package sy.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.IBaseDao;
import sy.service.IUserService;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 * Created by shui on 2014/11/14.
 */
@Service("baseService")
public class BaseServiceImpl<T> implements IUserService<T> {

    private static final Logger logger = Logger.getLogger(BaseServiceImpl.class);

    private IBaseDao<T> baseDao;

    public IBaseDao getbaseDao() {
        return baseDao;
    }

    @Autowired
    public void setbaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void test() {
        logger.warn("logger打印成功");
    }

    @Override
    public Serializable save(T t) {
        return baseDao.save(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public T getById(Class<T> c, Serializable id) {
        return baseDao.getById(c,id);
    }

    @Override
    public T getByHql(String hql) {
        return baseDao.getByHql(hql);
    }

    @Override
    public T getByHql(String hql, Map<String, Object> params) {
        return baseDao.getByHql(hql,params);
    }

    @Override
    public List<T> find(String hql) {
        return baseDao.find(hql);
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        return baseDao.find(hql,params);
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        return baseDao.find(hql,page,rows);
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        return baseDao.find(hql,params,page,rows);
    }

    @Override
    public Long count(String hql) {
        return baseDao.count(hql);
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        return baseDao.count(hql,params);
    }

    @Override
    public int executeHql(String hql) {
        return baseDao.executeHql(hql);
    }

    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        return baseDao.executeHql(hql,params);
    }

    @Override
    public List<Map> findBySql(String sql) {
        return baseDao.findBySql(sql);
    }

    @Override
    public List<Map> findBySql(String sql, int page, int rows) {
        return baseDao.findBySql(sql,page,rows);
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params) {
        return baseDao.findBySql(sql,params);
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        return baseDao.findBySql(sql,params,page,rows);
    }

    @Override
    public int executeSql(String sql) {
        return baseDao.executeSql(sql);
    }

    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        return baseDao.executeSql(sql, params);
    }

    @Override
    public BigInteger countBySql(String sql) {
        return baseDao.countBySql(sql);
    }

    @Override
    public BigInteger countBySql(String sql, Map<String, Object> params) {
        return baseDao.countBySql(sql,params);
    }
}
