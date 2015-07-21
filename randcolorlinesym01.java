// draw symbols or lines with random color 
// by using mouse attributes / functions

void setup() {
  size(640, 480);
  noSmooth();
  background(0);
}

boolean changeColor = true;
boolean drawModeLines = false;
boolean drawLine = false;
int drawSymbol = -1;
int drawColor = 0;
int symbolWidth = 10;
int symbolHeight = 10;

void draw() {
  if (changeColor == true) {
    int r = int(random(255));
    int g = int(random(255));
    int b = int(random(255));
    drawColor = color(r, g, b);
    changeColor = false;
  }
}

void mousePressed() {
  drawSymbol = int(random(4)); // todo random symbol
}

void mouseDragged() {
  if (drawModeLines == false && drawSymbol > -1) {
    switch (drawSymbol) {
      case 0:
        // square
        noStroke();
        fill(drawColor);
        rect(
          mouseX-symbolWidth/2, mouseY-symbolHeight/2, 
          symbolWidth, symbolHeight
        );
        break;
      case 1:
        // ellipse
        noStroke();
        fill(drawColor);
        ellipse(mouseX, mouseY, symbolWidth, symbolHeight);
        break;
      case 2:
        // triangle
        noStroke();
        fill(drawColor);
        triangle(
          mouseX-symbolWidth/2, mouseY+symbolHeight/2, 
          mouseX, mouseY-symbolHeight/2, 
          mouseX+symbolWidth/2, mouseY+symbolHeight/2
        );
        break;
      case 3:
        // x cross
        noFill();
        stroke(drawColor);
        line(
          mouseX-symbolWidth/2, mouseY-symbolHeight/2, 
          mouseX+symbolWidth/2, mouseY+symbolHeight/2 
        );
        line(
          mouseX-symbolWidth/2, mouseY+symbolHeight/2, 
          mouseX+symbolWidth/2, mouseY-symbolHeight/2
        );
        break;
    }
  } else if (drawModeLines == true) {
    noFill();
    stroke(drawColor);
    line(width/2, height/2, mouseX, mouseY);
  }
}

void mouseReleased() {
  changeColor = true; 
  drawSymbol = -1;
  drawLine = false;
}

void keyPressed() {
  if (drawModeLines == true) {
    drawModeLines = false;
  } else {
    drawModeLines = true;
  }
}
