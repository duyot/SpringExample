package com.vivas.springmvc.base;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by duyot on 8/29/2016.
 */
public interface BaseBusinessInterface<T extends BaseDTO,TModel extends BaseModel> {
    public String getSysDate(String pattern) throws Exception;

    public String deleteById(long id);
    public String deleteByObject(T obj);

    public String saveOrUpdate(T obj);
    public String save(T obj);
    public String saveBySession(T obj,Session session);
    public String saveList(List<T> lstObj);

    public List<T> getAll();
    public List<T> getList(int count);
    public List<T> getAllByPage(int pageNum, int countPerPage);

    public T findById(long id);
    public List<T> findByProperty(String property,String value);

    public List<T> convertListModeltoDTO(List<TModel> listModel);
    public List<TModel> convertListDTOtoModel(List<T> listDTO);
}
