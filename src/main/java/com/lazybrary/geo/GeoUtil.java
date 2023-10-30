package com.lazybrary.geo;

public class GeoUtil {

    /**
     * Radius of the earth (6371) * meter value (1000)
     */
    public static final Double METER_DISTANCE_UNIT = 6371000.0;

    /**
     * Get distance between two point. (lat1, lon1) and (lat2, lon2) with altitude
     * based on Haversine method
     * @param lat1 latitude of start point
     * @param lon1 longitude of start point
     * @param lat2 latitude of end point
     * @param lon2 longitude of end point
     * @param el1 altitude of start point
     * @param el2 altitude of end point
     * @return Distance in meter
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2, double el1, double el2){
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = METER_DISTANCE_UNIT * c; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    /**
     * Get distance between two point. (lat1, lon1) and (lat2, lon2) without altitude
     * based on Haversine method
     * @param lat1 latitude of start point
     * @param lon1 longitude of start point
     * @param lat2 latitude of end point
     * @param lon2 longitude of end point
     * @return Distance in Meters
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2){
        return getDistance(lat1, lon1, lat2, lon2, 0, 0);
    }
}
