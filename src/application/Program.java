package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data");
		System.out.printf("Name: ");
		String workerName = sc.nextLine();
		System.out.printf("Level: ");
		String workerLevel = sc.nextLine();
		System.out.printf("Base Salary: ");
		double baseSalary = sc.nextDouble();
		/**lº Em nosso construtor usamos a string para passar o valor para as CONSTANTES **/
		/**2º instanciamos o objeto departamento que ira receber o nome do departamento que é uma string **/
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,new Department(departmentName));
		
		System.out.print("how many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i =1; i <= n; i++) {
			System.out.println("Enter contract "+  i  + "º data");
			System.out.print("Date (DD/MM/YYYY) ");
			/**temos que criar um SIMPLEDATEFORMAT para recebermos a variavel digitada **/
			
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour ");
			double valuePerHour =sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();			
			/**Agora podemos iniciar o nosso contrato **/
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			/**com nosso contrato passamos ao nosso objeto worker **/
			worker.addContract(contract);
			}
		
		System.out.println();
		System.out.print("Enter month and year to calculte income (MM/YYYY): ");
		/** Vamos recortar o string manualmente **/		
		String monthAndYear = sc.next();	
		
		/**pegamos a variavel e a recortamos com a substring o corte ira pegar a posição 0 e 1 **/
		/** Depois convertemos esse valor em inteiro **/
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear +": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();

	}

}
