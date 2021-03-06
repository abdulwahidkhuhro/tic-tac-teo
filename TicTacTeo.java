import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.applet.*;
import javax.swing.JOptionPane;
public class TicTacTeo implements ActionListener{
	
	Frame window = new Frame();
	private Button _1 = new Button();
	private Button _2 = new Button();
	private Button _3 = new Button();
	private Button _4 = new Button();
	private Button _5 = new Button();
	private Button _6 = new Button();
	private Button _7 = new Button();
	private Button _8 = new Button();
	private Button _9 = new Button();
	private Button exit = new Button("Exit");
	private Button reStart = new Button("Restart");
	private Label playerTurnStatus = new Label("Player O's Turn");
	private Label winningStatus = new Label("Winning Status");
	private Label playerO = new Label("O : 0");
	private Label playerX = new Label("X : 0");
	private Button[] buttons = new Button[9];
	private Font font = new Font("SansSerif", Font.BOLD, 45);
	private Font fontPlayerStatus = new Font("SansSerif", Font.BOLD, 15);
	private boolean playerTurn = true;
	private int playerOWinningCount = 0;
	private int playerXWinningCount = 0;
	
	public TicTacTeo(){
		window.setBounds(600,100,380,550);
		window.setLayout(null);
		
		_1.setBounds(20,50,100,100);
		_2.setBounds(140,50,100,100);
		_3.setBounds(260,50,100,100);
		_4.setBounds(20,170,100,100);
		_5.setBounds(140,170,100,100);
		_6.setBounds(260,170,100,100);
		_7.setBounds(20,290,100,100);
		_8.setBounds(140,290,100,100);
		_9.setBounds(260,290,100,100);
		playerTurnStatus.setBounds(130,400,130,25);
		exit.setBounds(20,450,160,25);
		reStart.setBounds(200,450,160,25);
		winningStatus.setBounds(20,500,150,25);
		playerO.setBounds(170, 500, 90,25);
		playerX.setBounds(260,500,90,25);
		
		window.add(_1);
		window.add(_2);
		window.add(_3);
		window.add(_4);
		window.add(_5);
		window.add(_6);
		window.add(_7);
		window.add(_8);
		window.add(_9);
		window.add(playerTurnStatus);
		window.add(winningStatus);
		window.add(playerO);
		window.add(playerX);
		window.add(exit);
		window.add(reStart);
		
		buttons[0] = _1;
		buttons[1] = _2;
		buttons[2] = _3;
		buttons[3] = _4;
		buttons[4] = _5;
		buttons[5] = _6;
		buttons[6] = _7;
		buttons[7] = _8;
		buttons[8] = _9;
		
		_1.setFont(font);
		_2.setFont(font);
		_3.setFont(font);
		_4.setFont(font);
		_5.setFont(font);
		_6.setFont(font);
		_7.setFont(font);
		_8.setFont(font);
		_9.setFont(font);
		playerTurnStatus.setFont(fontPlayerStatus);
		winningStatus.setFont(fontPlayerStatus);
		playerO.setFont(fontPlayerStatus);
		playerX.setFont(fontPlayerStatus);
		
		_1.addActionListener(this);
		_2.addActionListener(this);
		_3.addActionListener(this);
		_4.addActionListener(this);
		_5.addActionListener(this);
		_6.addActionListener(this);
		_7.addActionListener(this);
		_8.addActionListener(this);
		_9.addActionListener(this);
		exit.addActionListener(this);
		reStart.addActionListener(this);
		
		window.show();
	}
	
