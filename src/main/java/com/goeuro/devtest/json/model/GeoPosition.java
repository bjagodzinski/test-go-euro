package com.goeuro.devtest.json.model;

/**
 * Model class for GOGRAPHIC POSITION.
 *
 * Created by bjagodzinski on 2016-08-04.
 */
public final class GeoPosition {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "GeoPosition {" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPosition other = (GeoPosition) o;

        if (Double.compare(other.latitude, latitude) != 0) return false;
        return Double.compare(other.longitude, longitude) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long tempHash;
        tempHash = Double.doubleToLongBits(latitude);
        result = (int) (tempHash ^ (tempHash >>> 32));
        tempHash = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (tempHash ^ (tempHash >>> 32));
        return result;
    }
}
