package lab3.geoPosition;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTracker extends Frame implements MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MouseTracker(){
		addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e ) {
		
	}
}
