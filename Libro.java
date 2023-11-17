package biblioteca;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Libro {
    private static int contadorCodigo = 0;
    private final int codigo; //Los códigos generados (gracias al contador static) serán finales
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
        //Validación en el dato añoPublicación
        if(añoPublicacion > 0 && añoPublicacion <= LocalDateTime.now().getYear()){
            this.añoPublicacion = añoPublicacion;
        }else{
            this.añoPublicacion = 0; //Año predeterminado si el año es menos a 0 o mayor al año actual
        }
        this.idioma = idioma;
        //Validación en el dato paginas
        if(paginas > 0){
            this.paginas = paginas;
        }else{
            this.paginas = 0; //Valor predeterminado si el número de páginas es inferior a 0
        }
        this.leido = leido;
    }
    public int getCodigo(){
        return codigo; //No tiene setter puesto que se trata de una constante
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIsbn() {
        return "El ISBN es " + isbn + "\n";
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setAñoPublicacion(int añoPublicacion){
        this.añoPublicacion = añoPublicacion;
    }
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    public int getPaginas(){
        return paginas;
    }
    public void setLeido(boolean leido){
        this.leido = leido;
    }
    public boolean getLeido(){
        return leido;
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
        info.append("Leído: ").append(leido ? "Sí" : "No").append("\n");
        info.append("Antigüedad: ").append(getAntiguedad());
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

    public void marcarComoLeido(boolean leido) {
        this.leido = leido;
    }

    public void actualizarInformacion(String nuevoTitulo, String nuevoAutor, String nuevoIsbn, String nuevoGenero, String nuevaEditorial, int nuevoAñoPublicacion, String nuevoIdioma, int nuevasPaginas){
        titulo = nuevoTitulo;
        autor = nuevoAutor;
        isbn = nuevoIsbn;
        genero = nuevoGenero;
        editorial =nuevaEditorial;
        if(nuevoAñoPublicacion > 0 && nuevoAñoPublicacion <= LocalDateTime.now().getYear()){
            añoPublicacion = nuevoAñoPublicacion;
        }else{
            añoPublicacion = 0;
        }
        idioma = nuevoIdioma;
        if(nuevasPaginas > 0){
            paginas = nuevasPaginas;
        }else{
            paginas = 0;
        }
        //Para el booleano leido ya tenemos el metodo marcarComoLeido() o el método marcarComoNoLeido()
    }
}
