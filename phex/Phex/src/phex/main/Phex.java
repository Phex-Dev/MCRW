package phex.main;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Phex {
	
	private Texture tweet;
	
	public Phex()
	{
		new LoginButton();
		try {
			Display.setDisplayMode(new DisplayMode(800, 650));
			Display.setTitle("Phex Launcher");
			Display.setResizable(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		Texture texture;
		
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("img/twitter-logo.png")));
		        // Replace PNG with your file extension
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		
		tweet = loadTexture("twitter-logo");
		
		//Initialisation code(OpenGL)
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); // Resets any previous projection matrices
		glOrtho(0, 800, 650, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		
		while(!Display.isCloseRequested())
		{
			//render
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			{
				Display.destroy();
				System.exit(0);
			}
			
			tweet.bind();
			
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2i(100, 0);
				glTexCoord2f(1, 0);
				glVertex2i(56, 0);
				glTexCoord2f(1, 1);
				glVertex2i(56, 56);
				glTexCoord2f(0, 1);
				glVertex2i(100, 56);
			glEnd();
			
			glBegin(GL_QUADS);
				glVertex2i(0, 0);
				glVertex2i(1025, 0);
				glVertex2i(1025, 100);
				glVertex2i(0, 100);
			glEnd();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	private Texture loadTexture(String key)
	{
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("img/" + key +".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void main(String args[])
	{
		new Phex();
	}

}
