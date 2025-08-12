/// <reference path="./global.d.ts" />
//
// @ts-check

/**
 * Determine the price of the pizza given the pizza and optional extras
 *
 * @param {Pizza} pizza name of the pizza to be made
 * @param {Extra[]} extras list of extras
 *
 * @returns {number} the price of the pizza
 */
export function pizzaPrice(pizza, ...extras) {
  const pizzaPrices = {
    Margherita : 7,
    Caprese : 9,
    Formaggio : 10
  };

  const extrasPrices = {
    ExtraSauce : 1,
    ExtraToppings : 2
  };
  
   if(extras.length === 0){
     return pizzaPrices[pizza] || 0;
   }

  const [firstExtra, ...remain] = extras;
  const extraPrice = extrasPrices[firstExtra] || 0;
  return extraPrice + pizzaPrice(pizza, ...remain);
  }

/**
 * Calculate the price of the total order, given individual orders
 *
 * (HINT: For this exercise, you can take a look at the supplied "global.d.ts" file
 * for a more info about the type definitions used)
 *
 * @param {PizzaOrder[]} pizzaOrders a list of pizza orders
 * @returns {number} the price of the total order
 */
export function orderPrice(pizzaOrders) {
    if (!Array.isArray(pizzaOrders)) return 0;

  return pizzaOrders.reduce((total, order) => {
    const pizza = order.pizza; // NE PAS transformer
    const extras = Array.isArray(order.extras) ? order.extras : [];

    return total + pizzaPrice(pizza, ...extras);
  }, 0);
}
