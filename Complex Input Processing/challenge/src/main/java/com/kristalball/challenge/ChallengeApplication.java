package com.kristalball.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kristalball.challenge.view.Result;
import com.kristalball.challenge.model.Subordinate;
import com.kristalball.challenge.utility.FindAchievers;
import com.kristalball.challenge.utility.InputProcessing;

/*
 * In console give first input as
 * {"id":"SE1","data":10,"left":{"id":"SE2","data":12,"left":{"id":"SE4","data":4,"right":{"id":"SE8","data":9,"left":{"id":"SE15","data":20}}},"right":{"id":"SE5","data":17,"left":{"id":"SE9","data":10,"left":{"id":"SE16","data":8,"right":{"id":"SE17","data":18}}},"right":{"id":"SE10","data":11}}},"right":{"id":"SE3","data":7,"left":{"id":"SE6","data":6,"left":{"id":"SE11","data":18},"right":{"id":"SE12","data":2}},"right":{"id":"SE7","data":3,"left":{"id":"SE13","data":13},"right":{"id":"SE14","data":15}}}};
 * 3000000
 * 
 * even input of json wihout semicolon at the end also works
 */
@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) throws IOException{
		// SpringApplication.run(ChallengeApplication.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		// System.out.println(input);
		long bonus = Long.parseLong(br.readLine());
		
		Subordinate rootInput = InputProcessing.processInput(input);
		// InputProcessing.printInput(rootInput);

		List<Result> lineWithHighestSalesBonus = FindAchievers.lineWithHighestSales(rootInput,bonus); 
		for(int i=0;i<lineWithHighestSalesBonus.size();i++){
			System.out.println(lineWithHighestSalesBonus.get(i).id +" "+lineWithHighestSalesBonus.get(i).bonus);
		}
	}
}

