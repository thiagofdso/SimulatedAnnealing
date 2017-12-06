package edu.flp.sa;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago
 */
public class Instancia {
    ArrayList<Integer> lista;
    Integer[][] custos;
    Set<Integer>[] fabricasClientes;
    int maxFabrica = 11;
    public Instancia(Integer[][] custos){
        lista = new ArrayList<>();
        this.custos = custos;
        fabricasClientes = new Set[custos.length];
        for(int i=0;i<custos.length;i++){
            fabricasClientes[i] = new HashSet<>();
            for(int j=0;j<custos.length;j++){
                if(custos[i][j]!=null)
                    fabricasClientes[i].add(j);
            }
        }
    }
    public void aleatorio(){
        int fabrica = 0;
/*        do{
            lista.clear();*/
            do{
               fabrica = (int) (Math.random() * (custos.length-1));
               if(!lista.contains(fabrica))
                    lista.add(fabrica);
            }while(!verificarAtendimento2());
        //}while(lista.size()>12);
    }

    public int calcularCusto(){
        int saida=0;
        int min;
        for(int i=0;i<custos.length;i++){
            min = Integer.MAX_VALUE;
            for(Integer fabrica : lista){
                if(custos[fabrica][i]!=null&&custos[fabrica][i]<min)
                    min = custos[fabrica][i];
            }
            if(min == Integer.MAX_VALUE)
                min = 0;
            saida += min;
        }
        
        return saida;
    }
    
    //verifica se todos clientes foram atendidos
    public boolean verificarAtendimento(){
        boolean existe;
        for(int i=0;i<custos.length;i++){
            existe = false;
            for(Integer fabrica : lista){
                if(custos[fabrica][i]!=null){
                    existe = true;
                    break;
                }
            }
            if(!existe)
                return false;
        }
        return true;
    }
    
    public boolean verificarAtendimento2(){
        Set<Integer> union;
        union = fabricasClientes[lista.get(0)];
        for(Integer i:lista){
            union.addAll(fabricasClientes[i]);
        }
        if(union.size()==custos.length)
            return true;
        else
            return false;
    }
    
    public String toString(){
        String s="fabricas: ";
        int c=0;
        for(Integer i : lista){
            c++;
            s+=i+",";
        }
        s+="\nquantidade="+c+"\ncusto="+calcularCusto() ;
        return s;
    }
    public void optimal(){
        lista.add(8);
        lista.add(24);
        lista.add(37);
        lista.add(39);
        lista.add(67);
        lista.add(73);
        lista.add(74);
        lista.add(77);
        lista.add(85);
        lista.add(94);
        lista.add(99);
        lista.add(118);
    }    
}
