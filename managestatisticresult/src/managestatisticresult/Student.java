/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestatisticresult;

public class Student {
    private String StudentName;
    private String Classes;
    private double Math,Chemistry,physics;

    public Student() {
    }

    public Student(String StudentName, String Classes, double Math, double Chemistry, double physics) {
        this.StudentName = StudentName;
        this.Classes = Classes;
        this.Math = Math;
        this.Chemistry = Chemistry;
        this.physics = physics;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getClasses() {
        return Classes;
    }

    public void setClasses(String Class) {
        this.Classes = Class;
    }

    public double getMath() {
        return Math;
    }

    public void setMath(double Math) {
        this.Math = Math;
    }

    public double getChemistry() {
        return Chemistry;
    }

    public void setChemistry(double Chemistry) {
        this.Chemistry = Chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }
    
    
}
