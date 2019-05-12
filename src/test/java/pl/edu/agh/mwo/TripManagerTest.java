package pl.edu.agh.mwo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip, trip1;
	Photo photo1, photo2;

	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
	}

	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
//		fail("chcemy zespuc");
	}

	@Test
	public void testFindTripUsingEmptyString() throws Exception {
		tripManager.add(trip);
		tripManager.add(new Trip("wycieczka", "opis wycieczki"));
		tripManager.findTrip("");
		assertEquals(2, tripManager.getTrips().size());
	}

	@Test
	public void testFindTripUsingEmptyStringOnEmptyTripList() throws Exception {
		tripManager.findTrip("");
		assertEquals(0, tripManager.getTrips().size());
	}

	@Before
	public void setUp2() {
		trip1 = new Trip("Teneryfa island", "Europe - Spain");
		photo1 = new Photo();
		photo1.setComment("nice view");
		photo2 = new Photo();
		photo2.setComment("panorama view");
		trip1.addPhoto(photo1);
		trip1.addPhoto(photo2);
	}

	@Test
	public void testFindTripUsingKeywornInName() throws TripAlreadyExistsException {
		tripManager.add(trip1);
		assertEquals(1, tripManager.findTrip("Teneryfa").size());
	}

	@Test
	public void testFindTripUsingKeywornInDesctiption() throws TripAlreadyExistsException {
		tripManager.add(trip1);
		assertEquals(1, tripManager.findTrip("Spain").size());
	}

	@Test
	public void testFindTripUsingKeywornInPhotoDescrioption() throws TripAlreadyExistsException {
		tripManager.add(trip1);
		assertEquals(1, tripManager.findTrip("view").size());
	}
}
