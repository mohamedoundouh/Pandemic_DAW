import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import java.awt.Color;
import java.awt.Font;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////AVISO IMPORTANE, ACORDAROS DE CAMBIAR LAS RUTAS DE LAS FOTOS PARA QUE SE VEAN EN EL PANEL////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Menu extends JFrame implements ActionListener {
	private JButton nuevaPartida;
	private JButton cargarPartida;
	private JButton informacion;
	private JButton resumenPuntuaciones;
	private JButton autores;
	private JButton version;
	private JButton salir;

	public static void main(String[] args) {
		Menu panel = new Menu(); // EL MAIN DONDE SE LLAMA AL MENU
		panel.setVisible(true);

	}

	public Menu() {
		// EN ESTA SECCION PERSONALIZAMOS EL PANEL PRINCIPAL
		setTitle("PANDEMIC");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.GREEN));
		setBounds(100, 100, 1200, 710);
		ImageIcon imagenDeFondo = new ImageIcon(
				"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\epico2.png");
		getContentPane().setLayout(null);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON NUEVA PARTIDA *LOS DEMAS NO LOS EXPLICO PORQUE BASICAMENTE SIGUEN EL
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// MISMO
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// PATRON*
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// (SI
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// HAY
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ALGO
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DIFERENTE
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// SI
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// QUE
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// QUEDA
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// EXPLICADO)
		JButton nuevaPartida = new JButton("NUEVA PARTIDA"); // NOMBRE DEL BOTON MAS LA CREACION
		nuevaPartida.setBackground(Color.GREEN); // FONDO DEL BOTON EN VERDE
		nuevaPartida.setForeground(Color.BLACK); // COLOCAMOS LAS LETRAS EN NEGRO
		nuevaPartida.setFont(new Font("Rockwell", Font.PLAIN, 14)); // TAMAÑO DE LA LETRA Y LA FUENTE
		nuevaPartida.setBounds(329, 418, 150, 35); // TAMAÑO DEL BOTON Y UBICACION
		nuevaPartida.addActionListener(new ActionListener() { // HACEMOS QUE EL BOTON REALICE UNA ACCION CUANDO ES
																// PULSADO
			public void actionPerformed(ActionEvent e) {

				panelNuevaPartida panelNuevaPartida = new panelNuevaPartida(); // CREARA UN NUEVO PANEL
				panelNuevaPartida.setVisible(true);
			}
		});
		getContentPane().add(nuevaPartida); // AÑADIMOS EL BOTON AL PANEL

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON CARGAR PARTIDA
		JButton cargarPartida = new JButton("CARGAR PARTIDA");
		cargarPartida.setBackground(Color.GREEN);
		cargarPartida.setForeground(Color.BLACK);
		cargarPartida.setFont(new Font("Rockwell", Font.PLAIN, 13));
		cargarPartida.setBounds(519, 418, 150, 35);
		cargarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una instancia del nuevo panel y lo muestra
				panelCargarPartida panelCargarPartida = new panelCargarPartida();
				panelCargarPartida.setVisible(true);
			}
		});
		getContentPane().add(cargarPartida);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON DESARROLLADORES
		JButton autores = new JButton("DESARROLLADORES");
		autores.setBackground(Color.GREEN);
		autores.setForeground(Color.BLACK);
		autores.setFont(new Font("Rockwell", Font.PLAIN, 12));
		autores.setBounds(519, 500, 150, 35);
		autores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una instancia del nuevo panel y lo muestra
				panelAutores panelAutores = new panelAutores();
				panelAutores.setVisible(true);
			}
		});
		getContentPane().add(autores);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON DE INFORMACION
		JButton informacion = new JButton("INFORMACIÓN");
		informacion.setBackground(Color.GREEN);
		informacion.setForeground(Color.BLACK);
		informacion.setFont(new Font("Rockwell", Font.PLAIN, 15));
		informacion.setBounds(718, 418, 150, 35);
		informacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una instancia del nuevo panel y lo muestra
				panelInformacion panelInformacion = new panelInformacion();
				panelInformacion.setVisible(true);
			}
		});
		getContentPane().add(informacion);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON DE PUNTUACIONES
		JButton puntuaciones = new JButton("PUNTUACIONES");
		puntuaciones.setBackground(Color.GREEN);
		puntuaciones.setFont(new Font("Rockwell", Font.PLAIN, 15));
		puntuaciones.setForeground(Color.BLACK);
		puntuaciones.setBounds(329, 500, 150, 35);
		puntuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una instancia del nuevo panel y lo muestra
				panelPuntuaciones panelPuntuaciones = new panelPuntuaciones();
				panelPuntuaciones.setVisible(true);
			}
		});
		getContentPane().add(puntuaciones);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON SALIR
		JButton botonSalir = new JButton("SALIR");
		botonSalir.setBackground(Color.GREEN);
		botonSalir.setForeground(Color.BLACK);
		botonSalir.setFont(new Font("Rockwell", Font.PLAIN, 16));
		botonSalir.setBounds(519, 582, 150, 35);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // EN ESTE CASO EN VEZ DE ABRIR UN NUEVO PANEL CIERRA EL PANEL EN EL QUE ESTAMOS
			}
		});
		getContentPane().add(botonSalir);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// BOTON VERSION
		JButton version = new JButton("VERSION");
		version.setBackground(Color.GREEN);
		version.setForeground(Color.BLACK);
		version.setFont(new Font("Rockwell", Font.PLAIN, 16));
		version.setBounds(718, 500, 150, 35);
		getContentPane().add(version);
		version.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una instancia del nuevo panel y lo muestra
				panelVersion panelVersion = new panelVersion();
				panelVersion.setVisible(true);
			}
		});

		JLabel labelDeFondo = new JLabel(imagenDeFondo); // CREAMOS UN LABEL PARA LA IMAGEN DE FONDO
		labelDeFondo.setBackground(Color.GREEN); // EL COLOR DEL BORDE DEL PANEL EN VERDE
		labelDeFondo.setBounds(0, 0, 1184, 671); // UBICACION Y TAMAÑO DEL LABEL DEL FONDO
		getContentPane().add(labelDeFondo); // LO AÑADIMOS AL PANEL

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

