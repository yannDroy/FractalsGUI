package main.javabrot.domain;

public class Complex {
  private double re;
  private double im;
  
  private static final Complex i = new Complex(0, 1);
  private static final Complex minusI = new Complex(0, -1);
  private static final Complex one = new Complex(1, 0);
  
  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }
  
  @Override
  public String toString() {
    return "<" + re + " + " + im + "i>";
  }
  
  public static Complex conjugate (Complex c) {
    return new Complex(c.re, -c.im);
  }
  
  public static Complex add (Complex c1, Complex c2) {
    return new Complex(c1.re + c2.re, c1.im + c2.im);
  }
  
  public static Complex sub(Complex c1, Complex c2) {
    Complex tmp = new Complex(-c2.re, -c2.im);
    
    return add(c1, tmp);
  }
  
  public static Complex mult (Complex c1, Complex c2) {
    return new Complex((c1.re * c2.re) - (c1.im * c2.im),
        (c1.re * c2.im) + (c1.im * c2.re));
  }
  
  public static Complex multByReal (Complex c, double x) {
    return mult(c, new Complex(x, 0));
  }
  
  public static Complex square (Complex c) {
    return mult(c, c);
  }
  
  public static Complex cube (Complex c) {
    return mult(c, square(c));
  }
  
  public static Complex toTheFour (Complex c) {
    return square(square(c));
  }
  
  public static Complex divide (Complex c1, Complex c2) {
    return new Complex((c1.re * c2.re + c1.im * c2.im) / (c2.re * c2.re + c2.im * c2.im),
        (c1.im * c2.re - c1.re * c2.im) / (c2.re * c2.re + c2.im * c2.im));
  }
  
  public static Complex inverse (Complex c) {
    return divide(one, c);
  }

  public static Complex sin (Complex c) {
    return new Complex(Math.sin(c.re) * Math.cosh(c.im),
        Math.cos(c.re) * Math.sinh(c.im));
  }
  
  public static Complex cos(Complex c) {
    return new Complex(Math.cos(c.re) * Math.cosh(c.im),
        -Math.sin(c.re) * Math.sinh(c.im));
  }
  
  public static Complex sinh(Complex c) {
    return mult(minusI, cos(mult(i, c)));
  }
  
  public static Complex cosh(Complex c) {
    return cos(mult(i, c));
  }
  
  /*public static Complex sqrt (Complex c) {
    return new Complex(-Math.sqrt(0.5 * (c.re + Math.sqrt(c.re * c.re + c.im * c.im))),
        -(c.im / (2 * Math.sqrt(0.5 * (c.re + Math.sqrt(c.re * c.re + c.im * c.im))))));
  }*/
  
  /*public static Complex exp (Complex c) {
    return new Complex(Math.exp(c.re) * Math.cos(c.im),
        Math.exp(c.re) * Math.sin(c.im));
  }*/
  
  public double magnitude() {
    return Math.sqrt((this.re * this.re) + (this.im * this.im));
  }
  
  // SERIES
  
  public static Complex mandelbrot (Complex z, Complex c){
    return add(square(z), c);
  }
  
  public static Complex handSpinner (Complex z, Complex c){
    Complex tmp = add(square(z), cube(c));
    
    tmp.re -= 1.401155;
    
    return tmp;
  }
  
  public static Complex weird (Complex z, Complex c){
    Complex tmp = new Complex(0.7, -0.2);
    
    return add(add(square(z), cube(add(cube(c), tmp))), i);
  }
  
  public static Complex mandelbrotCubed (Complex z, Complex c){
    return add(cube(z), c);
  }
  
  public static Complex mandelbrotToTheSix (Complex z, Complex c){
    return add(cube(square(z)), c);
  }
  
  public static Complex leaf (Complex z, Complex c){
    return cos(divide(z, c));
  }
  
  public static Complex dragon (Complex z, Complex c){
    return add(sinh(z), inverse(square(c)));
  }
  
  //SETTERS & GETTERS
  
  public double getRe() {
    return re;
  }

  public void setRe(double re) {
    this.re = re;
  }

  public double getIm() {
    return im;
  }

  public void setIm(double im) {
    this.im = im;
  }
}
