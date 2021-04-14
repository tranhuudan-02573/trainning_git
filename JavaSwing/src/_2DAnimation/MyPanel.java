package _2DAnimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	Timer timer;
	Image alien;
	Image earth;
	Image backgroundImage;
	int xVelocity = 5;
	int yVelocity = 2;
	int x = 0;
	int y = 0;

	public MyPanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		backgroundImage = new ImageIcon("./src/_2DAnimation/earth.png").getImage();
		alien = new ImageIcon(new ImageIcon("./src/_2DAnimation/ufo.png").getImage().getScaledInstance(150, 150, 0))
				.getImage();

		timer = new Timer(10, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);// paint background
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(alien, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (x >= PANEL_WIDTH - alien.getWidth(null) || x < 0) {
			xVelocity *= -1;
		}

		// TODO Auto-generated method stub
		x += xVelocity;
		if (y >= PANEL_HEIGHT - alien.getHeight(null) || y < 0) {
			yVelocity *= -1;
		}

		// TODO Auto-generated method stub
		y += yVelocity;
		repaint();
	}
}
