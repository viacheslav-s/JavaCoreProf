package ru.vyacheslav.javacoreprof.l2.model;

public class Items {
    private int id;
    private String prodId;
    private String title;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Товары {" +
                "id=" + id +
                ", prodID='" + prodId + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
