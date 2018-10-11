package imd0412.drugreminder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	My own API for Date.	
 * 
 * @author julianabs, GabrielUsui
 *
 */
public class DrugDate {
	
	
	private String data;
	private String hora;
	private String[] partData;
	private String[] partHora;
	private String[] parts;

	public DrugDate() 
	{
	
	}
	
		
	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String[] getParts() {
		return parts;
	}


	public void setParts(String[] parts) {
		this.parts = parts;
	}

	public String[] getPartData() {
		return partData;
	}


	public void setPartData(String[] partData) {
		this.partData = partData;
	}


	public String[] getPartHora() {
		return partHora;
	}


	public void setPartHora(String[] partHora) {
		this.partHora = partHora;
	}


	/**
	 * Metodo converte String no formato "dd/mm/aa hh:mm" em uma lista de inteiros.
	 *
	 * 
	 */
	
	
	public List<Integer> convertDate(String startTime)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		try
		{
			parts = startTime.split(" ");
			
			if(parts.length == 2)
			{
				data = parts[0];
				hora = parts[1];
				
				partData = data.split("/");
				partHora = hora.split(":");
				
				if(partData.length == 3)
				{
					for(int i = 0; i < partData.length; i++)
					{
						
						result.add(Integer.parseInt(partData[i]));
					}
				}
				else {
					throw new IllegalArgumentException("Argumento inválido");
				}
				
				if(partHora.length == 2)
				{
					for(int i = 0; i < partHora.length; i++)
					{
						result.add(Integer.parseInt(partData[i]));
					}
				}
				else 
				{
					throw new IllegalArgumentException("Argumento inválido");
				}
			}
			else 
			{
				throw new IllegalArgumentException("Argumento inválido");
			}
			
		}
		catch(IllegalArgumentException e){
			System.out.println("Argumento inválido");
		}
		
		return result;
	}
	
	public List<String> sixHours(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration) {
		
		List<String> reminders = new ArrayList<String>();
		String reminder = convertDate(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration);
		reminders.add(reminder);
		
				
		for(int i = 0; i < duration; i++) {
			hour += 6;
			if(hour >= 24) {
				hour = hour%24;
				day++;
			}
			if(day > 31) {
				day = 1;
				month ++;
			}
			if(month == 2) {
				if(day > 28 && hour>=24) {
					month ++;
				}
			}
			if(day == 30 && (month == 4 || month == 6 || month == 8 || month == 9 || month == 11)) {
				day = 1;
				month++;
			}
			if(month > 12) {
				year++;
				day = 1;
				month = 1;
			}
			if(day > 31) {
				month++;
			}			
		}
		
		return reminders;
	}
	
	public List<String> eightHours(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration) {
		
		List<String> reminders = new ArrayList<String>();
		String reminder = convertDate(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration);
		reminders.add(reminder);
		
		for(int i = 0; i < duration; i++) {
			hour += 8;
			if(hour >= 24) {
				hour = hour%24;
				day++;
			}
			if(day > 31) {
				day = 1;
				month ++;
			}
			if(month == 2) {
				if(day > 28 && hour>=24) {
					month ++;
				}
			}
			if(day == 30 && (month == 4 || month == 6 || month == 8 || month == 9 || month == 11)) {
				day = 1;
				month++;
			}
			if(month > 12) {
				year++;
				day = 1;
				month = 1;
			}
			if(day > 31) {
				month++;
			}		
		
		}
		
		return reminders;
	}
	
	public List<String> twelveHours(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration) {
		List<String> reminders = new ArrayList<String>();
		String reminder = convertDate(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration);
		reminders.add(reminder);
		
		for(int i = 0; i < duration; i++) {
			hour += 12;
			if(hour >= 24) {
				hour = hour%24;
				day++;
			}
			if(day > 31) {
				day = 1;
				month ++;
			}
			if(month == 2) {
				if(day > 28 && hour>=24) {
					month ++;
				}
			}
			if(day == 30 && (month == 4 || month == 6 || month == 8 || month == 9 || month == 11)) {
				day = 1;
				month++;
			}
			if(month > 12) {
				year++;
				day = 1;
				month = 1;
			}
			if(day > 31) {
				month++;
			}		
		
		}
		
		return reminders;
		
	}
	
	public List<String> twentyFourHours(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration) {
		List<String> reminders = new ArrayList<String>();
		String reminder = convertDate(Integer day, Integer month, Integer year, Integer hour, Integer minutes, Integer duration);
		reminders.add(reminder);
		
		for(int i = 0; i < duration; i++) {
			hour += 24;
			if(hour >= 24) {
				hour = hour%24;
				day++;
			}
			if(day > 31) {
				day = 1;
				month ++;
			}
			if(month == 2) {
				if(day > 28 && hour>=24) {
					month ++;
				}
			}
			if(day == 30 && (month == 4 || month == 6 || month == 8 || month == 9 || month == 11)) {
				day = 1;
				month++;
			}
			if(month > 12) {
				year++;
				day = 1;
				month = 1;
			}
			if(day > 31) {
				month++;
			}		
		
		}
		
		return reminders;
	}

	@Override
	public String toString() {
		return "DrugDate [data=" + data + ", hora=" + hora + ", partData=" + Arrays.toString(partData) + ", partHora="
				+ Arrays.toString(partHora) + ", parts=" + Arrays.toString(parts) + ", getData()=" + getData()
				+ ", getHora()=" + getHora() + ", getParts()=" + Arrays.toString(getParts()) + ", getPartData()="
				+ Arrays.toString(getPartData()) + ", getPartHora()=" + Arrays.toString(getPartHora()) + "]";
	}
	
	
}
