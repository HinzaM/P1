import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ViewAppointments extends JFrame {

    public ViewAppointments() {
        Container cPane;

        //set the frame properties
        setTitle("View Appointments");
        setSize(500, 300);
        setResizable(false);
        setLocation(300, 300);
        // shut down the program when the window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.lightGray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(300, 400);


        //1
        JLabel jLabelDate = new JLabel("Enter Date: ");
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        JFormattedTextField jTADate = new JFormattedTextField(format);
        jPanel1.setLayout(new GridLayout(1, 4));
        jTADate.setValue(new Date());
        jPanel1.add(jTADate);

        cPane.add(jPanel1);


        // adding Cal.java in ViewAppointment JFrame
        Cal cal= new Cal();

        JButton button1;

        // construct two buttons
        button1 = new JButton("Search");
        button1.setBounds(300,600,80,50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //searchAppointments();
            }
        });

        cPane.add(button1);

        cPane.add(cal);
    }

    /*
    private void searchAppointments()
    {
        String date;
        date = JOptionPane.showInputDialog(this,"Enter date");

        for(Appointment a: JMenuFrame.appointments)
        {
            if(a.getAppDate() != null && a.getAppDate().contains(date))
            {
                JOptionPane.showMessageDialog(null,a.toString());
            }//if end
        }// for end
    } //searchAppointments end...
    */
}

