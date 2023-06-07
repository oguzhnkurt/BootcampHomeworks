import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main (String[] Args){

        int rcount=1,lcount=1;

        ProcessHouse processHouse = new ProcessHouse();
        processHouse.CreateHouses();
        List<House> homelist = processHouse.getHomeList();
        List<House> summerylist = processHouse.getSummaryList();
        List<House> villalist = processHouse.getVillaList();


        double  totalHomePrice = processHouse.getTotalHomePrice();
        double  totalVillaPrice= processHouse.getTotalVillaPrice();
        double  totalSummeryPrice = processHouse.getTotalSummeryPrice();
        double  totalHousesPrice = processHouse.getTotalHousesPrice();
        double totalHomeAverageSquareMeters = processHouse.getTotalHomeAverageSquareMeters();
        double totalVillaAverageSquareMeters = processHouse.getTotalVillaAverageSquareMeters();
        double totalSummeryAverageSquareMeters = processHouse.getTotalSummeryAverageSquareMeters();
        double totalHousesAverageSquareMeters= processHouse.getTotalHousesAverageSquareMeters();

        System.out.println("Home : ");
        for(House house : homelist){
            System.out.println("id :" +house.id);
            System.out.println("Type : " +house.houseType );
            System.out.println("Price : " +house.price);
            System.out.println("Square Meter : "+house.squareMeters);
            System.out.println("Room Count : " +house.roomCount);
            System.out.println("Living Room Count : " +house.livingCount);


        }
        System.out.println("-----------------------------------------------");
        System.out.println("Villas : ");
        for(House house : villalist){
            System.out.println("id :" +house.id);
            System.out.println("Type : " +house.houseType);
            System.out.println("Price : " +house.price);
            System.out.println("Square Meter : "+house.squareMeters);
            System.out.println("Room Count : " +house.roomCount);
            System.out.println("Living Room Count : " +house.livingCount);


        }
        System.out.println("-----------------------------------------------");
        System.out.println("Summeries : ");
        for(House house : summerylist){
            System.out.println("id :" +house.id);
            System.out.println("Type : " +house.houseType );
            System.out.println("Price : " +house.price);
            System.out.println("Square Meter : "+house.squareMeters);
            System.out.println("Room Count : " +house.roomCount);
            System.out.println("Living Room Count : " +house.livingCount);

        }
        System.out.println("-----------------------------------------------");
        System.out.println("Total Home Price : " +totalHomePrice);
        System.out.println("Total Villa Price : " +totalVillaPrice);
        System.out.println("Total Summery Price :" +totalSummeryPrice);
        System.out.println("All Houses Price : " +totalHousesPrice);
        System.out.println("Total Home Average Square Meters : " +totalHomeAverageSquareMeters);
        System.out.println("Total Villa Average Square Meters : " +totalVillaAverageSquareMeters);
        System.out.println("Total Summery Average Square Meters  : " +totalSummeryAverageSquareMeters);
        System.out.println("All houses average Square Meters : " +totalHousesAverageSquareMeters);
        System.out.println("-----------------------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Room Number : ");
        rcount = input.nextInt();
        System.out.println("Please enter Living Room Number : ");
        lcount = input.nextInt();

        List<House> allHousesByLivRoomsAndRoomsCount = processHouse.getAllHousesByLivRoomsAndRoomsCount(lcount,rcount);

        System.out.println("What you looking for : ");

        for(House house : allHousesByLivRoomsAndRoomsCount){
            System.out.println("id :" +house.id);
            System.out.println("Type : " +house.houseType);
            System.out.println("Price : " +house.price);
            System.out.println("Square Meter : "+house.squareMeters);
            System.out.println("Room Count : " +house.roomCount);
            System.out.println("Living Room Count : " +house.livingCount);

        }
    }
}

