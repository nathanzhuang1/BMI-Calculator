//Header

//This class creates a GUI
//javax means Java extensions. 'Swing' sounds nice - marketing

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//'extends' means 'is-a' frame

public class BMICalculatorGUI extends JFrame implements ActionListener {
	
	//Declare and creating all the Swing objects. Camel case
	//Don't start with a capital letter due to class confusions
	JLabel heightLabel = new JLabel("Height");
	JLabel feetLabel = new JLabel("Feet");
	JLabel inchesLabel = new JLabel("Inches");
	JLabel weightLabel = new JLabel("Weight");
	JLabel poundsLabel = new JLabel("Pounds");
	
	JTextField feetTextField = new JTextField();
	JTextField inchesTextField = new JTextField();
	JTextField poundsTextField = new JTextField();
	
	JButton calculateButton = new JButton("Calculate");
	
	//ensure this is before the next function
	Font headingFont = new Font("Times New Roman", Font.BOLD, 28);
	
	
	//Constructor Method - very case sensitive
	//This method gets called when the GUI is created
	public BMICalculatorGUI() {
		
		//setup the frame
		setSize(500,500);
		setTitle("BMI Calculator");
		setLayout(null); //turn off the default Layout Manager
		
		//rgb
		Color myColour = new Color(72, 95, 100); 
		getContentPane().setBackground(myColour);
		setBackground(Color.RED);
		
		//add the Swing objects (components)
		heightLabel.setBounds(40, 0, 100, 200);
		heightLabel.setFont(headingFont);
		add(heightLabel);
		
		feetLabel.setBounds(100, 100, 100, 50);
		add(feetLabel);
		
		inchesLabel.setBounds(225, 100, 100, 50);
		add(inchesLabel);
		
		weightLabel.setBounds(40, 175, 100, 50);
		weightLabel.setFont(headingFont);
		add(weightLabel);
		
		poundsLabel.setBounds(100, 200, 100, 50);
		add(poundsLabel);
		
		//creating the text fields
		feetTextField.setBounds(25, 110, 70, 25);
		add(feetTextField);
		
		inchesTextField.setBounds(150, 110, 70, 25);
		add(inchesTextField);
		
		poundsTextField.setBounds(25, 210, 70, 25);
		add(poundsTextField);
		
		//button
		calculateButton.setBounds(25, 260, 100, 50);
		calculateButton.addActionListener(this);
		add (calculateButton);
		
		
		
		//show the frame
		setVisible(true);
		
		
	}

	//This method runs every time an event occurs (click)
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == calculateButton) {
			
			int feet = Integer.valueOf(feetTextField.getText());
			int inches = Integer.valueOf(inchesTextField.getText());
			int pounds = Integer.valueOf(poundsTextField.getText());
			
			double bmiValue;
			
			bmiValue = (pounds / Math.pow(feet * 12 + inches, 2)) * 703;
			
			String message = null;
			
			if(bmiValue < 18.5)
				message = "Underweight";
			else if (bmiValue >= 18.5 && bmiValue < 25)
				message = "Healthy Weight";
			
			
			String result = 
					String.format("%.2f - %s", bmiValue, message);
			
			//so if the user is overweight the 'String message = null' means empty
			
			JOptionPane.showMessageDialog(this, result);
			
		}
		
	}
	

}
