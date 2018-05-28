package it.fab.model.factory;

public class ShapeFactory extends AbstractFactory {
	
	private static Shapes shape;

	
	public Shapes getShape(String shapeType){
		
		if(shapeType.equals("RECTANGLE"))
			shape =  new Rectangle();
		if(shapeType.equals("CIRLCE"))
			shape = new Circle();
		return shape;
	}


	@Override
	public Colors getColor(String colorType) {
		// TODO Auto-generated method stub
		return null;
	}

}
