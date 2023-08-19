package com.kristalball.challenge.view;

import java.util.List;

import com.kristalball.challenge.model.Subordinate;

public class SubordinateLine {
   public List<Subordinate> maxLine;
   public int totalBonus;

   @Override
   public String toString(){
      return "Total Bonus "+totalBonus+" maximumLine : " + maxLine;
   }
}
