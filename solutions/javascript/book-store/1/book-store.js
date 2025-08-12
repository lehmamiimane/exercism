//
// This is only a SKELETON file for the 'BookStore' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const cost = (books) => {
  const PRICE = 800; // cents
  const DISCOUNTS = { 1: 1, 2: 0.95, 3: 0.90, 4: 0.80, 5: 0.75 };

  let groups = [];

  // Greedily form largest possible groups
  let pool = [...books];
  while (pool.length > 0) {
    const distinct = Array.from(new Set(pool));
    groups.push(distinct.length);
    distinct.forEach(book => {
      const idx = pool.indexOf(book);
      pool.splice(idx, 1);
    });
  }

  // Fix: convert (5,3) pairs into (4,4) pairs
  while (groups.includes(5) && groups.includes(3)) {
    groups.splice(groups.indexOf(5), 1, 4);
    groups.splice(groups.indexOf(3), 1, 4);
  }

  // Calculate total
  return groups.reduce((total, size) => {
    return total + size * PRICE * DISCOUNTS[size];
  }, 0);
};
