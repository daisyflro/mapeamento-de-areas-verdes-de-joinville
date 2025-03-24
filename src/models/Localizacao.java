package models;

public class Localizacao {

    int id;
    int idAreaVerde;
    double latitude;
    double longitude;

    public Localizacao(int idAreaVerde, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.idAreaVerde = idAreaVerde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getIdAreaVerde() {
        return idAreaVerde;
    }

    public void setIdAreaVerde(int idAreaVerde) {
        this.idAreaVerde = idAreaVerde;
    }

    @Override
    public  String toString() {
        return "Localização: " +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude;
    }
}