// PANEL DE INFORMACION *LOS DEMAS NO LOS EXPLICO PORQUE BASICAMENTE SIGUEN EL MISMO PATRON (SI HAY ALGO DIFERENTE SI QUE QUEDA EXPLICADO)*
	class panelInformacion extends JFrame {
		private JPanel panel;

		public panelInformacion() {
			// CREA EL PANEL
			panel = new JPanel();

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // QUE SE CIERRE AL PRESIONAR LA X DE LA TOLLBAR
			setTitle("PANDEMIC"); // NOMBRE QUE APARECE ARRIBA EN LA TOLLBAR
			setResizable(false); // QUE NO SE PUEDA CAMBIAR EL TAMAÑO DEL PANEL
			setBounds(100, 100, 1200, 710);// POSICION Y TAMAÑO DEL PANEL
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));// CAMBIAMOS
																														// EL
																														// LOGO
																														// DE
																														// LA
																														// TOLLBAR
																														// POR
																														// EL
																														// DEL
																														// PANDEMIC
																														// NUESTRO
			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\fondoInformacion2.jpg"); // FONDO
																																// DEL
																																// PANEL
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			getContentPane().add(labelDeFondo); // AÑADIMOS EL FONDO AL PANEL

		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// PANEL DEL BOTON NUEVA PARTIDA
	class panelNuevaPartida extends JFrame {
		private JPanel panel;

		public panelNuevaPartida() {

			panel = new JPanel();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("PANDEMIC");
			setResizable(false);
			setBounds(100, 100, 1200, 710);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));

			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\proximamente.jpg");
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			labelDeFondo.setBounds(0, 0, 1184, 671);
			getContentPane().add(labelDeFondo);

		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// PANEL DE CARGAR PARTIDA
	class panelCargarPartida extends JFrame {
		private JPanel panel;

		public panelCargarPartida() {

			panel = new JPanel();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("PANDEMIC");
			setResizable(false);
			setBounds(100, 100, 1200, 710);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));

			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\proximamente.jpg");
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			labelDeFondo.setBounds(0, 0, 1184, 671);
			getContentPane().add(labelDeFondo);

		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// PANEL DE PUNTUACIONES
	class panelPuntuaciones extends JFrame {
		private JPanel panel;

		public panelPuntuaciones() {
			// Crea el panel
			panel = new JPanel();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("PANDEMIC");
			setResizable(false);
			setBounds(100, 100, 1200, 710);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));
			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\proximamente.jpg");
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			labelDeFondo.setBounds(0, 0, 1184, 671);
			getContentPane().add(labelDeFondo);

		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// PANEL DE AUTORES
	class panelAutores extends JFrame {
		private JPanel panel;

		public panelAutores() {

			panel = new JPanel();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("PANDEMIC");
			setResizable(false);
			setBounds(390, 270, 626, 450);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));
			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\fondoautores.jpg");
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			labelDeFondo.setBounds(0, 0, 500, 671);
			getContentPane().add(labelDeFondo);

		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// PANEL DE VERSION DEL JUEGO
	class panelVersion extends JFrame {
		private JPanel panel;

		public panelVersion() {

			panel = new JPanel();

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("PANDEMIC");
			setResizable(false);
			setBounds(520, 270, 350, 350);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\pandemic2.png"));
			ImageIcon imagenDeFondo = new ImageIcon(
					"C:\\Users\\La T0sta-D0rA\\eclipse-workspace\\MENU PANDEMIC\\imagenes utilizadas\\fondoversion.jpg");
			JLabel labelDeFondo = new JLabel(imagenDeFondo);
			getContentPane().add(labelDeFondo);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// SI ESTO NO ESTA CREADO SALE ERROR EN EL EL PUBLIC VOID DEL MENU AUNQUE SE
		// INICIARA IGUAL PERO PORSIACASO SE DEJA CREADO. :)

	}

}

//Mohamed Oundouh, David Mir - محمد أندوح, دافيد مير
