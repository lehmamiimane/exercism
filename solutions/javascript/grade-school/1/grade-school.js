//
// This is only a SKELETON file for the 'Grade School' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export class GradeSchool {
  constructor() {
    this._roster = {};
  }

  roster() {
    // Return a deep copy of the roster to prevent external mutation
    const copy = {};
    for (const grade in this._roster) {
      copy[grade] = [...this._roster[grade]];
    }
    return copy;
  }

  add(name, grade) {
    // Remove the student from any existing grade
    for (const key in this._roster) {
      this._roster[key] = this._roster[key].filter(student => student !== name);
    }

    // Add the student to the new grade
    if (!this._roster[grade]) {
      this._roster[grade] = [];
    }
    this._roster[grade].push(name);

    // Sort the students in the grade alphabetically
    this._roster[grade].sort();
  }

  grade(grade) {
    // Return a copy of the grade array or an empty array if the grade doesn't exist
    return this._roster[grade] ? [...this._roster[grade]] : [];
  }
}
