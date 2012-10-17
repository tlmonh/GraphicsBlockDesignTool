/***************************************************************
* file: LineEntry
* author: Timothy Monh
* class: CS 245
*
* assignment: 2
* date last modified: 3/11
*
* purpose: Originally just meant for printing lines, this class is to allow printing on the panels
*
****************************************************************/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
public class LineEntry {
    private int xFirst;
    private int yFirst;
    private int xLast;
    private int yLast;
    private int xMid;
    private int yMid;
    public LineEntry()
    {
         xFirst = 0;
         yFirst = 0;
         xLast = xFirst;
         yLast = yFirst;
    }
    public LineEntry(int x1,int y1,int x2,int y2)
    {
        xFirst = x1;
        yFirst = y1;
        xLast = x2;
        yLast = y2;
    }
    public LineEntry(int x1,int y1,int x2,int y2,int x3,int y3)
    {
        xFirst = x1;
        yFirst = y1;
        xMid = x2;
        yMid = y2;
        xLast = x3;
        yLast = y3;
    }
    //For creating lines
    public void paintLine(Graphics g)
    {
        g.drawLine(xFirst, yFirst, xLast, yLast);
    }
    //For creating rectangles
    public void paintRect(Graphics g)
    {
         g.drawRect(xFirst,yFirst,xLast,yLast);
    }
    //For Creating text on specific coordinate
    public void paintText(Graphics g, String data)
    {
        g.drawString(data, xFirst, yFirst);
    }
    //For Creating ellipse on specific coordinate
    public void paintEllipse(Graphics g)
    {
        g.drawOval(xFirst, yFirst, xLast, yLast);
    }
    //For creating a curve for panels
    public void paintCurve(Graphics g)
    {
        Graphics2D g2 =(Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(rh);
        GeneralPath line = new GeneralPath();

        line.moveTo(xFirst, yFirst);
        line.curveTo(xFirst, yFirst, xMid, yMid, xLast, yLast);
        line.closePath();
        g2.setColor(Color.BLACK);
        g2.draw(line);
    }
}
