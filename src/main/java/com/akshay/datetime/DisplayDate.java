package com.akshay.datetime;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class DisplayDate {

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		
		LocalDate ld = LocalDate.now();
		Month month = ld.getMonth();
		DayOfWeek dow = ld.getDayOfWeek();
		int dayOfMonth = ld.getDayOfMonth();
		int year = ld.getYear();
		String output;
		
		if(dayOfMonth == 1 || dayOfMonth == 21 || dayOfMonth == 31) {
			output = String.format("%s,  The %dst of %s, %d", dow, dayOfMonth, month, year);
		} 
		
		else if(dayOfMonth == 2 || dayOfMonth == 22) {
			output = String.format("%s,  The %dnd of %s, %d", dow, dayOfMonth, month, year);
		}
		
		else if (dayOfMonth == 3 || dayOfMonth == 23) {
			output = String.format("%s,  The %drd of %s, %d", dow, dayOfMonth, month, year);
		}
		
		else {
			output = String.format("%s,  The %dth of %s, %d", dow, dayOfMonth, month, year);
		}
		
		model.addAttribute("date", output);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
		
		model.addAttribute("time", sdf.format(date));
		
		return "time.jsp";
	}
}
