package dominio;

/**
 * Esta clase define el comportamiento de los jugadores y el como estos jugaran
 * Autor: Chicuazuque-Sierra
 * Version: 1.2 09/12/2023
 */
public abstract class Player {
    private int score;
    private String color;
    private String name = "NoName";
    private int[] piedras;

    /**
     * Constructor de la clase
     * 
     * @param name  nombre del jugador
     * @param color color del jugador
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
        this.piedras = new int[] { 0, 0 };
    }

    /**
     * Metodo que permite jugar una piedra en el tablero.
     * 
     * @param row        Fila donde se quiere jugar la piedra.
     * @param col        Columna donde se quiere jugar la piedra.
     * @param tipoPiedra Tipo de piedra que se quiere jugar.
     * @return Tablero con la piedra jugada.
     */
    public abstract Celda[][] jugar(int row, int col, String tipoPiedra);

    /**
     * Metodo que permite obtener el puntaje del jugador.
     * 
     * @return Puntaje del jugador.
     */
    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }

    /**
     * metodo Definir cantidad de piedras pesadas
     * 
     */
    public void setPiedrasPesadas(int a) {
        this.piedras[0] = a;
    }

    public int getPiedras(String tipoPiedra) {
        if (tipoPiedra.equals("Pesada")) {
            return this.piedras[0];
        } else {
            return this.piedras[1];
        }
    }

    /**
     * metodo obtener cantidad de piedras pesadas
     * 
     */
    public int getPiedrasPesadas() {
        return this.piedras[0];
    }

    /**
     * metodo Definir cantidad de piedras ligeras
     * 
     */
    public void setPiedrasLigeras(int a) {
        this.piedras[1] = a;
    }

    /**
     * metodo obtener cantidad de piedras ligeras
     * 
     */
    public int getPiedrasLigeras() {
        return this.piedras[1];
    }

    /**
     * metodo para restar piedras
     * 
     */
    public void ronda(String tipoPiedra) {
        if (tipoPiedra.equals("Piedra Pesada")) {
            piedras[0] -= 1;
        } else {
            piedras[1] -= 1;
        }
    }

    /**
     * Metodo que permite obtener el color del jugador.
     * 
     * @return Color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo que permite obtener el nombre del jugador.
     * 
     * @return Nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que permite establecer el color del jugador.
     * 
     * @param nombre Color del jugador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que permite agregar puntaje al jugador.
     * 
     * @param score Puntaje a agregar.
     */
    public void addScore(int score) {
        this.score += score;
    }
}