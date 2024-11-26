/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EComPlatfrom;

/**
 *
 * @author Raylen
 */
public class mainClass2 {

    public static void main(String[] args) {
        UserClass userClass = new UserClass();
       int loggedInUserId = userClass.getUserSession();

        
        eComPageUser login = new eComPageUser(loggedInUserId);
        login.setVisible(true);
        login.setResizable(false);
        // login. setLocationRelativeTo(null);

    }
}
