import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;



public class GameField extends JPanel implements ActionListener{
    private final int SIZE = 500;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;


    public GameField(){
        //changed color
        setBackground(Color.yellow);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }

    public void initGame(){
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i*DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250,this);
        timer.start();
        createApple();
    }

    public void createApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }

    public void loadImages(){
        ImageIcon iia = new ImageIcon("Rokuro_Anime_Profile_photo-resizer.ru (1).png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("zenitsu2_photo-resizer.ru (3).jpg");
        dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot,x[i],y[i],this);
            }
        } else{
            //also was changed
            String str = "Game Over";
            g.setColor(Color.black);
            g.drawString(str,200,SIZE/3);
        }
      }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("something goes wrong  ");
        }

    }

    public void move(){
        try {
            for (int i = dots; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
        }catch (Exception e){
            System.out.println("something wrong in class MOVE");
        }
        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        } if(up){
            y[0] -= DOT_SIZE;
        } if(down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkApple(){
        if(x[0] == appleX && y[0] == appleY){
            dots++;
            createApple();
        }
    }

    public void checkCollisions(){
        // Restart  i did my self
        for (int i = dots; i >0 ; i--) {
            if(i>4 && x[0] == x[i] && y[0] == y[i]){
                timer = new Timer(250,this);
                timer.stop();
                JOptionPane.showMessageDialog(null,"ОЮН БУТТУ :  БАШЫДАН БАШТОО");
                setVisible(false);
                dots = 2;
                setVisible(true);
                timer.start();
                createApple();
            }

        }

        if(x[0]>SIZE){
            inGame = false;
        }
        if(x[0]<0){
            inGame = false;
        }
        if(y[0]>SIZE){
            inGame = false;
        }
        if(y[0]<0){
            inGame = false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            checkCollisions();
            move();

        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }


}