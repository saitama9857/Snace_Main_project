import javax.swing.*;



    public class MainWindow extends JFrame {

        public MainWindow(){
            setTitle("Demon Slayer");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // I changed size and location
            setSize(500,525);
            setLocation(400,200);
            add(new GameField());
            setVisible(true);
        }

        public static void main(String[] args) {
            MainWindow mw = new MainWindow();
        }
    }

