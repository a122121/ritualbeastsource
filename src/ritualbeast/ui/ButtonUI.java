package ritualbeast.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonUI {
	 

	public static void main(String[] args) {
		JFrame frame = new JFrame("為什麼我要玩靈獸-By業障香蕉");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		frame.setLayout(new GridLayout(6, 2));

		String[] buttonName = { "精靈獸　川豚", "靈獸使　蕾拉", "精靈獸　火獅", "靈獸使的長老", "精靈獸　雷鷹", "靈獸使　雯", "精靈獸　心企太", "英靈獸使－神數心皮莉卡",
				"精靈獸使　薇茵達", "精靈獸使　短手蕾拉" };
		JButton[] buttons = new JButton[buttonName.length];
		Font customFont = new Font("Serif", Font.BOLD, 20);
		for (int i = 0; i < buttonName.length; i++) {
			String buttonText = buttonName[i];
			String iconPathBlack = "/main/resources/images/B/" + (i + 1) + "_1.jpg";
			String iconPath = "/main/resources/images/N/" + (i + 1) + ".jpg";
			ImageIcon icon = new ImageIcon(ButtonUI.class.getResource(iconPath)); 
			ImageIcon iconBlack = new ImageIcon(ButtonUI.class.getResource(iconPathBlack));
			buttons[i] = new JButton();
			buttons[i].setIcon(icon);
			buttons[i].setFont(new Font("Serif", Font.BOLD, 20));
			buttons[i].setText(buttonText + " 未特招");
			buttons[i].setHorizontalTextPosition(JButton.CENTER); 
			buttons[i].setVerticalTextPosition(JButton.CENTER);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton) e.getSource();
					if (button.getText().equals(buttonText + " 未特招")) {
						ImageIcon ic = iconBlack;
						button.setIcon(ic);
						button.setText(buttonText + " 已特招");
						button.setBackground(Color.GREEN);
					} else {
						ImageIcon ic = icon;
						button.setIcon(ic);
						button.setText(buttonText + " 未特招");
						button.setBackground(Color.RED);
					}
				}
			});
			frame.add(buttons[i]);
		}
		JButton reset = new JButton();
		reset.setText("重置");
		reset.setFont(customFont);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < buttonName.length; i++) {
					String iconPath = "/main/resources/images/N/" + (i + 1) + ".jpg";
					ImageIcon icon = new ImageIcon(ButtonUI.class.getResource(iconPath));
					buttons[i].setIcon(icon);
					buttons[i].setText(buttonName[i] + " 未特招");
					buttons[i].setBackground(Color.RED);
				}
			}
		});
		frame.add(reset);

		frame.setVisible(true);
	}
}
