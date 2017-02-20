import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}
	
	/** Method to keep only the color blue */
	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}
	
	/** Method to negate the image */
	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(255 - (pixelObj.getBlue()));
				pixelObj.setRed(255 - (pixelObj.getRed()));
				pixelObj.setGreen(255 - (pixelObj.getGreen()));
			}
		}
	}
	
	/** Method to turn the image into shades of grey */
	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int averageColor = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3;
				pixelObj.setBlue(averageColor);
				pixelObj.setRed(averageColor);
				pixelObj.setGreen(averageColor);
			}
		}
	}
	
	/** Method to make the fish more visible in the image water.jpg */
	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(pixelObj.getBlue() - 50);
				pixelObj.setRed(pixelObj.getRed() + 50);
				pixelObj.setGreen(pixelObj.getGreen() - 75);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}
	
	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from right to left
	 */
	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}
	
	/**
	 * Method that mirrors the picture around a horizontal mirror in the center of
	 * the picture from top to bottom
	 */
	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	
	/**
	 * Method that mirrors the picture around a horizontal mirror in the center of
	 * the picture from bottom to top
	 */
	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}
	
	/**
	 * Method that mirrors the picture around a diagonal mirror in the center of
	 * the picture from top left to bottom right
	 */
	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int howFar;
		if (pixels.length > pixels[0].length) {
			howFar = pixels[0].length;
		} else {
			howFar = pixels.length;
		}
		for (int row = 0; row < howFar; row++) {
			for (int col = 0; col < row; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[col][row];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count ++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.println(count);
	}
	
	/** Method to mirror the snowman's arm so that it has four arms */
	public void mirrorArms() {
		int leftArmMirrorPoint = 191;
		int rightArmMirrorPoint = 191;
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 159; row < 191; row++) {
			for (int col = 107; col < 170; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[leftArmMirrorPoint - row + leftArmMirrorPoint][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
		
		for (int row = 172; row < 196; row++) {
			for (int col = 239; col < 294; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[rightArmMirrorPoint - row + rightArmMirrorPoint][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}
	
	/** Method to mirror the seagull so there are two of them */
	public void mirrorGull() {
		int mirrorPoint = 230;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		
		for (int row = 236; row < 321; row++) {
			for (int col = 238; col < 344; col++) {
				leftPixel = pixels[row][mirrorPoint - (col - mirrorPoint)];
				rightPixel = pixels[row][col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
	
	/**
	 * copy from a certain area from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 * @param fromPicRow
	 * 			  where to start copy of row
	 * @param fromPicCol
	 * 			  where to start copy of col
	 * @param length
	 * 			  how many rows to copy
	 * @param width
	 * 			  how many cols to copy            
	 *
	 */
	public void restrictedCopy(Picture fromPic, int startRow, int startCol, int fromPicRow, int fromPicCol, int length, int width) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = fromPicRow, toRow = startRow; fromRow < fromPicRow + length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = fromPicCol, toCol = startCol; fromCol < fromPicCol + width
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}
	
	/** Method to create a collage of several pictures */
	public void myCollage() {
		Picture snowman = new Picture("snowman.jpg");
		Picture bird = new Picture("seagull.jpg");
		this.copy(bird, 0, 0);
		this.restrictedCopy(snowman, 0, 0, 75, 165, 100, 80);
		this.restrictedCopy(snowman, 100, 80, 75, 165, 100, 80);
		this.restrictedCopy(snowman, 200, 160, 75, 165, 100, 80);
		this.mirrorVertical();
		this.mirrorHorizontal();
		this.negate();
		this.restrictedCopy(bird, 25, 270, 236, 238,85, 100);
		this.mirrorHorizontal();
		this.mirrorDiagonal();
		this.mirrorHorizontalBotToTop();
		this.mirrorVerticalRightToLeft();
		this.write("collage.jpg");
		Picture person = new Picture("barbaraS.jpg");
		this.copy(person, 200, 150);
		this.mirrorHorizontalBotToTop();
		this.mirrorVertical();
		this.negate();
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
		
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Color bottomColor = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[row + 1][col];
				bottomColor = bottomPixel.getColor();
				if (topPixel.colorDistance(bottomColor) > edgeDist)
					topPixel.setColor(Color.BLACK);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
