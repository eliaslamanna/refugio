package src.Controller;

import src.DTO.AnimalDTO;

import java.util.Scanner;

public class Principal {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarPrograma();
    }

    private static void iniciarPrograma() {
        System.out.println("Que desea hacer: ");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "dar de alta animal":
                AnimalDTO animalDTO = pedirDatosAnimal();
                AnimalController.getInstancia().altaAnimal(animalDTO);
                iniciarPrograma();
                break;
            default:
                System.out.println("Opcion invalida.");
                iniciarPrograma();
                break;
        }
    }

    public static AnimalDTO pedirDatosAnimal() {
        System.out.println("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la altura del animal: ");
        float altura = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Ingrese el peso del animal: ");
        float peso = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Ingrese la edad aproximada del animal: ");
        int edadAprox = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese si el animal presenta alguna condicion medica: ");
        String condicionMedica = scanner.nextLine();

        System.out.println("Es salvaje? (true/false): ");
        boolean esSalvaje = scanner.nextBoolean();

        System.out.println("Esta en tratamiento? (true/false): ");
        boolean enTratamiento = scanner.nextBoolean();

        return new AnimalDTO(nombre, altura, peso, edadAprox, condicionMedica, esSalvaje, enTratamiento);
    }

}
