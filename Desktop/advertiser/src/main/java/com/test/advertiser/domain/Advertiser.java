package com.test.advertiser.domain;

public class Advertiser  {

    private int id;
    private String name;
    private String contact;
    private int creditlimit;

    public Advertiser() {

    }
    public Advertiser(int id, String name, String contact, int creditlimit) {
        super();
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.creditlimit = creditlimit;
    }
    public Advertiser(String name, String contact, int creditlimit) {
        super();
        this.name = name;
        this.contact = contact;
        this.creditlimit = creditlimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(int creditlimit) {
        this.creditlimit = creditlimit;
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", creditlimit=" + creditlimit +
                '}';
    }

}
