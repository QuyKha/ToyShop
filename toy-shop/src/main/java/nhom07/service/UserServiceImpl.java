package nhom07.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom07.dao.UserDAO;
import nhom07.entity.User;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserDAO userDAO;
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	} 

	@Override
	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	@Override
	@Transactional
	public User getUserbyPhone(String phone) {
		return userDAO.getUserbyPhone(phone);
	}

	@Override
	@Transactional
	public List<User> getUsersFilter(String fullName, String phone, String email) {
		// TODO Auto-generated method stub
		return userDAO.getUsersFilter(fullName, phone, email);
	}

}
