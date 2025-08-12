export const colorCode = (color : String) : number => {
  const index = COLORS.indexOf(color.toLowerCase());

  if(index !== -1) return index;
  throw new Error(`Unknown color: ${color}`)
}

export const COLORS : string[] = [
        "black", "brown", "red", "orange", "yellow", 
        "green", "blue", "violet", "grey", "white"
    ];


