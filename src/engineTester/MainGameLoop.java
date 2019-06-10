package engineTester;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.Car;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();		
		
		Light light = new Light(new Vector3f(0,600,-20), new Vector3f(1,1,1));
		
		Camera camera = new Camera();

		MasterRenderer renderer = new MasterRenderer();
		
		Terrain terrain = new Terrain(0,-0.5f,loader, new ModelTexture(loader.loadTexture("grass")));
		Terrain terrain2 = new Terrain(-0.5f,-0.5f,loader, new ModelTexture(loader.loadTexture("grass")));

		RawModel model = OBJLoader.loadObjModel("m3r", loader);
	
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("null")));
		ModelTexture texture = staticModel.getTexture();
		texture.setShineDamper(25);
		texture.setReflectivity(10);
		
		List<Car> cars = new ArrayList<Car>();
		
		for(int i = 0; i < 4; i++) {
		cars.add(new Car("BODY", "FLW", "FRW", "LRW", "RRW", "tire", "null", new Vector3f(-10,0,-25 - i*20), 0, -135, 0, 4));
		cars.add(new Car("BODY", "FLW", "FRW", "LRW", "RRW", "tire", "null", new Vector3f(10,0,-25 - i*20), 0, 135, 0, 4));
		
		}
		while(!Display.isCloseRequested())
		{
			for(Car car : cars) {
			car.render(renderer);
			}
			camera.move();
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}
	
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		
	}

}
