public class Appointment {

    //1. private variables
    private int appNo;      // appointment number
    private int id;         // patient id
    private Cal appDate;   //appointment date


    //2. no-argument constructor
    public Appointment()
    {
        appNo = 0;
        id = 0;
        appDate = new Cal();
    }

    //3. argument constructor
    public Appointment(int appNo, int id, int dd, int mm, int yy) {
        setAppNo(appNo);
        setId(id);
        appDate = new Cal(dd,mm,yy);
    }


    //4. getters
    /** method to return the height value
     * @return the appNo of an appointment object
     */
    public int getAppNo() { return appNo; }
    public int getId() { return id; }
    public Cal getAppDate() { return appDate; }


    //5. setters
    /** method to set the age value
     * @param the appDate of an appointment object
     */
    public void setAppNo(int appNo) { this.appNo = appNo; }
    public void setId(int id) { this.id = id; }
    public void setAppDate(int dd, int mm, int yy) { appDate.setDate(dd, mm, yy); }


    //6. toString method
    @Override
    public String toString() {
        return "Appointment: \n\n" +
                "Appointment No: " + getAppNo() +
                "\nPatient Id: " + getId() +
                "\nAppointment Date: " + appDate.toString() +
                "\n";
    }
}
