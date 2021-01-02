package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	/*** FAZENDO AS ASSOCIA��ES ***/

	/** Ap�s criarmos as classes necess�rias vamos criar as associa��es **/

	/** o o WORKER tem apenas um DEPARTMENT ent�o **/

	private Department department;

	/** o o WORKER tem varios CONTRACTS ent�o teremos que usar o tipo LIST **/

	private List<HourContract> contracts = new ArrayList<>();

	/**
	 * Ja vamos deixar a lista isntanciada aqui dentro dessa classe para a lista
	 * come�ar vazia
	 ***/

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/**
	 * N�o podemos ter o SET PARA CONTRACTS POIS OS METODOS ADD E REMOVE FAR�O ISSO
	 **/

	/**
	 * No proximo construtor n�o selecionaremos nada que contenha lista ou seja o
	 * CONTRACTS
	 **/

	/** METODOS **/

	public void addContract(HourContract contract) {
		/*
		 * nesse metodo ele vai pegar a lista de contratos e adcionar o parametro
		 * passado
		 */
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		/*
		 * nesse metodo ele vai pegar a lista de contratos e remover o parametro passado
		 */
		contracts.remove(contract);
	}

	public double income(int year, int month) {
		/** Esse metodo vai calcular quanto o funcionario ganhou no m�s
		 * 
		 * ent�o pegaremos o salario base adicionando o quanto o cliente ganhou no
		 * contrato daquele m�s **/

		/** 1� criamos uma variavel para saber o salario **/

		double sum = baseSalary;

		/** Agora vamos percorrer os contratos para saber quais s�o do mes e ano que
		 * passamos como parametros se for do ano e mes ser� adicionado na soma **/

		/** 2� criamos um objeto calendar **/
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {
			/** So ser� acessada a lista se o ano e mes forem iguais ent�o **/
			/** 1� criamos uma variavel do tipo ano para representar o ano desse contrato C **/
			/** 3� Apos criarmos o calendario vamos colocar para cada contrato c vamos setar
			 * nesse calendario a data do contrato c **/
			/** 4� ou seja pegamos a data do contrato como se fosse a data do calendario **/

			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);

			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}

		}

		return sum;

	}
}
