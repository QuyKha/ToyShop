package nhom07.dao;

import java.util.List;

import nhom07.entity.Image;

public interface ImageDAO {
	public List<Image> getImages();
	public List<Image> getImagesByProductID(int productID);
	public Image getImage(int imageID);
	public void saveImage(Image image);
	public void updateImage(Image image);
	public void deleteImage(Image image);
}
