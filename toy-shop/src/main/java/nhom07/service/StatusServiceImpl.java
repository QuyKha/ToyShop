package nhom07.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhom07.dao.StatusDAO;
import nhom07.entity.Status;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	private StatusDAO statusDAO;

	@Override
	@Transactional
	public List<Status> getStatuses() {
		// TODO Auto-generated method stub
		return statusDAO.getStatuses();
	}

	@Override
	@Transactional
	public Status getStatus(int id) {
		// TODO Auto-generated method stub
		return statusDAO.getStatus(id);
	}

}
