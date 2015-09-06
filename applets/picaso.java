package painter;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class picaso extends Applet implements MouseMotionListener {
	
	int mx,my;
	int mx_p,my_p;
	boolean status;
	boolean moved_status;
	
	public void init()
	{
		mx=0;
		my=0;
		mx_p=0;
		my_p=0;
		
		status=false;
		moved_status=false;
		addMouseMotionListener(this);
	}
	
	public void mouseMoved(MouseEvent me)
	{
		moved_status=true;
	}
	
	public void mouseDragged(MouseEvent me)
	{
		mx_p=mx;
		my_p=my;
		mx=me.getX();
		my=me.getY();
		status=true;
		
		if(moved_status==true)
		{
			moved_status=false;
		}
		else
		{
			Graphics g=getGraphics();
			g.drawLine(mx_p, my_p, mx, my);
		}
		
		//repaint();
		
	}
	
	public void paint(Graphics g)
	{
		//super.paint(g);
		
		if(status==true)
		{
			status=false;
			g.drawLine(mx_p, my_p, mx, my);
		}
	}

}
