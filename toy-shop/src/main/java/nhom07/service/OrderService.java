package nhom07.service;

import java.sql.Date;
import java.util.List;

import nhom07.entity.Order;
import nhom07.entity.Product;

public interface OrderService {
	public List<Order> getOrders();
	public Order getOrder(int id);
	public void saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
	public int getMaxID();
	public List<Order> getOrdersByDK(String dk);
	public List<Order> getOrdersByDate(Date date);
}
