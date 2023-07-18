import java.util.HashMap;
public class IDandPasswords{

  HashMap<String, String> loginInfo = new HashMap<String, String>();

  IDandPasswords(){

    //database of usernames and passwords 
    loginInfo.put("Yasar", "Labib21");
    loginInfo.put("CompSci", "Password");
    loginInfo.put("Java", "abc123");
  }

  protected HashMap getLoginInfo(){
    return loginInfo;
  }
}
