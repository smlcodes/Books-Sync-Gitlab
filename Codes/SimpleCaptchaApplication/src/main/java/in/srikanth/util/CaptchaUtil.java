package in.srikanth.util;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;

public class CaptchaUtil {
	
	static List<java.awt.Color> textColors = Arrays.asList(
		     Color.gray, Color.decode("#410099"));
	
	static	List<java.awt.Font> textFonts = Arrays.asList(
		     new Font("Arial", Font.PLAIN, 40), 
		     new Font("Courier", Font.BOLD, 40));
	
	// Create Captcha Object
	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height).
				 addBackground(new GradiatedBackgroundProducer())
				.addText(new DefaultTextProducer())
				.addNoise(new CurvedLineNoiseProducer())
				.build();
	 }

	
	
	
	// Create Captcha Object
	public static Captcha satyaCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				 .addText(new DefaultTextProducer(), new DefaultWordRenderer(textColors, textFonts))
				.build();
	 }

	
	
	// 1. Create Captcha
	public static Captcha createOtherProjCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground(new GradiatedBackgroundProducer(Color.BLUE, Color.GREEN))
				.addText(new DefaultTextProducer()).addNoise(new CurvedLineNoiseProducer(Color.RED, 3.5f)).build();
	}
	
	
	
	// Convert to Binary String
	public static String encodeBase64(Captcha captcha) {

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		String imageData = null;

		try {
			ImageIO.write(captcha.getImage(), "png", os);
			byte[] bArray = Base64.getEncoder().encode(os.toByteArray());
			imageData = new String(bArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageData;
	}
}
