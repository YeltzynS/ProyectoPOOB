/**
 * Esta clase es un panel que contiene componentes de botones
 * que se muestran durante el transcurso del juego.
 * @author Chicuazuque-Sierra
 * @version 1.0 25/11/2023
 * 
 */
package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ButtonComponent extends JPanel implements ActionListener {

	private JButton openButton;
	private JButton saveButton;
	private JButton restartButton;
	private JButton quitButton;
	private JButton mainMenuButton;


	/**
	 * Constructor de la clase ButtonComponent.
	 */
	public ButtonComponent() {

		setBackground(Color.BLACK);
		openButton = new JButton("Abrir juego");
		add(openButton);
		openButton.addActionListener(this);

		saveButton = new JButton("Guardar juego");
		add(saveButton);
		saveButton.addActionListener(this);

		restartButton = new JButton("Nuevo juego");
		add(restartButton);
		restartButton.addActionListener(this);

		mainMenuButton = new JButton("Menú principal");
		add(mainMenuButton);
		mainMenuButton.addActionListener(this);

		quitButton = new JButton("Salir");
		add(quitButton);
		quitButton.addActionListener(this);
	}

	/**
	 * Este método contiene las acciones que se realizarán cuando
	 * se hace clic en los botones de esta clase.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openButton){
			GameController.cargarEstadoJuego();
		
		} else if(e.getSource() == saveButton){
			GameController.guardarEstadoJuego();
			GameController.restartGame();
			TimerComponent.getTimer().start();
		} else if(e.getSource() == restartButton) {
			int optionValue = JOptionPane.showConfirmDialog(null, "¿Estás seguro de comenzar un nuevo juego?",
					"Confirmar Nuevo juego", JOptionPane.OK_CANCEL_OPTION);
			if (optionValue == 0) {
				GameController.restartGame();
				TimerComponent.getTimer().start();
			}
		} else if (e.getSource() == mainMenuButton) {
			GomokuGUI.getGomokuGUI().mainMenu();
		} else if (e.getSource() == quitButton) {
			int optionValue = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir del juego?",
					"Confirmar Salida",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionValue == 0) {
				System.exit(0);
			}
		}
	}
}
