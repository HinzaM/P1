import java.lang.String;
import java.io.Serializable;

/**This is an instantiable Patient class.
 @author Hinza
 @version 1.0 */

public class Patient implements Comparable<Patient>, Serializable{ //JB added Serializable interface to ensure arraylist can be saved successfully

    //attributes
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
    /** argument constructor method
     @param name the full name of the patient
     @param address the address of patient
     @param phone the phone number of patient
     @param gender the gender of patient
     */
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
    public static int getAutoID() {
        return autoID;
    }
    /** methods to return the patient id
     * @return the id of a patient object
     */
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public char getGender() { return gender; }


    //setters
    /** method to set the name
     * @param name of a patient object
     */
    public void setName(String name) { this.name = name; }
    /** method to set the address
     * @param address of a patient object
     */
    public void setAddress(String address) { this.address = address; }
    /** method to set the phone
     * @param phone of a patient object
     */
    public void setPhone(String phone) { this.phone = phone; }
    /** method to set the gender value
     * @param gender of a patient object
     */
    public void setGender(char gender) {this.gender = gender; }


    //toString method
    /** toString method to return the patient details
     *@return the id, name, address, phone and gender of the patient as a string */

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

