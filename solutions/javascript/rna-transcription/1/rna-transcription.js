//
// This is only a SKELETON file for the 'RNA Transcription' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const toRna = (dna) => {
  const rna = dna.split('').map(base => {
    switch (base) {
      case 'A':
        return 'U';
      case 'T':
        return 'A';
      case 'C':
        return 'G';
      case 'G':
        return 'C';
      default:
        throw new Error('Invalid DNA base');
    }
  }).join('');
  
  return rna;
};

