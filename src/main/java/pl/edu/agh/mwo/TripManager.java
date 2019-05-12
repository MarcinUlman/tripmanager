package pl.edu.agh.mwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripManager {
	private HashMap<String, Trip> tripList;

	public TripManager() {
		tripList = new HashMap<String, Trip>();
	}

	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		} else {
			tripList.put(trip.getName(), trip);
		}
	}

	public HashMap<String, Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Map<String, Trip> findTrip(String keyword) {
		if (keyword.equals("")) {
			return tripList;
		}
		Map<String, Trip> findedTrips = new HashMap<String, Trip>();

		Set<String> tripNames = tripList.keySet();
		for (String tripName : tripNames) {
			Trip trip = tripList.get(tripName);
			if (tripName.contains(keyword)) {
				findedTrips.put(tripName, trip);
			} else if (trip.getDescription().contains(keyword)) {
				findedTrips.put(tripName, trip);
			} else {
				List<Photo> photos = trip.getPhotos();
				for (Photo p : photos) {
					if (p.getComment().contains(keyword)) {
						findedTrips.put(tripName, trip);
					}
				}
			}
		}
		return findedTrips;
	}

}
