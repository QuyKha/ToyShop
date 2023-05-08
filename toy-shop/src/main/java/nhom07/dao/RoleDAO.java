package nhom07.dao;

import java.util.List;

import nhom07.entity.Role;



public interface RoleDAO {
	public List<Role> getRoles();
	public void saveRole(Role role);
	public Role getRole(int id);
	public void deleteRole(Role role);
	public List<Role> getUserRoles(String phone);
}
