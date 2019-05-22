package lab3.geoPosition;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")

public class MainWindow extends JPanel implements ActionListener, MouseListener {
	private static bottomPanel bottom;
	
	private static final long serialVersionUID = 1L;
	int x,y;
	String mtext = "Mouse x? y?";
	
	
	class bottomPanel extends JPanel{
		private ArrayList<Integer> listCoordsX = new ArrayList<Integer>();
		private ArrayList<Integer> listCoordsY = new ArrayList<Integer>();
		
		
		public Dimension getPreferredSize(){
			return new Dimension(1024,768);
		}
		public void addPoint(int x, int y){
			listCoordsX.add(x);
			listCoordsY.add(y);
			repaint();
		}
	
		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		      g.drawString("Left mouse button to set new point", 10, 20);
		      g.drawString("Right mouse button to clear panel", 10, 40);
		      
		      int numberPoints = listCoordsX.size();
		      if (numberPoints > 1){
		    	  for (int i = 1; i < numberPoints; i++) {
		    		  g.drawLine(
		    				  listCoordsX.get(i -1), 
		    				  listCoordsY.get(i -1), 
		    				  listCoordsX.get(i), 
		    				  listCoordsY.get(i));
		    	  }
		      }
		    }
		
	
		
	}
	
	public MainWindow() throws IOException {
		
		bottom = new bottomPanel();

		//main window frame
		JFrame frame = new JFrame("MapGUI Exercise");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(1200, 0);
		
		//create UI elements		
		JButton exit = new JButton("Get Out!");
		JButton delete = new JButton("Go Back!");
		JLabel mouseCoords = new JLabel(mtext, JLabel.CENTER);
		JLabel stuff2 = new JLabel(" Stuff 2 ", JLabel.CENTER);	
		
		BufferedImage mapSrc = ImageIO.read(new File("lab3/geoPosition/OSM_Map.png"));
		JLabel mapImage = new JLabel(new ImageIcon(mapSrc));
		//ImageIcon mapSrc = new ImageIcon("lab3/geoPosition/OSM_Map.png");
	//	JLabel mapImage = new JLabel(mapSrc, JLabel.CENTER);
		
		Image background = Toolkit.getDefaultToolkit().createImage("lab3/geoPosition/OSM_Map.png");
		bottom.drawImage(background,0,0,null);
		bottom.add(mapImage);
		bottom.repaint();

		
		//create UI areas
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,2));
		top.add(exit);
		top.add(delete);
		top.add(mouseCoords);
		top.add(stuff2);
		
		
		
		// drawing area
		/*points = new ArrayList<Point>();
		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
			*/	
		//put everything in the main container
		Container myPane = frame.getContentPane();
		myPane.setBackground(Color.GREEN);
		myPane.setLayout(new BoxLayout(myPane, BoxLayout.Y_AXIS));
		myPane.add(top);
		myPane.add(bottom);

		//visibility & adaptive size
		frame.pack();
		frame.setVisible(true);
		
		//listeners
		exit.addActionListener( this );
		bottom.addMouseListener(this);
	}
	

	
	
	   
	
	
	//executable method
	public static void main(String[] args) throws IOException {
		new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		System.exit(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		    bottom.addPoint(e.getX(), e.getY());   
	
		
		int x=e.getX();
	    int y=e.getY();
	    this.x = x;
	    this.y = y;
	    System.out.println("Mouse x: " + x);
        System.out.println("Mouse y: " + y);
        //System.out.println(points);
        
	    mtext = "Mouse x" + x + " y" + y;
	    repaint();
	    	
	    }
	

	// UNUSED MOUSE EVENTS - - - - - - - - - - - - - - - - -
	@Override
	public void mousePressed(MouseEvent e) {// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {// TODO Auto-generated method stub	
	}
	@Override
	public void mouseEntered(MouseEvent e) {// TODO Auto-generated method stu
	}
	@Override
	public void mouseExited(MouseEvent e) {// TODO Auto-generated method stub
	}
}

