import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.awt.FlowLayout;
import javax.swing.JFrame;


public class AddPatient extends JFrame{

    public Patient getPatient(){ return patient; }

    JButton button1, button2;

    private Patient patient;

    public AddPatient() {
        Container cPane;

        //set the frame properties
        setTitle("Add Patient");
        setSize(500, 600);
        setResizable(false);
        setLocation(500, 500);
        // shut down the program when the window is closed
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.gray);

        JPanel jPanel1 = new JPanel();
        jPanel1.setSize(700, 400);


        //1. creating jLabel and JTextArea for Name
        JLabel jLabelName = new JLabel("Name: ");
        JTextField jTAName = new JTextField();
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelName);
        jPanel1.add(jTAName);

        //2. creating jLabel and JTextArea for Address
        JLabel jLabelAddress = new JLabel("Address: ");
        JTextField jTAAddress = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelAddress);
        jPanel1.add(jTAAddress);

        //3. creating jLabel and JTextArea for Phone
        JLabel jLabelPhone = new JLabel("Phone: ");
        JTextField jTAPhone = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 5));
        jPanel1.add(jLabelPhone);
        jPanel1.add(jTAPhone);

        //4. creating jLabel and JTextArea for Gender
        JLabel jLabelGender = new JLabel("Gender: (M/F/X) \n\n");
        JTextField jTAGender = new JTextField(20);
        jPanel1.setLayout(new GridLayout(5, 6));
        jPanel1.add(jLabelGender);
        jPanel1.add(jTAGender);


        cPane.add(jPanel1);


        /**
         * construct two buttons
         */

        //5. construct save button
        button1 = new JButton("Save");
        button1.setBounds(300, 600, 80, 50);
        cPane.add(button1);
        button1.addActionListener(e -> {
            String name = jTAName.getText();
            String address = jTAAddress.getText();
            String phone = jTAPhone.getText();
            char gender = jTAGender.getText().charAt(0);
            {
                if (gender != 'M' || gender != 'F' || gender != 'X'){
                    JOptionPane.showMessageDialog(null,"Gender no valid","Error",JOptionPane.INFORMATION_MESSAGE); }
            }

            patient = new Patient(name,address,phone,gender);
            setVisible(false);

            JMenuFrame.patients.add(patient);
        });


        //6. construct clear button
        button2 = new JButton("Clear");
        button2.setBounds(370, 250, 80, 50);
        cPane.add(button2);

        //actionListener to clear text fields
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jTAName.setText("");
                jTAAddress.setText("");
                jTAPhone.setText("");
                jTAGender.setText("");
            }
        });

    } // AddPatient end...

}

