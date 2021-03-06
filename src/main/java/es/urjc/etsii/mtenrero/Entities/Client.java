package es.urjc.etsii.mtenrero.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Client extends User {

    public final static String ROLE = "ROLE_CLIENT";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    @NotNull
    private int legalID;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private int phone1;
    private int phone2;
    private String addressStreet;
    private String addressCity;
    private int addressZIP;
    private int hoursBeforeNotification;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Client() {
        super.setRoles(ROLE);
    }

    public Client(int legalID, String firstName, String lastName) {
        this.legalID = legalID;
        this.firstName = firstName;
        this.lastName = lastName;
        super.setRoles(ROLE);
        super.setLogon(Integer.toString(legalID));
    }

    public Client(int legalID, String firstName, String lastName, int phone1, String addressStreet, String addressCity, int addressZIP, String email) {
        this.legalID = legalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressZIP = addressZIP;
        this.email = email;
        super.setRoles(ROLE);
        super.setLogon(Integer.toString(legalID));
        super.setPasswordHash(Integer.toString(phone1));
    }
    public long getId() {
        return this.id;
    }


    public int getLegalID() {
        return legalID;
    }

    public void setLegalID(int legalID) {
        this.legalID = legalID;
        super.setLogon(Integer.toString(legalID));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        this.phone1 = phone1;
        super.setPasswordHash(Integer.toString(phone1));
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public int getAddressZIP() {
        return addressZIP;
    }

    public void setAddressZIP(int addressZIP) {
        this.addressZIP = addressZIP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object obj) {
        return this.legalID == ((Client) obj).legalID;
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName;
    }

    @Override
    public int hashCode() {
        return this.legalID;
    }

    public int getHoursBeforeNotification() {
        return hoursBeforeNotification;
    }

    public void setHoursBeforeNotification(int hoursBeforeNotification) {
        this.hoursBeforeNotification = hoursBeforeNotification;
    }
}
