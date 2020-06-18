package ru.stqa.pft.learnjava;

public class Square {
    public double l;

    public Square(double l){
        this.l=l;
    }
    public Square(){}


    public double area(){
        return this.l *this.l;
    }
}
