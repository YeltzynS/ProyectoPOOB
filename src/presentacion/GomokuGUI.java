/**
 * Clase que representa la interfaz gráfica del juego Gomoku.
 * Contiene el método principal (main) y todos los componentes que se muestran en la interfaz.
 * Además, implementa la lógica del juego y maneja eventos de acción.
 * 
 * @author Chicuazuque-Sierra
 * @version 1.0 25/11/2023
 */
package presentacion;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import dominio.Gomoku;
import dominio.HumanoPlayer;

public class GomokuGUI extends JFrame implements ActionListener {
	private static GomokuGUI gomokuGUI;

	private static JPanel menuPrincipal;
	private static JButton normal;
	private static JButton timeLtiempo;
	private static JButton limiteFichas;
	private static JButton exitButton;

	private static JPanel menu;
	private static TitleComponent title;
	private static JButton play2PlayerButton;
	private static JButton playWithComputerButton;
	private static JButton exitButton2;

	private static JPanel panel;
	private static BoardComponent boardComponent;
	private static InfoComponent infoComponent;
	private static ButtonComponent buttonComponent;
	private static TimerComponent timerComponent;
	private static String firstName;
	private static String secondName;
	private static TypeOfRock typeRock;

	private static JPanel modoMaquinas;
	private static JButton maquinaMiedosa;
	private static JButton maquinaExperta;
	private static JButton maquinaAgresiva;
	private static JButton exitButton3;

	public static Gomoku gomoku;

	/**
	 * Constructor de la clase GomokuGUI. Configura la apariencia inicial de la
	 * interfaz.
	 */
	public GomokuGUI() {
		setTitle("Gomoku");
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.BLACK);
		constructMainDisplay();
		add(menuPrincipal, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		gomoku = new Gomoku("player1", "HumanoPlayer", "player2", "HumanoPlayer", "Normal");
		setVisible(true);
	}
	
	



