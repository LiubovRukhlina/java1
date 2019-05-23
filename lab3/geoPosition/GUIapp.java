package lab3.geoPosition;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUIapp extends MouseAdapter {
	public MyDrawPanel panel;
	double distance = 0;
	double mouseLat = 0;
	double mouseLon = 0;
	private JButton reset;
	JLabel dist = new JLabel("Distance" + distance + "km", JLabel.CENTER);
	JLabel pos = new JLabel("Position: (lat,lon) = (" + mouseLat + mouseLon + ")");
	
	public GUIapp() {
		JFrame frame = new JFrame("Route Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocation(200,0);
		
		//ImageIcon image = new ImageIcon("lab3/geoPosition/OSM_Map.png");
		//JLabel labelImage = new JLabel(image, JLabel.CENTER);
		//labelImage.addMouseMotionListener(this);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(1,3));
		reset = new JButton("Reset"); 
		reset.setActionCommand("Reset");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				panel.clear();
			}
		});
		upperPanel.add(reset);
		//reset.addActionListener(this);

		upperPanel.add(dist);
		upperPanel.add(pos);
		
		panel = new MyDrawPanel();
		panel.addMouseListener(this);
		

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(upperPanel);
		//contentPane.add(labelImage);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == reset) {
			panel.clear();
		}
	}
	
	public void actionPerformed2(ActionEvent event) {
	 String actionCommand = event.getActionCommand();
	 if(actionCommand.equals("Reset")){
		 panel.clear();
		 
	 }
	}
	
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == 1) {
			System.out.printf("(x,y) = (%d,%d)\n", event.getX(), event.getY());
			panel.addPoint(event.getX(), event.getY());
			mouseLat = event.getX();
			mouseLon = event.getY();
			System.out.printf("(%f,%f)\n", mouseLat, mouseLon);
			dist.setText("Distance" + distance + "km");
		} else if (event.getButton() == 3) {
			System.out.printf("Clear panel");
			panel.clear();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIapp();
	}

}

@SuppressWarnings("serial")
class MyDrawPanel extends JPanel {
	private ArrayList<Integer> listCoordsX = new ArrayList<Integer>();
	private ArrayList<Integer> listCoordsY = new ArrayList<Integer>();
	
	public MyDrawPanel(){
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(1024, 768);
	}
	
	public void addPoint(int x, int y){
		listCoordsX.add(x);
		listCoordsY.add(y);
		repaint();
	}
	

	public void clear(){
		listCoordsX.clear();
		listCoordsY.clear();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.red);;
		super.paintComponent(g);
		BufferedImage map = null;
		try{
	        map = ImageIO.read(new File("lab3/geoPosition/OSM_Map.png"));
	        }catch(IOException e){e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
		g.drawImage(map, 0, 0, this);
		int numberPoints = listCoordsX.size();
		if(numberPoints > 1) {
			for (int i = 1; i < numberPoints; i++) {
				g2.drawLine(listCoordsX.get(i - 1), listCoordsY.get(i - 1), listCoordsX.get(i), listCoordsY.get(i));
			}
		}
	//	dist.setText("Distance" + distance + "km");
	}
}

