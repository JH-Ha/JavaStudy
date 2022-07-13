public class Main {
  public static void main(String[] args)  {
    String userName = "testUser";
    UserService userService = new UserService();
    userService.createUser(userName);
    userService.deleteUser(userName);
    //System.out.println(userService.getClass().getClassLoader());
  }
}


