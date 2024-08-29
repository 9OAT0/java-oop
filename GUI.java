import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class GUI {
    public static void main(String[] args) {
        mainFrame MyFrame = new mainFrame();
        MyFrame.Init();
    }
}


class mainFrame extends JFrame{
    public void Init(){
        JPanel mainPanal = new JPanel();
        mainPanal.setBackground(Color.PINK);
        setTitle("Java GUI");
        setSize(500, 500);
        this.add(mainPanal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //commponent
        JLabel FNameL = new JLabel("First Name");
        JTextField FNameTF = new JTextField(10);
        JLabel LNameL = new JLabel("Last Name");
        JTextField LNameTF = new JTextField(10);
        mainPanal.setLayout(new GridLayout(4,2,5,5));
        mainPanal.add(FNameL);
        mainPanal.add(FNameTF);
        mainPanal.add(LNameL);
        mainPanal.add(LNameTF);
        JLabel WCTxt = new JLabel("...");
        JLabel Tmp = new JLabel();
        mainPanal.add(WCTxt);
        mainPanal.add(Tmp);


        //Button
        JButton OKButton = new JButton("OK");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Fname = FNameTF.getText();
                String LName = LNameTF.getText();
                WCTxt.setText("Welcome " + Fname + " " + LName);
            }
        });
        mainPanal.add(OKButton);


        JButton CButton =new JButton("Clear");
        CButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              FNameTF.setText("");
              LNameTF.setText("");
              WCTxt.setText("...");
            }
           
        });
        mainPanal.add(CButton);
        setVisible(true);
    }
}