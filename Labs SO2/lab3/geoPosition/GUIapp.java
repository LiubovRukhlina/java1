package lab3.geoPosition;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUIapp {
	double distance = 0;
	double mouseLat = 0;
	double mouseLon = 0;
	public GUIapp() {
		JFrame frame = new JFrame("Route Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocation(200,0);
		
		ImageIcon image = new ImageIcon("lab3/geoPosition/OSM_Map.png");
		JLabel labelImage = new JLabel(image, JLabel.CENTER);
		//labelImage.addMouseMotionListener(this);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,3));
		upperPanel.add(new JButton("Reset"));
		upperPanel.add(new JLabel("Distance" + distance + "km", JLabel.CENTER));
		upperPanel.add(new JLabel("Position: (lat,lon) = (" + mouseLat + mouseLon + ")"));
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(upperPanel);
		contentPane.add(labelImage);
		
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIapp();
	}

}
