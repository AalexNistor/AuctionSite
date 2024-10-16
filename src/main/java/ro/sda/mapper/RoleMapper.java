package ro.sda.mapper;

import ro.sda.dto.request.user.RoleRequest;
import ro.sda.dto.response.user.RoleResponse;
import ro.sda.entity.Role;

import java.util.List;

public class RoleMapper {

    public static Role fromRoleRequestToEntity(RoleRequest roleRequest)
    {
        Role role = new Role();
        role.setName(roleRequest.getRoleName());
        role.setUsers(List.of());

        return role;
    }

    public static RoleResponse fromRole(Role role)
    {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRoleName(role.getName());
        roleResponse.setUsers(role.getUsers().stream().map(r->r.getAccountName()).toList());

        return roleResponse;
    }
}
