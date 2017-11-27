/*
 * @author Donatien Criaud
 * 
 */
package simergy.tests;

import org.junit.Test;

import simergy.core.distributions.Deterministic;
import simergy.core.distributions.Exponential;
import simergy.core.distributions.Uniform;

public class DistriTest {

	// Ici on test si l'espérance expérimentale de nos lois est bien de 10
	// Cela m'a permis de détecter une petite erreur dans la loi exponentielle 
	@Test
	public void test() {
		Exponential e = new Exponential(0.1);
		Uniform u = new Uniform(0,20);
		Deterministic d = new Deterministic(10);
		double sumE = 0;
		double sumU = 0;
		double sumD = 0;
		for(int i=0;i<100000;i++){
			sumE += e.generateSample();
			sumU += u.generateSample();
			sumD += d.generateSample();
		}
		System.out.println("Espérance exp = " + Double.toString(sumE/100000));
		System.out.println("Espérance uni = " + Double.toString(sumU/100000));
		System.out.println("Espérance det = " + Double.toString(sumD/100000));
	}

}
