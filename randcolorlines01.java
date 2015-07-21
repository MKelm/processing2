// draw lines with random color 
// from center point by using mouse functions

void setup() {
  size(640, 480);
  noSmooth();
  background(0);
}

boolean changeColor = true;
boolean drawLine = false;

void draw() { 
  if (changeColor == true) {
    int r = int(random(255));
    int g = int(random(255));
    int b = int(random(255));
    stroke(color(r, g, b));
    changeColor = false;
  }
}

void mousePressed() {
  drawLine = true; 
}

void mouseDragged() {
  if (drawLine == true) {
    line(width/2, height/2, mouseX, mouseY);
  }
}

void mouseReleased() {
  changeColor = true; 
  drawLine = false;
}
