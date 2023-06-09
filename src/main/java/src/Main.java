package src;

import src.Controller.AnimalController;
import src.DTO.AnimalDTO;
import src.DTO.TipoAnimal;
import src.Model.Animal;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalController animalController = new AnimalController();
        Scanner scanner = new Scanner(System.in);

        inicio(scanner, animalController);

        System.out.println("Finalizo el programa");
    }

    private static void inicio(Scanner scanner, AnimalController animalController) {
        var tipoUsuario = loggeo(scanner);

        switch (tipoUsuario) {
            case "1":
                menuVeterinario(scanner, animalController);
                break;
            default:
                menuVisitador(scanner, animalController);
                break;
        }
    }

    private static String loggeo(Scanner scanner) {
        System.out.println("Ingrese el nombre de usuario:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("\nHola " + nombreUsuario);
        System.out.println("Quiere ingresar como: \n1. Veterinario \n2. Visitador");
        return scanner.nextLine();
    }

    private static void inicioVeterinario() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Ingresar animal");
        System.out.println("2. Buscar animal");
        System.out.println("3. Listar animales");
        System.out.println("4. Salir\n");
    }

    private static void inicioVisitador() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Generar visita");
        System.out.println("2. Buscar animal");
        System.out.println("3. Listar animales");
        System.out.println("4. Salir\n");
    }

    private static void menuVeterinario(Scanner scanner, AnimalController animalController) {
        inicioVeterinario();

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
                    animalController.ingresarAnimal(animalDTO);
                    inicioVeterinario();
                    break;
                case "2" :
                    System.out.println("\nIngrese el nombre del animal");
                    String nombreAnimal = scanner.nextLine();
                    Animal animalBuscado = animalController.buscarAnimal(nombreAnimal);
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
                    inicioVeterinario();
                    break;
                case "3":
                    System.out.println("\nLista de animales");
                    System.out.println("/-----------------------------/");
                    List<Animal> animales = Refugio.getInstancia().obtenerAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("Tipo -> " + animal.getTipoAnimal());
                        System.out.println("-----------------------------");
                    });
                    inicioVeterinario();
                    break;
                default:
                    inicioVeterinario();
                    break;
            }
            opcion = scanner.nextLine();
        }

        inicio(scanner, animalController);
    }

    private static void menuVisitador(Scanner scanner, AnimalController animalController) {
        inicioVisitador();

        String opcion = scanner.nextLine();
        while (!opcion.equals("4")) {
            switch (opcion) {
                case "1":

                    break;
                case "2" :
                    System.out.println("\nIngrese el id del animal");
                    String idAnimal = scanner.nextLine();
                    Animal animalBuscado = animalController.buscarAnimal(idAnimal);
                    if (animalBuscado != null) {
                        System.out.println("\n/-----------------------------/");
                        System.out.println("ID -> " + animalBuscado.getId());
                        System.out.println("Nombre -> " + animalBuscado.getNombre());
                        System.out.println("Edad -> " + animalBuscado.getEdadAprox());
                        System.out.println("Peso -> " + animalBuscado.getPeso());
                        System.out.println("Altura -> " + animalBuscado.getAltura());
                        System.out.println("Condicion medica -> " + animalBuscado.getCondicionMedica());
                        System.out.println("Tipo -> " + animalBuscado.getTipoAnimal());
                        System.out.println("/-----------------------------/");
                    }
                    inicioVeterinario();
                    break;
                case "3":
                    System.out.println("\nLista de animales");
                    System.out.println("/-----------------------------/");
                    List<Animal> animales = Refugio.getInstancia().obtenerAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("Tipo -> " + animal.getTipoAnimal());
                        System.out.println("-----------------------------");
                    });
                    inicioVeterinario();
                    break;
                default:
                    inicioVeterinario();
                    break;
            }
            opcion = scanner.nextLine();
        }

        inicio(scanner, animalController);
    }

}
