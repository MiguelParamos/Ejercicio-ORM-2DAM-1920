package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MasSaldo extends JPanel
{
	private JTextField addSaldoText;
	private JLabel lblSaldoAnadido;
	private Usuario usuario;



	/**
	 * 
	 * @author Jose Luis Gallardo
	 * @author Balint Salamon Mark
	 */
	public MasSaldo(VentanaPrincipal v, Usuario usuario)
	{
		this.usuario = usuario;
		setBackground(new Color(65, 105, 225));
		setLayout(null);
		JLabel labelSueldo = new JLabel("A\u00F1adir Saldo :");
		labelSueldo.setForeground(new Color(255, 165, 0));
		labelSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSueldo.setBounds(65, 83, 89, 17);
		add(labelSueldo);
		JButton atrasBoton = new JButton("Atras");
		atrasBoton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO hacer que el boton atras funcione :3
			}
		});
		atrasBoton.setBackground(new Color(139, 0, 0));
		atrasBoton.setForeground(new Color(178, 34, 34));
		atrasBoton.setBounds(12, 264, 89, 23);
		add(atrasBoton);
		JButton addSaldo = new JButton("A\u00F1adir");
		int newBal = (int) (usuario.getSaldo() + Integer.parseInt(labelSueldo.getText()));
		addSaldo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int newBal = (int) (Integer.parseInt(getAddSaldoText().getText()) + getUsuario().getSaldo());
				getUsuario().setSaldo(newBal);
				getLblSaldoAnadido().setText("lblSaldoAnadido");
			}
		});
		addSaldo.setForeground(new Color(50, 205, 50));
		addSaldo.setBackground(new Color(0, 128, 0));
		addSaldo.setBounds(166, 133, 89, 23);
		add(addSaldo);
		addSaldoText = new JTextField();
		addSaldoText.setBounds(166, 81, 96, 20);
		add(addSaldoText);
		addSaldoText.setColumns(10);

		lblSaldoAnadido = new JLabel("");
		lblSaldoAnadido.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoAnadido.setForeground(new Color(255, 165, 0));
		lblSaldoAnadido.setBounds(113, 267, 314, 20);
		add(lblSaldoAnadido);
	}



	public JLabel getLblSaldoAnadido()
	{
		return lblSaldoAnadido;
	}



	public JTextField getAddSaldoText()
	{
		return addSaldoText;
	}



	public Usuario getUsuario()
	{
		return usuario;
	}



	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}
