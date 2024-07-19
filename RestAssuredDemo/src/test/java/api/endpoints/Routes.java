package api.endpoints;

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/#/";
	
	//Pet Module
	public static String upload_image_url="https://petstore.swagger.io/#/pet/uploadFile";
	public static String add_pet_url="https://petstore.swagger.io/#/pet/addPet";
	public static String update_pet_url="https://petstore.swagger.io/#/pet/updatePet";
	public static String find_pet_url="https://petstore.swagger.io/#/pet/getPetById";
	public static String delete_pet="https://petstore.swagger.io/#/pet/deletePet";
	
	
	//Store Module
	
	public static String find_purchaseID_url="https://petstore.swagger.io/#/store/getOrderById";
	public static String place_order_url="https://petstore.swagger.io/#/store/placeOrder";
	public static String delete_purchaseID_url="https://petstore.swagger.io/#/store/deleteOrder";
	public static String pet_inventory_url="https://petstore.swagger.io/#/store/getInventory";
	
	//User Module
	public static String create_user_url="https://petstore.swagger.io/v2/user";
	public static String update_user_url="https://petstore.swagger.io/v2/user/{username}";
	public static String delete_user_url="https://petstore.swagger.io/v2/user/{username}";
	public static String get_user_url="https://petstore.swagger.io/v2/user/{username}";

}
