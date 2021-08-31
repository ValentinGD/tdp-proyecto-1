package gui;

import java.awt.BorderLayout;
import java.time.format.DateTimeFormatter;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldEMail;
	private JTextField textFieldGitHub;
	private JLabel LabelFecha;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(653, 291));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 385, 183);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel labelLU = new JLabel("LU");
		labelLU.setBounds(10, 19, 45, 13);
		tabInformation.add(labelLU);
		
		textFieldLU = new JTextField();
		textFieldLU.setEditable(false);
		textFieldLU.setBounds(96, 13, 274, 19);
		tabInformation.add(textFieldLU);
		textFieldLU.setColumns(10);
		textFieldLU.setText(String.valueOf(studentData.getId()));
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setBounds(10, 42, 76, 13);
		tabInformation.add(labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setBounds(96, 36, 274, 19);
		tabInformation.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(studentData.getLastName());
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setBounds(10, 71, 45, 13);
		tabInformation.add(LabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(96, 65, 274, 19);
		tabInformation.add(textFieldNombre);
		textFieldNombre.setText(studentData.getFirstName());
		
		JLabel labelEMail = new JLabel("E-Mail");
		labelEMail.setBounds(10, 100, 45, 13);
		tabInformation.add(labelEMail);		
		
		textFieldEMail = new JTextField();
		textFieldEMail.setEditable(false);
		textFieldEMail.setColumns(10);
		textFieldEMail.setBounds(96, 94, 274, 19);
		tabInformation.add(textFieldEMail);
		textFieldEMail.setText(studentData.getMail());
		
		JLabel labelGitHub = new JLabel("GitHub URL");
		labelGitHub.setBounds(10, 124, 87, 16);
		tabInformation.add(labelGitHub);
		contentPane.add(tabbedPane);
		
		textFieldGitHub = new JTextField();
		textFieldGitHub.setEditable(false);
		textFieldGitHub.setColumns(10);
		textFieldGitHub.setBounds(96, 123, 274, 19);
		tabInformation.add(textFieldGitHub);
		
		contentPane.add(tabbedPane);
		
		LocalTime hs= LocalTime.now();
        LocalDate fecha= LocalDate.now();
		LabelFecha = new JLabel("Esta ventana fue generada el "+fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"a las "
        + hs.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		LabelFecha.setBounds(10, 203, 375, 13);
		contentPane.add(LabelFecha);
		
		JLabel lebelFoto = new JLabel();
		lebelFoto.setBounds(420, 29, 181, 164);
		contentPane.add(lebelFoto);
		ImageIcon MiFoto =new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
        Image fotoEscalada = MiFoto.getImage().getScaledInstance(lebelFoto.getWidth(),lebelFoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon miFotoEscalada = new ImageIcon(fotoEscalada);
		lebelFoto.setIcon(miFotoEscalada);
		
	}
}
