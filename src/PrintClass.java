
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;

/***************************************************************
* file: PrintClass.java
* author: Timothy Monh
* class: CS 245 - Program Graphical User Interfaces
*
* assignment: 2
* date last modified: 3/11
*
* purpose: To create a class that passes a panel to be printed upon
*
****************************************************************/
public class PrintClass implements Printable{
    private JPanel p2Print;
    public PrintClass(JPanel p){
        this.p2Print = p;
    }
    //To print out the jpanel drawboard back on workframe
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if(page> 0){// page is 0 based
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(),pf.getImageableY());

        this.p2Print.printAll(g);

        return PAGE_EXISTS;
    }
}
