package imd0412.drugreminder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

class DrugReminderImplTest {
	
	@Parameters( name = "TestesParametrizaveis" )
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]
		{
			{"10/09/18 14:30", Frequency.SIX_HOURS, 1, Arrays.asList("10/09/18 14:30", "10/09/18 20:30", "11/09/18 02:30", "11/09/18 08:30", "11/19/18 14:30")},
			{"10/09/18 14:30", Frequency.EIGHT_HOURS, 1, Arrays.asList("10/09/18 14:30", "10/09/18 22:30", "11/09/18 06:30", "11/09/18 14:30")},
			{"10/09/18 14:30", Frequency.TWELVE_HOURS, 1, Arrays.asList("10/09/18 14:30", "11/09/18 02:30", "11/09/18 14:30")},
			{"10/09/18 14:30", Frequency.TWENTYFOUR_HOURS, 1, Arrays.asList("10/09/18 14:30", "11/09/18 14:30")},
		});
	}
	
	@Parameter(0)
	public DrugDate startTime;
	@Parameter(1)
	public Frequency frequency;
	@Parameter(2)
	public int duration;
	@Parameter(3)
	public List<String> expectedType;
	

	@Test
	public void testDefineType() throws Exception {
		DrugReminderImpl reminder = new DrugReminderImpl();
		List<String> returnedType = reminder.createReminders(startTime, frequency, duration);
	
		for(int i = 0; i < returnedType.size();i++)
		{
			assertEquals(expectedType.get(i), returnedType.get(i));
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
