package starter.BaseClass;

/*import io.restassured.RestAssured;
import io.restassured.response.Response;*/
//import net.thucydides.core.util.EnvironmentVariables;
//import net.thucydides.core.util.SystemEnvironmentVariables;

public class Base {

//CommonMethods comm=new CommonMethods();
//public static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    /*public static String getsecret(String key)
{
        Response response = RestAssured.with().contentType("application/json")
                .given().log().all()
                .header("X-Vault-Token", variables.getProperty("VaultToken"))
                .header("X-Vault-Namespace", variables.getProperty("VaultNameSpace"))
                .request().get(variables.getProperty("VaultURI")+"v1/cubbyhole/TestAutomation");
        Map<Object,HashMap<String, String>> res = response.jsonPath().getMap("$");
       return res.get("data").get(key).toString();
}*/


}
