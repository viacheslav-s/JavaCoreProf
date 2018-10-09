package ru.vyacheslav.javacoreprof.l6.task3.model;

public class Students {
    private int id;
    private String surname;
    private int score;

//    public Students(String surname,int score) {
//        this.surname = surname;
//        this.score = score;
//    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Студенты {" +
                "id=" + id +
                ", Фамилия='" + surname + '\'' +
                ", Баллы=" + score +
                '}';
    }
}
