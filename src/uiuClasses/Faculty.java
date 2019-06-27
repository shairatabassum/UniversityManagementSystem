/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuClasses;

/**
 *
 * @author MeRiDa
 */
public class Faculty extends Person {
    
    private String Designation;
    private String Department;
    private String Website;
    private String Room;
    
    public Faculty(String Name, String Username, String Password, String Mobile, String Email, String Designation, String Department, String Website, String Room) {
        super(Name, Username, Password, Mobile, Email);
        this.Designation = Designation;
        this.Department = Department;
        this.Website = Website;
        this.Room = Room;
    }

    /**
     * @return the Designation
     */
    public String getDesignation() {
        return Designation;
    }

    /**
     * @param Designation the Designation to set
     */
    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    /**
     * @return the Department
     */
    public String getDepartment() {
        return Department;
    }

    /**
     * @param Department the Department to set
     */
    public void setDepartment(String Department) {
        this.Department = Department;
    }

    /**
     * @return the Website
     */
    public String getWebsite() {
        return Website;
    }

    /**
     * @param Website the Website to set
     */
    public void setWebsite(String Website) {
        this.Website = Website;
    }

    /**
     * @return the Room
     */
    public String getRoom() {
        return Room;
    }

    /**
     * @param Room the Room to set
     */
    public void setRoom(String Room) {
        this.Room = Room;
    }
    
    
}
