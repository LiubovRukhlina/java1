package lab3.geoPosition;

import lab2.geoPosition.*;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;


@SuppressWarnings("serial")
public class MainWindow extends Frame implements ActionListener, MouseListener, MouseMotionListener {

	//executable method
	public static void main(String[] args) throws IOException {
		new MainWindow();
	}
		
	//building all the UI elements & variables
  	int x,y;
  	String mouseText, mapText, distanceTxt;
  	double distanceKm;
  	
	JFrame frame = new JFrame("MapGUI Exercise");
	JButton exit = new JButton("Get Out!");
	JButton delete = new JButton("Go Back!");
	JLabel mouseCoordsLabel = new JLabel(createText1(x,y), JLabel.CENTER);
	JLabel mapCoordsLabel = new JLabel(createText2(x,y), JLabel.CENTER);
	JLabel totDistanceLabel = new JLabel(createText3(distanceKm), JLabel.CENTER);
	
	ImageIcon mapSrc = new ImageIcon("/C:/Users/aco748/Desktop/EclipseStuff/Lab03_GeoMap/lab3/lab3/geoPosition/OSM_Map.png");
	
	JPanel top = new JPanel();
	DrawOnIt bottom = new DrawOnIt();
	
	
	//updatable TEXT labels
	public String createText1(int x, int y) {
  		mouseText = "X" + x + " / Y" + y;
  		return mouseText;
  	}
	
	public String createText2(double lat, double lon) {
		mapText = "Lon : " + new DecimalFormat("##.#####").format(lon) + " / Lat : " + new DecimalFormat("##.#####").format(lat);
  		return mapText;
  	}
	
	public String createText3(double distanceKm) {
		distanceTxt = "TOT Km " + new DecimalFormat("##.##").format(distanceKm);
  		return distanceTxt;
  	}
	//list of button actions
	private enum Actions {
		EXIT,
		DELETE
		  }
	 
  	//connecting blocks into a window structure  
	public MainWindow() throws IOException {
		
		//inject the image in a JLabel, then fuck it's properties to allow for drawing over it
		JLabel mapImage = new JLabel(mapSrc, JLabel.CENTER) {
	        
			//override basic PAINT properties
			public void paint(Graphics g) {
	            super.paint(g);
	            
	            //alter the color & thickness of the stroke
	            Graphics2D g2 = (Graphics2D) g;
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g2.setColor(Color.red);
		        g2.setStroke(new BasicStroke(3));
		        
		        //draw dots & lines
		        int numberPoints = bottom.listCoordsX.size();
		        if (numberPoints > 1) {
		        	for (int i = 1; i < numberPoints; i++) {
		        		for (int k = 0; k < numberPoints; k++) {
		        			
		        			g.fillOval(
		        				(bottom.listCoordsX.get(i -1))-5,
		        				(bottom.listCoordsY.get(i -1))-5,
		        				10,10);
		        			g.fillOval(
		        				(bottom.listCoordsX.get(i))-5,
		        				(bottom.listCoordsY.get(i))-5,
		        				10,10);
		        		}
		        		g.drawLine(
		        				bottom.listCoordsX.get(i -1),
		        				bottom.listCoordsY.get(i -1),
		        				bottom.listCoordsX.get(i),
		        				bottom.listCoordsY.get(i)
							   );   
		        	}
		        } else if (numberPoints == 1) {
		        	g.fillOval(
	        				(bottom.listCoordsX.get(0))-5,
	        				(bottom.listCoordsY.get(0))-5,
	        				10,10);
		        }
			}
	         
	      };
		
		//main window frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(800, 0);
		
		//UI areas
		top.setLayout(new GridLayout(1,2));
		top.add(exit);
		top.add(delete);
		top.add(mouseCoordsLabel);
		top.add(mapCoordsLabel);
		top.add(totDistanceLabel);
		bottom.add(mapImage);
				
		//put everything in the main container
		Container myPane = frame.getContentPane();
		myPane.setLayout(new BoxLayout(myPane, BoxLayout.Y_AXIS));
		myPane.add(top);
		myPane.add(bottom);

		//visibility & adaptive size
		frame.pack();
		frame.setVisible(true);
		
		//listeners
		exit.addActionListener( this );
		exit.setActionCommand(Actions.EXIT.name());
		delete.addActionListener( this );
		delete.setActionCommand(Actions.DELETE.name());
		bottom.addMouseListener(this);
		bottom.addMouseMotionListener(this);
		
	}
	
