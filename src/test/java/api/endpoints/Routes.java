package api.endpoints;

import api.utilities.BaseClass;



public class Routes {
	
	public static final String Base_URL = BaseClass.dotenv.get("BASE_URL");

	//User module
	public static final String User_Create_API = Base_URL+"/user";
	public static final String User_Get_API = Base_URL+"/user/{username}";
	public static final String User_Update_API = Base_URL+"/user/{username}";
	public static final String User_Delete_API = Base_URL+"/user/{username}";
	
	//Login module
	public static final String User_Login_API = Base_URL+"/user/login";
	public static final String User_Logout_API =Base_URL+"/user/logout";
	

}
