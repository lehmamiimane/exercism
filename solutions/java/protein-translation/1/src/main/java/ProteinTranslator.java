import java.util.*;
class ProteinTranslator {

    private static final Map<String, String> codonProteins = Map.ofEntries(
        Map.entry("AUG", "Methionine"),
        Map.entry("UUU", "Phenylalanine"),
        Map.entry("UUC", "Phenylalanine"),
        Map.entry("UUA", "Leucine"),
        Map.entry("UUG", "Leucine"),
        Map.entry("UCU", "Serine"),
        Map.entry("UCC", "Serine"),
        Map.entry("UCA", "Serine"),
        Map.entry("UCG", "Serine"),
        Map.entry("UAU", "Tyrosine"),
        Map.entry("UAC", "Tyrosine"),
        Map.entry("UGU", "Cysteine"),
        Map.entry("UGC", "Cysteine"),
        Map.entry("UGG", "Tryptophan"),
        Map.entry("UAA", "STOP"),
        Map.entry("UAG", "STOP"),
        Map.entry("UGA", "STOP")
    );

    List<String> translate(String rnaSequence) {
        List<String> protein = new ArrayList<String>();
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            int endIndex = Math.min(i + 3, rnaSequence.length());
            String codon = rnaSequence.substring(i, endIndex);
            String aminoAcid = this.codonProteins.get(codon);
            if (aminoAcid == null) {
                throw new IllegalArgumentException("Invalid codon");
            }
            
            if (aminoAcid.equals("STOP")) {
                break;
            }
            protein.add(aminoAcid);
        }
        
        return protein;
    }
}
