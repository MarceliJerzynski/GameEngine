package models;

import org.lwjgl.util.vector.Vector3f;

import entities.Entity;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import textures.ModelTexture;

public class Car {
		public Entity Body,FLW,FRW,LRW,RRW;
		public Car(String BodyfileName,
				String FLWfileName,
				String FRWfileName,
				String LRWfileName,
				String RRWfileName,
				String WheelTexture,
				String Bodytexture,
				Vector3f position,
				float rotX,
				float rotY,
				float rotZ,
				float scale)
		{
			Loader loader = new Loader();	
			this.Body=new Entity(new TexturedModel(OBJLoader.loadObjModel(BodyfileName, loader), new ModelTexture(loader.loadTexture(Bodytexture))), position,rotX,rotY,rotZ,scale);
			this.FLW=new Entity(new TexturedModel(OBJLoader.loadObjModel(FLWfileName, loader), new ModelTexture(loader.loadTexture(WheelTexture))), position,rotX,rotY,rotZ,scale);
			this.FRW=new Entity(new TexturedModel(OBJLoader.loadObjModel(FRWfileName, loader), new ModelTexture(loader.loadTexture(WheelTexture))), position,rotX,rotY,rotZ,scale);
			this.LRW=new Entity(new TexturedModel(OBJLoader.loadObjModel(LRWfileName, loader), new ModelTexture(loader.loadTexture(WheelTexture))), position,rotX,rotY,rotZ,scale);
			this.RRW=new Entity(new TexturedModel(OBJLoader.loadObjModel(RRWfileName, loader), new ModelTexture(loader.loadTexture(WheelTexture))), position,rotX,rotY,rotZ,scale);
		}
		
		public void render(MasterRenderer renderer) {
			renderer.processEntity(Body);
			renderer.processEntity(FLW);
			renderer.processEntity(FRW);
			renderer.processEntity(LRW);
			renderer.processEntity(RRW);
		}
		
		public void movecar(int x,int y, int z)
		{
			
		}
		
		public Entity getBody() {
			return Body;
		}
		public Entity getFLW() {
			return FLW;
		}
		public Entity getFRW() {
			return FRW;
		}
		public Entity getLRW() {
			return LRW;
		}
		public Entity getRRW() {
			return RRW;
		}
		
	}