	public void actionPerformed(ActionEvent e){
		if(_1 == e.getSource()){
			setSymbol(_1);
		}else if(_2 == e.getSource()){
			setSymbol(_2);
		}else if(_3 == e.getSource()){
			setSymbol(_3);
		}else if(_4 == e.getSource()){
			setSymbol(_4);
		}else if(_5 == e.getSource()){
			setSymbol(_5);
		}else if(_6 == e.getSource()){
			setSymbol(_6);
		}else if(_7 == e.getSource()){
			setSymbol(_7);
		}else if(_8 == e.getSource()){
			setSymbol(_8);
		}else if(_9 == e.getSource()){
			setSymbol(_9);
		}else if(exit == e.getSource()){
			int value = JOptionPane.showConfirmDialog(window,"Are you sure?","End Game",JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
			if(value == 0){
				window.dispose();
			}
		}else if(reStart == e.getSource()){
			reStart();
		}
	}
	
	public void setSymbol(Button clicked){
		
		if(playerTurn){
			clicked.setLabel("O");
			playerTurn = false;
			clicked.setEnabled(false);
			clicked.setBackground(Color.orange);
			if(hasWon("O")){
				playerTurnStatus.setText("Player O Won");
				playerOWinningCount++;
				playerO.setText("O : "+playerOWinningCount);
				playerX.setText("X : "+playerXWinningCount);
				//tunePlayer();
				endGame("O");
			}else{
				playerTurnStatus.setText("Player X's Turn");
			}			
		}else{
			clicked.setLabel("X");
			playerTurn = true;
			clicked.setEnabled(false);
			clicked.setBackground(Color.blue);
			if(hasWon("X")){
				playerTurnStatus.setText("Player X Won");
				playerXWinningCount++;
				playerO.setText("O : "+playerOWinningCount);
			playerX.setText("X : "+playerXWinningCount);
			//tunePlayer();
				endGame("X");
			}else{
				playerTurnStatus.setText("Player O's Turn");
			}	
		}
	}
	
	public void tunePlayer(){
		try{
			URL url = new URL("file:music.wav");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		}catch(Exception e){
			System.out.println("Exception");
		}
	}
	private void reStart(){
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i].setEnabled(true);
			buttons[i].setBackground(Color.white);
			buttons[i].setLabel("");
		}
		
		playerO.setText("O : 0");
		playerX.setText("X : 0");
		playerOWinningCount = 0;
		playerXWinningCount = 0;
		playerTurn = true;
	}
	
	private boolean hasWon(String label){
		boolean result = false;
		if(isOkay(_1, _2, _3, label)){
			winColor(_1,_2,_3);
			result = true;
		}else if(isOkay(_4, _5, _6, label)){
			winColor(_4,_5,_6);
			result = true;
		}else if(isOkay(_7, _8, _9, label)){
			winColor(_7,_8,_9);
			result = true;
		}else if(isOkay(_1, _4, _7, label)){
			winColor(_1,_4,_7);
			result = true;
		}else if(isOkay(_2, _5, _8, label)){
			winColor(_2,_5,_8);
			result = true;
		}else if(isOkay(_3, _6, _9, label)){
			winColor(_3,_6,_9);
			result = true;
		}else if(isOkay(_1, _5, _9, label)){
			winColor(_1,_5,_9);
			result = true;
		}else if(isOkay(_3, _5, _7, label)){
			winColor(_3,_5,_7);
			result = true;
		}
		return result;
	}
	
	public void winColor(Button b1,Button b2,Button b3){
		b1.setBackground(Color.red);
		b2.setBackground(Color.red);
		b3.setBackground(Color.red);
	}
	private void endGame(String label){
		
		JOptionPane.showMessageDialog(window,"Player "+label+" won the Game");
		int value = JOptionPane.showConfirmDialog(window,"Do You want to play again?", "Confirm",JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
		if(value == 0){
			for(int i = 0; i < buttons.length; i++){
				buttons[i].setEnabled(true);
				buttons[i].setBackground(Color.white);
				buttons[i].setLabel("");
			}
			playerTurnStatus.setText("Player "+(label.equals("X")?"O":"X")+"'s Turn");
		}else{   
			for(int i = 0; i < buttons.length; i++){
				buttons[i].setEnabled(false);
			}
		}
		
	}
	
	private boolean isOkay(Button b1, Button b2, Button b3, String label){
		return (b1.getLabel().equals(label) && b2.getLabel().equals(label) && b3.getLabel().equals(label));
	}
	public static void main(String[] args){
		new TicTacTeo();
	}
}