package view;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Comunicacion;

public class Motor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503682047144853029L;
	private JPanel contentPane;
	private Comunicacion com;

	/**
	 * Create the frame.
	 */
	public Motor() {
		com = new Comunicacion();
		com.initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		JToggleButton tglbtnPrenderapagar = new JToggleButton("Prender/Apagar");
		tglbtnPrenderapagar.addChangeListener(new ChangeListener() {
			boolean cambio = false;

			public void stateChanged(ChangeEvent e) {
				try {
					if (!cambio) {
						cambio = true;
						com.getOutput().write(1);
					} else {
						cambio = false;
						com.getOutput().write(0);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		panel_1.add(tglbtnPrenderapagar);
	}

	public static void main(String[] args) throws Exception {
		/*
		 System.out.println("Started");
		 new Motor().setVisible(true);
		*/
		
		Comunicacion com = new Comunicacion();
		com.initialize();
		ServerSocket ss = new ServerSocket(12345);
		System.out.println("Started");
		while (true) {
			Socket s = ss.accept();
			System.out.println("Peticion entrante.");
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			int n = ois.readInt();
			switch (n) {
			case 0:
				com.getOutput().write(0);
				break;
			case 1:
				com.getOutput().write(1);
				break;
			}
		}
		
	}

}
