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
public class Student extends Person {
    
    private String FatherName;
    private String MotherName;
    private String Address;
    private String DOB;
    private String BloodGroup;
    private String Department;
    private String Batch;
    
    public Student(String Name, String Username, String Password, String Mobile, String Email, String Address, String DOB, String BloodGroup, String Department, String Batch) {
        super(Name, Username, Password, Mobile, Email);
        this.Address = Address;
        this.DOB = DOB;
        this.BloodGroup = BloodGroup;
        this.Department = Department;
        this.Batch = Batch;
        
    }

    /**
     * @return the FatherName
     */
    public String getFatherName() {
        return FatherName;
    }

    /**
     * @param FatherName the FatherName to set
     */
    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    /**
     * @return the MotherName
     */
    public String getMotherName() {
        return MotherName;
    }

    /**
     * @param MotherName the MotherName to set
     */
    public void setMotherName(String MotherName) {
        this.MotherName = MotherName;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the BloodGroup
     */
    public String getBloodGroup() {
        return BloodGroup;
    }

    /**
     * @param BloodGroup the BloodGroup to set
     */
    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
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
     * @return the Batch
     */
    public String getBatch() {
        return Batch;
    }

    /**
     * @param Batch the Batch to set
     */
    public void setBatch(String Batch) {
        this.Batch = Batch;
    }
    
    
}
