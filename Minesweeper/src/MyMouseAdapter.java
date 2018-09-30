import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
//Testing the commits and pushes
public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
			case 1:		//Left mouse button
				Component c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}
				}
				JFrame myFrame = (JFrame) c;
				MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
				Insets myInsets = myFrame.getInsets();
				int x1 = myInsets.left;
				int y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				int x = e.getX();
				int y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				myPanel.mouseDownGridX = myPanel.getGridX(x, y);
				myPanel.mouseDownGridY = myPanel.getGridY(x, y);
				myPanel.repaint();
				break;
			case 3:		//Right mouse button
				Component c2 = e.getComponent();
				while (!(c2 instanceof JFrame)) {
					c2 = c2.getParent();
					if (c2 == null) {
						return;
					}
				}
				JFrame Frame = (JFrame) c2;
				MyPanel mPanel = (MyPanel) Frame.getContentPane().getComponent(0);
				Insets Insets = Frame.getInsets();
				int x12 = Insets.left;
				int y12 = Insets.top;
				e.translatePoint(-x12, -y12);
				int x13 = e.getX();
				int y13 = e.getY();
				mPanel.x = x13;
				mPanel.y = y13;
				mPanel.mouseDownGridX = mPanel.getGridX(x13, y13);
				mPanel.mouseDownGridY = mPanel.getGridY(x13, y13);
				mPanel.repaint();
				break;
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
			case 1:		//Left mouse button
				Component c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}
				}
				JFrame myFrame = (JFrame)c;
				MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
				Insets myInsets = myFrame.getInsets();
				int x1 = myInsets.left;
				int y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				int x = e.getX();
				int y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				int gridX = myPanel.getGridX(x, y);
				int gridY = myPanel.getGridY(x, y);
				if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
					//Had pressed outside
					//Do nothing
				} else {
					if ((gridX == -1) || (gridY == -1)) {
						//Is releasing outside
						//Do nothing
					} else {
						if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
							//Released the mouse button on a different cell where it was pressed
							//Do nothing
						} else {
							//Released the mouse button on the same cell where it was pressed
								//On the grid :
								Color newColor = Color.LIGHT_GRAY;
								
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
								myPanel.repaint();
							
						}
					}
				}
				myPanel.repaint();
				break;
			case 3:		//Right mouse button
				Component c2 = e.getComponent();
				while (!(c2 instanceof JFrame)) {
					c = c2.getParent();
					if (c2 == null) {
						return;
					}
				}
				JFrame Frame = (JFrame)c2;
				MyPanel mPanel = (MyPanel) Frame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
				Insets Insets = Frame.getInsets();
				int x12 = Insets.left;
				int y12 = Insets.top;
				e.translatePoint(-x12, -y12);
				int x13 = e.getX();
				int y13 = e.getY();
				mPanel.x = x13;
				mPanel.y = y13;
				int gridX1 = mPanel.getGridX(x13, y13);
				int gridY1 = mPanel.getGridY(x13, y13);
				if ((mPanel.mouseDownGridX == -1) || (mPanel.mouseDownGridY == -1)) {
					//Had pressed outside
					//Do nothing
				} else {
					if ((gridX1== -1) || (gridY1== -1)) {
						//Is releasing outside
						//Do nothing
					} else {
						if ((mPanel.mouseDownGridX != gridX1) || (mPanel.mouseDownGridY != gridY1)) {
							//Released the mouse button on a different cell where it was pressed
							//Do nothing
						} else {
							//Released the mouse button on the same cell where it was pressed
								//On the grid :
								Color newColor = Color.RED;
								
								mPanel.colorArray[mPanel.mouseDownGridX][mPanel.mouseDownGridY] = newColor;
								mPanel.repaint();
							
						}
					}
				}
				mPanel.repaint();
				break;
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
		}
	}
}