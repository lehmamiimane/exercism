//
// This is only a SKELETON file for the 'Bank Account' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class BankAccount {
  #money;
  #isOpen;

  constructor() {
    this.#money = 0;
    this.#isOpen = false;
  }

  open() {
    if (this.#isOpen) {
      throw new ValueError(); // compte déjà ouvert
    }
    this.#isOpen = true;
    this.#money = 0;
  }

  close() {
    if (!this.#isOpen) {
      throw new ValueError(); // compte déjà fermé
    }
    this.#isOpen = false;
    this.#money = 0;
  }

  deposit(amount) {
    if (!this.#isOpen || amount < 0) {
      throw new ValueError();
    }
    this.#money += amount;
  }

  withdraw(amount) {
    if (!this.#isOpen || amount < 0 || amount > this.#money) {
      throw new ValueError();
    }
    this.#money -= amount;
  }

  get balance() {
    if (!this.#isOpen) {
      throw new ValueError();
    }
    return this.#money;
  }
}

export class ValueError extends Error {
  constructor() {
    super('Bank account error');
  }
}
