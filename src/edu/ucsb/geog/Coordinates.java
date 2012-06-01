/*
 * @author: Grant McKenzie
 * @project: UCSBActivityTracker
 * @date: May 2012
 * UCSB Geography Department
 */

package edu.ucsb.geog;
import android.database.Observable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class Coordinates extends Observable<Fix> implements LocationListener, ISensorFeed {
	private double latitude;
	private double longitude;
	private long timestamp;
	private Fix newFix;
	
	@Override
	public void onLocationChanged(Location loc) {
		timestamp = System.currentTimeMillis()/1000;
		latitude = loc.getLatitude();
		longitude = loc.getLongitude();
		newFix = new Fix(latitude, longitude, timestamp);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// Toast.makeText( getApplicationContext(),"Gps Disabled",Toast.LENGTH_SHORT ).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// Toast.makeText( getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// Toast.makeText( getApplicationContext(),"Location Service changed to "+provider,Toast.LENGTH_SHORT).show();
	}

	@Override
	public Fix getSensorValue() {
		return newFix;
	}
	
	
}
