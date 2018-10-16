package imd0412.findmyrestaurant.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import imd0412.findmyrestaurant.domain.GeoCoordinate;
import imd0412.findmyrestaurant.domain.Restaurant;
import imd0412.findmyrestaurant.domain.Review;
import imd0412.findmyrestaurant.service.IMapService;
import imd0412.findmyrestaurant.service.IRestaurantService;

@RunWith(MockitoJUnitRunner.class)
public class FindMyRestaurantAPITest
{
	@Mock 
	private List mockList;
	
	@Test
	public final void testNearRestaurants_WithStubs()
	{
		IMapService mapService = new IMapService()
		{

			public GeoCoordinate convertToGeographicCoordinates(String address)
			{
				GeoCoordinate GeoTest;
				GeoTest = new GeoCoordinate(-5.824727,-35.2118145);
				Mockito.when(convertToGeographicCoordinates("Av. Salgado Filho, 1900.")).thenReturn(GeoTest);
				return GeoTest;
			}
		};
		IRestaurantService restaurantService = new IRestaurantService()
		{

			public List<Review> getReviews(String restaurantName)
			{
				List<Review> TestListReview = new ArrayList<Review>();
				Review TestReview;
				TestReview = new Review(comment, restaurant, rating)
				Mockito.when(getReviews("Dom Gourmet")).thenReturn(TestListReview);
				
				return TestReview;
				
			}

			public List<Restaurant> findNearRestaurants(GeoCoordinate coordinates)
			{
				Restaurant RestTest1;
				Restaurant RestTest2;
				Restaurant RestTest3;
				Restaurant RestTest4;
				Restaurant RestTest5;
				Restaurant RestTest6;
				
				
				RestTest1 = new Restaurant("Dom Gourmet", "Av. Miguel Castro, 1929", "Pizza");
				RestTest2 = new Restaurant("Habib's", "Av. Salgado Filho, 2815", "Pizza");
				RestTest3 = new Restaurant("Mozzarella Pizzas", "Av. Salgado Filho, 1853", "Pizza");
				RestTest4 = new Restaurant("Yong Xiang", "R. Cel. Auris Coelho, 354", "Culinária chinesa");
				RestTest5 = new Restaurant("Grãos Restaurante", "R. Cel. Auris Coelho, 230", "Culinária regional");
				RestTest6 = new Restaurant("Paladar Fino", "R. Eng. Bertholdo Gurgel, 41", "Culinária regional");
				
				List<Restaurant> RestTests = new ArrayList<Restaurant> ();
				RestTests.add(RestTest1);
				RestTests.add(RestTest2);
				RestTests.add(RestTest3);
				RestTests.add(RestTest4);
				RestTests.add(RestTest5);
				RestTests.add(RestTest6);
				
				Mockito.when(findNearRestaurants(coordinates)).thenReturn(RestTests);
				return RestTests;
				
			}
		};

		FindMyRestaurantAPI api = new FindMyRestaurantAPI(mapService, restaurantService);

		// INPUTS
		String speciality = "Regional";
		String address = "Av. Salgado Filho, 1900.";

		List<Restaurant> nearRestaurants = api.findNearRestaurantsBySpeciality(address, speciality);

		//Assert.assertFalse(nearRestaurants.isEmpty());
	}
	
	
	
	@Test
	public final void TestSpecifyingBehavior() {
		
	}
}
