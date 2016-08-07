package com.goeuro.devtest.json.model;

/**
 * Model class fot Position.
 *
 * Created by bjagodzinski on 2016-08-04.
 */
public final class Position {

    private int _id;

    private String name;
    private String type;

    private GeoPosition geo_position;

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public GeoPosition getGeo_position() {
        return geo_position;
    }

    @Override
    public String toString() {
        return "Position {" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", geo_position=" + geo_position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position otherPosition = (Position) o;

        if (_id != otherPosition._id) return false;
        if (name != null ? !name.equals(otherPosition.name) : otherPosition.name != null) return false;
        if (type != null ? !type.equals(otherPosition.type) : otherPosition.type != null) return false;
        return !(geo_position != null ? !geo_position.equals(otherPosition.geo_position) : otherPosition.geo_position != null);

    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (geo_position != null ? geo_position.hashCode() : 0);
        return result;
    }
}
