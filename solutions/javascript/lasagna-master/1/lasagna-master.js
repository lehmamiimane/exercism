/// <reference path="./global.d.ts" />
// @ts-check

/**
 * Implement the functions needed to solve the exercise here.
 * Do not forget to export them so they are available for the
 * tests. Here an example of the syntax as reminder:
 *
 * export function yourFunction(...) {
 *   ...
 * }
 */

export function cookingStatus(timer) {
  if (timer === 0) {
    return 'Lasagna is done.';
  } else if (timer === undefined) {
    return 'You forgot to set the timer.';
  } else {
    return 'Not done, please wait.';
  }
}

export function preparationTime(layers, time = 2){
  const numberLayers = layers.length;
  return numberLayers*time;
}

export function quantities(layers){
  const noodles = layers.filter(l => l === 'noodles').length * 50;     // 50g per layer
  const sauce = layers.filter(l => l === 'sauce').length * 0.2;        // 0.2L per layer

  return {
    noodles: noodles,
    sauce: sauce
  };
}

export function addSecretIngredient(friendsList, myList){
   const last = friendsList[friendsList.length - 1]; // last item
  myList.push(last); // add to your list
}

export function scaleRecipe(recipe, num = 1){
   const scaled = {};

  for (const key in recipe) {
    if (Object.hasOwn(recipe, key)) {
      scaled[key] = recipe[key] * (num / 2);
    }
  }

  return scaled;
}