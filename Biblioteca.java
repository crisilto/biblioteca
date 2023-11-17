package biblioteca;

public class Biblioteca {
    private Libro[] libros;
    private int numLibros;

    public Biblioteca(int tamaño){
        libros = new Libro[tamaño];
        numLibros = 0;
    }
    //Añadir un libro al array libros[]
    public void añadirLibro (Libro libro){
        if(numLibros < libros.length){
            libros[numLibros] = libro;
            numLibros++;
        }else{
            System.out.println("No hay espacio para más libros.");
        }
    }
    //Eliminar un libro del array libros[]
    public void eliminarLibro (String isbn){
        for(int i = 0; i < numLibros; i++){
            if(libros[i].getIsbn().equalsIgnoreCase(isbn)){
                for(int j = i; j < numLibros - 1; j++){
                    libros[j] = libros[j+1];
                }
                numLibros--;
                return;
            }
        }
        System.out.println("Libro eliminado.");
    }
    //Buscar un libro en el array libros[]
    public void buscarLibro (String titulo){
        for(int i = 0; i < numLibros; i++){
            System.out.println("Comparando con: "+libros[i].getTitulo());
            if(libros[i].getTitulo().trim().equalsIgnoreCase(titulo.trim())){
                System.out.println("Libro encontrado: " + libros[i].getTitulo());
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
    //Mostrar todos los libros del array libros[] de dentro de la Biblioteca
    public void mostrarBiblioteca(){
        System.out.println("Libros disponibles en La Biblioteca: ");
        for(int i = 0; i < numLibros; i++){
            System.out.println(libros[i].getCodigo() +": "+libros[i].getTitulo());
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(5);

        Libro libro1 = new Libro("Harry Potter 1", "JK Rowling", "L001", "Fantasía", "Salamandra", 1999, "Español", 256,true);
        Libro libro2 = new Libro("Crepúsculo", "Stephanie Mayer", "L002", "Fantasía", "Alfaguara", 2006, "Español", 512, false);

        biblioteca.añadirLibro(libro1);
        biblioteca.mostrarBiblioteca();
        biblioteca.buscarLibro("Crepúsculo"); //No encontrado
        biblioteca.añadirLibro(libro2); //Lo añadimos
        biblioteca.mostrarBiblioteca();
        biblioteca.buscarLibro("Crepúsculo"); //Encontrado

    }
}
