import java.util.List;

class RelationshipComputer<T> {
    Relationship computeRelationship(List<T> firstList, List<T> secondList) {
        if (firstList.equals(secondList)) {
        return Relationship.EQUAL;
    } else if (isSubList(firstList, secondList)) {
        return Relationship.SUPERLIST;
    } else if (isSubList(secondList, firstList)) {
        return Relationship.SUBLIST;
    } else {
        return Relationship.UNEQUAL;
    }
    }


    private boolean isSubList(List<T> main, List<T> sub){
        int mainSize = main.size(); 
        int subSize = sub.size(); 

        if(subSize == 0) return true;

        for(int i = 0; i<= mainSize - subSize; i++){
            if(main.subList(i, i + subSize).equals(sub)){
                return true;
            }
        }
        return false;
    }
}
