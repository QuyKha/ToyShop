package nhom07.dao;

import java.util.List;

import nhom07.entity.Status;

public interface StatusDAO {
	public List<Status> getStatuses();
	public Status getStatus(int id) ;
}
