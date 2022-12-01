package org.javaturk.jpa.ch04.mappings.lob.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class BookDisplayer {
	
	public void displayBook(Book book) {
		displayCoverImage(book.getTitle(), book.getDescription(), new ImageIcon(book.getCoverPicture()));
	}

	public void displayCoverImage(String title, String description, ImageIcon image) {
		JFrame frame = new JFrame();
		frame.setSize(1250, 1000);
		frame.setLayout(new BorderLayout());

		JLabel label = null;
		if (image == null) {
			label = new JLabel("No Cover Picture Found for: " + title, JLabel.CENTER);
			label.setFont(new Font("Arial", Font.BOLD, 24));
			frame.add(label, BorderLayout.CENTER);
		} else {
			label = new JLabel("Cover Picture for " + title, JLabel.CENTER);
			label.setFont(new Font("Arial", Font.BOLD, 24));
			label.setForeground(Color.WHITE);
			label.setBackground(Color.BLACK);
			frame.add(label, BorderLayout.CENTER);
			JPanel labelPanel = new JPanel();
			labelPanel.setBackground(Color.BLACK);
			labelPanel.add(label);
			frame.add(labelPanel, BorderLayout.NORTH);

			JPanel centerPanel = new JPanel(new BorderLayout());
			
			JPanel imagePanel = new JPanel();
			JLabel imageLabel = new JLabel(image);
			imagePanel.add(imageLabel);
			JScrollPane scroller1 = new JScrollPane(imagePanel);
			centerPanel.add(scroller1, BorderLayout.NORTH);
			
			JPanel descPanel = new JPanel();
			JTextArea descArea = new JTextArea(10, 100);
			descArea.setLineWrap(true);
			descArea.setText(description);
			descPanel.add(descArea);
			JScrollPane scroller2 = new JScrollPane(descPanel);
			centerPanel.add(scroller2, BorderLayout.SOUTH);
			
			JScrollPane scroller3 = new JScrollPane(centerPanel);
			frame.add(scroller3, BorderLayout.CENTER);
			
			
			
//			frame.add(scroller2, BorderLayout.SOUTH);
		}

		label.setOpaque(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
