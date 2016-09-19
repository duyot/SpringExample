package com.vivas.springmvc.base;

import com.google.common.collect.Lists;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyot on 8/29/2016.
 */
public class BaseBusinessImpl<T extends BaseDTO, TDAO extends BaseDAOImpl,TModel extends BaseModel> implements BaseBusinessInterface<T,TModel>{
    public TDAO tdao;
    public T tDTO;
    protected Class<T> entityClass;

    @Override
    public String getSysDate(String pattern) throws Exception {
       return tdao.getSysDate(pattern);
    }

    @Override
    public String deleteById(long id) {
        return tdao.deleteById(id);
    }

    @Override
    public String deleteByObject(T obj) {
        return tdao.deleteByObject(obj.toModel());
    }

    @Override
    public String saveOrUpdate(T obj) {
        return null;
    }

    @Override
    public String save(T obj) {
        return tdao.save(obj.toModel());
    }

    @Override
    public String saveBySession(T obj, Session session) {
        return tdao.saveBySession(obj.toModel(),session);
    }

    @Override
    public String saveList(List<T> lstObj) {
        return tdao.saveList(lstObj);
    }

    @Override
    public List<T> getAll() {
        return tdao.getAll();
    }

    @Override
    public List<T> getList(int count) {
        return tdao.getList(count);
    }

    @Override
    public T findById(long id) {
        return (T)tdao.findById(id).toDTO();
    }

    @Override
    public List<T> findByProperty(String property, String value) {
        return tdao.findByProperty(property,value);
    }

    @Override
    public List convertListModeltoDTO(List<TModel> listModel) {
        List<BaseDTO> lstForm = Lists.newArrayList();
        if (listModel != null) {
            for (TModel model : listModel) {
                lstForm.add(model.toDTO());
            }
        }
        return lstForm;
    }

    @Override
    public List convertListDTOtoModel(List<T> listDTO) {
        List<BaseModel> lstModel = Lists.newArrayList();
        if (listDTO != null) {
            for (T dto : listDTO) {
                lstModel.add(dto.toModel());
            }
        }
        return lstModel;
    }


    @Override
    public List<T> getAllByPage(int pageNum, int countPerPage) {
        return tdao.getAllByPage(pageNum,countPerPage);
    }
}
