package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		Point P = new Point(0, 1, 2, 3);
		P.p1 = 0;
		P.p2 = 1;
		P.p3 = 2;
		P.p4 = 3;
		System.out.println("Расстояние между точками = " + P.distance());
	}
}
