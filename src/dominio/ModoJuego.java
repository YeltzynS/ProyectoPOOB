package dominio;

/**
 * Esta clase es la encargada de definir el modo de juego.
 * Autor: Chicuazuque-Sierra
 * Version: 1.2 09/12/2023
 */
public abstract class ModoJuego {
    protected static String modo;

    /**
     * Constructor de la clase.
     */
    public ModoJuego() {

    }

    /**
     * Este metodo retorna el modo de juego.
     * 
     * @return Modo de juego.
     */
    public String getModo() {
        return modo;
    }

    /**
     * Este metodo se encarga de jugar una piedra en el tablero.
     * 
     * @param row       Fila donde se quiere jugar la piedra.
     * @param col       Columna donde se quiere jugar la piedra.
     * @param tipoCelda Tipo de celda que se quiere jugar.
     * @return Tablero con la piedra jugada.
     */
    public abstract Celda[][] jugar(int row, int col, String tipoCelda);

    /**
     * Este metodo se encarga de poner una piedra en el tablero.
     * 
     * @param row        Fila donde se quiere jugar la piedra.
     * @param col        Columna donde se quiere jugar la piedra.
     * @param tipoPiedra Tipo de piedra que se quiere jugar.
     * @return Tablero con la piedra jugada.
     */
    public Celda[][] ponerPiedra(int row, int col, String tipoPiedra) {
        if (validarPosicion(row, col)) {

            Gomoku.setCelda(row, col, new Ocupada());

            // Obtén la celda actual y la piedra asociada
            Celda celda = Gomoku.getCelda(row, col);
            Piedra piedraActual = celda.getPiedra();

            // Verifica si la piedra actual es una instancia de PiedraVacia
            if (piedraActual instanceof PiedraVacia) {
                // Si es PiedraVacia, crea una nueva instancia de Piedra y asígnale el nombre
                Piedra nuevaPiedra;
                if (tipoPiedra.equals("PiedraPesada")) {
                    nuevaPiedra = new PiedraPesada(row, col);
                } else {
                    // Agrega condiciones para otros tipos de piedra si es necesario
                    nuevaPiedra = new PiedraLigera(row, col);
                }
                nuevaPiedra.setName(Gomoku.getTurno());

                // Asigna la nueva piedra a la celda
                celda.setPiedra(nuevaPiedra);
            } else {
                Gomoku.getInstance().setMensaje("Celda ocupada");
                Gomoku.getInstance().setHayMensjae(true);
            }
        } else {
            Gomoku.getInstance().setMensaje("Celda ocupada");
            Gomoku.getInstance().setHayMensjae(true);
        }
        return Gomoku.getBoard();
    }

    /**
     * Este metodo se encarga de validar la posicion de la celda.
     * 
     * @param row Fila donde se quiere jugar la piedra.
     * @param col Columna donde se quiere jugar la piedra.
     * @return True si la posicion es valida, false de lo contrario.
     */
    public boolean validarPosicion(int row, int col) {
        if (Gomoku.getCelda(row, col) instanceof Vacia)
            return true;
        else if (Gomoku.getCelda(row, col) instanceof Mina) {
            Gomoku.getCelda(row, col).actuando(row, col);
            Gomoku.getInstance().setMensaje("Has pisado una mina");
            Gomoku.getInstance().setHayMensjae(true);
            return true;
        } else if (Gomoku.getCelda(row, col) instanceof Teleport) {
            Gomoku.getCelda(row, col).actuando(row, col);
            Gomoku.getInstance().setMensaje("Has pisado un teleport");
            Gomoku.getInstance().setHayMensjae(true);
            return false;
        }

        return false;
    }

    protected abstract boolean validarCantidadPiedras(String tipoPiedra);
}