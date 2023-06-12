package src;

import src.Controller.AdopcionesController;
import src.Controller.AnimalController;


import src.DTO.*;
import src.Controller.ClinicaController;

import src.DTO.AnimalDTO;
import src.DTO.AdoptanteDTO;
import src.DTO.TipoAnimal;

import src.DTO.UsuarioDTO;


import src.Model.Adoptante;
import src.Model.Animal;
import src.Service.AutenticacionService;

import java.util.ArrayList;

import src.Controller.SeguimientoController;
import src.Controller.UsuarioController;
import src.DTO.*;

import src.Enum.Rol;
import src.Model.*;
import src.Service.AutenticacionService;

import java.io.BufferedReader;
import java.util.EnumSet;

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
        String respuesta;
        String idadoptante;
        String idanimal;
        String idVisitadorAAsignar;
        String medioNotificacion = "";

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    System.out.println("Existe el adoptante en el sistema? S/N");
                     respuesta = scanner.nextLine();
                     if(respuesta.equalsIgnoreCase("s")) {

                         List<Adoptante> disponiblesadop = AdopcionesController.getInstancia().getaAdoptantesDisponibles();
                         if (disponiblesadop.size() == 0){
                             System.out.println("NO HAY ADOPTANTES DISPONIBLES EN EL SISTEMA.\nINTRODUZCA CUALQUIER CARACTER PARA SALIR.");
                             break;
                         }
                         System.out.println("Lista de adoptantes disponibles");
                         System.out.println("-----------------------------");
                         disponiblesadop.forEach(adoptante -> {
                             System.out.println("Nombre -> " + adoptante.getNombre());
                             System.out.println("ID -> " + adoptante.getId());
                             System.out.println("                              ");
                         });
                         System.out.println("-----------------------------");
                         System.out.println("Ingrese el Id a elegir como adoptante");
                         idadoptante = scanner.nextLine();
                     }

                     else{
                    System.out.println("Ingrese el nombre del adoptante:");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese el apellido del adoptante:");
                    String apellido = scanner.nextLine();

                    System.out.println("Ingrese el estado civil del adoptante:");
                    String estadoCivil = scanner.nextLine();

                    System.out.println("Ingrese la dirección del adoptante:");
                    String direccion = scanner.nextLine();

                    System.out.println("Ingrese el número de teléfono del adoptante:");
                    String telefono = scanner.nextLine();

                    System.out.println("Ingrese la ocupación del adoptante:");
                    String ocupacion = scanner.nextLine();

                    System.out.println("Ingrese la cantidad de otras mascotas que tiene el adoptante:");
                    int otrasMascotas = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese el motivo de adopción del adoptante:");
                    String motivoAdopcion = scanner.nextLine();

                    System.out.println("Ingrese el tipo de animal en el que está interesado el adoptante:");
                    String tipoAnimalInteresado = scanner.nextLine();
                    AdoptanteDTO adoptanteDTO = new AdoptanteDTO(nombre, apellido, estadoCivil, direccion, telefono,
                            ocupacion, otrasMascotas, motivoAdopcion, tipoAnimalInteresado);
                    AdopcionesController.getInstancia().AltaAdoptante(adoptanteDTO);
                    idadoptante = AdopcionesController.getInstancia().getaAdoptantesDisponibles().get(AdopcionesController.getInstancia().getaAdoptantesDisponibles().size()-1).getId();
                }

                    System.out.println("Que animal desea adoptar?");
                    List <Animal> animalesDisp = AnimalController.getInstancia().getAnimalesDisponibles();
                    if (animalesDisp.size() == 0){
                        System.out.println("NO HAY ANIMALES PARA ADOPTAR EN ESTE MOMENTO.\nINTRODUZCA CUALQUIER CARACTER PARA SALIR.");
                        break;
                    }
                    animalesDisp.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });
                    idanimal = scanner.nextLine();
                    System.out.println("Quien sera el responsable del seguimiento de la adopcion?");
                    System.out.println("Visitadores para asignar");
                    System.out.println("\n/-----------------------------/");
                    List<UsuarioDTO> veterinarios_seguimiento = AutenticacionService.getInstance().getUsuariosVeterinarios();
                    veterinarios_seguimiento.forEach(veterinario -> {
                        System.out.println("Nombre -> " + veterinario.getNombre() + " " + veterinario.getApellido());
                        System.out.println("ID -> " + veterinario.getIdUsuario());
                    });
                    System.out.println("-----------------------------");
                    idVisitadorAAsignar = scanner.nextLine();
                    System.out.println("Cada cuanto seran las visitas al domicilio?");
                    int cadenciaVisitas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Cuantos dias de anticipacion quiere recibir el recordatorio de la visita?");
                    int diasRecordatorio = scanner.nextInt();
                    scanner.nextLine();
                    while (medioNotificacion != "SMS" || medioNotificacion != "WHATSAPP" || medioNotificacion != "MAIL" ){
                        System.out.println("Por que medio se notificara el recordatorio? SMS/WHATSAPP/EMAIL");
                        medioNotificacion = scanner.nextLine();
                        if (medioNotificacion != "SMS" || medioNotificacion != "WHATSAPP" || medioNotificacion != "MAIL" ){
                            System.out.println("OPCION INCORRECTA.\n");
                        }
                    }
                    AdopcionesController.getInstancia().CrearAdopcion(idadoptante,idanimal,cadenciaVisitas,medioNotificacion,diasRecordatorio,idVisitadorAAsignar);
                    inicioGestionarAdopciones();
                    System.out.println("LA ADOPCION SE CARGO CORRECTAMENTE.\n");
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
                    System.out.println("\nElige el animal por id");
                    List<Animal> animales = AnimalController.getInstancia().obtenerAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });
                    String idAnimal = scanner.nextLine();
                    AnimalDTO animal =  AnimalController.getInstancia().buscarAnimal(idAnimal).toDTO();
                    if (animal == null){
                        System.out.println("EL ANIMAL NO EXISTE");
                        break;
                    }
                    System.out.println("\nEn que formato deseas exportar la ficha medica?");
                    System.out.println("1. PDF");
                    System.out.println("2. Excel");
                    String opcion2 = "";
                    while (opcion2 != "1" || opcion2 != "2" ){
                        opcion2 = scanner.nextLine();
                        if (opcion2 != "1" || opcion2 != "2" ){
                            System.out.println("\nVALOR INCORRECTE");
                            System.out.println("\nINTRODUZCA ALGUN CARACTER PARA CONTINUAR");
                        }
                        switch (opcion2){
                            case "1":
                                ClinicaController.getInstancia().exportarFichaMedica(animal, "PDF");
                            case "2":
                                ClinicaController.getInstancia().exportarFichaMedica(animal, "EXCEL");
                        }
                    }
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

    private static void mostrarControles(){
        List<>
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
        System.out.println("\n Animales con alarmas activas");
        System.out.println("1. Elegir animal");
        System.out.println("2. Menu anterior\n");
    }

    private static void mostrarAnimalesConAlarmas(List<AnimalXAlarmaDTO> listaAnimal){
        System.out.println("\n Animales con alarmas activas");
        for (int i = 0; i < listaAnimal.size(); i++){
            int indice = i + 1;
            System.out.println(indice+") Animal "+ listaAnimal.get(i).getNombreAnimal() + " posee: "+ listaAnimal.get(i).getCantAlarmas() + " alarmas");
        }
        System.out.println("\n Ingrese el numero de animal para revisar la alerta");
        System.out.println("\n O ingrece cero para ir al Menu anterior");
    }

    private static void mostrarAlarmasConControles(List <AlarmaXControlDTO> listaAlarmas){
        System.out.println("\n Alarmas activas");
        for (int i = 0; i < listaAlarmas.size() ; i++){
            int indice = i +1;
            System.out.println(indice+") Fecha vencimiento "+ listaAlarmas.get(i).getFechaLimite());
            listaAlarmas.get(i).mostrarAcciones();
            System.out.println("\n --------- \n");
        }
        System.out.println("\n Ingrese el numero de alarma para cancelarla");
        System.out.println("\n O ingrece cero para ir al Menu anterior");
    }

    private static void atenderAlarmasXAnimal(Scanner scanner, String idAnimal){
        List<AlarmaXControlDTO> listaAlarmas = ClinicaController.getInstancia().traerAlarmasActivasDeSeguimiento(idAnimal);
        mostrarAlarmasConControles(listaAlarmas);
        String opcion = scanner.nextLine();

        switch (opcion){
            case "0":
                break;

            default:

                ClinicaController.getInstancia().cancelarAlarma(listaAlarmas.get(Integer.parseInt(opcion)-1).getIdAlarma(), idAnimal);
                break;
        }

        opcion = scanner.nextLine();


        menuVeterinario(scanner);

    }


    private static void atenderAlarmas(Scanner scanner){
        //inicioAtenderAlarmas();
        String idAnimalDTO;
        List<AnimalXAlarmaDTO> listaAnimales = new ArrayList<>();
        listaAnimales = ClinicaController.getInstancia().traerSeguimientosConAlarmasActivas();
        mostrarAnimalesConAlarmas(listaAnimales);

        String opcion = scanner.nextLine();

            switch (opcion) {
                case "0":

                    break;
                default:
                    idAnimalDTO = listaAnimales.get(Integer.parseInt(opcion) - 1).getIdAnimal();
                    atenderAlarmasXAnimal(scanner, idAnimalDTO);
                    break;
            }
            opcion = scanner.nextLine();


        menuVeterinario(scanner);
    }



    private static void inicioVeterinario() {
        int cantAlarmasActivas = ClinicaController.getInstancia().hayAlarmasActivas();

        System.out.println("\nQue desea hacer?");
        System.out.println("1. Gestionar Animales");
        System.out.println("2. Gestionar Adopciones");
        System.out.println("3. Gestionar Salud");
        System.out.println("4. Programar Alarmas");
        System.out.println("5. Atender Alarmas ("+cantAlarmasActivas+")");
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

        String estadoAnimal = "";
        String estadoAmbiente = "";
        String estadoLugar = "";
        String continuarVisitas = "";
        String opcion = scanner.nextLine();
        EstadoLimpiezaAmbiente estadoAmbienteDTO = null;
        EstadoLimpiezaAmbiente estadoLugarDTO = null;
        EstadoLimpiezaAmbiente estadoAnimalDTO = null;
        boolean continuarVisitasBoolean = false;
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    List<AnimalDTO> animalesConSeguimientoActivo = AdopcionesController.getInstancia().getAnimalesConSeguimientoActivo();
                    if (animalesConSeguimientoActivo.size() == 0){
                        System.out.println("\nNO HAY ANIMALES CON SEGUIMIENTOS ACTIVOS. \nINTRODUZCA CUALQUIER CARACTER PARA SALIR.");
                        break;
                    }

                    List<Animal> animales = AnimalController.getInstancia().obtenerAnimales();
                    System.out.println("/-----------------------------/");
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });
                    String idAnimalSeguido = scanner.nextLine();
                    VisitaDTO visitaDTO = AdopcionesController.getInstancia().getUltimaVisitaPorAnimal(idAnimalSeguido);
                    System.out.println("\nIngrese id del animal");
                    String nombre = scanner.nextLine();
                    System.out.println("\nIngrese alguna observacion sobre la visita");
                    String observacion = scanner.nextLine();
                    while (estadoAnimal != "BUENO" || estadoAnimal != "REGULAR " || estadoAnimal != "MALO"){
                        System.out.println("\nIngrese el estado general del animal BUENO/MALO/REGULAR");
                        estadoAnimal = scanner.nextLine();
                        if (estadoAnimal != "BUENO" || estadoAnimal != "REGULAR " || estadoAnimal != "MALO"){
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    if (estadoAnimal == "BUENO" ){
                        estadoAnimalDTO = EstadoLimpiezaAmbiente.BUENO;
                    }
                    if (estadoAnimal == "MALO" ){
                        estadoAnimalDTO = EstadoLimpiezaAmbiente.MALO;
                    }
                    if (estadoAnimal == "REGULAR" ){
                        estadoAnimalDTO = EstadoLimpiezaAmbiente.REGULAR;
                    }
                    while (estadoLugar != "BUENO" || estadoAnimal != "REGULAR " || estadoLugar != "MALO") {
                        System.out.println("\nValore la limpieza del lugar BUENO/MALO/REGULAR");
                        estadoLugar = scanner.nextLine();
                        if (estadoLugar != "BUENO" || estadoLugar != "REGULAR " || estadoLugar != "MALO"){
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    if (estadoLugar == "BUENO" ){
                        estadoLugarDTO = EstadoLimpiezaAmbiente.BUENO;
                    }
                    if (estadoLugar == "MALO" ){
                        estadoLugarDTO = EstadoLimpiezaAmbiente.MALO;
                    }
                    if (estadoLugar == "REGULAR" ){
                        estadoLugarDTO = EstadoLimpiezaAmbiente.REGULAR;
                    }
                    while (estadoAmbiente != "BUENO" || estadoAmbiente != "REGULAR " || estadoAmbiente != "MALO") {
                        System.out.println("\nValore el ambiente donde se encuentra el animal BUENO/MALO/REGULAR");
                        estadoAmbiente = scanner.nextLine();
                        if (estadoAmbiente != "BUENO" || estadoAmbiente != "REGULAR " || estadoAmbiente != "MALO"){
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    if (estadoAmbiente == "BUENO" ){
                        estadoAmbienteDTO = EstadoLimpiezaAmbiente.BUENO;
                    }
                    if (estadoAmbiente == "MALO" ){
                        estadoAmbienteDTO = EstadoLimpiezaAmbiente.MALO;
                    }
                    if (estadoAmbiente == "REGULAR" ){
                        estadoAmbienteDTO = EstadoLimpiezaAmbiente.REGULAR;
                    }
                    while (continuarVisitas != "S" || continuarVisitas != "N") {
                        System.out.println("\nValore el ambiente donde se encuentra el animal BUENO/MALO/REGULAR");
                        estadoAmbiente = scanner.nextLine();
                        if (continuarVisitas != "S" || continuarVisitas != "N"){
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    if (continuarVisitas == "S"){
                        continuarVisitasBoolean = true;
                    }
                    else{
                        continuarVisitasBoolean = false;
                    }
                    EncuestaDTO encuestaDTO = new EncuestaDTO();
                    encuestaDTO.setLimpieza(estadoLugarDTO);
                    encuestaDTO.setAmbiente(estadoAmbienteDTO);
                    encuestaDTO.setEstado(estadoAnimalDTO);
                    visitaDTO.setObservaciones(observacion);
                    visitaDTO.setEncuesta(encuestaDTO);
                    SeguimientoController.getInstancia().terminarVisita(visitaDTO,idAnimalSeguido, continuarVisitasBoolean);
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
