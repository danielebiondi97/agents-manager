package it.unifi.ing.gel.swe.elaborato;

public class Posizione {
	
	private double lat;
	private double lon;
	
	public Posizione(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}
	
	public double getLat() { return lat; }
	
	public double getLon() { return lon; }
	
	@Override
	public String toString () {
		return "Posizione [lat = " + lat + ", lon = " + lon + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Posizione other = (Posizione) obj;
		
		return this.lat == other.lat
				&& this.lon == other.lon;
	}

}
