//
// This is only a SKELETON file for the 'Pangram' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const isPangram = (input) => {
   const alphabet = 'abcdefghijklmnopqrstuvwxyz';
  const inputLower = input.toLowerCase();

  for(let c of alphabet){
    if(!inputLower.includes(c)){
      return false;
    }
  }
  return true;
};