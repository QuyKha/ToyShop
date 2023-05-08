package nhom07.dao;

import java.util.List;

import nhom07.entity.Cart;

public interface CartDAO {
	public List<Cart> getCartsbyUserID(int UserID);
	public Cart getCart(int userID, int productID);
	public void saveCart( Cart cart );
	public void updateCart( Cart cart );
	public void deleteCart( Cart cart );
}
