package api.parkinglot;

public class AddressDto {

    private String streetName;
    private String streetNumber;
    private String city;
    private String postalCode;

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressDto withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressDto withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
