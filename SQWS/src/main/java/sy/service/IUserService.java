package sy.service;

import java.io.Serializable;

/**
 * Created by shui on 2014/11/14.
 */
public interface IUserService<T> extends IBaseService<T>{

    public void test();

    public Serializable save(T t);
}
