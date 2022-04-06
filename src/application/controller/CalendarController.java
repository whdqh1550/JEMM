package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CalendarController implements Initializable{

    @FXML
    private Label d52;

    @FXML
    private Label d51;

    @FXML
    private HBox b12;

    @FXML
    private Label d54;

    @FXML
    private HBox b11;

    @FXML
    private Label d53;

    @FXML
    private HBox b14;

    @FXML
    private Label d56;

    @FXML
    private HBox b13;

    @FXML
    private Label d55;

    @FXML
    private HBox b16;

    @FXML
    private HBox b15;

    @FXML
    private Label d57;

    @FXML
    private HBox b17;

    @FXML
    private Label Saturday;

    @FXML
    private HBox b21;

    @FXML
    private HBox b23;

    @FXML
    private HBox b22;

    @FXML
    private HBox b25;

    @FXML
    private HBox b24;

    @FXML
    private HBox b27;

    @FXML
    private HBox b26;

    @FXML
    private Label a11;

    @FXML
    private HBox b32;

    @FXML
    private HBox b31;

    @FXML
    private Label a13;

    @FXML
    private HBox b34;

    @FXML
    private Label a12;

    @FXML
    private HBox b33;

    @FXML
    private Label a15;

    @FXML
    private HBox b36;

    @FXML
    private Label a14;

    @FXML
    private HBox b35;

    @FXML
    private Label a17;

    @FXML
    private Label a16;

    @FXML
    private HBox b37;

    @FXML
    private HBox b41;

    @FXML
    private Label a22;

    @FXML
    private HBox b43;

    @FXML
    private Label a21;

    @FXML
    private HBox b42;

    @FXML
    private Label a24;

    @FXML
    private HBox b45;

    @FXML
    private Label a23;

    @FXML
    private HBox b44;

    @FXML
    private Label a26;

    @FXML
    private HBox b47;

    @FXML
    private Label a25;

    @FXML
    private HBox b46;

    @FXML
    private Label a27;

    @FXML
    private Label Thursday;

    @FXML
    private Label a31;

    @FXML
    private HBox b52;

    @FXML
    private HBox b51;

    @FXML
    private Label a33;

    @FXML
    private HBox b54;

    @FXML
    private Label a32;

    @FXML
    private HBox b53;

    @FXML
    private Label a35;

    @FXML
    private HBox b56;

    @FXML
    private Label a34;

    @FXML
    private HBox b55;

    @FXML
    private Label Monday;

    @FXML
    private Label d12;

    @FXML
    private Label a37;

    @FXML
    private Label d11;

    @FXML
    private Label a36;

    @FXML
    private HBox b57;

    @FXML
    private Label d14;

    @FXML
    private Label d13;

    @FXML
    private Label d16;

    @FXML
    private Label d15;

    @FXML
    private Label d17;

    @FXML
    private Label Friday;

    @FXML
    private Label monthDisplay;

    @FXML
    private Label a42;

    @FXML
    private Label a41;

    @FXML
    private Label a44;

    @FXML
    private Label a43;

    @FXML
    private Label d21;

    @FXML
    private Label a46;

    @FXML
    private Label a45;

    @FXML
    private Label d23;

    @FXML
    private Label d22;

    @FXML
    private Label a47;

    @FXML
    private Label d25;

    @FXML
    private Label d24;

    @FXML
    private Label d27;

    @FXML
    private Label d26;

    @FXML
    private Label Sunday;

    @FXML
    private Label Wednesday;

    @FXML
    private Label a51;

    @FXML
    private Label a53;

    @FXML
    private Label a52;

    @FXML
    private Label a55;

    @FXML
    private Label a54;

    @FXML
    private Label d32;

    @FXML
    private Label a57;

    @FXML
    private Label d31;

    @FXML
    private Label a56;

    @FXML
    private Label d34;

    @FXML
    private Label d33;

    @FXML
    private Label d36;

    @FXML
    private Label d35;

    @FXML
    private Label d37;

    @FXML
    private Label Tuesday;

    @FXML
    private Label d41;

    @FXML
    private Label d43;

    @FXML
    private Label d42;

    @FXML
    private Label d45;

    @FXML
    private Label d44;

    @FXML
    private Label d47;

    @FXML
    private Label d46;
    @FXML
    private Label d61;
    @FXML
    private Label d62;
    @FXML
    private Label d63;
    @FXML
    private Label d64;
    @FXML
    private Label d65;
    @FXML
    private Label d66;
    @FXML
    private Label d67;
    @FXML
    private Label a61;
    @FXML
    private Label a62;
    @FXML
    private Label a63;
    @FXML
    private Label a64;
    @FXML
    private Label a65;
    @FXML
    private Label a66;
    @FXML
    private Label a67;
    @FXML
    private HBox b61;
    @FXML
    private HBox b62;
    @FXML
    private HBox b63;
    @FXML
    private HBox b64;
    @FXML
    private HBox b65;
    @FXML
    private HBox b66;
    @FXML
    private HBox b67;
    
    @FXML 
    private Label yearDisplay;
    
    LocalDate date = LocalDate.now().withDayOfMonth(1);
    int month = date.getMonthValue();
    int year = date.getYear();
    
    String[] months = {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
    
    

    ArrayList<Label> aCalendar = new ArrayList<Label>();
    ArrayList<Label> dCalendar = new ArrayList<Label>();
    int mCounter = 0;
    
    
    
    
    
    
    

    @FXML
    void prevMonth(ActionEvent event) {
    	
    	mCounter--;
    	monthWriter(month+mCounter);
    	dateWriter(month+mCounter,date.minusMonths(1));
    }
    @FXML
    void nextMonth(ActionEvent event) {
    	mCounter++;
    	monthWriter(month+mCounter);
    	dateWriter(month+mCounter,date.plusMonths(1));
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		monthWriter(month);
		dateWriter(month,date);
		
		
		
		
			
			
		
		
	}
	void monthWriter(int dmonth) {
		if(dmonth >12) {
			month = 1;
			dmonth = 1;
			mCounter = 0;
			year++;
		}
		if(dmonth <1) {
			month = 12;
			dmonth = 12;
			mCounter = 0;
			year--;
		}
		monthDisplay.setText(months[dmonth-1]);
		yearDisplay.setText(""+year);
	}
	
	void dateWriter(int month,LocalDate upDatedate) {
		date = upDatedate;
		int startingDay = starter(date.getDayOfWeek().toString());
		int [] tDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int [] LeaptDays = {31,29,31,30,31,30,31,31,30,31,30,31};
		int counter = 1;
		arrayadder();
		
		if(date.isLeapYear()) {
			for(int i = 0 ; i < 42;i++) {
				if(i < startingDay) {
					aCalendar.get(i).setText("");
					dCalendar.get(i).setText("");
				}
				else if(counter > LeaptDays[month-1]) {
					dCalendar.get(i).setText("");
					aCalendar.get(i).setText("");
				}
				else {
					dCalendar.get(i).setText(""+counter);
					aCalendar.get(i).setText("testing");
					counter++;
				}
			}
		}
		else {
			for(int i = 0 ; i < 42;i++) {
				if(i < startingDay) {
					dCalendar.get(i).setText("");
					aCalendar.get(i).setText("");
				}
				else if(counter > tDays[month-1]) {
					dCalendar.get(i).setText("");
					aCalendar.get(i).setText("");
				}
				else {
					dCalendar.get(i).setText(""+counter);
					aCalendar.get(i).setText("testing");// gotta put capacity of that day.
					counter++;// brings the date that matches with counter, cause counter is the date. 
				}
				
			}
			
		}
		
	}
	
	int starter(String day) {
		int picker = 1;
		switch(day.toUpperCase()) {
			case "SUNDAY":
				picker = 0;
				break;
			case "MONDAY":
				picker = 1;
				break;
			case "TUESDAY":
				picker = 2;
				break;
			case "WEDNESDAY":
				picker = 3;
				break;
			case "THURSDAY":
				picker = 4;
				break;
			case "FRIDAY":
				picker = 5;
				break;
			case "SATURDAY":
				picker = 6;
				break;
			default: picker = 0;
				break;
			
		}
		
		
		return picker;
		
	}
	void arrayadder() {
		dCalendar.add(d11);
		dCalendar.add(d12);
		dCalendar.add(d13);
		dCalendar.add(d14);
		dCalendar.add(d15);
		dCalendar.add(d16);
		dCalendar.add(d17);
		dCalendar.add(d21);
		dCalendar.add(d22);
		dCalendar.add(d23);
		dCalendar.add(d24);
		dCalendar.add(d25);
		dCalendar.add(d26);
		dCalendar.add(d27);
		dCalendar.add(d31);
		dCalendar.add(d32);
		dCalendar.add(d33);
		dCalendar.add(d34);
		dCalendar.add(d35);
		dCalendar.add(d36);
		dCalendar.add(d37);
		dCalendar.add(d41);
		dCalendar.add(d42);
		dCalendar.add(d43);
		dCalendar.add(d44);
		dCalendar.add(d45);
		dCalendar.add(d46);
		dCalendar.add(d47);
		dCalendar.add(d51);
		dCalendar.add(d52);
		dCalendar.add(d53);
		dCalendar.add(d54);
		dCalendar.add(d55);
		dCalendar.add(d56);
		dCalendar.add(d57);
		aCalendar.add(a11);/////////////
		aCalendar.add(a12);
		aCalendar.add(a13);
		aCalendar.add(a14);
		aCalendar.add(a15);
		aCalendar.add(a16);
		aCalendar.add(a17);
		aCalendar.add(a21);
		aCalendar.add(a22);
		aCalendar.add(a23);
		aCalendar.add(a24);
		aCalendar.add(a25);
		aCalendar.add(a26);
		aCalendar.add(a27);
		aCalendar.add(a31);
		aCalendar.add(a32);
		aCalendar.add(a33);
		aCalendar.add(a34);
		aCalendar.add(a35);
		aCalendar.add(a36);
		aCalendar.add(a37);
		aCalendar.add(a41);
		aCalendar.add(a42);
		aCalendar.add(a43);
		aCalendar.add(a44);
		aCalendar.add(a45);
		aCalendar.add(a46);
		aCalendar.add(a47);
		aCalendar.add(a51);
		aCalendar.add(a52);
		aCalendar.add(a53);
		aCalendar.add(a54);
		aCalendar.add(a55);
		aCalendar.add(a56);
		aCalendar.add(a57);
		dCalendar.add(d61);
		dCalendar.add(d62);
		dCalendar.add(d63);
		dCalendar.add(d64);
		dCalendar.add(d65);
		dCalendar.add(d66);
		dCalendar.add(d67);
		aCalendar.add(a61);
		aCalendar.add(a62);
		aCalendar.add(a63);
		aCalendar.add(a64);
		aCalendar.add(a65);
		aCalendar.add(a66);
		aCalendar.add(a67);
		
		
		
		
	}

}
