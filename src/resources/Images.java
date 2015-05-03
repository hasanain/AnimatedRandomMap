package resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * This class is a singleton that loads all the images that are going to be used in the program
 *
 * @author Hasanain Jamal
 *
 */
public class Images {

	private static ArrayList<BufferedImage> images = new ArrayList<>();

	private static Images instance;

	private Images() {
		images = new ArrayList<>();
		makeImages();
	}

	private static void makeImages() {
		try {
			File fs = new File("images/");
			for (File f : fs.listFiles()) {
				images.add(ImageIO.read(f));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getGrass() {
		return images.get(0);
	}

	public BufferedImage getMetal() {
		return images.get(1);
	}

	public BufferedImage getWall() {
		return images.get(2);
	}

	public BufferedImage getActor() {
		return images.get(3);
	}

	public BufferedImage getRandomImage() {
		Random r = new Random();
		return images.get(r.nextInt(images.size() - 1));

	}

	public static Images getInstance() {
		if (instance == null) {
			instance = new Images();
		}
		return instance;
	}
}
