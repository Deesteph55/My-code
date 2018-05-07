import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Playgame extends JFrame {
	public JTextField[][] getTextcells() {
		return textcells;
	}
	public void setTextcells(JTextField[][] textcells) {
		this.textcells = textcells;
	}
	public static final int SIZE_OF_GRID = 9;
	public static final int INNER_GRID = 3;
	private JTextField[][] textcells = new JTextField[SIZE_OF_GRID][SIZE_OF_GRID];
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Playgame frame = new Playgame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Playgame() throws FileNotFoundException  {
	
		int puzzle[][];
		String Name = "Sudoku.txt";
		File file = new File(Name);
		Scanner inputStream = new Scanner(file);
		puzzle = new int[9][9];
		 try{
	        while(inputStream.hasNext())
	        {
	        	String line = inputStream.next();
	        	inputStream = new Scanner(file);
	     	for(int i = 0; i<9; i++){
	     		for(int j = 0; j<9; j++){
	     			line = inputStream.next();
	     			puzzle[i][j]= Integer.parseInt(line);
	        		}
	            }
	         }
		 }
	       catch(FileNotFoundException e){
	        	 System.out.println("error");
	     } 	
	     	inputStream.close();
	     	Container c = getContentPane();
			c.setLayout(new GridLayout(SIZE_OF_GRID,SIZE_OF_GRID));
			int row;
			int col;
			boolean[][] clean =
			      {{true, true, true, true, true, false, true, false, true},
			       {false, false, true, true, false, true, false, true, true},
			       {true, false, true, false, false, true, true, true, false},
			       {false, false, false, true, false, false, true, true, true},
			       {false, false, false, true, true, true, false, false, false},
			       {true, true, true, false, false, true, false, false, false},
			       {false, true, true, true, false, false, true, false, true},
			       {true, true, false, true, false, true, true, false, false},
			       {true, false, false, true, true, true, true, true, true}};
			
			for(row = 0; row<SIZE_OF_GRID; ++row){
				for(col = 0; col <SIZE_OF_GRID; ++col){
					textcells[row][col] = new JTextField();
					c.add(textcells[row][col]);
					textcells[row][col].setText(puzzle[row][col] + "");
					
					if(clean[row][col])
					{
						textcells[row][col].setText(" ");
						textcells[row][col].setEditable(true);
					}
					else{
						textcells[row][col].setText(puzzle[row][col] + " ");
						textcells[row][col].setEditable(false);
					}
					
				}
			}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 451);
		
	}
	
}	