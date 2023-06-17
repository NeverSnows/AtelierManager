package com.company.Controller;

import com.company.dao.TecidoDAO;
import com.company.dao.TecidoDTO;
import com.company.model.Tecido;

import java.util.ArrayList;
import java.util.List;

public class TecidoController {

    public List<TecidoDTO> traduzirResultado(List<Tecido> resultados) {
        List<TecidoDTO> tecidos = new ArrayList<>();
        for (Tecido resultado : resultados) {
            String nome = resultado.getNome();
            Double preco = resultado.getPreco();
            TecidoDTO tecido = new TecidoDTO(nome, preco);
            tecidos.add(tecido);
        }
        return tecidos;
    }

    public static void main(String[] args) {
        TecidoController tc = new TecidoController();
        TecidoDAO td = new TecidoDAO();
        System.out.println(tc.traduzirResultado(td.buscarTodos()));
    }
}
