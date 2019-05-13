import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
	public ControlPanel(){
		setLayout(new FlowLayout());
		add(new JButton("Exit"));
	}
}
