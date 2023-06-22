package com.company.atelier_manager;

import com.company.Controller.*;
import com.company.dao.UsuarioDAO;
import com.company.model.*;

import java.util.*;

public class DatabaseManager {
   private UsuarioController usuarioController = new UsuarioController();
    public static boolean validateUser(User user){
        return UsuarioController.verificarCredenciais(user.getEmailUsuario(), user.getSenhaUsuario());
    }
    public static User getUserByEmail(String email){
        //(email deveria ser UNIQUE, para garantir que esta consulta faça sentido)
        //busca um usuario com este email, monta um Usuario e retorna ele.
        return UsuarioDAO.retornarUsuarioPorEmail(email);
    }

    /*
    Referente às funções register:

    Caso o id recebido seja -1, devera criar uma nova linha no BD,
     caso seja um numero diferente de -1, temos um problema, pois -1 indica que o sistema criou o objeto
     (ja que por ser um objeto novo, ele não sabe qual ID deve colocar, mas tambem não pode deixar ele vazio por ser final)

    A checagem de -1 é apenas uma garantia, mas desnecessária em tese, já que chamaremos as funções registerAlgo() apenas com coisas que não possuem ID ainda.
    */

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
        //registra o cliente no BD, criando uma linha de medida na tabela TB_MEDIDAS
        // para cada medida em measures e colocando o id do cliente (gerado pelo db) como FK em cada medida.
    }

    //Funções getAlgo() apenas retornam listas, nada de mais.
    public static List<Customer> getCustomers(){
        //Retorna uma lista com todos os clientes em objetos Customer.
        //List<Customer> customers = new ArrayList<>();

        //Objetos de teste.
        //customers.add(new Customer(1, "João", "12342356", "joão@jão.bom", null));
        //customers.add(new Customer(2, "Maria", "11 94545 4545", "joão.e.maria@hotmail.bom", null));

        return ClienteController.retornaClientes();
    }

    public static List<Estimate> getEstimates(){
        //Retorna uma lista com todos os clientes em objetos Customer.
        //List<Estimate> customers = new ArrayList<>();

        //Objeto de teste.
        /*customers.add(new Estimate(
                new User("rogerin", "email1", "password1"),
                new Customer(1, "João", "12342356", "joão@jão.bom", null),
                new Date(),
                new ArrayList<OrderItem>(),
                "observacoes e pa"));*/

        return OrcamentoController.retornaOrcamentos();
    }

    public static List<Model> getModels(){
        //List<Model> models = new ArrayList<>();

        //Objetos de teste.
        //models.add(new Model("camisa longa", 5.99));
        //models.add(new Model("camisa curta", 99.99));
        return ModeloController.retornaModelos();
    }

    public static List<Piece> getPieces(){
        //List<Piece> pieces = new ArrayList<>();

        //Objetos de teste.
        //pieces.add(new Piece("Camisa", 12.33));
        //pieces.add(new Piece("calça", 50.55));
        return PecaController.retornaPecas();
    }

    public static List<Fabric> getFabrics(){
        //List<Fabric> fabrics = new ArrayList<>();

        //Objetos de teste.
        //fabrics.add(new Fabric("Seda", 1.11));
        //fabrics.add(new Fabric("Ceda", 1.13));
        return TecidoController.retornaTecidos();
    }

    public static List<Order> getOrders(){
        //List<Orderr> orders = new ArrayList<>();
/*
        Estimate estimate = new Estimate(
                new User("rogerin", "email1", "password1"),
                new Customer(1, "João", "12342356", "joão@jão.bom", null),
                new Date(),
                new ArrayList<OrderItem>(),
                "observacoes e pa");

        //Objetos de teste.
        orders.add(new Orderr(
                estimate,
                new Date(),
                true,
                PaymentOption.PIX,
                OrderStatus.DELIVERED
        ));
*/
        return PedidoController.retornarPedidos();
    }
    //Metodos de deletar
    public static void deleteEstimate(Estimate estimate){

    }
    public static void deleteOrder(Order order){

    }
    public static void deleteModel(Model model){

    }
    public static void deletePiece(Piece piece){
        PecaController.deletarPeca(piece);
    }
    public static void deleteCustomer(Customer customer){

    }
    public static void deleteFabric(Fabric fabric){

    }

    public static void registerEstimate(Estimate estimate){
        //registra um orçamento no bd.
    }

}
