import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewPatients extends JFrame {

    private Patient patient;

    public ViewPatients() {
        Container cPane;

        //set the frame properties
        setTitle("View Patients");
        setSize(300, 200);
        setResizable(false);
        setLocation(300, 200);
        // shut down the program when the window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.lightGray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(300, 400);


        JButton button1;

        // construct search button
        button1 = new JButton("Search Patient");
        button1.setBounds(300, 600, 80, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPatients();
            }
        });

        cPane.add(button1);

    }// ViewPatient end...


    private void searchPatients()
    {
        String name;
        name = JOptionPane.showInputDialog(this,"Enter name");

        for(Patient p: JMenuFrame.patients)
        {
            if(p.getName() != null && p.getName().contains(name))
            {
                JOptionPane.showMessageDialog(null,p.toString());
            }//if end

            //else{ JOptionPane.showMessageDialog(null,"There is no such Patient"); }

        }// for end
    } //searchPatients end...

    public Patient getPatient(){ return patient; }

}



