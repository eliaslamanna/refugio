package src;

import src.Controller.*;
import src.DTO.*;
import src.Enum.*;

import java.util.*;

public class Main {

    private static UsuarioDTO usuarioAuntenticado;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenido al refugio de animales\n");
        inicio(scanner);

        System.out.println("Finalizo el programa");
    }
    static boolean seCargaronLosDatos = false;

    private static void inicio(Scanner scanner) {
        if (!seCargaronLosDatos) {
            List<AnimalDTO> animalesDatos = new ArrayList<>();

            // Definir animales de pruebas.
            AnimalDTO animal1 = new AnimalDTO("Bobby", 2, 5.6, 0.6, "Sin condiciones medicas.", TipoAnimal.SALVAJE);
            AnimalDTO animal2 = new AnimalDTO("Max", 3, 7.2, 0.8, "Condicion leve.", TipoAnimal.DOMESTICO);
            AnimalDTO animal3 = new AnimalDTO("Lola", 1, 4.5, 0.5, "Sin condiciones medicas.", TipoAnimal.DOMESTICO);
            AnimalDTO animal4 = new AnimalDTO("Mora", 7, 8.8, 0.9, "Problemas respiratorios.", TipoAnimal.DOMESTICO);
            animalesDatos.add(animal1);
            animalesDatos.add(animal2);
            animalesDatos.add(animal3);
            animalesDatos.add(animal4);
            // Ingresar animales.
            for (AnimalDTO animal :
                    animalesDatos) {
                AnimalController.getInstancia().ingresarAnimal(animal, UsuarioController.getInstancia().getUsuarioPorId("veterinario01"));
            }
            // --------------------------------------------------------------------------------------------------------------------------------------------------

            List<AdoptanteDTO> adoptantesDatos = new ArrayList<>();

            // Definir adoptantes de pruebas.
            AdoptanteDTO adoptante1 = new AdoptanteDTO("Carlos", "Perez", "Soltero", "Calle Falsa 123", "11 4444-5555", "Desempleado", 2, "Se siente solo", "Perros");
            AdoptanteDTO adoptante2 = new AdoptanteDTO("Maria", "Hernandez", "Casada", "Calle Falsa 321", "11 1234-5678", "Maestra", 0, "Sin motivo", "Gatos");
            adoptantesDatos.add(adoptante1);
            adoptantesDatos.add(adoptante2);
            for (AdoptanteDTO adoptante :
                    adoptantesDatos) {
                AdoptanteController.getInstancia().altaAdoptante(adoptante);
            }
            // --------------------------------------------------------------------------------------------------------------------------------------------------
            //Seguimiento
            SeguimientoDTO seguimiento1 = new SeguimientoDTO();
            seguimiento1.setCadenciaVisita(15);
            seguimiento1.setContinuarVisitas(true);
            seguimiento1.setResponsable(UsuarioController.getInstancia().autenticarUsuario(
                    new UsuarioDTO("visitador01",null,null,null,null,null
                            ,null,false)));
            seguimiento1.setMedioNotificacion(MedioRecordatorio.WHATSAPP);
            seguimiento1.setDiasRecordatorio(16);

            AnimalDTO animalParaAdopcion = AnimalController.getInstancia().getRandomAnimal();
            // Adopcion
            AdopcionesController.getInstancia().crearAdopcion(AdoptanteController.getInstancia().getRandomAdoptante(), animalParaAdopcion, seguimiento1);

            seCargaronLosDatos = true;

        }



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
                    usuarioAuntenticado = new UsuarioDTO(scanner.nextLine(),null,null,null,null
                            ,null,null,false);
                    usuarioAuntenticado = UsuarioController.getInstancia().autenticarUsuario(usuarioAuntenticado);

                    if (usuarioAuntenticado.isAutenticado()) {
                        switch (usuarioAuntenticado.getTipo()) {
                            case VETERINARIO:
                                menuVeterinario(scanner);
                                break;
                            case VISITADOR:
                                menuVisitador(scanner);
                                break;
                        }
                    }
                    break;
                case "2":
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
        System.out.println("2. Buscar animal por ID");
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
                    System.out.println("\nIngrese el ID del animal");
                    String idAnimal = scanner.nextLine();
                    AnimalDTO animalBuscado = AnimalController.getInstancia().getAnimalPorId(idAnimal);
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
                    else {
                        System.out.println("\nNo se encontro un animal con ese id.");
                    }
                    inicioGestionarAnimalesVeterinario();
                    break;
                case "3":
                    System.out.println("\nLista de animales");
                    System.out.println("/-----------------------------/");
                    List<AnimalDTO> animales = AnimalController.getInstancia().getAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("Tipo -> " + animal.getTipoAnimal());
                        System.out.println("Id -> " + animal.getId());
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

    private static void gestionarAdopciones(Scanner scanner) {
        inicioGestionarAdopciones();
        String respuesta;
        String medioNotificacion = "";

        List<AdoptanteDTO> adoptantesDisponibles;

        AdoptanteDTO adoptanteDTO = null;
        UsuarioDTO visitadorDTO = null;
        AnimalDTO mascotaDTO = null;
        SeguimientoDTO seguimientoDTO = null;

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    System.out.println("Existe el adoptante en el sistema? S/N");
                    respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {

                        adoptantesDisponibles = AdoptanteController.getInstancia().getAdoptantesDisponibles();

                        if (adoptantesDisponibles.size() == 0) {
                            System.out.println("NO HAY ADOPTANTES DISPONIBLES EN EL SISTEMA.\nINTRODUZCA CUALQUIER CARACTER PARA CONTINUAR.");
                            break;
                        }
                        System.out.println("Lista de adoptantes disponibles");
                        System.out.println("-----------------------------");
                        adoptantesDisponibles.forEach(adoptante -> {
                            System.out.println("Nombre -> " + adoptante.getNombre());
                            System.out.println("ID -> " + adoptante.getId());
                            System.out.println("                              ");
                        });
                        System.out.println("-----------------------------");
                        System.out.println("Ingrese el Id a elegir como adoptante");

                        adoptanteDTO = AdoptanteController.getInstancia().getAdoptantePorId(scanner.nextLine());

                        if(adoptanteDTO == null) {
                            System.out.println("\nNo existe el aninaml con ese id");
                            break;
                        }
                    } else {
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

                        adoptanteDTO = AdoptanteController.getInstancia().altaAdoptante(
                                new AdoptanteDTO(nombre, apellido, estadoCivil, direccion, telefono,
                                        ocupacion, otrasMascotas, motivoAdopcion, tipoAnimalInteresado));

                    }

                    System.out.println("Que animal desea adoptar?");
                    List<AnimalDTO> animalesDisp = AdopcionesController.getInstancia().getMascotasDisponiblesParaAdopcion();
                    if (animalesDisp.size() == 0) {
                        System.out.println("NO HAY ANIMALES PARA ADOPTAR EN ESTE MOMENTO.\nINTRODUZCA CUALQUIER CARACTER PARA SALIR.");
                        break;
                    }
                    animalesDisp.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });

                    mascotaDTO = AnimalController.getInstancia().getAnimalPorId(scanner.nextLine());

                    if(mascotaDTO == null) {
                        System.out.println("\nEl animal con el el id no existe.");
                        break;
                    }

                    System.out.println("Quien sera el responsable del seguimiento de la adopcion?");
                    System.out.println("Visitadores para asignar");
                    System.out.println("\n/-----------------------------/");
                    List<UsuarioDTO> veterinarios_seguimiento = UsuarioController.getInstancia().getUsuariosVeterinarios();
                    veterinarios_seguimiento.forEach(veterinario -> {
                        System.out.println("Nombre -> " + veterinario.getNombre() + " " + veterinario.getApellido());
                        System.out.println("ID -> " + veterinario.getIdUsuario());
                    });
                    System.out.println("-----------------------------");

                    visitadorDTO = UsuarioController.getInstancia().getUsuarioPorId(scanner.nextLine());

                    if(visitadorDTO == null) {
                        System.out.println("\nEl visitador con ese id no existe.");
                        break;
                    }

                    System.out.println("Cada cuanto seran las visitas al domicilio?");
                    int cadenciaVisitas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Cuantos dias de anticipacion quiere recibir el recordatorio de la visita?");
                    int diasRecordatorio = scanner.nextInt();
                    scanner.nextLine();
                    while (!medioNotificacion.equals(MedioRecordatorio.SMS.toString())
                            && !medioNotificacion.equals(MedioRecordatorio.WHATSAPP.toString())
                            && !medioNotificacion.equals(MedioRecordatorio.EMAIL.toString())) {
                        System.out.println("Por qué medio se notificará el recordatorio? SMS/WHATSAPP/EMAIL");
                        medioNotificacion = scanner.nextLine();
                        if (!medioNotificacion.equals(MedioRecordatorio.SMS.toString())
                                && !medioNotificacion.equals(MedioRecordatorio.WHATSAPP.toString())
                                && !medioNotificacion.equals(MedioRecordatorio.EMAIL.toString())) {
                            System.out.println("OPCIÓN INCORRECTA.\n");
                        }
                    }

                    seguimientoDTO = new SeguimientoDTO();
                    seguimientoDTO.setResponsable(visitadorDTO);
                    seguimientoDTO.setCadenciaVisita(cadenciaVisitas);
                    seguimientoDTO.setDiasRecordatorio(diasRecordatorio);
                    seguimientoDTO.setMedioNotificacion(MedioRecordatorio.valueOf(medioNotificacion));

                    AdopcionesController.getInstancia().crearAdopcion(adoptanteDTO, mascotaDTO, seguimientoDTO);

                    inicioGestionarAdopciones();
                    System.out.println("LA ADOPCION SE CARGO CORRECTAMENTE.\n");
                    break;
                default:
                    inicioGestionarAdopciones();
                    break;
            }
            gestionarAdopciones(scanner);
            //opcion = scanner.nextLine();
        }
        menuVeterinario(scanner);
    }

    private static void inicioGestionarSalud() {
        System.out.println("\nQue desea hacer?");
        System.out.println("1. Exportar Ficha medica");
        System.out.println("2. Menu anterior\n");
    }

    private static void gestionarSalud(Scanner scanner) {
        inicioGestionarSalud();

        String opcion = scanner.nextLine();
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    System.out.println("\nElige el animal por id");
                    List<AnimalDTO> animales = AnimalController.getInstancia().getAnimales();
                    animales.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });
                    String idAnimal = scanner.nextLine();
                    AnimalDTO animal = AnimalController.getInstancia().getAnimalPorId(idAnimal);
                    if (animal == null) {
                        System.out.println("EL ANIMAL NO EXISTE");
                        break;
                    }
                    System.out.println("\nEn que formato deseas exportar la ficha medica?");
                    System.out.println("1. PDF");
                    System.out.println("2. Excel");
                    String opcion2 = "";
                    while (!opcion2.equals("1") && !opcion2.equals("2")) {
                        opcion2 = scanner.nextLine();
                        if (!opcion2.equals("1") && !opcion2.equals("2")) {
                            System.out.println("\nVALOR INCORRECTE");
                            System.out.println("\nINTRODUZCA ALGUN CARACTER PARA CONTINUAR");
                            break;
                        }
                        switch (opcion2) {
                            case "1":
                                ClinicaController.getInstancia().exportarFichaMedica(animal, "PDF");
                                break;
                            case "2":
                                ClinicaController.getInstancia().exportarFichaMedica(animal, "EXCEL");
                                break;
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

    private static void programarAlarmas(Scanner scanner) {
        inicioProgramarAlarmas();
        List<AnimalDTO> animales;
        String tipoDeControl = "";
        List<Accion> controlesDisponibles;
        List<Accion> controlesAProgramar = new ArrayList<>();
        String controlElegido = "";
        List<Accion> tratamientosDisponibles;
        List<Accion> tratamientosAProgramar = new ArrayList<>();
        String tratamientoElegido = "";
        String accionElegida = "";

        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("\nElige el animal por id");
                animales = AnimalController.getInstancia().getAnimales();
                animales.forEach(animal -> {
                    System.out.println("Nombre -> " + animal.getNombre());
                    System.out.println("ID -> " + animal.getId());
                    System.out.println("-----------------------------");
                });
                String idAnimal = scanner.nextLine();


                System.out.println("\nIngrese C/T/S para crear un Control ó un Tratamiento ó Salir");
                tipoDeControl = scanner.nextLine();

                switch (tipoDeControl) {
                    case "c":
                    case "C":
                        controlesDisponibles = ClinicaController.getInstancia().getAccionesDeControlDeSalud();
                        while (controlesDisponibles.stream().count() > 0
                                && !accionElegida.equalsIgnoreCase("s")) {
                            System.out.println("\nIngrese la accion disponible ó S para Salir");
                            System.out.println("-----------------------------");
                            controlesDisponibles.forEach(accion -> {
                                System.out.println("Accion -> " + accion.toString());
                                System.out.println("-----------------------------");
                            });
                            accionElegida = scanner.nextLine();

                            if (accionElegida.equals(Accion.CONTROLAR_NUTRICION.toString())
                                    || accionElegida.equals(Accion.CONTROLAR_PARASITOS.toString())
                                    || accionElegida.equals(Accion.CONTROLAR_PESO.toString())
                                    || accionElegida.equals(Accion.CONTROLAR_TAMANIO.toString())) {
                                controlesAProgramar.add(Accion.valueOf(accionElegida));
                                controlesDisponibles.remove(Accion.valueOf(accionElegida));
                            }else {
                                System.out.println("\nOpcion incorrecta, vuelva a elegir");
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    case "t":
                    case "T":
                        tratamientosDisponibles = ClinicaController.getInstancia().getAccionesDeTratamientoMedico();
                        while (tratamientosDisponibles.stream().count() > 0
                                && !accionElegida.equalsIgnoreCase("s")) {
                            System.out.println("\nIngrese la accion disponible ó S para Salir");
                            System.out.println("-----------------------------");
                            tratamientosDisponibles.forEach(accion -> {
                                System.out.println("Accion -> " + accion.toString());
                                System.out.println("-----------------------------");
                            });
                            accionElegida = scanner.nextLine();

                            if (accionElegida.equals(Accion.COLOCAR_ANTIPARASITARIO.toString())
                                    || accionElegida.equals(Accion.COLOCAR_VACUNA.toString())) {
                                tratamientosAProgramar.add(Accion.valueOf(accionElegida));
                                tratamientosDisponibles.remove(Accion.valueOf(accionElegida));
                            }else {
                                System.out.println("\nOpcion incorrecta, vuelva a elegir");
                                System.out.println("-----------------------------");
                            }
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                inicioProgramarAlarmas();
                break;
        }
        menuVeterinario(scanner);
    }

    /*
    private static void mostrarAnimalesConAlarmas(List<AnimalXAlarmaDTO> listaAnimal) {
        System.out.println("\n Animales con alarmas activas");
        for (int i = 0; i < listaAnimal.size(); i++) {
            int indice = i + 1;
            System.out.println(indice + ") Animal " + listaAnimal.get(i).getNombreAnimal() + " posee: " + listaAnimal.get(i).getCantAlarmas() + " alarmas");
        }
        System.out.println("\n Ingrese el numero de animal para revisar la alerta");
        System.out.println("\n O ingrece cero para ir al Menu anterior");
    }

    private static void mostrarAlarmasConControles(List<AlarmaXControlDTO> listaAlarmas) {
        System.out.println("\n Alarmas activas");
        for (int i = 0; i < listaAlarmas.size(); i++) {
            int indice = i + 1;
            System.out.println(indice + ") Fecha vencimiento " + listaAlarmas.get(i).getFechaLimite());
            listaAlarmas.get(i).mostrarAcciones();
            System.out.println("\n --------- \n");
        }
        System.out.println("\n Ingrese el numero de alarma para cancelarla");
        System.out.println("\n O ingrece cero para ir al Menu anterior");
    }

    private static void atenderAlarmasXAnimal(Scanner scanner, String idAnimal) {
        List<AlarmaXControlDTO> listaAlarmas = AlarmaController.getInstancia().traerAlarmasActivasDeSeguimiento(idAnimal);
        mostrarAlarmasConControles(listaAlarmas);
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "0":
                break;

            default:

                //AlarmaController.getInstancia().atenderAlarma(listaAlarmas.get(Integer.parseInt(opcion) - 1).getIdAlarma(), idAnimal);
                break;
        }

        opcion = scanner.nextLine();


        menuVeterinario(scanner);

    }

    private static void atenderAlarmas(Scanner scanner) {
        //inicioAtenderAlarmas();
        String idAnimalDTO;
        List<AnimalXAlarmaDTO> listaAnimales = new ArrayList<>();
        listaAnimales = AlarmaController.getInstancia().traerSeguimientosConAlarmasActivas();
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

     */

    private static void inicioAtenderAlarmas() {
        System.out.println("\n Animales con alarmas activas");
        System.out.println("1. Elegir animal");
        System.out.println("2. Menu anterior\n");
    }

    private static void atenderAlarmas(Scanner scanner) {
        //inicioAtenderAlarmas();
        menuVeterinario(scanner);
    }

    private static void inicioVeterinario() {
        int cantAlarmasActivas = AlarmaController.getInstancia().hayAlarmasActivas();

        System.out.println("\nQue desea hacer?");
        System.out.println("1. Gestionar Animales");
        System.out.println("2. Gestionar Adopciones");
        System.out.println("3. Gestionar Salud");
        System.out.println("4. Programar Alarmas");
        System.out.println("5. Atender Alarmas (" + cantAlarmasActivas + ")");
        System.out.println("6. Salir\n");
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
        AdopcionesController.getInstancia().enviarRecordatorio(usuarioAuntenticado.getIdUsuario());
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
                    AnimalDTO animalBuscado = AnimalController.getInstancia().getAnimalPorId(nombreAnimal);
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
                    List<AnimalDTO> animales = AnimalController.getInstancia().getAnimales();
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

    private static void gestionarVisitas(Scanner scanner) {
        inicioGestionarVisitas();

        String estadoAnimal = "";
        String estadoAmbiente = "";
        String estadoLugar = "";
        String continuarVisitas = "";
        String opcion = scanner.nextLine();
        EstadoLimpiezaAmbiente estadoAmbienteDTO = null;
        EstadoLimpiezaAmbiente estadoLugarDTO = null;
        EstadoLimpiezaAmbiente estadoAnimalDTO = null;
        AnimalDTO mascotaDTO = null;

        boolean continuarVisitasBoolean = false;
        while (!opcion.equals("2")) {
            switch (opcion) {
                case "1":
                    List<AnimalDTO> animalesConSeguimientoActivo = AdopcionesController.getInstancia().getAnimalesConSeguimientoActivo();
                    if (animalesConSeguimientoActivo.size() == 0) {
                        System.out.println("\nNO HAY ANIMALES CON SEGUIMIENTOS ACTIVOS. \nINTRODUZCA CUALQUIER CARACTER PARA SALIR.");
                        break;
                    }

                    System.out.println("/-----------------------------/");
                    animalesConSeguimientoActivo.forEach(animal -> {
                        System.out.println("Nombre -> " + animal.getNombre());
                        System.out.println("ID -> " + animal.getId());
                        System.out.println("-----------------------------");
                    });
                    System.out.println("\nIngrese id del animal");
                    String idAnimalSeguido = scanner.nextLine();
                    VisitaDTO visitaDTO = AdopcionesController.getInstancia().getUltimaVisitaPorAnimal(idAnimalSeguido);
                    System.out.println("\nIngrese alguna observacion sobre la visita");
                    String observacion = scanner.nextLine();
                    while (!estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                            && !estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                            && !estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                        System.out.println("\nIngrese el estado general del animal BUENO/MALO/REGULAR");
                        estadoAnimal = scanner.nextLine();
                        if (!estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                                && !estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                                && !estadoAnimal.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    estadoAnimalDTO = EstadoLimpiezaAmbiente.valueOf(estadoAnimal.toUpperCase());

                    while (!estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                            && !estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                            && !estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                        System.out.println("\nValore la limpieza del lugar BUENO/MALO/REGULAR");
                        estadoLugar = scanner.nextLine();
                        if (!estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                                && !estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                                && !estadoLugar.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    estadoLugarDTO = EstadoLimpiezaAmbiente.valueOf(estadoLugar.toUpperCase());

                    while (!estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                            && !estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                            && !estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                        System.out.println("\nValore el ambiente donde se encuentra el animal BUENO/MALO/REGULAR");
                        estadoAmbiente = scanner.nextLine();
                        if (!estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.BUENO.toString())
                                && !estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.REGULAR.toString())
                                && !estadoAmbiente.equalsIgnoreCase(EstadoLimpiezaAmbiente.MALO.toString())) {
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    estadoAmbienteDTO = EstadoLimpiezaAmbiente.valueOf(estadoAmbiente.toUpperCase());

                    while (!continuarVisitas.equalsIgnoreCase("S")
                            && !continuarVisitas.equalsIgnoreCase("N")) {
                        System.out.println("\nEs necesario continuar con el seguimiento? S/N");
                        continuarVisitas = scanner.nextLine();
                        if (!continuarVisitas.equalsIgnoreCase("S")
                                && !continuarVisitas.equalsIgnoreCase("N")) {
                            System.out.println("Ingrese una opcion valida.\n");
                        }
                    }
                    if (continuarVisitas.equalsIgnoreCase("S")) {
                        continuarVisitasBoolean = true;
                    } else {
                        continuarVisitasBoolean = false;
                    }
                    EncuestaDTO encuestaDTO = new EncuestaDTO();
                    encuestaDTO.setLimpieza(estadoLugarDTO);
                    encuestaDTO.setAmbiente(estadoAmbienteDTO);
                    encuestaDTO.setEstado(estadoAnimalDTO);
                    visitaDTO.setObservaciones(observacion);
                    visitaDTO.setEncuesta(encuestaDTO);
                    visitaDTO.setTerminada(true);

                    mascotaDTO = AnimalController.getInstancia().getAnimalPorId(idAnimalSeguido);

                    if(mascotaDTO == null) {
                        System.out.println("\nEl animal con el id no existe.");
                        break;
                    }

                    AdopcionesController.getInstancia().registrarVisita(visitaDTO, mascotaDTO, continuarVisitasBoolean);
                    estadoAnimal = "";
                    estadoAmbiente = "";
                    estadoLugar = "";
                    continuarVisitas = "";
                    estadoAmbienteDTO = null;
                    estadoLugarDTO = null;
                    estadoAnimalDTO = null;
                    mascotaDTO = null;
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