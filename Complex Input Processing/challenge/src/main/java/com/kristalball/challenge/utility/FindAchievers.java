package com.kristalball.challenge.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kristalball.challenge.model.Subordinate;
import com.kristalball.challenge.view.Result;
import com.kristalball.challenge.view.SubordinateLine;

public class FindAchievers {
    public static List<Result> lineWithHighestSales(Subordinate root, long bonus){
		SubordinateLine maxLineofSubordiantes = getLine(root);
        // System.out.println(maxLineofSubordiantes);
		List<Subordinate> listOfAchievers = maxLineofSubordiantes.maxLine;
		Collections.reverse(listOfAchievers);
        System.out.println(listOfAchievers);
		long BudgeEfficiency = (bonus/100)*25;
		long SalesEfficiency = (bonus/100)*75;
		int numberOfSubordiantes = listOfAchievers.size()-1;
		int totalSubordinates = (numberOfSubordiantes*(numberOfSubordiantes+1))/2;
		BudgeEfficiency = BudgeEfficiency/totalSubordinates;
		SalesEfficiency = SalesEfficiency/maxLineofSubordiantes.totalBonus;
		List<Result> answer = new ArrayList<>();
        
		for(int i=0;i<listOfAchievers.size();i++){
			Result temp = new Result();
			temp.id = listOfAchievers.get(i).id;
			int calculateBonus = 0;
			calculateBonus = (int)BudgeEfficiency*(listOfAchievers.size()-(i+1));
			calculateBonus = calculateBonus + (int)(SalesEfficiency*listOfAchievers.get(i).data);
            temp.bonus = calculateBonus;
			answer.add(temp);
		}
		return answer;
	}    
    private static SubordinateLine getLine(Subordinate root){
		if(root==null)
			return null;
		SubordinateLine left = getLine(root.left);
		SubordinateLine right = getLine(root.right);
		SubordinateLine result = null;
		if(left==null && right==null){
			result = new SubordinateLine();
			result.maxLine = new ArrayList<>();
			result.maxLine.add(root);
			result.totalBonus = 0;
			result.totalBonus += root.data;
		}else if(left!=null && right!=null){
			if(left.totalBonus>right.totalBonus){
				result = left;
				result.maxLine.add(root);
				result.totalBonus += root.data;
			}else{
				result = right;
				result.maxLine.add(root);
				result.totalBonus += root.data;
			}
		}else if(left!=null){
			result = left;
			result.maxLine.add(root);
			result.totalBonus += root.data;
		}else if(right!=null){
			result = right;
			result.maxLine.add(root);
			result.totalBonus += root.data;
		}
		return result;
	}
}
