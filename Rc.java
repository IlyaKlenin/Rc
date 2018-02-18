package rc;

//создать приложение, рисующее прямоугольник в случайных координатах
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//создать обрамляющее окно
public class Rc extends Frame {
    String keymsg = "Нажмите кнопку мыши в любом месте окна";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;
    static int xwindow = 1300, ywindow = 600; //объявление и инициализация переменных для размеров окна
    static int rxmax = 1000, rymax = 300; // объявление и инициализация переменных для максимально возможных координат прямоугольника
    static int rx = 0, ry = 0; //объявление и инициализация переменных для случайных координат окружности
    //static int vl = 200, hl = 200; //объявление переменных для длины вертикальной и горизоонтальной сторон
    static double r = 0; //расстояние от центра окружности до точки клика
    static double rox = 0, roy = 0; // координаты центра окружности
    static int diam = 200; // диаметр окружности
    static double R = 0; //радиус окружности
    
    
    
    
    
    public Rc() {
            addKeyListener (new MyKeyAdapter(this));
            addMouseListener (new MyMouseAdapter(this));
            addWindowListener (new MyWindowAdapter());
      
}

    public void paint (Graphics g) {
    g.drawString(keymsg, 10, 40);
    g.drawString(mousemsg, mouseX, mouseY);
    g.setColor(Color.green);
    g.drawOval(rx, ry, diam, diam);
    
    
    
}
//создать окно
    
public static void main(String args[]) {
    Rc appwin = new Rc();
    Random r = new Random();
            
            diam = r.nextInt(400);
            rx = r.nextInt(xwindow-diam);
            ry = r.nextInt(ywindow-diam);

    appwin.setSize(new Dimension (xwindow,ywindow));
    appwin.setTitle("Created by Ilya Klenin as a portfolio, to get a developer job");
	
    //приложение на основе библиотеки AWT
    appwin.setVisible(true);
    
    }
}
class MyKeyAdapter extends KeyAdapter {
    Rc appWindow;
    public MyKeyAdapter(Rc appWindow) {
        this.appWindow = appWindow;
    }
   
}

class MyMouseAdapter extends MouseAdapter {
    Rc appWindow;
    public MyMouseAdapter(Rc appWindow) {
        this.appWindow = appWindow;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
    appWindow.mouseX = me.getX();
    appWindow.mouseY = me.getY();
    appWindow.R = appWindow.diam/2;
    appWindow.rox = appWindow.rx + appWindow.diam/2;
    appWindow.roy = appWindow.ry + appWindow.diam/2;
    appWindow.r = Math.sqrt((appWindow.rox - appWindow.mouseX)*(appWindow.rox - appWindow.mouseX) + (appWindow.roy - appWindow.mouseY)*(appWindow.roy - appWindow.mouseY));
    
    if (appWindow.r < appWindow.R)
    
    appWindow.mousemsg = "Mouse key pressed inside green circle " + appWindow.mouseX +
            ", " + appWindow.mouseY;
    
    else 
    
    appWindow.mousemsg = "Mouse key pressed in empty field " + appWindow.mouseX +
            ", " + appWindow.mouseY;
    
    
appWindow.repaint();
    }
}

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
    
