package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uh1.ac.ma.metier.entities.Client;

public class Util {
	
	
	public static int getAge(Date dateOfBirth) {

	    Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();

	    int age = 0;

	    birthDate.setTime(dateOfBirth);
	    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
	            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
	        age--;

	    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
	              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
	        age--;
	    }
	    
		System.out.println("=======================****************** get age" );

	    return age;
	}
	
	
	public static boolean sontFamille(List<Client> clients){
		int i = 0;
		String nom = clients.get(i).getNom();
		while( i < clients.size() ){
			System.out.println("=======================****************** famille" );
			if ( !clients.get(i).getNom().equals(nom)) return false;
			i++;
		}
		System.out.println("=======================****************** fin famille" );

		return true;
	}
	
	
	
	public static boolean sontMajeurs(List<Client> clients){
		int i = 0;
		while( i < clients.size() ){
			if ( Util.getAge(clients.get(i).getDateNaissance()) < 18 ) return false;
			i++;
		}
		return true;
	}
	
	
	public static double calculerTaux(List<Client> clients){
		double taux = 0;
		int i = 0;
		while( i < clients.size() ){
			System.out.println("=======================****************** age" );
			if( Util.getAge(clients.get(i).getDateNaissance()) < 18 ) taux = taux +5;
			else if ( Util.getAge(clients.get(i).getDateNaissance()) >= 18  && Util.getAge(clients.get(i).getDateNaissance()) < 25 ) taux = taux + 4;
			else if ( Util.getAge(clients.get(i).getDateNaissance()) >= 25  && Util.getAge(clients.get(i).getDateNaissance()) < 40 ) taux = taux + 3.5;
			else if ( Util.getAge(clients.get(i).getDateNaissance()) >= 40  && Util.getAge(clients.get(i).getDateNaissance()) < 40 ) taux = taux + 3;
			else taux = taux + 2.5;
			
			i++;
		}
		System.out.println("=======================****************** fin age" );

		return taux;
	}
	
	
	public static Date getDateFromString(String date){
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return myFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	

}
