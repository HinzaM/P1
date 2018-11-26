/**
 * Created by T00203592.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
/**
 *   JMenuFrame: includes one JMenuBar,3 JMenus and 2 JMenuItem objects.
 *   When a menu item is selected, a string
 *   showing which menu choice is selected will appear in a label on the frame.
 */

/**This is an instantiable JMenuFrame class.
 @author Hinza
 @version 1.0 */

public class JMenuFrame extends JFrame implements ActionListener {
    JMenu fileMenu;
    JMenu appointmentMenu;
    JMenu patientMenu;
    JLabel response; // to hold a result from the menus

    // Patient [] patients;
    int count;

    static ArrayList<Patient> patients;
    static ArrayList<Appointment> appointments;

    //------------------------------------------------------------------------------------------------------------------
    // creates a new system and when ViewPatients is clicked it displays the patient list
    public void newSystem()
    {
        //patients = new ArrayList<Patient>();

        //JB added code to ensure the arraylist is only initialised empty on one occasion
        if(open().equals("problem"))
            patients = new ArrayList<Patient>();
        else
            open();
    }


    //------------------------------------------------------------------------------------------------------------------
    public JMenuFrame() throws IOException
    {
        newSystem();
        Container cPane;

        //1. setting the frame properties
        setTitle     ("MEDIDOC");
        setSize      (800,600);
        setResizable (false);
        setLocation  (300,300);

        //2. shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowEventHandler());

        cPane = getContentPane();

        //3. create a BufferedImage from a jpg file
        BufferedImage image = ImageIO.read(new File("src\\docBg.jpg"));
        JLabel mainLabel = new JLabel(new ImageIcon(image));
        setContentPane(mainLabel);
        JPanel jpanel=new JPanel();
        jpanel.setSize(50,50);
        //image end...

        //4. creating menu items
        createFileMenu();
        createAppointmentMenu();
        createPatientMenu();

        //5. adding menu items to the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.orange);
        menuBar.add(fileMenu);
        menuBar.add(appointmentMenu);
        menuBar.add(patientMenu);

        //6. creating and positioning title/response label
        response = new JLabel("Welcome to MEDIDOC\n\n\n" );
        response.setBounds(395,10,500,50);
        response.setFont(new Font("Bold", Font.BOLD, 17));
        mainLabel.add(response);

        //7. creating buttons
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        JButton button5;


        //8. construct button 3
        button3 = new JButton("Add Patient");                                              // button3 (Add Patient)
        button3.setBounds(380,70,200,50);
        mainLabel.add(button3);
        button3.addActionListener(e -> {
            AddPatient patientDetails = new AddPatient();
            patientDetails.setVisible(true);
            // patients.add(patientDetails.getPatient());
        });


        //9. construct button 4
        button4 = new JButton("View Patients");                                           // button4 (View Patient)
        button4.setBounds(380,140,200,50);
        mainLabel.add(button4);
        button4.addActionListener(e -> {
            ViewPatients patientDetails = new ViewPatients();
            patientDetails.setVisible(true);

            /** JTextArea display team
             *
             * @param patients an array of Patient
             *
             */
            JTextArea jta = new JTextArea();
            Font font = new Font("monospaced",Font.PLAIN,13);

            jta.setFont(font);
            jta.setText("\t--- Patient List ---\n");

            for(Patient p:patients)
            {
                if (p == null)
                    break;

                else {
                    jta.append(p.toString());
                }
            }
            JOptionPane.showMessageDialog(null,jta);
        });

        //10. construct button 1                                                            // button1 (Make Appointment)
        button1 = new JButton("Make Appointment");
        button1.setBounds(380,210,200,50);
        //mainLabel.setLocation(150, 371);
        mainLabel.add(button1);
        button1.addActionListener(e -> {
            MakeAppointment appointments = new MakeAppointment();
            appointments.setVisible(true);
        });


        //11. construct button 2                                                            // button2 (View Appointment)
        button2 = new JButton("View Appointments");
        button2.setBounds(380,280,200,50);
        //jpanel.setLocation(50, 371);
        mainLabel.add(button2);
        button2.addActionListener(e -> {
            ViewAppointments appointmentDetails = new ViewAppointments();
            appointmentDetails.setVisible(true);

            /** JTextArea display team
             *
             * @param appointments an array of Appointment
             *
             */
            JTextArea jta = new JTextArea();
            Font font = new Font("monospaced",Font.PLAIN,13);

            jta.setFont(font);
            jta.setText("--- Information ---\n");

            for(Appointment a:appointments)
            {
                if (a == null)
                    break;

                else {
                    jta.append(a.toString());
                }
            }
            JOptionPane.showMessageDialog(null,jta);
        });


        //12. construct button 5                                                                // button5 (Doctor Info)
        button5 = new JButton("Doctor Profile");
        button5.setBounds(380,400,200,50);
        mainLabel.add(button5);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, "Dr. Matt Smith \n- General Practitioner " +
                                "\n- 11 years experience" +
                                "\n\n\nClinic Hours\n- Sat-Sun:   9:00am - 12:00pm " +
                                "                   \n- Mon-Thus:  9:00am - 3:00pm " +
                                "                   \n- Friday:    Closed \n","Doctor Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cPane.add(jpanel);

    }// end constructor



