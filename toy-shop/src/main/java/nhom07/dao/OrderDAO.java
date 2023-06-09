package nhom07.dao;

import java.sql.Date;
import java.util.List;

import nhom07.entity.Order;

public interface OrderDAO {
	public List<Order> getOrders();
	public Order getOrder(int id);
	public void saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
	public int getMaxID();
	public List<Order> getOrdersByDK(String dk);
	public List<Order> getOrdersByDate(Date date);
}
