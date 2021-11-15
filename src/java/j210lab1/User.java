/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j210lab1;

/**
 *
 * @author User
 */
public class User {

    int id;
    String role;
    String firstNmae;
    String family;
    String department;

    public User() {

    }

    public User(int id, String role, String firstNmae, String family, String department) {
        this.id = id;
        this.role = role;
        this.firstNmae = firstNmae;
        this.family = family;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public String getFamily() {
        return family;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role=" + role + ", firstNmae=" + firstNmae + ", family=" + family + ", department=" + department + '}';
    }

}
