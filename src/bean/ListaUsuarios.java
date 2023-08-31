/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eniof
 */
public class ListaUsuarios {
    public static void main(String[] args) {
        List lista = new ArrayList();
        Usuarios usuarios = new Usuarios();
        usuarios.setIdUsuarios(1);
        usuarios.setNome("Enio");
        usuarios.setApelido("Fabi");
        lista.add(usuarios);
        
        Usuarios usuarios1 = new Usuarios();
         usuarios.setIdUsuarios(2);
        usuarios.setNome("Aline");
        usuarios.setApelido("Linne");
        lista.add(usuarios1);
        
        lista.add( new Usuarios(4, "Amanda", "Mands"));
      
        Collections.sort(lista);
        lista.forEach((usuarios2) -> {
            System.out.println(((Usuarios)usuarios2).getApelido());
        });
    }
}