	/**
	 * Configura y construye los componentes principales de la interfaz.
	 */
	public void constructMainDisplay() {
		Dimension size = new Dimension(800, 750);

		menuPrincipal = new JPanel();
		menuPrincipal.setPreferredSize(size);
		menuPrincipal.setLayout(null);
		menuPrincipal.setBackground(Color.BLACK);

		title = new TitleComponent();
		JPanel contenedor = new JPanel();
		contenedor.setLayout(new GridLayout(6, 1));
		contenedor.setBackground(Color.BLACK);
		menuPrincipal.add(contenedor);
		contenedor.setPreferredSize(size);

		normal = new JButton("Normal");
		normal.setForeground(Color.WHITE);
		normal.setFont(new Font("SansSerif", Font.PLAIN, 30));
		normal.setOpaque(false);
		normal.setContentAreaFilled(false);
		normal.addActionListener(this);
		normal.setFocusPainted(false);

		timeLtiempo = new JButton("Tiempo");
		timeLtiempo.setForeground(Color.WHITE);
		timeLtiempo.setFont(new Font("SansSerif", Font.PLAIN, 30));
		timeLtiempo.setOpaque(false);
		timeLtiempo.setContentAreaFilled(false);
		timeLtiempo.addActionListener(this);
		timeLtiempo.setFocusPainted(false);

		limiteFichas = new JButton("Limite de fichas");
		limiteFichas.setForeground(Color.WHITE);
		limiteFichas.setFont(new Font("SansSerif", Font.PLAIN,30));
		limiteFichas.setOpaque(false);
		limiteFichas.setContentAreaFilled(false);
		limiteFichas.addActionListener(this);
		limiteFichas.setFocusPainted(false);

		exitButton = new JButton("Salir");
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.addActionListener(this);
		exitButton.setFocusPainted(false);


		contenedor.add(title);
		contenedor.add(normal);
		contenedor.add(timeLtiempo);
		contenedor.add(limiteFichas);
		contenedor.add(exitButton);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		contenedor.setBounds((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2, size.width,
				size.height);

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(Color.BLACK);
		JLabel about1 = new JLabel("Creado por Diego Chicuazuque y Yeltzyn Sierra");
		about1.setForeground(Color.WHITE);
		about1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about1);
		JLabel about2 = new JLabel("Proyecto de POOB 2023-2");
		about2.setForeground(Color.WHITE);
		about2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about2);

	}

	public void constructModePlayersDisplay() {
		Dimension size = new Dimension(800, 600);
		menu = new JPanel();
		menu.setPreferredSize(size);
		menu.setLayout(null);
		menu.setBackground(Color.BLACK);

		JPanel container = new JPanel();
		container.setLayout(new GridLayout(5, 1));
		container.setBackground(Color.BLACK);
		menu.add(container);
		container.setPreferredSize(size);

		play2PlayerButton = new JButton("Jugador vs Jugador");
		play2PlayerButton.setForeground(Color.WHITE);
		play2PlayerButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
		play2PlayerButton.setOpaque(false);
		play2PlayerButton.setContentAreaFilled(false);
		play2PlayerButton.addActionListener(this);
		play2PlayerButton.setFocusPainted(false);

		playWithComputerButton = new JButton("Jugador vs Computador");
		playWithComputerButton.setForeground(Color.WHITE);
		playWithComputerButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
		playWithComputerButton.setOpaque(false);
		playWithComputerButton.setContentAreaFilled(false);
		playWithComputerButton.addActionListener(this);
		playWithComputerButton.setFocusPainted(false);

		exitButton2 = new JButton("Salir");
		exitButton2.setForeground(Color.WHITE);
		exitButton2.setFont(new Font("SansSerif", Font.PLAIN, 30));
		exitButton2.setOpaque(false);
		exitButton2.setContentAreaFilled(false);
		exitButton2.addActionListener(this);
		exitButton2.setFocusPainted(false);

		container.add(title);
		container.add(play2PlayerButton);
		container.add(playWithComputerButton);
		container.add(exitButton2);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		container.setBounds((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2, size.width,
				size.height);

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(Color.BLACK);
		JLabel about1 = new JLabel("Creado por Diego Chicuazuque y Yeltzyn Sierra");
		about1.setForeground(Color.WHITE);
		about1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about1);
		JLabel about2 = new JLabel("Proyecto de POOB 2023-2");
		about2.setForeground(Color.WHITE);
		about2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about2);
	}

	public void constructModeMachine() {
		Dimension size = new Dimension(800, 600);
		modoMaquinas = new JPanel();
		modoMaquinas.setPreferredSize(size);
		modoMaquinas.setLayout(null);
		modoMaquinas.setBackground(Color.BLACK);

		JPanel container2 = new JPanel();
		container2.setLayout(new GridLayout(5, 1));
		container2.setBackground(Color.BLACK);
		modoMaquinas.add(container2);
		container2.setPreferredSize(size);

		maquinaAgresiva = new JButton("Maquina Agresiva");
		maquinaAgresiva.setForeground(Color.WHITE);
		maquinaAgresiva.setFont(new Font("SansSerif", Font.PLAIN, 30));
		maquinaAgresiva.setOpaque(false);
		maquinaAgresiva.setContentAreaFilled(false);
		maquinaAgresiva.addActionListener(this);
		maquinaAgresiva.setFocusPainted(false);

		maquinaExperta = new JButton("Maquina Experta");
		maquinaExperta.setForeground(Color.WHITE);
		maquinaExperta.setFont(new Font("SansSerif", Font.PLAIN, 30));
		maquinaExperta.setOpaque(false);
		maquinaExperta.setContentAreaFilled(false);
		maquinaExperta.addActionListener(this);
		maquinaExperta.setFocusPainted(false);

		maquinaMiedosa = new JButton("Maquina Miedosa");
		maquinaMiedosa.setForeground(Color.WHITE);
		maquinaMiedosa.setFont(new Font("SansSerif", Font.PLAIN, 30));
		maquinaMiedosa.setOpaque(false);
		maquinaMiedosa.setContentAreaFilled(false);
		maquinaMiedosa.addActionListener(this);
		maquinaMiedosa.setFocusPainted(false);

		exitButton3 = new JButton("Salir");
		exitButton3.setForeground(Color.WHITE);
		exitButton3.setFont(new Font("SansSerif", Font.PLAIN, 30));
		exitButton3.setOpaque(false);
		exitButton3.setContentAreaFilled(false);
		exitButton3.addActionListener(this);
		exitButton3.setFocusPainted(false);

		container2.add(title);
		container2.add(maquinaAgresiva);
		container2.add(maquinaExperta);
		container2.add(maquinaMiedosa);
		container2.add(exitButton3);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		container2.setBounds((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2, size.width,
				size.height);

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBackground(Color.BLACK);
		JLabel about1 = new JLabel("Creado por Diego Chicuazuque y Yeltzyn Sierra");
		about1.setForeground(Color.WHITE);
		about1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about1);
		JLabel about2 = new JLabel("Proyecto de POOB 2023-2");
		about2.setForeground(Color.WHITE);
		about2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		panel.add(about2);
	}

	/**
	 * Maneja eventos de acción para botones y realiza acciones correspondientes.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton || e.getSource() == exitButton2) {
			int optionValue = JOptionPane.showConfirmDialog(null, "Estas seguro de salir del juego?", "Confirm Exit",
					JOptionPane.OK_CANCEL_OPTION);
			if (optionValue == 0) {
				System.exit(0);
			}
		} else if (e.getSource() == normal || e.getSource() == timeLtiempo || e.getSource() == limiteFichas) {
			remove(menuPrincipal);
			remove(panel);

			constructModePlayersDisplay();

			add(menu, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);

			revalidate();

			if (e.getSource() == normal) {
				Gomoku.getInstance().setModoDeJuego("Normal");
			} else if (e.getSource() == timeLtiempo) {
				Gomoku.getInstance().setModoDeJuego("Tiempo");
			} else if (e.getSource() == limiteFichas) {
				Gomoku.getInstance().setModoDeJuego("Limite de fichas");
			}
			remove(menuPrincipal);
			remove(panel);
			constructMainDisplay();
		} else if (e.getSource() == play2PlayerButton || e.getSource() == playWithComputerButton) {
			remove(menu);
			remove(panel);

			if (e.getSource() == play2PlayerButton) {
				Gomoku.setPlayer1("HumanoPlayer", "Jugador 1");
				Gomoku.setPlayer2("HumanoPlayer", "Jugador 2");
				Dimension boardSize = new Dimension(600, 600);

				panel = new JPanel();
				add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(boardSize);
				panel.setBackground(Color.BLACK);
				panel.setLayout(null);

				boardComponent = new BoardComponent();
				panel.add(boardComponent);
				boardComponent.setPreferredSize(boardSize);

				infoComponent = new InfoComponent();

				buttonComponent = new ButtonComponent();
				timerComponent = new TimerComponent();
				typeRock = new TypeOfRock();
				add(infoComponent, BorderLayout.NORTH);
				add(buttonComponent, BorderLayout.SOUTH);
				add(timerComponent, BorderLayout.WEST);
				add(typeRock, BorderLayout.EAST);

				revalidate();
				boardComponent.setBounds((panel.getWidth() - boardSize.width) / 2,
						(panel.getHeight() - boardSize.height) / 2, boardSize.width, boardSize.height);

				revalidate();
				welcomeScreen();
			} else if (e.getSource() == playWithComputerButton) {
				Gomoku.setPlayer1("HumanoPlayer", "Jugador 1");
				Gomoku.setPlayer2("MaquinaExpertaPlayer", "Computador");
				constructModeMachine();
				add(modoMaquinas, BorderLayout.CENTER);
				add(panel, BorderLayout.SOUTH);
				revalidate();
			}

		} else if (e.getSource() == maquinaAgresiva || e.getSource() == maquinaExperta
				|| e.getSource() == maquinaMiedosa) {
			remove(modoMaquinas);
			remove(panel);
			Dimension boardSize = new Dimension(600, 600);

			panel = new JPanel();
			add(panel, BorderLayout.CENTER);
			panel.setPreferredSize(boardSize);
			panel.setBackground(Color.BLACK);
			panel.setLayout(null);

			boardComponent = new BoardComponent();
			panel.add(boardComponent);
			boardComponent.setPreferredSize(boardSize);

			infoComponent = new InfoComponent();

			buttonComponent = new ButtonComponent();
			timerComponent = new TimerComponent();
			typeRock = new TypeOfRock();
			add(infoComponent, BorderLayout.NORTH);
			add(buttonComponent, BorderLayout.SOUTH);
			add(timerComponent, BorderLayout.WEST);
			add(typeRock, BorderLayout.EAST);
			revalidate();
			boardComponent.setBounds((panel.getWidth() - boardSize.width) / 2,
					(panel.getHeight() - boardSize.height) / 2, boardSize.width, boardSize.height);

			revalidate();
			welcomeScreen();
			if (e.getSource() == maquinaAgresiva) {
				Gomoku.setPlayer2("MaquinaAgresivaPlayer", "Computador");
			} else if (e.getSource() == maquinaExperta) {
				Gomoku.setPlayer2("MaquinaExpertaPlayer", "Computador");
			} else if (e.getSource() == maquinaMiedosa) {
				Gomoku.setPlayer2("MaquinaMiedosaPlayer", "Computador");
			}

		}

	}

	/**
	 * Obtiene el componente del tablero.
	 * 
	 * @return El componente del tablero.
	 */
	public static BoardComponent getBoardComponent() {
		return boardComponent;
	}

	/**
	 * Obtiene el componente de información.
	 * 
	 * @return El componente de información.
	 */
	public static InfoComponent getInfoComponent() {
		return infoComponent;
	}

	/**
	 * Obtiene el nombre del primer jugador.
	 * 
	 * @return El nombre del primer jugador.
	 */
	public static String getFirstName() {
		return firstName;
	}

	/**
	 * Obtiene el nombre del segundo jugador.
	 * 
	 * @return El nombre del segundo jugador.
	 */
	public static String getSecondName() {
		return secondName;
	}

	/**
	 * Método llamado antes del inicio del juego para que los jugadores ingresen sus
	 * nombres.
	 * Además, inicia el temporizador del juego según la configuración.
	 */
	public static void welcomeScreen() {
		firstName = JOptionPane.showInputDialog(null,
				"Bienvenido a GOMOKU!", "Ingresa el nombre del jugador uno");
		firstName = firstName == null ? "Primer jugador" : firstName;
		firstName = firstName.equals("Ingresa el nombre jugador 1") ? "Primer jugador"
				: firstName;

		infoComponent.clearInfo();
		Gomoku.getInstance().getPlayer1().setName(firstName);
		/*
		 * Si el jugador elige jugar contra la computadora, entonces después de él, es
		 * decir,
		 * el primer jugador, ingresa el nombre, comienza el temporizador del juego.
		 */
		if (!(Gomoku.getInstance().getPlayer2() instanceof HumanoPlayer)) {
			TimerComponent.getTimer().start();
			Gomoku.getInstance().getPlayer2().setName("Computador");
		}

		/*
		 * Si no juega contra la computadora, entonces el segundo jugador ingresa su
		 * nombre
		 * y después de ingresar el nombre, comienza el temporizador del juego.
		 */
		if (Gomoku.getInstance().getPlayer2() instanceof HumanoPlayer) {
			secondName = JOptionPane.showInputDialog(null,
					"Bienvenido a GOMOKU!", "Ingresa el nombre  del jugador dos");
			secondName = secondName == null ? "Segundo jugador" : secondName;
			secondName = secondName.equals("Ingresa el nombre jugador 2") ? "Segundo jugador"
					: secondName;
			Gomoku.getPlayer2().setName(secondName);
			TimerComponent.getTimer().start();
		}
		TimerComponent.getTimer().start();

	}
	

	/**
	 * Método llamado cuando un jugador está en la arena de juego y desea volver al
	 * menú principal.
	 * Restaura la interfaz al estado del menú principal y reinicia el juego.
	 */
	public void mainMenu() {
		gomokuGUI.remove(panel);
		gomokuGUI.remove(infoComponent);
		gomokuGUI.remove(buttonComponent);
		gomokuGUI.remove(timerComponent);
		gomokuGUI.remove(typeRock);
		Gomoku.getInstance().setSeEncontroGanador(false);

		constructMainDisplay();

		gomokuGUI.add(menuPrincipal, BorderLayout.CENTER);
		gomokuGUI.add(panel, BorderLayout.SOUTH);

		gomokuGUI.revalidate();
		GameController.restartGame();
	}

	/**
	 * Obtiene la instancia de la clase GomokuGUI.
	 * 
	 * @return La instancia de GomokuGUI.
	 */
	public static GomokuGUI getGomokuGUI() {
		return gomokuGUI;
	}

	/**
	 * Método principal (main) que inicia la aplicación.
	 * z
	 * 
	 * @param args Argumentos de la línea de comandos (no se utilizan).
	 */
	public static void main(String[] args) {
		gomokuGUI = new GomokuGUI();
	}
}
