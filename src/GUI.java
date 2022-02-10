import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serial;

public class GUI extends JPanel{

	private TicTacToe spiel;
	private static JFrame f;
	private static JLabel l;

	public static void createAndShowGui() {
		Container panel;
		l = new JLabel("Player to move: 1", JLabel.CENTER);
		f = new JFrame("TicTacToe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new TicTacToe(f, l);
		panel.setLayout(new BorderLayout());
		panel.add(l, BorderLayout.PAGE_END);
		f.getContentPane().add(panel, BorderLayout.CENTER);

		f.setLocationRelativeTo(null);
		f.setSize(325, 400);
		f.setResizable(false);
		f.setVisible(true);
	}


	public static void main(final String[] args) {
		Runnable gui = new Runnable() {

			@Override
			public void run() {
				createAndShowGui();
			}
		};
		//GUI must start on EventDispatchThread:
		SwingUtilities.invokeLater(gui);
	}

	public TicTacToe getSpiel() {
		return spiel;
	}

	public void setSpiel(TicTacToe spiel) {
		this.spiel = spiel;
	}
}
