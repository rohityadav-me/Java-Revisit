package com.kristalball.challenge.model;

public class Subordinate {
   public String id;
   public int data;
   public Subordinate left;
   public Subordinate right;

   @Override
   public String toString(){
      return "id "+id+" data "+data;
   }
}
