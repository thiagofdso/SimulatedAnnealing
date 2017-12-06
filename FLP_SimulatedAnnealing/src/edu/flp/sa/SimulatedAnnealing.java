package edu.flp.sa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago
 */
public class SimulatedAnnealing {
    public static void main(String[] args) {
        FileIO reader = new FileIO();
        String[] texto=reader.load("1PM_FP_11.txt");
        String[]entrada = texto[2].split("\\s+");
        int fabricas = Integer.parseInt(entrada[1]);
        Integer[][] custoFabricaCliente = new Integer[fabricas][fabricas];
        for(int i=4;i<texto.length;i++){
            String[]parts = texto[i].split("\\s+");
            int j = Integer.parseInt(parts[1])-1;
            int k = Integer.parseInt(parts[2])-1;
            custoFabricaCliente[j][k] = Integer.parseInt(parts[3]);
        }
        Instancia instancia = new Instancia(custoFabricaCliente);
        instancia.aleatorio();
        System.out.println("inicial "+instancia.toString());
    }    
}
