import java.util.*;
class Driver{
    int driverId;
    String dName;
    String  phone;
    String cabBrand;
    String location;
    boolean isOnline;
    Driver(int driverId,String dName,String phone,String cabBrand,String location,boolean isOnline){
         this.driverId=driverId;
         this.dName=dName;
         this.phone=phone;
         this.cabBrand=cabBrand;
         this.location=location;
         this.isOnline=isOnline;  
    }
 
}
class Customer{
    int customerId;
    String cName;
    String pno;
    Customer(int customerId,String cName,String pno){
          this.customerId=customerId;
          this.cName=cName;
          this.pno=pno;
    }
       
}
class CusInput {
    int startKm;
    int desKm;
    String type;
    CusInput(int startKm,int desKm,String type){
        this.startKm=startKm;
        this.desKm=desKm;
        this.type=type;
    }
    
}
class FareEngine{
    int fare=30;
    void estimate(int startKm,int desKm,String type){
        if(type.equals("Economy")){
            int d=desKm-startKm;
            int p=d*12;
            fare=fare+p;
            System.out.println("Price: $"+fare);
        }
        else{
            int d=desKm-startKm;
            int p=d*18;
            fare=fare+p;
            System.out.println("Price: $"+fare);
        }
    }
}
class Trip{
    int tripId;
    int customerId;
    int driverId;
    String type;
    int fare=30;
    void journey(){
        System.out.println("Continue trip or not.");
    }
    void start(String pickup){
         System.out.println("Trip started from "+pickup +" safely. Happy Journey");
    }
    void complete(String drop){
         System.out.println("Dropped safely at "+drop +". Thank you visit us again.");
    }
    void tripDetail(String pickup,String drop,String type){
        System.out.println("Pickup: "+pickup);
        System.out.println("Drop: "+drop);
        System.out.println("Trip Type: "+type);
    }
    void calculateFare(int startKm,int desKm,String type){
        int fare=0;
        if(desKm-startKm<2){
            fare=60;
        }
        if(type.equals("Economy")){
            int d=desKm-startKm;
            int p=d*12;
            fare=fare+p;
            System.out.println("Price: $"+fare);
        }
        else{
            int d=desKm-startKm;
            int p=d*18;
            fare=fare+p;
            System.out.println("Price: $"+fare);
        }
    }
    
}
class Rating{
    void rate(int rate){
        System.out.println("Rating given : "+rate);
        }
}
public class CabBook{
    static ArrayList<Driver> dr=new ArrayList<>();
    static ArrayList<Customer> cr=new ArrayList<>();
    static ArrayList<CusInput> ci=new ArrayList<>();
    public static void main(String[] args){
        Scanner A=new Scanner(System.in);
        Trip t=new Trip();
        Rating r=new Rating();
        
        //  FareEngine f=new FareEngine();
         addDriver(101,"Ram","90876543221","Suzuki","CH01",true);
         addDriver(103,"Arjun","91234432212","Hyndai","DL12",true);
         addDriver(105,"Sara","91234432200","Lamborghini","BL23",false);
         displayD();
         addCustomer(156,"Saran","8015445001");
         System.out.println("Enter start point in km: ");
         int start=A.nextInt();
         System.out.println("Enter end point in km: ");
         int end=A.nextInt();
         A.nextLine();
         System.out.println("Enter type of ride: ");
         String type=A.nextLine();
         getRide(start,end,type);

         displayC();
         System.out.println("Enter the pickup area: ");
         String pickup=A.nextLine();
          System.out.println("Enter the drop area: ");
         String drop=A.nextLine();
         t.tripDetail(pickup,drop,type);  
         t.journey();
         String op=A.nextLine();  
         if(op.equals("Continue")){
         t.start(pickup); 
         t.complete(drop);
         System.out.println("Final price: ");
         t.calculateFare(start,end,type);
         System.out.println("Enter rating from 1 to 10:");
         int ra=A.nextInt();
         r.rate(ra);
         }
         else{
            System.out.println("Journey Cancelled");
         }
        //  f.estimate(14,46,"Economy");
    }
    static void addDriver(int driverId,String dName,String phone,String cabBrand,String location,boolean isOnline){
            dr.add(new Driver(driverId,dName,phone,cabBrand,location,isOnline));
    }
    static void displayD(){
        for(Driver e:dr){
            System.out.println(e.driverId+" "+e.dName+" "+e.phone+" "+e.cabBrand);
        }
    }
     static void addCustomer(int cid,String cname,String cphone){
        // System.out.println("Enter Your Details:");
            cr.add(new Customer(cid,cname,cphone));
    }
    static void displayC(){
        System.out.println("Customer Details: ");
        for(Customer c:cr){
            System.out.println(c.customerId+" "+c.cName+" "+c.pno);
        }
    }
    static void getRide(int startKm,int desKm,String type){
          ci.add(new CusInput(startKm,desKm,type));
    }
     
}