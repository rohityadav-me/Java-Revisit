package com.kristalball.challenge.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kristalball.challenge.model.Subordinate;

/*
* {"id":"SE1","data":10,"left":{"id":"SE2","data":12,"left":{"id":"SE4","data":4,"right":{"id":"SE8","data":9,"left":{"id":"SE15","data":20}}},"right":{"id":"SE5","data":17,"left":{"id":"SE9","data":10,"left":{"id":"SE16","data":8,"right":{"id":"SE17","data":18}}},"right":{"id":"SE10","data":11}}},"right":{"id":"SE3","data":7,"left":{"id":"SE6","data":6,"left":{"id":"SE11","data":18},"right":{"id":"SE12","data":2}},"right":{"id":"SE7","data":3,"left":{"id":"SE13","data":13},"right":{"id":"SE14","data":15}}}};
*/
public class InputProcessing {
    public static Subordinate processInput(String input){
		ObjectMapper objectMapper = new ObjectMapper();
		Subordinate rootSubordinate = null;
		try{
			JsonNode rootNode = objectMapper.readTree(input); 
			rootSubordinate = buildHierarchy(rootNode);
		}catch(JsonMappingException jsonMappingException){
			jsonMappingException.printStackTrace();
		}catch(JsonProcessingException jsonProcessingException){
			jsonProcessingException.printStackTrace();
		}catch(Exception generalException){
            generalException.printStackTrace();
        }
		return rootSubordinate;
	}
    private static Subordinate buildHierarchy(JsonNode node){
		Subordinate subordinate = new Subordinate();
		subordinate.id = node.get("id").asText();
		subordinate.data = node.get("data").asInt();
        
		if(node.has("left")){
			JsonNode leftNode = node.get("left");
			subordinate.left = buildHierarchy(leftNode);
		}
		if(node.has("right")){
			JsonNode rightNode = node.get("right");
			subordinate.right = buildHierarchy(rightNode);
		}
		return subordinate;
	}

    public static void printInput(Subordinate root){
		if(root==null)
			return;
		System.out.println(root.id+" "+root.data);
		printInput(root.left);
		printInput(root.right);
	}	
}
