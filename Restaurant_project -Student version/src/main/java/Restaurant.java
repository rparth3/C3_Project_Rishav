import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
    	
    	LocalTime openingTime = this.openingTime;
        LocalTime closingTime = this.closingTime;        
        if(getCurrentTime().isBefore(openingTime) || getCurrentTime().isAfter(closingTime)) {
        	return false;
        }
        else
        {
        	return true;
        
        }
        
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){ 
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
    public int total_price_of_selected_items_from_menu(String... items ) {
    	int index =0;
    	int price =0;
    	int totalprice =0;
    	String menuoutput[];
    	for(String selected_item : items) {
    		Item objselecteditem = findItemByName(selected_item);
    		if(menu.contains(objselecteditem)) {
    			menuoutput = objselecteditem.toString().split(":");
    			price = Integer.valueOf(menuoutput[1].trim());
    			totalprice = totalprice+price;
    		}
    		index++;
    	}
    	return totalprice; 
    }
   
}
