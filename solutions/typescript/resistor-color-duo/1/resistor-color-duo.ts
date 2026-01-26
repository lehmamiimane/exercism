export const COLORS: string[] = [
  "black", "brown", "red", "orange", "yellow", 
  "green", "blue", "violet", "grey", "white"
];

export function getColorCode(color: string): number {
  const index = COLORS.indexOf(color);
  if (index !== -1) {
    return index;
  }
  throw new Error(`Unknown color: ${color}`);
}

export function decodedValue(colors: string[]): number {
  const firstDigit = getColorCode(colors[0].toLowerCase());
  const secondDigit = getColorCode(colors[1].toLowerCase());
  return firstDigit * 10 + secondDigit;
}

