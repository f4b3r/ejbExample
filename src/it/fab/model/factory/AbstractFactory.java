package it.fab.model.factory;

public abstract class AbstractFactory {
	
	public abstract Colors getColor(String colorType);
	public abstract Shapes getShape(String shapeType);

}
