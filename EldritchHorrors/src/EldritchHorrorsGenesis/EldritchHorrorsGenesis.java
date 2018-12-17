package EldritchHorrorsGenesis;

import java.awt.Color;
import java.util.Random;

public class EldritchHorrorsGenesis {
   static Color fore = StdDraw.MAGENTA;
   static Color back = StdDraw.BLACK;
   static Random random = new Random();
   static double orbPosX;
   static double orbNegX;
   static double orbPosY;
   static double orbNegY;
   public EldritchHorrorsGenesis() {
      orbPosX = .5;
      orbNegX = .5;
      orbPosY = .5;
      orbNegY = .5;
   }
   private static void tentacles(int n, double x, double y, double a){
      if(n == 0) {
         return;
      }
      double tentacleRadius = .002;
      double ca;
      double bendAngle = Math.toRadians(1);
      double tentacleAngle = Math.toRadians(30);
      double cx = x + Math.cos(a) * tentacleRadius;
      double cy = y + Math.sin(a) * tentacleRadius;
      StdDraw.setPenColor(fore);;
      StdDraw.setPenRadius(n * .00002);
      StdDraw.line(x, y, cx, cy);
      if(n == 0) {
         return;
      }
      boolean forward = random.nextBoolean();
      boolean turn = random.nextBoolean();
      if(forward) {
         ca = a + bendAngle;
      }
      else {
         if(turn) {
            ca = a + bendAngle + tentacleAngle;
         }
         else {
            ca = a + bendAngle - tentacleAngle;
         }
      }
      tentacles(n-1, cx, cy, ca);
   }
   private static void mouths(double x, double y, double orbRadius) {
      StdDraw.setPenColor(back);
      StdDraw.setPenRadius();
      double mouthRadius = orbRadius * random.nextDouble() / 3;
      StdDraw.filledCircle(x, y, mouthRadius);
      StdDraw.setPenColor(fore);
      StdDraw.filledCircle(x, y, mouthRadius - mouthRadius * .17);
      StdDraw.setPenColor(back);
      double teethDepth = .25;
      double[] xaul = {x-mouthRadius*.85, x-mouthRadius*teethDepth, x-mouthRadius/2.5};
      double[] yaul = {y+mouthRadius/2.5, y+mouthRadius*teethDepth, y+mouthRadius*.85};
      StdDraw.filledPolygon(xaul, yaul);
      double[] xau = {x-mouthRadius/2.5, x, x+mouthRadius/2.5};
      double[] yau = {y+mouthRadius*.85, y+mouthRadius*teethDepth, y+mouthRadius*.85};
      StdDraw.filledPolygon(xau, yau);
      double[] xaur = {x+mouthRadius/2.5, x+mouthRadius*teethDepth, x+mouthRadius*.85};
      double[] yaur = {y+mouthRadius*.85, y+mouthRadius*teethDepth, y+mouthRadius/2.5};
      StdDraw.filledPolygon(xaur, yaur);
      double[] xadl= {x-mouthRadius*.85, x-mouthRadius*teethDepth, x-mouthRadius/2.5};
      double[] yadl = {y-mouthRadius/2.5, y-mouthRadius*teethDepth, y-mouthRadius*.85};
      StdDraw.filledPolygon(xadl, yadl);
      double[] xad = {x-mouthRadius/2.5, x, x+mouthRadius/2.5};
      double[] yad = {y-mouthRadius*.85, y-mouthRadius*teethDepth, y-mouthRadius*.85};
      StdDraw.filledPolygon(xad, yad);
      double[] xadr = {x+mouthRadius/2.5, x+mouthRadius*teethDepth, x+mouthRadius*.85};
      double[] yadr = {y-mouthRadius*.85, y-mouthRadius*teethDepth, y-mouthRadius/2.5};
      StdDraw.filledPolygon(xadr, yadr);
      double[] xar = {x+mouthRadius*.85, x+mouthRadius*teethDepth, x+mouthRadius*.85};
      double[] yar = {y-mouthRadius/2.5, y, y+mouthRadius/2.5};
      StdDraw.filledPolygon(xar, yar);
      double[] xal = {x-mouthRadius*.85, x-mouthRadius*teethDepth, x-mouthRadius*.85};
      double[] yal = {y-mouthRadius/2.5, y, y+mouthRadius/2.5};
      StdDraw.filledPolygon(xal, yal);
   }
   private static void orbs(int n){
      if(n == 0) {
         return;
      }
      double x;
      double y;
      if(random.nextBoolean()) {
         orbPosX = orbPosX + random.nextDouble()/50;
         x = orbPosX;
      }
      else if(random.nextBoolean()){
         orbNegX = orbNegX - random.nextDouble()/50;
         x = orbNegX;
      }
      else {
         x = .5;
      }
      if(random.nextBoolean()) {
         orbPosY = orbPosY + random.nextDouble()/50;
         y = orbPosY;
      }
      else if(random.nextBoolean()){
         orbNegY = orbNegY - random.nextDouble()/50;
         y = orbNegY;
      }
      else {
         y = .5;
      }
      double orbRadius = random.nextDouble()/20 + random.nextDouble()/100;
      StdDraw.setPenColor(fore);
      StdDraw.setPenRadius();
      StdDraw.filledCircle(x, y, orbRadius);
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            tentacles(1000, x, y, random.nextDouble() * Math.PI);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            tentacles(1000, x, y, random.nextDouble() * Math.PI);
         }
      }
      if(random.nextBoolean()) {
         StdDraw.setPenColor(back);
         StdDraw.setPenRadius();
         double eyeRadius = orbRadius * random.nextDouble() / 3;
         StdDraw.ellipse(x, y, eyeRadius * 2.5, eyeRadius);
         StdDraw.filledCircle(x, y, eyeRadius);
         StdDraw.setPenColor(fore);
         StdDraw.filledCircle(x, y, eyeRadius / 2);
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x + orbRadius / 2, y  + orbRadius / 2, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x + orbRadius / 2, y, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x + orbRadius / 2, y  - orbRadius / 2, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x, y + orbRadius / 2, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x, y - orbRadius / 2, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x - orbRadius / 2, y + orbRadius / 2, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x - orbRadius / 2, y, orbRadius);
         }
      }
      if(random.nextBoolean()) {
         if(random.nextBoolean()) {
            mouths(x - orbRadius / 2, y - orbRadius / 2, orbRadius);
         }
      }
      orbs(n - 1);
   }
   private static void generate() {
      orbPosX = .5;
      orbNegX = .5;
      orbPosY = .5;
      orbNegY = .5;
      orbs(30);
   }
   public static void main(String[] args) {
      StdDraw.clear(back);
      generate();
      StdDraw.show();
   }
}
