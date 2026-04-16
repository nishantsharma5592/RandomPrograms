/*
* The intent is to create a minimal function JFrame using draggable buttons and fixed JPanels.
* Learning objectives: 
* 1. To understand how to set up a Swing application
* 2. How to create frames, panels, buttons etc. and how to do their placement [on a frame]
* 3. How to change properties of a panel, or a button, etc. on mouse events
* 4. How to drag a particular component along the frame; and to locate it after re-placement
* 5. Set up a basic minimal functional application
*/

/*
* What to do: There are four draggable buttons +, -, *, and / kept on the top-center of the frame. Drag the appropriate
* operator to the middle empty box and complete the equation.	
*/

/*
* Since, the equation 5 _ 7 = -2 is fixed; only the minus button achieves the success condition.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.event.MouseInputAdapter;

class ABasicMinimalSwingApplication{

	Point location;
	Point new_location;
	MouseEvent mouse_pressed;
	
	boolean button_minus_correctly_placed = false;
	
	private void setUpGUI(){
		JFrame frame = new JFrame("Complete the Equation.");
		frame.setName("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
		// Start setting up draggable buttons:
		JButton button_plus = new JButton("+");
		button_plus.setName("Button plus");
		button_plus.setSize(45, 45);
	
		// By trial and error; i figured out [with the help of Internet]
		// that in order to implement a draggable aspect
		// on a button [inside a complex application], it is best
		// to implement separate addMouseListener and
		// addMouseMotionListener adapters
		
		button_plus.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent mp){
			mouse_pressed = mp;
			}

		});

		button_plus.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent me){
				Component component = me.getComponent();
				location = component.getLocation(location);
		
				// -> The following lines of code correctly give the new location on drag
				// -> I did not find it extremely useful to understand this at a deeper 
				// -> level for my simple use case
				// System.out.println("Component's old location:" + location);

				int delta_x = me.getX() - mouse_pressed.getX();
				int delta_y = me.getY() - mouse_pressed.getY();

				int x = location.x + delta_x;
				int y = location.y + delta_y;
		
				component.setLocation(x, y);
				new_location = component.getLocation(new_location);
				// System.out.println("Component's new location:" + new_location);
				
				// It is this motion listener that should check if we have reached
				// our success condition
				// Button plus does not achieve the success condition
				
			}
		});
		
		JButton button_minus = new JButton("-");
		button_minus.setName("Button minus");
		button_minus.setSize(45, 45);
		
		button_minus.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent mp){
			mouse_pressed = mp;
			}

		});

		button_minus.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent me){
				Component component = me.getComponent();
				location = component.getLocation(location);
		
				// -> The following lines of code correctly give the new location on drag
				// -> I did not find it extremely useful to understand this at a deeper 
				// -> level for my simple use case
				// System.out.println("Component's old location:" + location);

				int delta_x = me.getX() - mouse_pressed.getX();
				int delta_y = me.getY() - mouse_pressed.getY();

				int x = location.x + delta_x;
				int y = location.y + delta_y;
		
				component.setLocation(x, y);
				new_location = component.getLocation(new_location);
				// System.out.println("Component's new location:" + new_location);
				
				button_minus_correctly_placed = false;
				
				// It is this motion listener that should check if we have reached
				// our success condition
				
				// When the minus button is correctly placed, we update the 
				// button_minus_correctly_placed flag
				
				if ((new_location.getX() >= 120) && (new_location.getX() <= 180) && (new_location.getY() >= 250) && (new_location.getY() <= 370)) {
					button_minus_correctly_placed = true;
				}
				
			}
		});
		
		
		JButton button_multiply = new JButton("*");
		button_multiply.setName("Button multiply");
		button_multiply.setSize(45, 45);
		
		button_multiply.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent mp){
			mouse_pressed = mp;
			}

		});

		button_multiply.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent me){
				Component component = me.getComponent();
				location = component.getLocation(location);
		
				// -> The following lines of code correctly give the new location on drag
				// -> I did not find it extremely useful to understand this at a deeper 
				// -> level for my simple use case
				// System.out.println("Component's old location:" + location);

				int delta_x = me.getX() - mouse_pressed.getX();
				int delta_y = me.getY() - mouse_pressed.getY();

				int x = location.x + delta_x;
				int y = location.y + delta_y;
		
				component.setLocation(x, y);
				new_location = component.getLocation(new_location);
				// System.out.println("Component's new location:" + new_location);
				
				// It is this motion listener that should check if we have reached
				// our success condition
				// Button multiply does not achieve the success condition
				
			}
		});
		
		JButton button_divide = new JButton("/");
		button_divide.setName("Button divide");
		button_divide.setSize(45, 45);
		
		button_divide.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent mp){
			mouse_pressed = mp;
			}

		});

		button_divide.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent me){
				Component component = me.getComponent();
				location = component.getLocation(location);
		
				// -> The following lines of code correctly give the new location on drag
				// -> I did not find it extremely useful to understand this at a deeper 
				// -> level for my simple use case
				// System.out.println("Component's old location:" + location);

				int delta_x = me.getX() - mouse_pressed.getX();
				int delta_y = me.getY() - mouse_pressed.getY();

				int x = location.x + delta_x;
				int y = location.y + delta_y;
		
				component.setLocation(x, y);
				new_location = component.getLocation(new_location);
				// System.out.println("Component's new location:" + new_location);
				
				// It is this motion listener that should check if we have reached
				// our success condition
				// Button divide does not achieve the success condition				
			}
		});

		// The rest of the GUI:

		JPanel main_panel = new JPanel();
		main_panel.setName("Main Panel");
		
		// I have decided to use absolute free positioning of all components
		// by setting the layout manager to null
		main_panel.setLayout(null);
		
		// Add draggable buttons to main_panel. 
		
		button_plus.setLocation(200, 30);
		button_plus.setFocusPainted(false);
		main_panel.add(button_plus);
		
		button_minus.setLocation(250, 30);
		button_minus.setFocusPainted(false);
		main_panel.add(button_minus);
		
		button_multiply.setLocation(200, 90);
		button_multiply.setFocusPainted(false);
		main_panel.add(button_multiply);
		
		button_divide.setLocation(250, 90);
		button_divide.setFocusPainted(false);
		main_panel.add(button_divide);
		
		JTextField text_field_five=new JTextField(1);
		text_field_five.setText("5");
		text_field_five.setSize(30, 30);
		text_field_five.setLocation(60, 280);
		
		JPanel rect_panel=new JPanel(){
    			@Override
    			protected void paintComponent(Graphics g){
    				super.paintComponent(g);
    				g.drawRect(10, 10, 60, 60); 
    			}
		};
		
		rect_panel.setSize(120, 120);
		rect_panel.setLocation(120, 250);
		
		JTextField text_field_seven=new JTextField(1);
		text_field_seven.setText("7");
		text_field_seven.setSize(30, 30);
		text_field_seven.setLocation(220, 280);
		
		JButton button_equal_to = new JButton("=");
		button_equal_to.setName("Button equal to");
		button_equal_to.setSize(45, 45);
		button_equal_to.setFocusPainted(false);
		button_equal_to.setLocation(280, 270);		

		button_equal_to.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mp){
				if (button_minus_correctly_placed == true){
					System.out.println("Success!");
					button_minus_correctly_placed = false;
				}
			}

		});
		
		JTextField text_field_result=new JTextField(2);
		text_field_result.setText("-2");
		text_field_result.setSize(30, 30);
		text_field_result.setLocation(360, 280);
		
		main_panel.add(text_field_five);
		main_panel.add(text_field_seven);
		main_panel.add(rect_panel);
		main_panel.add(button_equal_to);
		main_panel.add(text_field_result);
		
		frame.add(main_panel);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		// System.out.println("Hello World!");
		ABasicMinimalSwingApplication object = new ABasicMinimalSwingApplication();
		object.setUpGUI();
	}
}