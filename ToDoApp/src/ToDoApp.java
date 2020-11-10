//This is the main class of the ToDoList app.

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToDoApp {
	//Initialise Variables
	
	//Variable to iterate over and display the tasks saved in the database. "rows" means the amount of rows. 
	//Arrays for storing the output of the selectAll() method from the database to display tasks on the GUI.
	int rows;
	ArrayList<String> savedTasks = new ArrayList<String>();
	JLabel[] tasks = new JLabel[11];
	String list;
	int position_Y_axis = 130;
	
	//Variables for getting and formatting the date
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
	String formattedDate=sdf.format(today); 
	
	//Initial Variables to display on GUI
	private JFrame frmTodoapp;
	JTextField taskInputText;
	JLabel task1;
	JLabel task2;
	JLabel task3;
	JLabel task4;
	JLabel task5;
	JLabel task6;
	JLabel task7;
	JLabel task8;
	JLabel task9;
	JLabel task10;
	JLabel task11;
	private JButton deleteTask1Button;
	private JButton deleteTask2Button;
	private JButton deleteTask3Button;
	private JButton deleteTask4Button;
	private JButton deleteTask5Button;
	private JButton deleteTask6Button;
	private JButton deleteTask7Button;
	private JButton deleteTask8Button;
	private JButton deleteTask9Button;
	private JButton deleteTask10Button;
	private JButton deleteAllButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoApp window = new ToDoApp();
					window.frmTodoapp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	
	public ToDoApp() {
		initialize();
		dbConnection.dbConnector();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		//Initialise frame.
		frmTodoapp = new JFrame();
		frmTodoapp.setTitle("ToDoApp");
		frmTodoapp.setBounds(100, 100, 900, 600);
		frmTodoapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTodoapp.getContentPane().setLayout(null);
		
		//Select all current tasks from database and store them as strings in arraylist.
		savedTasks = ToDoAppDB.selectAll();
		
		//Loop through the tasks database and create new JLabels to display the tasks in the correct position of the GUI.
		for(int i=0; i<savedTasks.size(); i++) {
			list = savedTasks.get(i).substring(1, 12) + "               " + savedTasks.get(i).substring(12);
			tasks[i] = new JLabel(list);
			tasks[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
			tasks[i].setBounds(108, position_Y_axis, 300, 14);
			frmTodoapp.getContentPane().add(tasks[i]);
			position_Y_axis = position_Y_axis + 30;
		}
		
		
		
		//Display the contents of the GUI.
		JLabel Date = new JLabel("Date: " + formattedDate);
		Date.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Date.setBounds(10, 30, 205, 25);
		frmTodoapp.getContentPane().add(Date);
		
		JLabel taskLabel = new JLabel("Tasks:");
		taskLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		taskLabel.setBounds(10, 80, 74, 25);
		frmTodoapp.getContentPane().add(taskLabel);
		
		JLabel newTaskLabel = new JLabel("New Task: ");
		newTaskLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		newTaskLabel.setBounds(236, 22, 121, 40);
		frmTodoapp.getContentPane().add(newTaskLabel);
		
		taskInputText = new JTextField();
		taskInputText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		taskInputText.setBounds(353, 31, 400, 30);
		frmTodoapp.getContentPane().add(taskInputText);
		taskInputText.setColumns(10);
		
		JLabel dateOfEnteryLabel = new JLabel("Date of Entry");
		dateOfEnteryLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateOfEnteryLabel.setBounds(108, 91, 117, 14);
		frmTodoapp.getContentPane().add(dateOfEnteryLabel);
		
		JLabel taskListLabel = new JLabel("Task");
		taskListLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		taskListLabel.setBounds(266, 91, 56, 14);
		frmTodoapp.getContentPane().add(taskListLabel);
		
		
		//Button and functionality to add new tasks to the database.
		JButton addTask = new JButton("+");
		
		//Action listener for the add button.
		addTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == addTask) {
					
					//Get task and date
					String newTask = taskInputText.getText();
			    	String newDate = formattedDate;
			    	
			    	//Create new instance of ToDoAppDB() object to use functionality of database commands. In this case the
			    	//insert() and countRows() methods.
			    	ToDoAppDB DBCommand = new ToDoAppDB();
					rows = DBCommand.countRows();
					DBCommand.insert(rows, newDate, newTask);
					
					//Display all the tasks from the database on the GUI.
					switch(rows) {
					  case 0:
						  task1.setText(formattedDate + "               " + newTask);
					    break;
					  case 1:
						  task2.setText(formattedDate + "               " + newTask);
					    break;
					  case 2:
						  task3.setText(formattedDate + "               " + newTask);
					    break;
					  case 3:
						  task4.setText(formattedDate + "               " + newTask);
					    break;
					  case 4:
						  task5.setText(formattedDate + "               " + newTask);
					    break;
					  case 5:
						  task6.setText(formattedDate + "               " + newTask);
					    break;
					  case 6:
						  task7.setText(formattedDate + "               " + newTask);
					    break;
					  case 7:
						  task8.setText(formattedDate + "               " + newTask);
					    break;
					  case 8:
						  task9.setText(formattedDate + "               " + newTask);
					    break;
					  case 9:
						  task10.setText(formattedDate + "               " + newTask);
					    break;
					  case 10:
						  task11.setText("No more Tasks Available");
					    break;
					  default:
						  System.out.println("All tasks used");
					}				
				}
			}
		});
		//Parameters to style and display the add task button
		addTask.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addTask.setBounds(773, 30, 56, 32);
		frmTodoapp.getContentPane().add(addTask);
		
		
		//JLabels to display the tasks
		task1 = new JLabel();
		task1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task1.setBounds(110, 130, 700, 14);
		frmTodoapp.getContentPane().add(task1);
		
		task2 = new JLabel();
		task2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task2.setBounds(110, 160, 700, 14);
		frmTodoapp.getContentPane().add(task2);
		
		task3 = new JLabel();
		task3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task3.setBounds(110, 190, 300, 14);
		frmTodoapp.getContentPane().add(task3);
		
		task4 = new JLabel();
		task4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task4.setBounds(110, 220, 300, 14);
		frmTodoapp.getContentPane().add(task4);
		
		task5 = new JLabel();
		task5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task5.setBounds(110, 250, 300, 14);
		frmTodoapp.getContentPane().add(task5);
		
		task6 = new JLabel();
		task6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task6.setBounds(110, 280, 300, 14);
		frmTodoapp.getContentPane().add(task6);
		
		task7 = new JLabel();
		task7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task7.setBounds(108, 310, 300, 14);
		frmTodoapp.getContentPane().add(task7);
		
		task8 = new JLabel();
		task8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task8.setBounds(108, 340, 300, 14);
		frmTodoapp.getContentPane().add(task8);
		
		task9 = new JLabel();
		task9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task9.setBounds(108, 370, 300, 14);
		frmTodoapp.getContentPane().add(task9);
		
		task10 = new JLabel();
		task10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task10.setBounds(108, 400, 300, 14);
		frmTodoapp.getContentPane().add(task10);
		
		task11 = new JLabel();
		task11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		task11.setBounds(108, 430, 300, 14);
		frmTodoapp.getContentPane().add(task11);
		
		//Buttons to delete the selected tasks from the database.
		//Delete button 1.
		deleteTask1Button = new JButton("X");
		deleteTask1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == deleteTask1Button) {
					
					ToDoAppDB.delete(0);
					task1.setFont(new Font("SuperFrench", Font.PLAIN, 16));
					tasks[0].setFont(new Font("SuperFrench", Font.PLAIN, 16));
				}
			}
		});
		deleteTask1Button.setBounds(10, 122, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask1Button);
		
		
		
		//Delete button 2.
		deleteTask2Button = new JButton("X");
		deleteTask2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(1);
				task2.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[1].setFont(new Font("SuperFrench", Font.PLAIN, 16));
				
			}
		});
		deleteTask2Button.setBounds(10, 152, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask2Button);
		
		
		
		//Delete button 3.
		deleteTask3Button = new JButton("X");
		deleteTask3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(2);
				task3.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[2].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask3Button.setBounds(10, 184, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask3Button);
		
		
		//Delete button 4.
		deleteTask4Button = new JButton("X");
		deleteTask4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(3);
				task4.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[3].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask4Button.setBounds(10, 214, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask4Button);
		
		
		//Delete button 5.
		deleteTask5Button = new JButton("X");
		deleteTask5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(4);
				task5.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[4].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask5Button.setBounds(10, 246, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask5Button);
		
		
		//Delete button 6.
		deleteTask6Button = new JButton("X");
		deleteTask6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(5);
				task6.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[5].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask6Button.setBounds(10, 276, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask6Button);
		
		
		//Delete button 7.
		deleteTask7Button = new JButton("X");
		deleteTask7Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ToDoAppDB.delete(6);
				task7.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[6].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask7Button.setBounds(10, 306, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask7Button);
		
		
		//Delete button 8.
		deleteTask8Button = new JButton("X");
		deleteTask8Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ToDoAppDB.delete(7);
				task8.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[7].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask8Button.setBounds(10, 334, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask8Button);
		
		
		//Delete button 9.
		deleteTask9Button = new JButton("X");
		deleteTask9Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(8);
				task9.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[8].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask9Button.setBounds(10, 364, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask9Button);
		
		
		//Delete button 10.
		deleteTask10Button = new JButton("X");
		deleteTask10Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ToDoAppDB.delete(9);
				task10.setFont(new Font("SuperFrench", Font.PLAIN, 16));
				tasks[9].setFont(new Font("SuperFrench", Font.PLAIN, 16));
			}
		});
		deleteTask10Button.setBounds(10, 394, 45, 23);
		frmTodoapp.getContentPane().add(deleteTask10Button);
		
		
		//Button to clear the database
		deleteAllButton = new JButton("Delete All");
		deleteAllButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToDoAppDB.deleteAll();
				deleteAllButton.setText("All Tasks Deleted");
				deleteAllButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
		});
		deleteAllButton.setBounds(681, 513, 160, 23);
		frmTodoapp.getContentPane().add(deleteAllButton);
		
		
		//JLabels to display task numbers
		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(65, 130, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(65, 160, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(65, 190, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("4.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(65, 220, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("5.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(65, 250, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("6.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(65, 280, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("7.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(65, 310, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("8.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(65, 340, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("9.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(65, 370, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("10.");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(65, 400, 46, 14);
		frmTodoapp.getContentPane().add(lblNewLabel_9);
		
	}
}

