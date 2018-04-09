package ihm;

import java.lang.Object;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Date;
import java.text.*;

public class JCanvas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int X = 800;
	int Y = 600;
	
	int boule1 = ThreadLocalRandom.current().nextInt(1, 51);
	int boule2 = ThreadLocalRandom.current().nextInt(1, 51);
	int boule3 = ThreadLocalRandom.current().nextInt(1, 51);
	int boule4 = ThreadLocalRandom.current().nextInt(1, 51);
	int boule5 = ThreadLocalRandom.current().nextInt(1, 51);
	int etoile1 = ThreadLocalRandom.current().nextInt(1, 13);
	int etoile2 = ThreadLocalRandom.current().nextInt(1, 13);
	
	int nb_degrade;
	int rand_fond = ThreadLocalRandom.current().nextInt(0, 6);
	
	//int[] colors = new int[5]

	public void paint(Graphics g) {
		super.paint(g);
		
		//Fond
		Graphics2D g2d = (Graphics2D)g;         			//(inclin d,,color1, inclinaison g, rapport col1 col2, col2, repetition)
		GradientPaint gp = new GradientPaint(0, 0, Color.white, 200, 600, Color.white, false);                

		switch (rand_fond) {
	    case 0 :
			gp = new GradientPaint(200, 0, Color.red, 200, 600, Color.blue, false);
			break;
	    case 1 :
	    	gp = new GradientPaint(0, 200, Color.green, 600, 200, Color.yellow, false);
			break;
	    case 2 :
			gp = new GradientPaint(0, 0, Color.blue, 300, 500, Color.gray, true);
			break;
	    case 3 :
	    	gp = new GradientPaint(200, 0, Color.red, 400, 400, Color.white, false);
			break;
	    case 4 :
			gp = new GradientPaint(0, 200, Color.magenta, 200, 600, Color.orange, false);
			break;
	    case 5 :
	    	gp = new GradientPaint(0, 0, Color.white, 200, 600, Color.white, false);
			break;
	    }
		
	    g2d.setPaint(gp);
		g2d.fillRect(0,0,this.getWidth(),this.getHeight());
		//Fin Fond
		
		
		
		//Forme 1
		if (etoile1+etoile2 >= 16) {				//degrader ?
			Color color_d = new Color(boule1*5, boule2*5, boule3*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, Color.black, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
		else {
			Color color_d = new Color(boule1*5, boule2*5, boule3*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, color_d, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
	
		if (boule1 < 25) {				//forme ?			        
			g2d.fillRect(boule1*14,boule2*10,boule3*6,boule4*6);
		}
		else {
			g2d.fillOval(boule1*14,boule2*10,boule3*6,boule4*6);
		}
		
		
		//Forme 2 
		if (etoile1+etoile2 >= 16) {				//degrader ?
			Color color_d = new Color(boule3*5, boule4*5, boule5*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, Color.black, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
		else {
			Color color_d = new Color(boule3*5, boule4*5, boule5*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, color_d, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
			
		if (boule2 < 25) {				//forme ?			        
			g2d.drawRect(boule3*14,boule4*10,boule5*6,boule1*6);
		}
		else {
			g2d.drawOval(boule3*14,boule4*10,boule5*6,boule1*6);
		}
				
		//Forme 3 double ou triple ligne
		if (etoile1+etoile2 >= 16) {				//degrader ?
			Color color_d = new Color(boule5*5, boule3*5, boule1*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, Color.black, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
		else {
			Color color_d = new Color(boule5*5, boule3*5, boule1*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, color_d, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
			
		if (boule3 < 25) {				//forme ?			        
			g2d.drawLine((boule2+boule1)*3,boule3*3,(boule5+boule4)*10,boule1*10);
			g2d.drawLine((boule2+boule3)*3,boule1*3,(boule5+boule1)*10,boule4*10);

		}
		else {
			g2d.drawLine((boule2+boule5)*2,boule1*2,(boule3+boule4)*7,boule2*7);
			g2d.drawLine((boule4+boule3)*2,boule1*2,(boule5+boule3)*7,boule4*7);
			g2d.drawLine((boule4+boule5)*2,boule2*10,(boule1+boule3)*10,boule1*10);
		}
		
		//Forme 4 double rond ou triangle
		if (etoile1+etoile2 >= 16) {				//degrader ?
			Color color_d = new Color(boule4*5, boule2*5, boule5*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, Color.black, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
		else {
			Color color_d = new Color(boule4*5, boule2*5, boule5*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, color_d, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
		}
			
		if (boule4 < 25) {				//forme ?			        
			g2d.fillOval(boule4*14,boule2*10,boule5*6,boule5*6);
			Color color_d = new Color(boule3*5, boule1*5, boule4*5, 255);
			GradientPaint gpd = new GradientPaint(20, 40, Color.lightGray, 200, 300, color_d, true);                
		    g2d.setPaint(gpd);
			g2d.fillOval(boule4*15,boule2*11,boule1*2,boule1*2);
		}
		else {
			g2d.drawLine(boule5*11,boule5*10,boule4*8,boule3*8);
			g2d.drawLine(boule4*8,boule3*8,boule5*6,boule1*6);
			g2d.drawLine(boule5*6,boule1*6,boule5*11,boule5*10);
		}	
		
		//Forme 5 carre ou rectangle
				if (etoile1+etoile2 >= 10) {				//degrader ?
					Color color_d = new Color(boule2*5, boule1*5, boule4*5, 255);
					GradientPaint gpd = new GradientPaint(20, 40, Color.black, 200, 300, color_d, true);                
				    g2d.setPaint(gpd);
				}
				else {
					Color color_d = new Color(boule2*5, boule1*5, boule4*5, 255);
					GradientPaint gpd = new GradientPaint(20, 40, color_d, 200, 300, color_d, true);                
				    g2d.setPaint(gpd);
				}
					
				if (boule5 < 25) {				//forme ?			        
					g2d.fillRect(boule4*14,boule2*15,boule1*5,boule1*5);
				}
				else {
					g2d.drawRect(boule4*12,boule1*14,boule1*5,boule4*5);
				}	
				
												
		
		/*
		//exemple carre
		Color col = new Color(200, 200, 50, 255);
		g.setColor(col);				
		g.fillRect(10,310,80,80);
		
		//exemple carre avec dégradé
		Graphics2D g2d2 = (Graphics2D)g;         
	    GradientPaint gp2 = new GradientPaint(20, 40, Color.black, 200, 300, Color.cyan, true);                
	    g2d2.setPaint(gp2);
		g2d2.fillRect(400,250,150,250);
		
		//exemples ovales
		Graphics2D g2d3 = (Graphics2D)g;         
	    GradientPaint gp3 = new GradientPaint(0, 0, Color.green, 200, 280, Color.yellow, false);                
	    g2d3.setPaint(gp3);
		g.fillOval(150,50,140,140);
		
		Color col3 = new Color(120, 230, 250, 185);
		g.setColor(col3);
		g.drawOval(320,80,180,120);
		
		//lignes
		Color col1 = new Color(100, 230, 150, 140);
		g.setColor(col1);
	    g.drawLine(0, 0, this.getWidth(), this.getHeight());
	    
	    Color col2 = new Color(230, 230, 150, 180);
		g.setColor(col2);
	    g.drawLine(350, 100, 600, 120);
	    
	    */
	    
	    //exemple signature
	    Font font = new Font("Serif", Font.ITALIC, 20);
	    g.setFont(font);
		g.setColor(Color.BLACK);
	    g.drawString("Kandinsk'App", this.getWidth()-130, this.getHeight()-20);

	}

}
