// ALBERTO M. SANCHEZ MACIAS
// CURSO: DAW 1-B - PROGRAMACIÓN - TAREA 1 EVALUABLE

import java.util.Random;
import java.util.Scanner;

public class Practica1_Alberto {
    public static void main(String[] args) {

//  TECLADO Y EL GENERADOR

        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();

        int jugador = 0;
        int respuestaMenu = 0;
        int computadora;
        String jugadorNombre;
        boolean correctoMenu, correctoSimple, correctoCinco;

        // CONTADORES

        int marcadorJugador;                        // MODO SIMPLE
        int marcadorComputadora;                    // MODO SIMPLE
        int jugadorPartidaGanadaSimple = 0;         // MODO SIMPLE
        int compuPartidaGanadaSimple = 0;           // MODO SIMPLE
        int partidaEmpateSimple = 0;                // MODO SIMPLE
        int contaPartidaJugada = 0;                 // MODO SIMPLE/MEJOR 5
        int rondaGanaJugador = 0;                   // MODO SIMPLE/MEJOR 5
        int rondaGanaComputadora = 0;               // MODO SIMPLE/MEJOR 5
        int totalRondasJugada = 0;                  // MODO SIMPLE/MEJOR 5
        int totalIntentos = 0;                      // MODO SIMPLE/MEJOR 5
        int cincoPartidaGanadaJ = 0;                // MODO MEJOR 5
        int cincoPartidaGanadaC = 0;                // MODO MEJOR 5
        int porcentajeAcierto = 0;                  // MODO SIMPLE/MEJOR 5
        int cincoRondaGanaJugador;                  // MODO MEJOR 5
        int cincoRondaGanaComputadora;              // MODO MEJOR 5

        // [0]----->      MENÚ DE BIENVENIDA

        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                                             *");
        System.out.println("*  [  BIENVENIDOS A PIEDRA, PAPEL, TIJERAS, LAGARTO, SPOCK  ] *");
        System.out.println("*                       El Videojuego                         *");
        System.out.println("*                                                             *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        // [0.1]---->      ELECCIÓN NOMBRE JUGADOR

        System.out.println("\n [INGRESA TU NOMBRE PARA EMPEZAR]\n");
        System.out.print("[NOMBRE]----> ");
        jugadorNombre = teclado.nextLine();

        do {
            //             MENÚ PRINCIPAL
            System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                             *");
            System.out.println("*              [MENÚ PRINCIPAL]               *");
            System.out.println("*                                             *");
            System.out.println("*           Selecciona una opción:            *");
            System.out.println("*                                             *");
            System.out.println("*            [1] Partida Simple               *");
            System.out.println("*            [2] Partida Mejor de 5           *");
            System.out.println("*            [3] Estadísticas                 *");
            System.out.println("*            [4] Instrucciones                *");
            System.out.println("*            [5] Salir                        *");
            System.out.println("*                                             *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *\n");


            do {

                System.out.print("\n[OPCIÓN]--> ");
                try {       // TRY-CATCH PARA ASEGURAR QUE SE INTRODUCE EL VALOR CORRECTO
                    respuestaMenu = teclado.nextInt();

                    if ((respuestaMenu > 0) && (respuestaMenu < 6)) {
                        correctoMenu = true;
                    } else {
                        correctoMenu = false;
                        teclado.nextLine();         // PARA LIMPIAR EL BUFFER
                        System.out.println("\n[OPCIÓN INCORRECTA - intentalo de nuevo.]\n");
                    }
                } catch (Exception e) {
                    teclado.nextLine();
                    System.out.println("\n[OPCIÓN INCORRECTA - intentalo de nuevo.]\n");
                    correctoMenu = false;

                }

            } while (!correctoMenu);

// [1]------>   [PARTIDA SIMPLE]

            while (respuestaMenu == 1) {

                System.out.println("\n******* [PARTIDA SIMPLE] *******\n");
                System.out.println("[" + jugadorNombre + "👤] " + "🆚" + " [COMPUTADORA🤖]");

                // LA COMPUTADORA ELIGE UNA OPCION ALEATORIA Y SE LE AVISA AL JUGADOR

                computadora = generador.nextInt(1, 6);
                System.out.println("\n- [LA COMPUTADORA🤖 YA HA ELEGIDO]\n");

                // SE LE PREGUNTA AL JUGADOR QUE OPCION VA A ELEGIR

                do {
                    System.out.println("- ¿Qué vas a elegir?:\n \n [1]-Piedra\n [2]-Papel\n [3]-Tijeras\n [4]-Lagarto\n [5]-Spock");
                    System.out.print("\n[" + jugadorNombre + "👤] ELIGE ---->");

                    try {
                        jugador = teclado.nextInt();
                        if ((jugador > 0) && (jugador < 6)) {
                            correctoSimple = true;
                        } else {
                            correctoSimple = false;
                            teclado.nextLine();
                            System.out.println("\n[ELECCIÓN INCORRECTA - intentalo de nuevo.]\n");
                        }
                    } catch (Exception e) {
                        teclado.nextLine();
                        System.out.println("\n[ELECCIÓN INCORRECTA - intentalo de nuevo.]\n");
                        correctoSimple = false;
                    }

                } while (!correctoSimple);

                System.out.print("\nHas elegido: ");


                //CONVERSIÓN DE LA OPCION DEL JUGADOR A STRING

                switch (jugador) {
                    case 1 -> System.out.println("Piedra");
                    case 2 -> System.out.println("Papel");
                    case 3 -> System.out.println("Tijeras");
                    case 4 -> System.out.println("Lagarto");
                    case 5 -> System.out.println("Spock");
                }

                System.out.print("\nLa computadora eligió: ");

                switch (computadora) {
                    case 1 -> System.out.println("Piedra\n");
                    case 2 -> System.out.println("Papel\n");
                    case 3 -> System.out.println("Tijeras\n");
                    case 4 -> System.out.println("Lagarto\n");
                    case 5 -> System.out.println("Spock\n");
                }

                // CONDICIONES DE GANA-JUGADOR / PIERDE-JUGADOR PARA EL JUEGO

                boolean ganaJugador = (((jugador == 1) && ((computadora == 3) || (computadora == 4))) || ((jugador == 2) && ((computadora == 1) || (computadora == 5))) || ((jugador == 3) && ((computadora == 2) || (computadora == 4))) || ((jugador == 4) && ((computadora == 2) || (computadora == 5))) || ((jugador == 5) && ((computadora == 1) || (computadora == 3))));
                boolean pierdeJugador = (((jugador == 1) && ((computadora == 2) || (computadora == 5))) || ((jugador == 2) && ((computadora == 3) || (computadora == 4))) || ((jugador == 3) && ((computadora == 1) || (computadora == 5))) || ((jugador == 4) && ((computadora == 3) || (computadora == 1))) || ((jugador == 5) && ((computadora == 2) || (computadora == 4))));

                // JUEGO SIMPLE

                //RESETEO DE MARCADOR JUGADOR Y COMPUTADORA
                marcadorJugador = 0;
                marcadorComputadora = 0;

                if (ganaJugador) {
                    marcadorJugador++;
                    System.out.println("✅ " + jugadorNombre + " " + marcadorJugador + "-" + marcadorComputadora + " Computadora ❌");
                    System.out.println("✅✅✅ ¡¡ Has ganado !! ✅✅✅\n");
                    jugadorPartidaGanadaSimple++;
                    rondaGanaJugador++;
                    totalIntentos++;

                } else if (pierdeJugador) {
                    marcadorComputadora++;
                    System.out.println("❌ " + jugadorNombre + " " + marcadorJugador + "-" + marcadorComputadora + " Computadora ✅");
                    System.out.println("❌❌❌ ¡¡ Has perdido !! ❌❌❌\n");
                    compuPartidaGanadaSimple++;
                    rondaGanaComputadora++;
                    totalIntentos++;

                } else {
                    System.out.println("🟰 " + jugadorNombre + " " + marcadorJugador + "-" + marcadorComputadora + " Computadora 🟰");
                    System.out.println("🟰🟰🟰 ¡¡ Empate !! 🟰🟰🟰\n");
                    partidaEmpateSimple++;
                    totalIntentos++;

                }

                contaPartidaJugada++;
                totalRondasJugada++;             // EN MODO SIMPLE SI CUENTO EL EMPATE COMO RONDA JUGADA

                porcentajeAcierto = ((rondaGanaJugador * 100) / totalIntentos);
                respuestaMenu--;
            }


// [2]------>       PARTIDA MEJOR DE 5

            while (respuestaMenu == 2) {
                System.out.println("[MODO MEJOR DE 5]");
                System.out.println("CONDICION DEL JUEGO: ¡EL PRIMERO QUE LLEGUE A 3 RONDAS GANADAS!");
                System.out.println("\n[ * * * * * * * * * * * * * * * * * * * * * * * *]\n");

                // RESETEO MARCADOR Y RONDAS PARA EL BUCLE FOR

                marcadorJugador = 0;
                marcadorComputadora = 0;
                cincoRondaGanaJugador = 0;
                cincoRondaGanaComputadora = 0;

                do {        // BUCLE (CONDICION QUE GANE 3 RONDAS JUGADOR O CPU)

                    for (int i = 1; i <= 5; i++) {

                        computadora = generador.nextInt(1, 6);

                        System.out.println("[MODO MEJOR DE 5]");
                        System.out.println("\n*****[RONDA " + i + "]*****");
                        System.out.println("[" + jugadorNombre + "👤] " + "🆚" + " [COMPUTADORA🤖]");
                        System.out.println("\n- [LA COMPUTADORA🤖 YA HA ELEGIDO]\n");

                        do {

                            System.out.println("- ¿Qué vas a elegir?:\n [1]-Piedra\n [2]-Papel\n [3]-Tijeras\n [4]-Lagarto\n [5]-Spock");
                            System.out.print("\n[" + jugadorNombre + "👤] ELIGE ---->");

                            try {

                                jugador = teclado.nextInt();
                                if ((jugador > 0) && (jugador < 6)) {
                                    correctoCinco = true;
                                } else {
                                    correctoCinco = false;
                                    teclado.nextLine();
                                    System.out.println("\nDato incorrecto, intentalo de nuevo.\n");
                                }
                            } catch (Exception e) {
                                teclado.nextLine();
                                System.out.println("Dato incorrecto, intentalo de nuevo.");
                                correctoCinco = false;
                            }
                        } while (!correctoCinco);

                        switch (jugador) {
                            case 1 -> System.out.println("Piedra");
                            case 2 -> System.out.println("Papel");
                            case 3 -> System.out.println("Tijeras");
                            case 4 -> System.out.println("Lagarto");
                            case 5 -> System.out.println("Spock");
                        }

                        System.out.print("\nLa computadora eligió: ");

                        switch (computadora) {
                            case 1 -> System.out.println("Piedra\n");
                            case 2 -> System.out.println("Papel\n");
                            case 3 -> System.out.println("Tijeras\n");
                            case 4 -> System.out.println("Lagarto\n");
                            case 5 -> System.out.println("Spock\n");
                        }

                        boolean ganaJugador = (((jugador == 1) && ((computadora == 3) || (computadora == 4))) || ((jugador == 2) && ((computadora == 1) || (computadora == 5))) || ((jugador == 3) && ((computadora == 2) || (computadora == 4))) || ((jugador == 4) && ((computadora == 2) || (computadora == 5))) || ((jugador == 5) && ((computadora == 1) || (computadora == 3))));
                        boolean pierdeJugador = (((jugador == 1) && ((computadora == 2) || (computadora == 5))) || ((jugador == 2) && ((computadora == 3) || (computadora == 4))) || ((jugador == 3) && ((computadora == 1) || (computadora == 5))) || ((jugador == 4) && ((computadora == 3) || (computadora == 1))) || ((jugador == 5) && ((computadora == 2) || (computadora == 4))));

                        // EL JUEGO MEJOR DE 5

                        if (ganaJugador) {
                            System.out.println("✅✅✅ ¡¡ Has ganado !! ✅✅✅\n");
                            cincoRondaGanaJugador++;
                            rondaGanaJugador++;
                            totalRondasJugada++;
                            marcadorJugador++;
                            totalIntentos++;

                        } else if (pierdeJugador) {
                            System.out.println("❌❌❌ ¡¡ Has perdido !! ❌❌❌\n");
                            cincoRondaGanaComputadora++;
                            rondaGanaComputadora++;
                            totalRondasJugada++;
                            marcadorComputadora++;
                            totalIntentos++;


                        } else {
                            System.out.println("🟰🟰🟰 ¡¡ Empate !! 🟰🟰🟰\n");
                            i--;                    // PARA QUE NO PASE DE RONDA EN CASO DE EMPATE
                            totalIntentos++;

                            // [ACLARACIÓN] AQUI NO HAY totalRondasJugada++; PORQUE EN EL MODO MEJOR DE 5 MI CONDICION DE PASAR RONDAS ES QUE GANE JUGADOR O COMPUTADORA
                            // LOS EMPATES NO CUENTAN COMO RONDAS JUGADAS EN ESTE MODO DE JUEGO
                            // PERO SI CUENTAN COMO INTENTO PARA EL PORCENTAJE DE ACIERTO
                        }

                        System.out.println("MARCADOR ACTUAL: " + jugadorNombre + " [" + marcadorJugador + " - " + marcadorComputadora + "]" + " COMPUTADORA\n");
                        System.out.println("\n[ * * * * * * * * * * * * * * * * * * * * * * * *]\n");

                        if ((cincoRondaGanaJugador == 3) || (cincoRondaGanaComputadora == 3)) {
                            i = 5; //  VALOR=5 PARA ASEGURAR QUE SE SALGA DEL BUCLE
                        }

                    }

                } while ((cincoRondaGanaJugador < 3) && (cincoRondaGanaComputadora < 3));  // BUCLE CONDICION QUE GANE 3 JUGADOR O CPU

                // AL FINALIZAR LA PARTIDA CONTARÁ LA PARTIDA JUGADA Y PARTIDA GANADA POR JUGADOR O COMPUTADORA
                contaPartidaJugada++;

                if (cincoRondaGanaJugador == 3) {
                    cincoPartidaGanadaJ++;
                    System.out.println("  * * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("  * 🎉🎉🎉¡HAS GANADO LA PARTIDA!🎉🎉🎉  *");
                    System.out.println("  * * * * * * * * * * * * * * * * * * * * *");

                } else {
                    cincoPartidaGanadaC++;
                    System.out.println("  * * * * * * * * * * * * * * * * * * * * * * *");
                    System.out.println("  *😭😭😭¡LA COMPUTADORA TE HA GANADO!😭😭😭 *");
                    System.out.println("  * * * * * * * * * * * * * * * * * * * * * * *");

                }

                respuestaMenu-=2;
            }

// [3]------> ESTADISTICAS

            while (respuestaMenu == 3) {
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*                     [ESTADISTICAS]                          *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

                // [1]  PARTIDAS TOTALES JUGADAS

                System.out.println("\nPARTIDAS TOTALES JUGADAS: " + contaPartidaJugada);

                // [2]  NUMERO DE RONDAS JUGADAS

                System.out.println("\nTOTAL RONDAS JUGADAS: " + totalRondasJugada);

                // [3]  PARTIDAS GANADAS

                // [3.1] PARTIDAS GANADAS-PERDIDAS-EMPATADAS MODO SIMPLE

                System.out.println("\n[MODO SIMPLE]\n");
                System.out.println("PARTIDAS GANADAS JUGADOR: " + jugadorPartidaGanadaSimple);
                System.out.println("PARTIDAS GANADAS COMPUTADORA: " + compuPartidaGanadaSimple);
                System.out.println("PARTIDAS EMPATADAS: " + partidaEmpateSimple + "\n");

                // [3.2.1]       PARTIDAS GANADAS [JUGADOR] MODO MEJOR DE 5

                System.out.println("\n[MODO MEJOR DE 5]\n");
                System.out.print("PARTIDAS GANADAS POR " + jugadorNombre + "(JUGADOR): ");
                System.out.println(cincoPartidaGanadaJ);

                // [3.2.2]      PARTIDAS GANADAS [COMPUTADORA] MODO MEJOR DE 5

                System.out.print("PARTIDAS GANADAS POR LA COMPUTADORA: ");
                System.out.println(cincoPartidaGanadaC);

                // [5]   RONDA GANADA JUGADOR

                System.out.println("\n[TOTAL RONDAS GANADAS]");
                System.out.println("\nRONDAS GANADAS POR" + jugadorNombre + "(JUGADOR): " + rondaGanaJugador);

                // [6]   RONDA GANADA COMPUTADORA

                System.out.println("RONDAS GANADAS POR COMPUTADORA: " + rondaGanaComputadora);

                // [7]  PORCENTAJE DE ACIERTO DEL JUGADOR

                System.out.println("\n[PORCENTAJE DE ACIERTO DEL JUGADOR]");
                System.out.println("\nPORCENTAJE DE ACIERTO: " + porcentajeAcierto + "%");

                System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*                 [FIN ESTADISTICAS]                          *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

                respuestaMenu-=3;
            }


// [4]------> INSTRUCCIONES

            while (respuestaMenu == 4) {
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*                                                                 *");
                System.out.println("*                 [INSTRUCCIONES DEL JUEGO]                       *");
                System.out.println("*                                                                 *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                System.out.println("*             [1]-  🪨 Piedra aplasta Tijeras     ✂️             *\n*             [2]-  ✂️ Tijeras cortan Papel       📃             *\n*             [3]-  📃 Papel cubre Piedra         🪨             *\n*             [4]-  🪨 Piedra aplasta Lagarto     🦎             *\n*             [5]-  🦎 Lagarto envenena Spock     🖖🏻️             *\n*             [6]-  🖖🏻 Spock destroza Tijeras     ✂️             *\n*             [7]-  ✂️ Tijeras decapitan Lagarto  🦎             *\n*             [8]-  🦎 Lagarto se come el Papel   📃             *\n*             [9]-  📃 Papel desautoriza a Spock  🖖🏻             *\n*             [10]- 🖖🏻 Spock vaporiza la Piedra   🪨             *");
                System.out.println("*                                                                 *");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");

                respuestaMenu-=4;
            }
// [5]------> SALIDA

        } while (respuestaMenu != 5);
        System.out.println("\n* * * * * * * * * * * *");
        System.out.println("*  GRACIAS POR JUGAR  *");
        System.out.println("*   ¡HASTA PRONTO!    *");
        System.out.println("* * * * * * * * * * * *");

    }
}
