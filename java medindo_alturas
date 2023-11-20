package application;

import java.util.Locale;
import java.util.Scanner;

public class Programa2 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantas alturas você deseja inserir? ");
		int n = sc.nextInt();
		double[] vect = new double[n];

    System.out.println("Insira as alturas: ");
		for(int i=0;i<n;i++) {
			vect[i] = sc.nextDouble();
		}
		
		double sum = 0.0;
		for(int i=0;i<n;i++) {

			sum += vect[i];
		}
		double avg = sum / n;
		
		System.out.printf("media: %.2f%n",avg);
		
		
		sc.close();
	}

}
