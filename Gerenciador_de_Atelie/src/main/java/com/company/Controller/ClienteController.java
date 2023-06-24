package com.company.Controller;

import com.company.dao.ClienteDAO;
import com.company.model.Customer;

import java.util.List;

public class ClienteController {
    private static ClienteDAO cd = new ClienteDAO();
    public static void insereCliente(Customer customer){
        cd.atualizar(customer);
    }

    public static void deletaCliente(Customer customer){
        cd.deletar(customer);
    }

    public static List<Customer> retornaClientes(){
        return cd.buscarTodos();
    }
}
