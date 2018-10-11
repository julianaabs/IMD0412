package imd0412.drugreminder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class DrugReminderTestException {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Parameters(name = "TestesParametrizaveisException")
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]
		{
			{"10/01/17 14:30", Frequency.SIX_HOURS, 1, IllegalArgumentException.class},
			{"10/01/18 25:30", Frequency.EIGHT_HOURS, 1, IllegalArgumentException.class},
			{"10/09/18 14:30", Frequency.TWELVE_HOURS, 0, IllegalArgumentException.class},
			{"10/09/18 14:30", Frequency.TWENTYFOUR_HOURS, 35, IllegalArgumentException.class},
			{"10/09/18 12:30", Frequency.EIGHT_HOURS, -2, IllegalArgumentException.class},
			{"10/09/18 12:30", Frequency.EIGHT_HOURS, 35, IllegalArgumentException.class}
			
		});
	}
	
	@Parameter(0)
	public DrugDate startTime;
	@Parameter(1)
	public Frequency frequency;
	@Parameter(2)
	public int duration;
	@Parameter(3)
	public Class <? extends Exception> expectedException;
	
	@Test(expected = IllegalArgumentException.class)
	public void createReminderTest() {
		expected.expect(expectedException);
		new DrugReminderImpl().createReminders(startTime, frequency, duration);
		
	}

}
