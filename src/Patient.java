import java.lang.String;
import java.io.Serializable;


public class Patient implements Comparable<Patient>, Serializable{ //JB added Serializable interface to ensure arraylist can be saved successfully

    //private variables
    private static int autoID;
    private String name;
    private String address;
    private String phone;
    private char gender;
    private int id;


    //no-argument constructor
    public Patient()
    {
        name = "Null";
        address = "No Address Specified";
        phone = "Null";
        //dob = 0;
        gender = 'X';
        autoID = JMenuFrame.patients.size() + 1; //JB added code to autoincrement patient ID
        id = autoID;
    }


    //argument constructor
    public Patient(String name, String address, String phone, char gender)
    {
        autoID = JMenuFrame.patients.size() + 1;
        setName(name);
        setAddress(address);
        setPhone(phone);
        setGender(gender);
        this.id = autoID;
    }


    //getters
    /** method to return the height value
     * @return the id of a patient object
     */
    public static int getAutoID() {
        return autoID;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public char getGender() { return gender; }


    //setters
    /** method to set the name, address, phone and gender value
     * @param name of a patient object
     */
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setGender(char gender) {this.gender = gender; }


    //toString method
    @Override
    public String toString() {
        return "\n\n" +
                "ID:  " + getId() +
                "\nName:  " + getName()  +
                "\nAddress:  " + getAddress() +
                "\nPhone:  " + getPhone() +
                "\nGender:  " + getGender() +
                "\n";
    }


    public int compareTo(Patient another) { return this.name.compareTo(another.getName()); }


}

