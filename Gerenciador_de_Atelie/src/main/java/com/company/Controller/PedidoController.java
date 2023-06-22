package com.company.Controller;

import com.company.dao.PedidoDAO;
import com.company.model.Order;

import java.util.List;

public class PedidoController {
    private static PedidoDAO pd = new PedidoDAO();

    public static List<Order> retornarPedidos(){
       return pd.buscarTodos();
    }
}
