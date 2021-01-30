package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		Point p1 = new Point(-1, 4);
		Point p2 = new Point(-2, -3);
		System.out.println("Расстояние между двумя точками = " + (p1.distance(p2)));
		System.out.println("Расстояние между двумя точками = " + (p2.distanceInverse(p1)));
	}
}
