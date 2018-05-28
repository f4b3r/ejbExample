package it.fab.model.factory;

public class ColorFactory extends AbstractFactory{
	
	private static Colors color;
	
	public Colors getColor(String colorType){
		if(colorType.equals("BLUE"))
			color = new Blue();
		if(colorType.equals("RED"))
			color=  new Red();
		
		return color;
	}

	@Override
	public Shapes getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}

}
