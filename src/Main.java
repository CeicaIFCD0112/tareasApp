import controller.TaskController;
import models.User;

public class Main {
    public static void main(String[] args) {


        // Metodo 1
        /*User user= new User();
        System.out.println(user.login("task","1234").toString());

        //TaskController taskController=new TaskController();
        */

        //Metodo 2
        /*TaskController taskController=new TaskController();
        taskController.login("admin","1234");
        System.out.println(taskController.userLogged.toString());
        */
        TaskController taskController=new TaskController();
        taskController.login("pepe","1234");
        System.out.println(taskController.getAllTaskByUser());

    }
}