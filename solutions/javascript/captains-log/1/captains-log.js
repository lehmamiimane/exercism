// @ts-check

/**
 * Generates a random starship registry number.
 *
 * @returns {string} the generated registry number.
 */
export function randomShipRegistryNumber() {
  const regNum = Math.floor(Math.random() * (9999 - 1000 + 1)) + 1000;
  return `NCC-${regNum}`;
}

/**
 * Generates a random stardate.
 *
 * @returns {number} a stardate between 41000 (inclusive) and 42000 (exclusive).
 */
export function randomStardate() {
  const stardate = Math.random() * (42000.0 - 41000.0) + 41000.0;
  return stardate;
}

/**
 * Generates a random planet class.
 *
 * @returns {string} a one-letter planet class.
 */
export function randomPlanetClass() {
   const classes = ["D", "H", "J", "K", "L", "M", "N", "R", "T", "Y"];
  const randomIndex = Math.floor(Math.random() * classes.length);
  return classes[randomIndex];
}