	//drawable area blueprint
	class DrawOnIt extends JPanel {
		
		//list of coordinates
		ArrayList<Integer> listCoordsX = new ArrayList<Integer>();
	  	ArrayList<Integer> listCoordsY = new ArrayList<Integer>();
		
	  	ArrayList<GeoPosition> geoCoords = new ArrayList<GeoPosition>();
	  	
	  	//convert XY to LatLon
	  	int listSize = listCoordsX.size();
	  	GeoRoute route = new GeoRoute("");
	  	
	  	public void converter(){
		  	double lon = 8.4375 + ( (11.24725 - 8.4375) * x / 1024 );
		  	double lat = 54.5720556 - ( (54.5720556 - 53.3325) * y / 768 );
		  	route.addWaypoint(new GeoPosition(lat, lon));
	  		
	  		System.out.println(route.getNumberWaypoints());
	  		double d = route.getDistance();
	  		System.out.println(d);
	  		totDistanceLabel.setText(createText3(d));
	  	}
	  	
	    //populate the List
		public void addPoint(int x, int y){
	  		bottom.listCoordsX.add(x);
	  		bottom.listCoordsY.add(y);
	  		repaint();
	  	 }

		//remove stuff from the List
		public void deletePoint(int numberPoints) {
			if (numberPoints > 0) {
	    		bottom.listCoordsX.remove(numberPoints-1);
	    		bottom.listCoordsY.remove(numberPoints-1);
	    		repaint();
	    	}
		}
}

	
	//button actions
	@Override
	public void actionPerformed(ActionEvent click) {
	    if (click.getActionCommand() == Actions.EXIT.name()) {
	    	System.exit(0);	//close the window
	    } else if (click.getActionCommand() == Actions.DELETE.name()) {
	    	int numberPoints = bottom.listCoordsX.size();
	    	bottom.deletePoint(numberPoints); //drop last coordinates set
//	    	bottom.deletePoint(bottom.listCoordsX.size() - 1);
//	    	bottom.converter();
	    	
	    	//TEST CODE - Console Printout
	    	int lessPoints = numberPoints -1;
	    	System.out.println("List Size: " + lessPoints);
	        for (int i = 0; i < lessPoints; i++) {
	        	System.out.println("Mouse coords: " + bottom.listCoordsX.get(i) + "/" + bottom.listCoordsY.get(i));
	        }
	    }
	}
	
	//mouse CLICK actions
	@Override
	public void mouseClicked(MouseEvent e) {
	    //get mouse coords
		x=e.getX();
	    y=e.getY();
	    
	    //add mouse coords to List
	    bottom.addPoint(x, y);
	    
	    bottom.converter();
	  
	    
	  //TEST CODE - Console Printout
	    int numberPoints = bottom.listCoordsX.size();
        System.out.println("List Size: " + numberPoints);
        for (int i = 0; i < numberPoints; i++) {
        	System.out.println("Mouse coords: " + bottom.listCoordsX.get(i) + "/" + bottom.listCoordsY.get(i));
        }
        
        //update text label
        mouseCoordsLabel.setText(createText1(x,y)); 
	}
	
	//mouse MOVE actions
	public void mouseMoved(MouseEvent e) {
		int x=e.getX();
	    int y=e.getY();
	    mouseCoordsLabel.setText(createText1(x,y));
	    
	    //convert XY to LatLon
	    double lon = 8.4375 + ( (11.24725 - 8.4375) * x / 1024 );
	    double lat = 54.5720556 - ( (54.5720556 - 53.3325) * y / 768 );
		mapCoordsLabel.setText(createText2(lat,lon));
	    }
	
	//translate XY to LatLon
	public void convertCoords() {
		
		
	}
	

	// UNUSED MOUSE EVENTS - - - - - - - - - - - - - - - - -
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
}

