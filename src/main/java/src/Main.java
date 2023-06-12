package src;

import src.Controller.AnimalController;
import src.DTO.AnimalDTO;
import src.DTO.TipoAnimal;

import src.DTO.UsuarioDTO;

import src.Model.Animal;
import src.Service.AutenticacionService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static UsuarioDTO usuarioAuntenticado=new UsuarioDTO();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenido al refugio de animales\n");
        inicio(scanner);

        System.out.println("Finalizo el programa");
    }


    private static void inicio(Scanner scanner) {

        String tipoUsuario;
        String opcion = "0";

        while (!opcion.equals("2")) {

            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar al sistema");
            System.out.println("2. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println("\nIngrese el id de usuario:");
                    usuarioAuntenticado.setIdUsuario(scanner.nextLine());
                    usuarioAuntenticado = AutenticacionService.getInstance().autenticarUsuario(usuarioAuntenticado);

                    if (usuarioAuntenticado.isEstaAutenticado()) {
                        switch (usuarioAuntenticado.getTipo().toString()) {
                            case "VETERINARIO":
                                menuVeterinario(scanner);
                                break;
                            case "VISITADOR":
                                menuVisitador(scanner);
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("\nFinalizo el programa\n");
                    break;
            }

        }
    }

    private static void inicioGestionarAnimalesVeterinario() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Agregar animal");
        System.out.println("2. Buscar animal");
        System.out.println("3. Buscar todos los animales");
        System.out.println("4. Menu anterior\n");
    }

    private static void gestionarAnimalesVeterinario(Scanner scanner) {
        inicioGestionarAnimalesVeterinario();

        String opcion = scanner.nextLine();
        while (!opcion.equals("4")) {
            switch (opcion) {
                case "1":
                    System.out.println("\nIngrese el nombre del animal");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la edad aproximada del animal");
                    Integer edadAprox = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el peso de animal");
                    Double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la altura del animal");
                    Double altura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Indique si el animal presenta alguna condicion medica");
                    String condicionMedica = scanner.nextLine();
                    System.out.println("El animal es Salvaje o Domestico? -> S/D");
                    String tipo = scanner.nextLine();
                    TipoAnimal tipoAnimal = tipo.equals("S") ? TipoAnimal.SALVAJE : TipoAnimal.DOMESTICO;
                    AnimalDTO animalDTO = new AnimalDTO(nombre, edadAprox, peso, altura, condicionMedica, tipoAnimal);
                    AnimalController.getInstancia().ingresarAnimal(animalDTO, usuarioAuntenticado);
                    inicioGestionarAnimalesVeterinario();
                    break;
                case "2":
                    System.out.println("\nIngrese el nombre del animal");
                    String nombreAnimal = scanner.nextLine();
                    Animal animalBuscado = AnimalController.getInstancia().buscarAnimal(nombreAnimal);
                    if (animalBuscado != null) {
                        System.out.println("\n/-----------------------------/");
                        System.out.println("Nombre -> " + animalBuscado.getNombre());
                        System.out.println("Edad -> " + animalBuscado.getEdadAprox());
                        System.out.println("Peso -> " + animalBuscado.getPeso());
                        System.out.println("Altura -> " + animalBuscado.getAltura());
                        System.out.println("Condicion medica -> " + animalBuscado.getCondicionMedica());
                        System.out.println("Tipo -> " + animalBuscado.getTipoAnimal());
                        System.out.println("/-----------------------------/");
                    }
                    inicioGestionarAnimalesVeterinario();
                    break;
                case "3":
                    System.out.println("\nLista de animales");
                    System.out.println("/-----------------------------/");
                    List<Animal> animales = AnimalController.getInstancia().obtenerAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("Tipo -> " + animal.getTipoAnimal());
                        System.out.println("-----------------------------");
                    });
                    inicioGestionarAnimalesVeterinario();
                    break;
                default:
                    inicioGestionarAnimalesVeterinario();
                    break;
            }
            opcion = scanner.nextLine();
        }
        menuVeterinario(scanner);
    }

    private static void inicioGestionarAdopciones() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Crear Adopcion");
        System.out.println("2. Menu anterior\n");
    }

    private static void gestionarAdopciones(Scanner scanner){
        inicioGestionarAdopciones();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    inicioGestionarAdopciones();
                    break;
                default:
                    inicioGestionarAdopciones();
                    break;
            }
            opcion = scanner.nextLine();
        }

        menuVeterinario(scanner);
    }

    private static void inicioGestionarSalud() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Exportar Ficha medica");
        System.out.println("2. Menu anterior\n");
    }

    private static void gestionarSalud(Scanner scanner){
        inicioGestionarSalud();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    inicioGestionarSalud();
                    break;
                default:
                    inicioGestionarSalud();
                    break;
            }
            opcion = scanner.nextLine();
        }

        menuVeterinario(scanner);
    }
    private static void inicioProgramarAlarmas() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Elegir animal");
        System.out.println("2. Menu anterior\n");
    }

    private static void programarAlarmas(Scanner scanner){
        inicioProgramarAlarmas();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    inicioProgramarAlarmas();
                    break;
                default:
                    inicioProgramarAlarmas();
                    break;
            }
            opcion = scanner.nextLine();
        }

        menuVeterinario(scanner);
    }
    private static void inicioAtenderAlarmas() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Elegir animal");
        System.out.println("2. Menu anterior\n");
    }

    private static void atenderAlarmas(Scanner scanner){
        inicioAtenderAlarmas();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    inicioAtenderAlarmas();
                    break;
                default:
                    inicioAtenderAlarmas();
                    break;
            }
            opcion = scanner.nextLine();
        }

        menuVeterinario(scanner);
    }

    private static void inicioVeterinario() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Gestionar Animales");
        System.out.println("2. Gestionar Adopciones");
        System.out.println("3. Gestionar Salud");
        System.out.println("4. Programar Alarmas");
        System.out.println("5. Atender Alarmas");
        System.out.println("6. menu anterior\n");
    }

    private static void menuVeterinario(Scanner scanner) {
        inicioVeterinario();

        String opcion = scanner.nextLine();
        while (!opcion.equals("6")) {
            switch (opcion) {
                case "1":
                    gestionarAnimalesVeterinario(scanner);
                    break;
                case "2":
                    gestionarAdopciones(scanner);
                    break;
                case "3":
                    gestionarSalud(scanner);
                    break;
                case "4":
                    programarAlarmas(scanner);
                    break;
                case "5":
                    atenderAlarmas(scanner);
                    break;
                default:
                    break;
            }
            opcion = scanner.nextLine();
        }
        inicio(scanner);
    }


    private static void inicioVisitador() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Gestionar Animales");
        System.out.println("2. Completar visita");
        System.out.println("3. Salir\n");
    }

    private static void menuVisitador(Scanner scanner) {
        inicioVisitador();

        String opcion = scanner.nextLine();
        while (!opcion.equals("3")) {
            switch (opcion) {
                case "1":
                    gestionarAnimalesVisitador(scanner);
                    break;
                case "2":
                    gestionarVisitas(scanner);
                    break;
                default:
                    break;
            }
            opcion = scanner.nextLine();
        }

        inicio(scanner);
    }

    private static void inicioGestionarAnimalesVisitador() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Buscar animal");
        System.out.println("2. Buscar todos los animales");
        System.out.println("3. Menu anterior\n");
    }

    private static void gestionarAnimalesVisitador(Scanner scanner) {
        inicioGestionarAnimalesVisitador();

        String opcion = scanner.nextLine();
        while (!opcion.equals("3")) {
            switch (opcion) {
                case "1":
                    System.out.println("\nIngrese el nombre del animal");
                    String nombreAnimal = scanner.nextLine();
                    Animal animalBuscado = AnimalController.getInstancia().buscarAnimal(nombreAnimal);
                    if (animalBuscado != null) {
                        System.out.println("\n/-----------------------------/");
                        System.out.println("Nombre -> " + animalBuscado.getNombre());
                        System.out.println("Edad -> " + animalBuscado.getEdadAprox());
                        System.out.println("Peso -> " + animalBuscado.getPeso());
                        System.out.println("Altura -> " + animalBuscado.getAltura());
                        System.out.println("Condicion medica -> " + animalBuscado.getCondicionMedica());
                        System.out.println("Tipo -> " + animalBuscado.getTipoAnimal());
                        System.out.println("/-----------------------------/");
                    }
                    inicioGestionarAnimalesVisitador();
                    break;
                case "2":
                    System.out.println("\nLista de animales");
                    System.out.println("/-----------------------------/");
                    List<Animal> animales = AnimalController.getInstancia().obtenerAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("Tipo -> " + animal.getTipoAnimal());
                        System.out.println("-----------------------------");
                    });
                    inicioGestionarAnimalesVisitador();
                    break;
                default:
                    inicioGestionarAnimalesVisitador();
                    break;
            }
            opcion = scanner.nextLine();
        }
        menuVisitador(scanner);
    }

    private static void inicioGestionarVisitas() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Elegir animal visitado");
        System.out.println("2. Menu anterior\n");
    }

    private static void gestionarVisitas(Scanner scanner){
        inicioGestionarVisitas();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    inicioGestionarVisitas();
                    break;
                default:
                    inicioGestionarVisitas();
                    break;
            }
            opcion = scanner.nextLine();
        }

        menuVisitador(scanner);
    }

}
