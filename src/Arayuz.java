import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Arayuz  {
    ImageIcon resim = new ImageIcon("hasdeeme/src/bas.png");
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JButton[][] buton ;
    JButton[] degerler;
    Random random= new Random();
    int degerTutucu;

    Arayuz(){
        buton = new JButton[9][9];
        degerler= new JButton[9];

        for (int x = 0 ;x<9;x++){

            degerler[x] = new JButton();
            degerler[x].setBounds(820,60+x*70,50,50);
            String str = String.valueOf(x+1);
            degerler[x].setText(str);
            degerler[x].setBorderPainted(false);
            degerler[x].setBackground(new Color(20,150,255));
            degerler[x].setFont(new Font ("sea",Font.BOLD,20));



            int finalX = x;
            degerler[x].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int k =0;k<9;k++){
                        if (k==finalX){
                           degerTutucu=finalX+1;
                            degerler[k].setBackground(Color.GREEN);}
                        else {degerler[k].setBackground(new Color(20,150,255));}

                    }
                }
            });
            frame.getContentPane().add(degerler[x]);
            frame.add(degerler[x]);
        }

        for (int y = 0;y<9;y++){
            for (int x=0;x <9;x++){
               int r;
                r= random.nextInt(9)+1;
                String rs=String.valueOf(r);
                buton[x][y] = new JButton();
                buton[x][y].setBackground(Color.white);
                buton[x][y].setBounds(41+85*x,40+74*y,80,68);
                buton[x][y].setBorderPainted(false);
                buton[x][y].setFont(new Font ("font",Font.BOLD,30));
                buton[x][y].setText(rs);
                buton[x][y].setOpaque(false);
                frame.add(buton[x][y]);

                int finalY = y; // ActionListener için final olması gerekiyor
                int finalX = x;
                buton[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int y = 0;y<9;y++){
                            for (int x=0;x <9;x++){
                                if (y==finalY && x==finalX){
                                    String str =String.valueOf(degerTutucu);

                                    buton[x][y].setText(str);

                                }

                            }
                        }
                    }
                });


            }


        }
        panel.setBounds(20,20,800,800);
        label.setIcon(resim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(label);
        frame.add(panel);


        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(1000,800));
        frame.setVisible(true);



    }




}
