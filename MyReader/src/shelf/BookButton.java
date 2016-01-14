package shelf;

import java.awt.Dimension;

import javax.swing.JButton;

public class BookButton extends JButton {

	private final int width = 180;
	private final int height = 60;
	/**
	 * 
	 */
	private static final long serialVersionUID = 151802594118639073L;

	public BookButton(String s) {
		super(s);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
	}

}
