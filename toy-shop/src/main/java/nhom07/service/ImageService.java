package nhom07.service;

import java.util.List;

import nhom07.entity.Image;

public interface ImageService {
	public List<Image> getImages();
	public List<Image> getImagesByProductID(int productID);
	public Image getImage(int imageID);
	public void saveImage(Image image);
	public void updateImage(Image image);
	public void deleteImage(Image image);
}
