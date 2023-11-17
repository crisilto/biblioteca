package biblioteca;

import java.util.Scanner;

public class Biblioteca {
    private Libro[] libros;
    private int numLibros;

    public Biblioteca(int tamaño) {
        libros = new Libro[tamaño];
        numLibros = 0;
    }

    public void crearLibro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el título del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Ingrese el ISBN del libro: ");
        String isbn = sc.nextLine();
        System.out.println("Ingrese el género del libro: ");
        String genero = sc.nextLine();
        System.out.println("Ingrese la editorial del libro: ");
        String editorial = sc.nextLine();
        System.out.println("Ingrese el año de publicación del libro: ");
        int añoPublicacion = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el idioma del libro: ");
        String idioma = sc.nextLine();
        System.out.println("Ingrese las páginas del libro: ");
        int paginas = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Ha leído el libro?: ");
        boolean leido = sc.nextBoolean();

        Libro nuevoLibro = new Libro(titulo, autor, isbn, genero, editorial, añoPublicacion, idioma, paginas, leido);
        añadirLibro(nuevoLibro);

        System.out.println("Libro creado y añadido a la Biblioteca con éxito.");
    }

    //Añadir un libro al array libros[]
    public void añadirLibro(Libro libro) {
        if (numLibros < libros.length) {
            libros[numLibros] = libro;
            numLibros++;
        } else {
            System.out.println("No hay espacio para más libros.");
        }
    }

    //Eliminar un libro del array libros[]
    public void eliminarLibro(String titulo) {
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                for (int j = i; j < numLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                numLibros--;
                return;
            }
        }
    }

    //Buscar un libro en el array libros[]
    public void buscarLibro(String titulo) {
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                System.out.println("Libro encontrado: " + libros[i].getTitulo());
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    //Mostrar todos los libros del array libros[] de dentro de la Biblioteca
    public void mostrarBiblioteca() {
        System.out.println("Libros disponibles en La Biblioteca: ");
        for (int i = 0; i < numLibros; i++) {
            System.out.println(libros[i].getCodigo() + ": " + libros[i].getTitulo());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca(5);

        Libro libro1 = new Libro("Harry Potter 1", "JK Rowling", "L001", "Fantasía", "Salamandra", 1999, "Español", 256, true);
        Libro libro2 = new Libro("Crepúsculo", "Stephanie Mayer", "L002", "Fantasía", "Alfaguara", 2006, "Español", 512, false);
        biblioteca.añadirLibro(libro1);
        biblioteca.añadirLibro(libro2);

        boolean salir = false; //Booleano para controlar menú
        System.out.println("Bienvenido/a a la Biblioteca.\nSeleccione una opción (7 para salir): ");
        while (!salir) {
            System.out.println(
                    "1. Mostrar Biblioteca" +
                            "\n2. Buscar Libro" +
                            "\n3. Añadir Libro" +
                            "\n4. Eliminar libro" +
                            "\n5. Marcar libro como leído" +
                            "\n6. Mostrar información de un libro" +
                            "\n7. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("---------------------------");
                    biblioteca.mostrarBiblioteca();
                    sc.nextLine();
                    System.out.println("---------------------------");
                    break;
                case 2:
                    System.out.println("---------------------------");
                    System.out.println("Introduce el nombre del libro que desea bucar:");
                    sc.nextLine();
                    String nombreBuscar = sc.nextLine();
                    biblioteca.buscarLibro(nombreBuscar);
                    System.out.println("---------------------------");
                    break;
                case 3:
                    System.out.println("---------------------------");
                    biblioteca.crearLibro();
                    sc.nextLine();
                    System.out.println("---------------------------");
                    break;
                case 4:
                    System.out.println("---------------------------");
                    System.out.println("Introduce el nombre del libro que desea eliminar:");
                    sc.nextLine();
                    String nombreEliminar = sc.nextLine();
                    biblioteca.eliminarLibro(nombreEliminar);
                    System.out.println("---------------------------");
                    break;
                case 5:
                    System.out.println("---------------------------");
                    System.out.println("¿Qué libro desea marcar como leído? Indique el título.");
                    sc.nextLine();
                    String nombreLeido = sc.nextLine();
                    boolean libroEncontrado = false;
                    for (int i = 0; i < biblioteca.numLibros; i++) {
                        Libro libro = biblioteca.libros[i];
                        if (libro.getTitulo().equalsIgnoreCase(nombreLeido)) {
                            libro.marcarComoLeido(true);
                            libroEncontrado = true;
                            System.out.println("Libro marcado como leído correctamente.");
                            break;
                        }
                    }
                    if (!libroEncontrado) {
                        System.out.println("Libro no encontrado, verifique el título.");
                    }
                    System.out.println("---------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------");
                    System.out.println("¿De qué libro desea ver su información? Indique el título.");
                    sc.nextLine();
                    String nombreInformacion = sc.nextLine();
                    System.out.println("---------------------------");
                    for(int i = 0; i < biblioteca.numLibros; i++){
                        Libro libro = biblioteca.libros[i];
                        if(libro.getTitulo().equalsIgnoreCase(nombreInformacion)){
                            System.out.print(libro.getInformacion());
                            break;
                        }
                    }
                    System.out.println("---------------------------");
                    break;
                case 7:
                    System.out.println("---------------------------");
                    System.out.println("Hasta luego.");
                    salir = true;
                    System.out.println("---------------------------");
                    break;
                default:
                    System.out.println("Introduce un número válido entre el 1 y el 6.");
                    break;
            }
        }
        sc.close();
    }
}
