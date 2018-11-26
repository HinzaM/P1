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
import javax.swing.JTextField;

public class MakeAppointment extends JFrame{
    private Appointment appointment;

    public Appointment getAppointment(){
        return appointment;
    }

    //public static void main(final String args[]) { JFrame frame = new JFrame("Formatted Example"); }

    public MakeAppointment() {
        Container cPane;

        //set the frame properties
        setTitle("Make Appointment");
        setSize(500, 600);
        setResizable(false);
        setLocation(500, 500);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.gray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(700,400);


        JLabel jLabelApNo = new JLabel("Appointment No: ");                                  //1. Appointment No
        JTextField jTAApNo = new JTextField(20);
        jPanel1.setLayout(new GridLayout(3,5)) ;
        jPanel1.add(jLabelApNo);
        jPanel1.add(jTAApNo);


        JLabel jLabelId = new JLabel("Patient Id: ");                                            //2. Patient Id
        JTextField jTAId = new JTextField();
        jPanel1.setLayout(new GridLayout(3,5)) ;
        jPanel1.add(jLabelId);
        jPanel1.add(jTAId);



        JLabel jLabelDate = new JLabel("Date: ");                                                //3. Appointment Date
        jPanel1.add(jLabelDate);
        /*
        The code for the Date format is taken from the following

        http://esus.com/creating-a-jformattedtextfield-that-only-accepts-dates/
         */
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField jTADate = new JFormattedTextField(format);
        jTADate.setValue(new Date());
        jPanel1.add(jTADate);


        cPane.add(jPanel1);


        JButton button1;
        JButton button2;

        // construct save button
        button1 = new JButton("Save");                                                         //4. button1 (Save)
        button1.setBounds(250,600,80,50);
        cPane.add(button1);
        button1.addActionListener(e -> {
            int appNo = Integer.parseInt(jTAApNo.getText());
            int id = Integer.parseInt(jTAId.getText());                                                     // Patient id
            //Cal appDate = new Cal(jTADate.getText());

            //appointment = new Appointment(appNo,id,appDate);

            setVisible(false);
            JMenuFrame.appointments.add(appointment);

        });


        // construct clear button
        button2 = new JButton("Clear");                                                        //5. button2 (Clear)
        button2.setBounds(370,250,80,50);
        cPane.add(button2);
        //code for clear field
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jTAApNo.setText("");
                jTAId.setText("");
                jTADate.setText("");
            }
        });

    }// MakeAppointment() end...

}