    //------------------------------------------------------------------------------------------------------------------
    /**
     * constructing menu items
     */

    //13. creating Appointment menu items
    private void createAppointmentMenu( )
    {
        // creating the menu
        appointmentMenu = new JMenu("Appointments");

    } // end createAppointmentMenu



    //14. creating Patient Menu items
    private void createPatientMenu( )
    {
        patientMenu = new JMenu("Patients");

    } // end createPatientMenu


    //15. creating file menu
    private void createFileMenu(){

        fileMenu = new JMenu("File");

        JMenuItem item1;
        JMenuItem item2;

        item1 = new JMenuItem("Save");                                                                       //Save
        item1.addActionListener(this);
        fileMenu.add(item1);

        fileMenu.addSeparator();

        item2 = new JMenuItem("Quit");                                                                       //Quit
        item2.addActionListener(this);
        fileMenu.add(item2);
    }

    //------------------------------------------------------------------------------------------------------------------
    //16. creating action listeners
    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }

        else if (event.getActionCommand() .equals ("Save"))
        {
            try{
                save();
                showMessage("Data saved successfully");
            }

            catch (IOException f)
            {
                showMessage("Not able to save the file:\n"+
                        "Check the console printout for clues to why. ");
                f.printStackTrace();
            }

        }// else if

        else
            showMessage("I have no idea what you clicked");
        // end else
    } // end actionPerformed

    /** Quits the program when quit is clicked in menu items
     * or
     * Displays text telling what menu item is selected */



    //------------------------------------------------------------------------------------------------------------------
    //17. save method
    public void save() throws IOException {
        //	public void save(){// throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream ("patients.dat"));
        os.writeObject(patients);
        os.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    //18. open method
    public String open() {
        count = 0;
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("patients.dat"));
            patients  = (ArrayList<Patient>) is.readObject();
            //for(Patient p:patients)
            //JOptionPane.showMessageDialog(null,p);
            is.close();
            return "good";
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Open didn't work");
            return "problem";
            // e.printStackTrace();
        }

    } // end open()



    //------------------------------------------------------------------------------------------------------------------
    //19. creating JMenuFrame
    public static void main(String[] args) throws IOException
    {
        JMenuFrame frame = new JMenuFrame();

        frame.setVisible(true);
        // frame.newSystem();
    }

    //------------------------------------------------------------------------------------------------------------------
    //20. creating event handler to close the window

    private class WindowEventHandler extends WindowAdapter
    {
        //private class WindowEventHandler implements WindowListener {
        public void windowClosing(WindowEvent e) {
            JOptionPane.showMessageDialog(null, "Closing the window");
            System.exit(0);
        } // end method
    }



    //------------------------------------------------------------------------------------------------------------------
    //21. this shows a particular message when an action event is performed
    /** utility methods to make the code simpler */
    public void showMessage (String s){
        JOptionPane.showMessageDialog(null,s);
    }

}


// end class
