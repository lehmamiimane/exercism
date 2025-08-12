//
// This is only a SKELETON file for the 'D&D Character' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const abilityModifier = score => {
  if (score < 3) throw Error("Ability scores must be at least 3");
  if (score > 18) throw Error("Ability scores can be at most 18");
  return Math.floor((score - 10) / 2);
};
export const Character = class Character {
  constructor() {
    this.strength = Character.rollAbility();
    this.dexterity = Character.rollAbility();
    this.constitution = Character.rollAbility();
    this.intelligence = Character.rollAbility();
    this.wisdom = Character.rollAbility();
    this.charisma = Character.rollAbility();
    this.hitpoints = abilityModifier(this.constitution) + 10;
  }
  static rollAbility() {
    const rollDice = () => {
      return Math.floor(Math.random() * Math.floor(6)) + 1;
    };
    return Array(4)
      .fill(0)
      .map(rollDice)  // 4d6
      .sort()
      .slice(1, 4)    // keep top 3
      .reduce((a, v) => a + v, 0);
  }
};
