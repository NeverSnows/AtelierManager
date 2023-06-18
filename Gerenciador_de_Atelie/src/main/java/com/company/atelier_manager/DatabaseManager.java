package com.company.atelier_manager;

import com.company.atelier_manager.structure.*;

import java.time.LocalDate;
import java.util.*;

public class DatabaseManager {
    public static boolean validateUser(User user){
        //pega a senha e email do usuario e valida se dão match no BD. Retorna true se sim.
        return true;
    }
    public static User getUserByEmail(String email){
        //(email deveria ser UNIQUE, para garantir que esta consulta faça sentido)
        //busca um usuario com este email, monta um Usuario e retorna ele.
        return new User("Test User of Silva", "test_user@of.silva", "testPassw0rd");
    }

    /*
    Referente às funções register:

    Caso o id recebido seja -1, devera criar uma nova linha no BD,
     caso seja um numero diferente de -1, temos um problema, pois -1 indica que o sistema criou o objeto
     (ja que por ser um objeto novo, ele não sabe qual ID deve colocar, mas tambem não pode deixar ele vazio por ser final)

    A checagem de -1 é apenas uma garantia, mas desnecessária em tese, já que chamaremos as funções registerAlgo() apenas com coisas que não possuem ID ainda.
    */

    public static boolean registerUser(User user){
        return true;
    }

    public static void registerModel(Model model){
        //salva o modelo no BD.
    }

    public static void registerPiece(Piece piece){
        //salva a peça no BD
    }

    public static void registerFabric(Fabric fabric){
        //salva o tecido no BD
    }

    public static void registerCustomer(Customer customer){
        //registra o cliente no BD, criando uma linha de medida na tabela TB_MEDIDAS
        // para cada medida em measures e colocando o id do cliente (gerado pelo db) como FK em cada medida.
    }

    //Funções getAlgo() apenas retornam listas, nada de mais.
    public static List<Customer> getCustomers(){
        //Retorna uma lista com todos os clientes em objetos Customer.
        List<Customer> customers = new ArrayList<>();

        //Objetos de teste.
        customers.add(new Customer(1, "João", "12342356", "joão@jão.bom", null));
        customers.add(new Customer(2, "Maria", "11 94545 4545", "joão.e.maria@hotmail.bom", null));

        return customers;
    }

    public static List<Estimate> getEstimates(){
        //Retorna uma lista com todos os clientes em objetos Customer.
        List<Estimate> customers = new ArrayList<>();

        //Objeto de teste.
        customers.add(new Estimate(
                new User("rogerin", "email1", "password1"),
                new Customer(1, "João", "12342356", "joão@jão.bom", null),
                new Date(),
                new ArrayList<OrderItem>(),
                "observacoes e pa"));

        return customers;
    }

    public static List<Model> getModels(){
        List<Model> models = new ArrayList<>();

        //Objetos de teste.
        models.add(new Model("camisa longa", 5.99));
        models.add(new Model("camisa curta", 99.99));
        return models;
    }

    public static List<Piece> getPieces(){
        List<Piece> pieces = new ArrayList<>();

        //Objetos de teste.
        pieces.add(new Piece("Camisa", 12.33));
        pieces.add(new Piece("calça", 50.55));
        return pieces;
    }

    public static List<Fabric> getFabrics(){
        List<Fabric> fabrics = new ArrayList<>();

        //Objetos de teste.
        fabrics.add(new Fabric("Seda", 1.11));
        fabrics.add(new Fabric("Ceda", 1.13));
        return fabrics;
    }

    //Metodos de deletar
    public static void deleteEstimate(Estimate estimate){

    }
    public static void deleteOrder(Order order){

    }
    public static void deleteModel(Model model){

    }
    public static void deletePiece(Piece piece){

    }
    public static void deleteCustomer(Customer customer){

    }
    public static void deleteFabric(Fabric fabric){

    }

}
