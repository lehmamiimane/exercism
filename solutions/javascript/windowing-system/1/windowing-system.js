// @ts-check

/**
 * Implement the classes etc. that are needed to solve the
 * exercise in this file. Do not forget to export the entities
 * you defined so they are available for the tests.
 */

export class Size {
  constructor(width=80, height=60){
    this.width=width;
    this.height=height;
  }

  resize(newWidth, newHeight){
    this.width=newWidth;
    this.height=newHeight;
  }
}

export class Position {
  constructor(x=0, y=0){
    this.x=x;
    this.y=y;
  }

  move(dx, dy){
    this.x=dx;
    this.y=dy;
  }
}

export class ProgramWindow {
  constructor(){
    this.screenSize= new Size(800,600);
    this.size=new Size();
    this.position = new Position();
  }

  resize(size){
    const minWidth = 1;
    const minHeight = 1;

    const maxWidth = this.screenSize.width - this.position.x;
    const maxHeight = this.screenSize.height - this.position.y;

    const newWidth = Math.max(minWidth, Math.min(size.width, maxWidth));
    const newHeight = Math.max(minHeight, Math.min(size.height, maxHeight));

    this.size.width = newWidth;
    this.size.height = newHeight;
}

  move(position){
     const minX = 0;
    const minY = 0;

    const maxX = this.screenSize.width - this.size.width;
    const maxY = this.screenSize.height - this.size.height;

    this.position.x = Math.max(minX, Math.min(position.x, maxX));
    this.position.y = Math.max(minY, Math.min(position.y, maxY));
  }
  
}

export function changeWindow(programWindow){
  programWindow.position.move(100,150);
  const size = new Size(400,300);
  programWindow.resize(size);
  return programWindow;
}