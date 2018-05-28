package it.fab.model.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryClient {
	
	public static void main(String[] args){
		List<String> prova = new ArrayList<String>();
		prova.add("1000");
		prova.add("1001");
		prova.add("1000");
		prova.add("1001");
		Map provamap = new HashMap<String,String>();
		provamap.put("1000", "aaa");
		provamap.put("1000", "aea");
		provamap.put("1003", "aaag");
		provamap.put("1004", "aaag");
		System.out.println(prova.size());
		System.out.println("Maps" + provamap.size());
//		System.out.println("Oh i need a rectangle right now!");
//		Shapes shape  = ShapeFactory.getShape("RECTANGLE");
		
//		shape.draw();
	}

}
