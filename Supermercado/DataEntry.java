package Supermercado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataEntry extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldFornecedor;
	private JTextField textFieldNome;
	private JTextField textFieldCampo1;
	private JTextField textFieldCampo2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntry frame = new DataEntry("Teste");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DataEntry(String title) {
		setTitle("Entrada de Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(305, 11, 98, 20);
		contentPane.add(lblCategoria);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(147, 26, 86, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(44, 29, 46, 14);
		contentPane.add(lblCodigo);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(44, 65, 64, 14);
		contentPane.add(lblFornecedor);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setBounds(147, 62, 135, 20);
		contentPane.add(textFieldFornecedor);
		textFieldFornecedor.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(44, 100, 46, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(147, 97, 135, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblCampo = new JLabel("Campo1:");
		lblCampo.setBounds(44, 138, 46, 14);
		contentPane.add(lblCampo);

		textFieldCampo1 = new JTextField();
		textFieldCampo1.setColumns(10);
		textFieldCampo1.setBounds(147, 135, 135, 20);
		contentPane.add(textFieldCampo1);

		JLabel lblCampo_1 = new JLabel("Campo2:");
		lblCampo_1.setBounds(44, 179, 46, 14);
		contentPane.add(lblCampo_1);

		textFieldCampo2 = new JTextField();
		textFieldCampo2.setColumns(10);
		textFieldCampo2.setBounds(147, 176, 135, 20);
		contentPane.add(textFieldCampo2);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(305, 61, 89, 23);
		contentPane.add(btnEnviar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(305, 96, 89, 23);
		contentPane.add(btnCancelar);

		btnEnviar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Dados Enviados");

			}
		});

		btnCancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Dados Cancelados");

			}
		});

	}
}
