package biblioteca;

import java.time.LocalDateTime;

public class Libro {
    private static int contadorCodigo = 0;
    private int codigo;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private String editorial;
    private int añoPublicacion;
    private String idioma;
    private int paginas;
    private boolean leido;

    //Constructor base con valores por defecto
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, "Género no especificado",
                "Editorial no proporcionada", 0,
                "Idioma no especificado", 0, false);
    }

    //Otro constructor base con algunos parámetros más y el resto de valores por defecto
    public Libro(String titulo, String autor, String isbn, String genero) {
        this(titulo, autor, isbn, genero,
                "Editorial no proporcionada", 0,
                "Idioma no especificado", 0, false);
    }

    //Constructor completo
    public Libro(String titulo, String autor, String isbn, String genero, String editorial, int añoPublicacion, String idioma, int paginas, boolean leido) {
        contadorCodigo++;
        this.codigo = contadorCodigo;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.editorial = editorial;
        this.añoPublicacion = añoPublicacion;
        this.idioma = idioma;
        this.paginas = paginas;
        this.leido = leido;
    }
    public int getCodigo(){
        return codigo;
    }

    //Permitir establecer título al recibir un parámetro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Devolver un string con el valor del título
    public String getTitulo() {
        return titulo + "\n";
    }

    //Permitir establecer autor al recibir un parámetro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Devolver un string con el valor del autor
    public String getAutor() {
        return "El autor es " + autor + "\n";
    }

    //Permitir establecer isbn al recibir un parámetro
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Devolver un string con el valor del isbn
    public String getIsbn() {
        return "El ISBN es " + isbn + "\n";
    }

    //Permitir establecer genero al recibir un parámetro
    public void setGenero(String genero) {
        this.genero = genero;
    }

    //Devolver un string con el valor del genero
    public String getGenero() {
        return "El género es " + genero + "\n";
    }

    //Getters de las propiedades/los atributos ya inicializados
    public String getEditorial() {
        return "La editorial es " + editorial + "\n";
    }

    public String getAñoPublicacion() {
        return "El año de publicación es " + añoPublicacion + "\n";
    }

    public String getIdioma() {
        return "El idioma es " + idioma + "\n";
    }
    public String getPaginas(){
        return "Tiene "+paginas+" páginas";
    }
    public String getLeido(){
        return leido ? "Si" : "No";
    }

    //Mostrar información del libro
    public String getInformacion(){
        StringBuilder info = new StringBuilder();
        info.append("Código: ").append(codigo).append("\n");
        info.append("Título: ").append(titulo).append("\n");
        info.append("Autor: ").append(autor).append("\n");
        info.append("ISBN: ").append(isbn.equals("ISBN no proporcionado") ? "No proporcionado" : isbn).append("\n");
        info.append("Género: ").append(genero.equals("Género no especificado") ? "No proporcionado" : genero).append("\n");
        info.append("Editorial: ").append(editorial.equals("Editorial no proporcionada") ? "No proporcionada" : editorial).append("\n");
        info.append("Año de Publicación: ").append(añoPublicacion > 0 ? añoPublicacion : "No proporcionado").append("\n");
        info.append("Idioma: ").append(idioma.equals("Idioma no especificado") ? "No proporcionado" : idioma).append("\n");
        info.append("Páginas: ").append(paginas > 0 ? getPaginas() : "No proporcionado").append("\n");
        info.append("Leído: ").append(getLeido()).append("\n");
        info.append("Antigüedad: ").append(getAntiguedad()).append("\n");
        return info.toString();
    }

    //Calcular antiguedad del libro
    public String getAntiguedad() {
        LocalDateTime fecha = LocalDateTime.now();
        int añoActual = fecha.getYear();
        if (añoPublicacion == 0) {
            return "No es posible calcular la antigüedad";
        } else {
            int antiguedad = añoActual - añoPublicacion;
            return "El libro tiene una antigüedad de " + antiguedad + " años.\n";
        }
    }

    public void marcarComoLeido() {
        this.leido = true;
    }

    public void marcarComoNoLeido(){
        this.leido = false;
    }

    //Practicando el method overloading:
    //Actualizar únicamente el título
    public void actualizarDatos(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
    }
    //Actualizar tanto título como autor
    public void actualizarDatos(String nuevoTitulo, String nuevoAutor) {
        this.titulo = nuevoTitulo;
        this.autor = nuevoAutor;
    }
    //Actualizar título, autor, número de páginas
    public void actualizarDatos(String nuevoTitulo, String nuevoAutor, int nuevasPaginas) {
        this.titulo = nuevoTitulo;
        this.autor = nuevoAutor;
        this.paginas = nuevasPaginas;
    }
}
