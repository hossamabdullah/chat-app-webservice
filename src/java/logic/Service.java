package logic;

import com.google.gson.Gson;
import com.sun.jersey.core.util.Base64;
import dao.UserDaoInt;
import dao.utility.DaoProvider;
import dto.UserSearchResultDto;
import dto.UserSignInDto;
import dto.UserSignUpDto;
import dto.UserUpdatePpDto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
//import jdk.nashorn.internal.parser.JSONParser;
import logic.utility.FileManagementUtility;
import logic.utility.MainUtility;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;

/**
 *
 * @author uranus
 */
@Path("/service")
public class Service { 
  @POST
  @Path("/profilepicture")  
//  @Consumes(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.APPLICATION_JSON)
  //JSONObject userData
  //String data
  public String updateProfilePicture(String data)throws IOException, ParseException {
//      JSONObject json = (JSONObject)new JSONParser().parse("{\"name\":\"MyNode\", \"width\":200, \"height\":100}");
//        System.out.println("name=" + json.get("name"));
//        System.out.println("width=" + json.get("width"));
        //                             key1=xxx&key2=yyy
//      System.out.println(data);
//      Gson gs = new Gson();
//      UserUpdatePpDto ss = gs.fromJson(data, UserUpdatePpDto.class);
//      System.out.println(ss.getId());
//      System.out.println(ss.getMobile());
//        String key1 = data.substring(0,data.indexOf("="));
//        String value1 = data.substring(data.indexOf("=")+1 , data.indexOf("&"));
//        System.out.println(key1+":"+value1);
//        
//        String newData = data.substring(data.indexOf("&")+1);
//        String key2 = newData.substring(0,data.indexOf("="));
//        String value2 = newData.substring(data.indexOf("=")+1 , data.indexOf("&"));
//        
//        System.out.println(key2+":"+value2);
//        System.out.println(data);
      
//      return "helloSharePoint";
      System.out.println("WeLcome");
      System.out.println(data+"aaaaaaaaaaaaaaaaaaaaaaaa");
      JSONObject userData = (JSONObject)new JSONParser().parse(data);
      System.out.println(((String) userData.get("appKey")));
      if( ((String) userData.get("appKey")) == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if( ((String) userData.get("appKey")).equals("447ad97d40c592")){
            String bytes = (String) userData.get("image");
            String mobile = (String) userData.get("mobile");
                  System.out.println("Sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"+bytes);

            UserUpdatePpDto userDto = new UserUpdatePpDto(mobile, bytes);
            UserDaoInt userDao = DaoProvider.getUserDao();
            boolean result = userDao.updatePp(userDto);
            return "process is"+result;
            //boolean FileSaved = FileManagementUtility.convertFile(userData.getString("file"), "notes.jpg" , "C:\\Users\\Hossam Abdallah\\Documents\\MyServer\\");
        //    return ""+fileReceived;
      }else{
          return "Invalid app";
      }
  }
  @GET
  @Path("/update")
  @Produces(MediaType.TEXT_HTML)
  public String updateUser(@QueryParam("user") String jsonObject,@QueryParam("appKey") String appKey) {
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
        //    System.out.println("object is : "+jsonObject);
        //   object is {"displayName":"Hossam","email":"email","mobile":"999999s","fullName":"ful name","password":"password"}
          Gson gs=new Gson();
          UserSignUpDto user=gs.fromJson(jsonObject, UserSignUpDto.class);
          UserDaoInt userDao = DaoProvider.getUserDao();
          boolean result = userDao.updateUser(user);
          if(result){
              return jsonObject;
          }else{
              return "null";
          }
      }else{
          return "invalid app";
      }
    
  }
  
  
  /*
  JSONObject userData = (JSONObject)new JSONParser().parse(jsonObject);
    String mobile = (String) userData.get("mobile");
    String password = (String) userData.get("password");
    
    UserSignInDto user= new UserSignInDto(mobile, password);
    UserDaoInt userDao = DaoProvider.getUserDao();
    UserSearchResultDto userResult = userDao.getUser(user.getMobile(),user.getPassword());
    if(userResult == null)
        return "null";
    else{
        return "true";
    }
  */
  @GET
  @Path("/signin")
  @Produces(MediaType.TEXT_HTML)
  public String signIn(@QueryParam("user") String jsonObject,@QueryParam("appKey") String appKey) {
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
            System.out.println(jsonObject);
          Gson gs=new Gson();
          UserSignInDto user=gs.fromJson(jsonObject, UserSignInDto.class);
          UserDaoInt userDao = DaoProvider.getUserDao();
            System.out.println(user.getMobile());
            System.out.println(user.getPassword());
          UserSearchResultDto userResult = userDao.getUser(user.getMobile(),user.getPassword());
          if(userResult == null)
              return "null";
          else{
              String userString = gs.toJson(user);
              return "true";
          }
      }else{
          return "Invalid app";
      }
  } 
  @GET
  @Path("/getuser")
  @Produces(MediaType.TEXT_HTML)
  public String getUser(@QueryParam("mobile") String mobile,@QueryParam("appKey") String appKey) {
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
            UserDaoInt userDao = DaoProvider.getUserDao();
            UserSearchResultDto user = userDao.getUser(mobile);
            if(user == null)
                return "null";
            else{
                Gson gs=new Gson();
                String userString = gs.toJson(user);
                return userString;
            }
      }else{
          return "Invalid app";
      }
  }
  
  public UserSearchResultDto getUserJavaObject(String mobile){
    UserDaoInt userDao = DaoProvider.getUserDao();
    UserSearchResultDto user = userDao.getUser(mobile);
    if(user == null)
        return null;
    else{
        return user;
    }
  }
  @GET
  @Path("/create")
  @Produces(MediaType.TEXT_HTML)
  public String createUser(@QueryParam("user") String jsonObject,@QueryParam("appKey") String appKey) {
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
        System.out.println(jsonObject);
        Gson gs=new Gson();
        UserSignUpDto user=gs.fromJson(jsonObject, UserSignUpDto.class);
        UserDaoInt userDao = DaoProvider.getUserDao();

        boolean result=userDao.insertUser(user);
          System.out.println(""+result);
        return ""+result;
      }else{
          return "Invalid app";
      }
  }
  
  
  @GET
  @Path("/restore")
  @Produces(MediaType.TEXT_HTML)
  public String restorePw(@QueryParam("mobile") String mobile,@QueryParam("appKey") String appKey){
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
        try{
            System.out.println("im there");
          UserDaoInt userDao = DaoProvider.getUserDao();
          final String password = userDao.getPassword(mobile);
          final String email = userDao.getEmail(mobile);
          if(email!=null && password!=null){
              new Thread(new Runnable() {

                @Override
                public void run() {
                    MainUtility.sendMessage("Reseting Your Password", "Your password is : "+password,email);
                }
            }).start();
            return "true";
          }else{
              return null;
          }
        }catch(Exception ex){
            return null;
        }
      }else{
          return "Invalid app";
      }
  }
  
  
  @GET
  @Path("/confirm")
  @Produces(MediaType.TEXT_HTML)
  public String confirmAcc(@QueryParam("mobile") String decrytedMobile,@QueryParam("appKey") String appKey){
      if(appKey == null){
          return "you have to get an app Id contact hossamabdalh@gmail.com for more information";
      }
      if(appKey.equals("447ad97d40c592")){
        UserDaoInt userDao = DaoProvider.getUserDao();
        boolean result = userDao.confirmUser(decrytedMobile);
        return ""+result;
      }else{
          return "Invalid app";
      }
  }
}
