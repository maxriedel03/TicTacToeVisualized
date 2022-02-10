import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class GUI extends JPanel {

	@Serial
	private static final long serialVersionUID = 3781969029025239025L;

	private TicTacToe spiel;
	private static JFrame f;
	private static JLabel l;

	public GUI() {
		spiel = new TicTacToe(f, l);
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		spiel.paintField(g);
	}

	public TicTacToe getSpiel() {
		return spiel;
	}

	public void setSpiel(TicTacToe spiel) {
		this.spiel = spiel;
	}

	public static void main(final String[] args) {

		Container panel;
		l = new JLabel("Player to move: 1", JLabel.CENTER);

		f = new JFrame("Spiel des Lebens");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new GUI();
		panel.setLayout(new BorderLayout());
		panel.add(l, BorderLayout.PAGE_END);
		f.getContentPane().add(panel, BorderLayout.CENTER);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(325, 400);
		f.setResizable(false);
		f.setVisible(true);

	}

}
