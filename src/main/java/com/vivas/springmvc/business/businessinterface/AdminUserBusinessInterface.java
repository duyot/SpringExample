package com.vivas.springmvc.business.businessinterface;

import com.vivas.springmvc.dto.AdminUserDTO;

import java.util.List;

/**
 * Created by duyot on 8/24/2016.
 */
public interface AdminUserBusinessInterface {
    public List<AdminUserDTO> getAdminUserHQL();
}
