package projeto.pkg1bim;

import java.util.Scanner;

public class Projeto1Bim {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hospedes[] = new String[99];
        Boolean quartos[] = new Boolean[99];
        byte opcao = 1;
        byte numQuarto = 0;
        
        
        //transforma os elementos dos quartos em false, ao inves de null
        for(int i = 0; i < 99; i++) { 
            quartos[i] = false;
        }
        
        System.out.println("Bem-vindo\n");
        
        while (opcao != 0) {
            System.out.println("\nSelecione uma opção:\n"
                + "\nReservar quarto - (1)"
                + "\nCancelar reserva - (2)"
                + "\nListar reservas - (3)"
                + "\nConsultar hóspede - (4)"
                + "\nEditar hóspede - (5)"
                + "\nSair - (0)\n"
            );
                
        
            opcao = input.nextByte();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Insira seu nome:");
                    String nome = input.nextLine();

                    System.out.println("Insira o número do quarto de 1 a 100:");
                    numQuarto = input.nextByte();
                    
                    while (numQuarto < 1 || numQuarto > 100 ){
                        System.out.println("Insira um número válido:");
                        numQuarto = input.nextByte();
                    }

                    while (quartos[numQuarto - 1]) {
                        System.out.println("Este quarto está reservado, selecione outro:");
                        numQuarto = input.nextByte();
                    }
                    
                    hospedes[numQuarto - 1] = nome;
                    quartos[numQuarto - 1] = true;
                    System.out.println("Quarto reservado com sucesso!");
                    
                    break;
                case 2:
                    System.out.println("Insira o número do quarto de 1 a 100:");
                    numQuarto = input.nextByte();

                    while (numQuarto < 1 || numQuarto > 100 ){
                        System.out.println("Insira um número válido:");
                        numQuarto = input.nextByte();
                    }
                    
                    while (quartos[numQuarto - 1]) {
                        System.out.println("Este quarto está disponível, selecione outro:");
                        numQuarto = input.nextByte();
                    }
                    
                    hospedes[numQuarto - 1] = "";
                    quartos[numQuarto - 1] = false;
                    
                    break;
                case 3:
                    System.out.println("\nQuartos:\n");
                    for (byte i = 0; i < 99; i++) {
                        if (quartos[i]) {
                            System.out.println("Quarto " + (i + 1) + " reservado por " + hospedes[i] + "\n");
                        } else {
                            System.out.println("Quarto " + (i + 1) + " disponível\n");
                        }                     
                    }
                    
                    break;
                case 4:
                    System.out.println("Insira o número do quarto de 1 a 100:");
                    numQuarto = input.nextByte();
                    
                    while (numQuarto < 1 || numQuarto > 100 ){
                        System.out.println("Insira um número válido:");
                        numQuarto = input.nextByte();
                    }
                    System.out.println("Hóspede :" + hospedes[numQuarto - 1]);
                    
                    break;
                case 5:
                    System.out.println("Insira o número do quarto de 1 a 100:");
                    numQuarto = input.nextByte();
                    
                    while (numQuarto < 1 || numQuarto > 100 ){
                        System.out.println("Insira um número válido:");
                        numQuarto = input.nextByte();
                    }
                    
                    while (quartos[numQuarto - 1]) {
                        System.out.println("Este quarto está disponível, selecione outro:");
                        numQuarto = input.nextByte();
                    }
                    System.out.println("Insira o novo nome:");
                    nome = input.nextLine();
                    
                    hospedes[numQuarto - 1] = nome;
                    quartos[numQuarto - 1] = true;
                    
                    System.out.println("Hóspede editado com sucesso!");
                    
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Insira uma opção válida: ");
                    opcao = input.nextByte();
            }
        }
        input.close();
    }
}
