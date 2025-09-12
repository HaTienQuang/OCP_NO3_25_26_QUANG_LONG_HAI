/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserDTO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Team6
 */
public class UserDAO {
    List <UserDTO> ls = new ArrayList<>();

    public UserDAO() {
        
        ls.add(new UserDTO("huuquan", "123456", true));
        ls.add(new UserDTO("viethung", "123456", true));
        ls.add(new UserDTO("batai", "123456", true));
        ls.add(new UserDTO("admin", "admin", true));
        ls.add(new UserDTO("username", "password", true));
        ls.add(new UserDTO("taikhoan", "matkhau", true));
          
    }
    public boolean checkLogIn(String username, String password){
        for(UserDTO u : ls){
            if(u.getUsername().equals(username)
                    &&u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
