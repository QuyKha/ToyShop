package nhom07.service;

import java.util.List;

import nhom07.entity.Status;

public interface StatusService {

	public List<Status> getStatuses();
	public Status getStatus(int id) ;
}
