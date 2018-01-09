//Beverly Ackah
//Extra Point Activity
//Play with the pixels of an image


import java.io.*;

import javax.imageio.*;

import java.awt.Color;
import java.awt.image.*;
public class ColorChanger{

	public static void main(String args[]) throws IOException{

		BufferedImage raw,processed;
		raw= ImageIO.read(new File("flower.png"));

		int width= raw.getWidth();
		int height= raw.getHeight();

		processed= new BufferedImage(width,height,raw.getType());
		float hue= 90/360.0f;//hard coded hue value
		for(int y=0; y<height;y++){
			for(int x=0;x<width;x++){

				//this is how we grab the RGBvalue of a pixel at x,y coordinates in the image
				int rgb= raw.getRGB(x,y);
				
				//extract the red value
				int extractR = (rgb>>16) & 0xFF;
				
				//extract the green value
				int extractG = (rgb>>8) & 0xFF;

				//extract the blue value
				int extractB = rgb & 0xFF;

				//user Color.RGBtoHSB() method to convert RGB values to HSB 
				float[] hsb = Color.RGBtoHSB(extractR, extractG, extractB, null);
				
				//then use Color.HSBtoRGB() method to convert the HSB value to a new RGB 
				
				int newRGB = Color.HSBtoRGB(hue, hsb[1], hsb[2]);
				//value
				
				//set the new RGBvalue to a pixel at x,y coordinates in the image

				processed.setRGB(x,y, newRGB);
				
				System.out.println("rgb: " + extractR + ", " + extractG + ", " + extractB);
			}
		}
		ImageIO.write(processed,"PNG",new File("processed.png"));
	}
}
