package model;

public class Customer {
    public Customer(String fname, String lname, String dnascita, String genderA, String genderB, String citta, String provincia, String cap, String strada, String idcard, String email, String phone, String website) {
        this.fname = fname;
        this.lname = lname;
        this.dnascita = dnascita;
        this.genderA = genderA;
        this.genderB = genderB;
        this.citta = citta;
        this.provincia = provincia;
        this.cap = cap;
        this.strada = strada;
        this.idcard = idcard;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public Customer(){};

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDnascita() {
        return dnascita;
    }

    public String getGenderA() {
        return genderA;
    }

    public String getGenderB() {
        return genderB;
    }

    public String getCitta() {
        return citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCap() {
        return cap;
    }

    public String getStrada() {
        return strada;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setDnascita(String dnascita) {
        this.dnascita = dnascita;
    }

    public void setGenderA(String genderA) {
        this.genderA = genderA;
    }

    public void setGenderB(String genderB) {
        this.genderB = genderB;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private String fname, lname, dnascita, genderA, genderB, citta, provincia, cap, strada, idcard, email, phone, website;

    }
