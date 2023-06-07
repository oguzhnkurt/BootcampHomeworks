import java.util.List;

public class House {

    public int id;
    public HouseTypeEnum houseType;
    public double price;
    public double squareMeters;
    public int roomCount;
    public int livingCount;

    public House (int id,HouseTypeEnum houseType , double price , double squareMeters , int roomCount , int livingCount){

        this.houseType = houseType;
        this.price = price;
        this.squareMeters = squareMeters;
        this.roomCount = roomCount;
        this.livingCount = livingCount;
        this.id=id;
    }
}
