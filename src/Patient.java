import java.math.BigInteger;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.lang.String;
import java.io.Serializable;

public class Patient implements Comparable<Patient>, Serializable{ //JB added Serializable interface to ensure arraylist can be saved successfully

    //private variables
    private static int autoID=0;
    private String name;
    private String address;
    private String phone;
    //protected Date dob;
    private char gender;
    private int id;
   // private Date regDate;


    //no-argument constructor
    public Patient()
    {
        name = "Null";
        address = "No Address Specified";
        phone = "Null";
        //dob = 0;
        gender = 'X';
        //regDate;
        autoID++;  //JB added code to autoincrement patient ID
        id = autoID;
    }


    //argument constructor
    public Patient(String name, String address, String phone, char gender)
    {
        autoID++;
        this.name = name;
        setAddress(address);
        this.phone = phone;
        //this.dob = dob;
        this.gender = gender;
        //this.regDate = regDate;
        this.id = autoID;
    }

    //getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    //public Date getDob() { return dob; }
    public char getGender() { return gender; }
   // public Date getRegDate() { return regDate; }


    //setters
    public void setName(String name)
    {
        if (name == null)
        {
            //throw new IllegalArgumentException();
            JOptionPane.showMessageDialog(null,"Name required!");
        }
        else
            this.name = name;

    }

    public void setAddress(String address) { this.address = address; }

    public void setPhone(String phone) { this.phone = phone; }

    //public void setDob(Date dob) { this.dob = dob; }

    public void setGender(char gender)
    {
        if(gender != 'M' || gender != 'F' || gender != 'X')
        {
            JOptionPane.showMessageDialog(null,"Error! \n 'M' for Make \n 'F' for Female \n 'X' for Other ");
            //throw new IllegalArgumentException();
        }
        else
            this.gender = gender;

    }
    //public void setRegDate(Date regDate) { this.regDate = regDate; }



    //toString
    @Override
    public String toString() {
        return "Patient List \n\n" +
                "ID:     " + getId() +
                "\nName:   " + name  +
                "\nAddress:" + address +
                "\nPhone:  " + phone +
                //", dob=" + dob +
                "\nGender: " + gender +
                //", regDate=" + regDate +
                "\n";
    }

    public int compareTo(Patient another) {
        return this.name.compareTo(another.getName());
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Patient) {
            Patient another = (Patient) obj;
            if (this.name.equals(another.getName())) {
                return true;
            }
        }

        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }


}

