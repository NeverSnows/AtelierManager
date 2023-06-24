package com.company.atelier_manager;

import com.company.Controller.*;
import com.company.dao.UsuarioDAO;
import com.company.model.*;
import com.company.model.Util.OrderReportGenerator;

import java.util.*;

public class DatabaseManager {


    public static boolean sendRecoveryCode(String email){
        UsuarioController.enviaCodigoVerificacao(email);
        return true;
    }

    public static boolean checkRecoveryCode(String email, String code){
        return CodigosVerificacaoController.validaCodigoVerificacao(email, code);
        //Retorna true caso o codigo seja valido.
    }

    public static boolean changePassword(String email, String password){
        UsuarioController.alterarSenha(email, password);
        return true;
    }

    public static void registerOrder(Order order){
        PedidoController.registraPedido(order);
        //registra um Pedido no bd.
    }

    public static void printOrder(Order order){
        OrderReportGenerator.generateOrderReport(order);
    }

    public static boolean validateUser(User user){
        return UsuarioController.verificarCredenciais(user.getEmail(), user.getPasword());
    }
    public static User getUserByEmail(String email){
        return UsuarioDAO.retornarUsuarioPorEmail(email);
    }

    public static boolean registerUser(User user){
        return UsuarioDAO.inserirr(user);
    }

    public static void registerModel(Model model){
        ModeloController.insereModelo(model);
    }

    public static void registerPiece(Piece piece){
        PecaController.inserePeca(piece);
    }

    public static void registerFabric(Fabric fabric){
        TecidoController.insereTecido(fabric);
    }

    public static void registerCustomer(Customer customer){
        ClienteController.insereCliente(customer);
    }

    public static List<Customer> getCustomers(){
       return ClienteController.retornaClientes();
    }

    public static List<Estimate> getEstimates(){

        return OrcamentoController.retornaOrcamentos();
    }

    public static List<Model> getModels(){
        return ModeloController.retornaModelos();
    }

    public static List<Piece> getPieces(){
        return PecaController.retornaPecas();
    }

    public static List<Fabric> getFabrics(){
        return TecidoController.retornaTecidos();
    }

    public static List<Order> getOrders(){
        return PedidoController.retornarPedidos();
    }

    public static void deleteEstimate(Estimate estimate){
        OrcamentoController.deletaOrcamento(estimate);
    }
    public static void deleteOrder(Order order){
        PedidoController.deletaPedido(order);
    }
    public static void deleteModel(Model model){
        ModeloController.deletaModelo(model);
    }
    public static void deletePiece(Piece piece){
        PecaController.deletarPeca(piece);
    }
    public static void deleteCustomer(Customer customer){
        ClienteController.deletaCliente(customer);
    }
    public static void deleteFabric(Fabric fabric){
        TecidoController.deletaTecido(fabric);
    }

    public static void registerEstimate(Estimate estimate){
        OrcamentoController.registraOrcamento(estimate);
    }


}
