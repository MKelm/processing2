// draw symbols with random color 
// to mouse position by using mouse functions

void setup() {
  size(640, 480);
  noSmooth();
  background(0);
}

boolean changeColor = true;
int drawSymbol = -1;
int symbolColor = 0;
int symbolWidth = 10;
int symbolHeight = 10;

void draw() {
  if (changeColor == true) {
    int r = int(random(255));
    int g = int(random(255));
    int b = int(random(255));
    symbolColor = color(r, g, b);
    changeColor = false;
  }
}

void mousePressed() {
  drawSymbol = int(random(4)); // todo random symbol
}

void mouseDragged() {
  if (drawSymbol > -1) {
    switch (drawSymbol) {
      case 0:
        // square
        noStroke();
        fill(symbolColor);
        rect(
          mouseX-symbolWidth/2, mouseY-symbolHeight/2, 
          symbolWidth, symbolHeight
        );
        break;
      case 1:
        // ellipse
        noStroke();
        fill(symbolColor);
        ellipse(mouseX, mouseY, symbolWidth, symbolHeight);
        break;
      case 2:
        // triangle
        noStroke();
        fill(symbolColor);
        triangle(
          mouseX-symbolWidth/2, mouseY+symbolHeight/2, 
          mouseX, mouseY-symbolHeight/2, 
          mouseX+symbolWidth/2, mouseY+symbolHeight/2
        );
        break;
      case 3:
        // x cross
        noFill();
        stroke(symbolColor);
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
  }
}

void mouseReleased() {
  changeColor = true; 
  drawSymbol = -1;
}
