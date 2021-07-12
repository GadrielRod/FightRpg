import java.util.Random;
import java.util.Scanner;


public class RPGFightGame{

    static int attackUser(){
        Scanner wasd = new Scanner(System.in);
        try {Thread.sleep(1000);} catch (Exception e) {}
        System.out.println("Escolha seu ataque:");
        System.out.println("(1) - Soco");
        System.out.println("(2) - Especial");
        return wasd.nextInt();
    }

    static int attackComputer(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    static void printHp(int hpUser, int hpComputer, int countSpecial){
        System.out.println("=======================");
        System.out.println(" - HP Usuario: " +hpUser);
        System.out.println(" - HP Computador: " +hpComputer);
        System.out.println(" * Contagem Especiais: "+countSpecial);
        System.out.println("========================");
    }

    static int fight(){
        int hpUser = 150;
        int hpComputer;
        int countSpecial = 5;
        int chooseAttack;
        int i = 1;

        while (hpUser > 0) {

            hpComputer = 10 + i;

            System.out.println("=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("INIMIGO " +i);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=");


            while(hpUser > 0 && hpComputer > 0){
                printHp(hpUser, hpComputer, countSpecial);
                chooseAttack = attackUser();
                try {Thread.sleep(1000);} catch (Exception e) {}
                switch(chooseAttack){
                    case 1:
                        System.out.println("Usuario aplicou um soco.");
                        hpComputer -=7;
                    break;
                    case 2:
                        System.out.println("Usuario aplicou um ataque especial.");
                        if(countSpecial > 0){
                            hpComputer -= 20;
                            countSpecial--;
                        }else{
                            countSpecial = 0;
                            hpComputer -= 0;
                            System.out.println("Usuario não possui mais ataque especiais");
                        }
                    break;
                    default:
                        System.out.println("Opção invalida");
                    break;
                }
                if(hpComputer > 0){
                    chooseAttack = attackComputer();
                    switch(chooseAttack){
                        case 1:
                            System.out.println("Computador aplicou um soco");
                            hpUser -= 2 + (int)(i / 10);
                        break;
                        case 2:
                            System.out.println("Computador aplicou um chute");
                            hpUser -=3 + (int)(i / 10);
                        break;
                        case 3:
                            System.out.println("Computador aplicou um ataque especial");
                            hpUser -=4  + (int)(i / 20);
                        break;
                    }
                }else{
                    System.out.println("Inimigo derrotado");
                }
            }
            if(hpUser > 0){
                hpUser += 5;
                if(hpUser > 150){
                    hpUser = 150;
                }
                if(i % 10==0){
                    countSpecial++;
                    if(countSpecial > 5){
                        countSpecial = 5;
                    }
                }
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args){
        Scanner wasd = new Scanner(System.in);
        int continua = 1;
        int record = 0;
        while(continua == 1){


            int pontos = fight();
            System.out.println("Usuario chegou a " + pontos + " pontos.");
            if(pontos > record){
                record = pontos;
            }
            System.out.println("recorde atual = " + record);

            System.out.println("Fim de jogo. Deseja continuar? (1) Sim (2) Não");
            continua = wasd.nextInt();
        }
    }
}