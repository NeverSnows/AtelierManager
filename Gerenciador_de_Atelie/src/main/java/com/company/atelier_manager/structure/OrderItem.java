package com.company.atelier_manager.structure;

import com.company.atelier_manager.structure.enums.Size;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private final long id;
    private Piece piece;
    private Size size;
    private Model model;
    private Fabric fabric;
    private Color color; //TODO definir se foi decidido usar Color do javafx, ou criar um Enum Color (prefiro usar o que for mais facil para o Backend).
    private List<ExtraRequirement> extraRequirements = new ArrayList<>();
    private double totalPrice;

    public OrderItem(long id, Piece piece, Size size, Model model, Fabric fabric, Color color, List<ExtraRequirement> extraRequirements) {
        this.id = id;
        this.piece = piece;
        this.size = size;
        this.model = model;
        this.fabric = fabric;
        this.color = color;
        this.extraRequirements = extraRequirements;
        updateTotalPrice();
    }
    public OrderItem(Piece piece, Size size, Model model, Fabric fabric, Color color, List<ExtraRequirement> extraRequirements) {
        this.id = -1;
        this.piece = piece;
        this.size = size;
        this.model = model;
        this.fabric = fabric;
        this.color = color;
        this.extraRequirements = extraRequirements;
        updateTotalPrice();
    }

    //totalPrice é um campo que não deve ser armazenado no BD pois deve ser calculado.
    //UpdateTotalPrice() ja cuida disso e deve ser chamado em cada alteração nos dados dos objetos OrderItem.
    //
    //Adicionamos todos os adicionais e no fim multiplicamos os multiplicadores pela soma total (apenas um neste caso, o do tamanho).
    public void updateTotalPrice(){
        totalPrice = 0;
        totalPrice += piece.getValue() + fabric.getValue();
        for(ExtraRequirement extraRequirement : extraRequirements){
            totalPrice += extraRequirement.getValue();
        }
        totalPrice *= size.getPriceMultiplier();
    }
    public long getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        updateTotalPrice();
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
        updateTotalPrice();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
        updateTotalPrice();
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
        updateTotalPrice();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //TODO avisar que eu adicionei esse sistema.
    //Este getter possui uma chamada a updateTotalPrice(), pois ao receber uma referencia a uma lista, podemo usar List.add() para modifica-la.
    //Isto garante que não ocorrerão modificações no preço, sem a correção do preço total.
    //
    //Alternativa: fazer este getter retornar uma copia dos dados contidos na lista ao invez de uma referencia a propria lista,
    // alem de criar uma função "addExtraRequirement()" e "removeExtraRequirement()", alem de remover a função "setExtraRequirements()" por questão de boas praticas.
    //Em suma: um rolê absurdo, este metodo é mais facil e faz o que necessitamos.
    public List<ExtraRequirement> getExtraRequirements() {
        updateTotalPrice();
        return extraRequirements;
    }

    public void setExtraRequirements(List<ExtraRequirement> extraRequirements) {
        this.extraRequirements = extraRequirements;
        updateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
