package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import clases.Cliente;
import clases.Empanada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empanada empanada=new Empanada("empanada de papa y carnes","papa,carne",1200,5000);
        Cliente cliente=new Cliente();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        int opcion=100;
        Scanner entradaTeclado=new Scanner(System.in);
        System.out.println("**MENU");
        System.out.println("1.Agregar empanadas");
        System.out.println("2.ver la Empanadas");
        System.out.println("3.editar precio Empanadas");
        System.out.println("4 Salir");




        while (opcion!=5){
            System.out.println("digite una opcion: ");

            opcion=entradaTeclado.nextInt();

            if (opcion ==1) {

                System.out.println("Ingrese su saldo disponible");
                cliente.setSaldoDisponible(entradaTeclado.nextInt());
                if (cliente.getSaldoDisponible()>=5000) {
                    System.out.println("El ingrediente de la empada es "+empanada.getIngrediente());
                    System.out.println("El precio de la empanada es "+empanada.getPrecioVenta());
                    System.out.println("Digite la cantiad de empanadas deseadas");
                    empanada.setCantidad(entradaTeclado.nextInt());


                    if (empanada.getCantidad()> cliente.getSaldoDisponible()){
                        System.out.println("no tienes saldo suficiente");
                        System.out.println("Ingrese una cantidad menor");
                        empanada.setCantidad(entradaTeclado.nextInt());

                    }else{
                       cliente.setSaldoDisponible(cliente.getSaldoDisponible()-empanada.calcularVenta());
                        System.out.println("gracias por su compra");
                        System.out.println("su nuevo saldo es:"+cliente.getSaldoDisponible());
                    }

                }else {
                    System.out.println("No tienes plata");
                    break;
                }


            }else if(opcion==2){
                System.out.println("***"+empanada.getNombre()+"***");
                System.out.println("-Regimen comun");
                System.out.println(dtf.format(LocalDateTime.now()));
                System.out.println("Producto: empanada de"+empanada.getIngrediente());
                System.out.println("Valor unitario: "+empanada.getPrecioVenta());
                System.out.println("Cantidad de empanadas que compradas: "+empanada.getCantidad());
                System.out.println("El valor total:"+empanada.getPrecioVenta());
                System.out.println("**GRACIAS POR SU COMPRA**");

            }else if (opcion==3){

            }else if (opcion==3){

            } else {

            }

        }


    }
}