package com.project3.www.AutismAtEase;


/**
 * Created by Madhav on 3/6/2018.
 * Refrenced: Michael Eierman on 11/10/2016.
 */

class Contact {

    private int contactID;
    private String fName;
    private String lName;
    private String eMail;
    private String gender;
    private String age;
    private String password;

    public Contact() {
        contactID = -1;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int i) {
        contactID = i;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String s) {
        fName = s;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String s) {
        lName = s;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String s) {
        gender = s;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String s) {
        age = s;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String s) {
        eMail = s;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String s) {
        password = s;
    }

}
