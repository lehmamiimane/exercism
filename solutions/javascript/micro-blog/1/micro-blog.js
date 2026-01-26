//
// This is only a SKELETON file for the 'Micro-blog' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const truncate = (input) => {
  let result = '';
  let count = 0;

  for(let c of input){
    result+=c;
    count++;
    if(count === 5){
      break;
    }
  }
  return result;
};
