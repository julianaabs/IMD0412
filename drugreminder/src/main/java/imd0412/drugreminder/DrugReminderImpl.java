package imd0412.drugreminder;

import java.util.ArrayList;
import java.util.List;

public class DrugReminderImpl implements IReminder {
	
	private String nameMedication;
	private String dosage;
	private String startTime;
	private DrugDate time;
	private Frequency frequency;
	private Integer duration;
	
	public DrugReminderImpl() {
		
	}
	
	public DrugReminderImpl(String nameMedication, String dosage, String startTime, Frequency frequency, Integer duration) {
		this.nameMedication = nameMedication;
		this.dosage = dosage;
		this.startTime = startTime;
		this.frequency = frequency;
		this.duration = duration;
	}
		
	public String getNameMedication() {
		return nameMedication;
	}

	public void setNameMedication(String nameMedication) {
		this.nameMedication = nameMedication;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public DrugDate getTime() {
		return time;
	}

	public void setTime(DrugDate time) {
		this.time = time;
	}

	public List<String> createReminders(String startTime, Frequency frequency, Integer duration) {
		//throw new IllegalStateException("Method createReminders not yet implemented.");
		
		
		List<String> reminders = new ArrayList<String>();
		
		time.convertDate(startTime);
		
		if(frequency == Frequency.SIX_HOURS) {
			time.sixHours(day, month, year, hour, minutes, duration);
		}
		if(frequency == Frequency.EIGHT_HOURS) {
			time.eightHours(day, month, year, hour, minutes, duration);
		}
		if(frequency == Frequency.TWELVE_HOURS) {
			time.twelveHours(day, month, year, hour, minutes, duration);
		}
		if(frequency == Frequency.TWENTYFOUR_HOURS) {
			time.twentyFourHours(day, month, year, hour, minutes, duration);
		}
		
		time.toString();
		
		
		return reminders;
		
				
	}
	
	

}
