import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.ArrayList;
import java.util.List;

public class ProcessHouse {

    private List<House> list ;

    public void CreateHouses() {

        this.list = new ArrayList<House>();
        //region create home
        this.list.add(new House(1,HouseTypeEnum.home,10000,180,3,1));
        this.list.add(new House(2,HouseTypeEnum.home,20000,190,4,2));
        this.list.add(new House(3,HouseTypeEnum.home,30000,200,5,3));
        //endregion
        //region create villa
        this.list.add(new House(1,HouseTypeEnum.villa,10000,250,6,4));
        this.list.add(new House(2,HouseTypeEnum.villa,20000,300,7,5));
        this.list.add(new House(3,HouseTypeEnum.villa,30000,350,8,6));
        //endregion
        //region create summery
        this.list.add(new House(1,HouseTypeEnum.summery,50000,450,9,7));
        this.list.add(new House(2,HouseTypeEnum.summery,60000,475,10,8));
        this.list.add(new House(3,HouseTypeEnum.summery,70000,500,11,9));
        //endregion

    }
    public List<House> getHomeList() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.home).toList();
    }
    public List<House> getVillaList() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.villa).toList();
    }
    public List<House> getSummaryList() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.summery).toList();
    }
    public double getTotalHomePrice() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.home).map(x->x.price).count();
    }
    public double getTotalVillaPrice() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.villa).map(x->x.price).count();
    }
    public double getTotalSummeryPrice() {
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.summery).map(x->x.price).count();
    }
    public double getTotalHousesPrice() {
        return this.list.stream().map(x->x.price).count();
    }

    public double getTotalHomeAverageSquareMeters() {
        int totalHome = this.list.stream().filter(x -> x.houseType == HouseTypeEnum.home).toList().size();
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.home).map(x->x.squareMeters).count() / totalHome;
    }
    public double getTotalVillaAverageSquareMeters() {
        int totalVilla = this.list.stream().filter(x -> x.houseType == HouseTypeEnum.villa).toList().size();
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.villa).map(x->x.squareMeters).count() / totalVilla;
    }
    public double getTotalSummeryAverageSquareMeters() {
        int totalSummery = this.list.stream().filter(x -> x.houseType == HouseTypeEnum.summery).toList().size();
        return this.list.stream().filter(x -> x.houseType == HouseTypeEnum.summery).map(x->x.squareMeters).count() / totalSummery;
    }
    public double getTotalHousesAverageSquareMeters() {
        int totalHouses = this.list.stream().toList().size();
        return this.list.stream().map(x -> x.squareMeters).count() / totalHouses;
    }
    public List<House> getAllHousesByLivRoomsAndRoomsCount(int livingRoom , int room) {

        return this.list.stream().filter(x -> x.roomCount == room && x.livingCount == livingRoom).toList();
    }
}
