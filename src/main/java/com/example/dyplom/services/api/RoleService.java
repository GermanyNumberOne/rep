package com.example.dyplom.services.api;

import com.example.dyplom.dto.RoleDto;

public interface RoleService extends AbstractService<RoleDto>{
    RoleDto getRoleByName(String name);
}
