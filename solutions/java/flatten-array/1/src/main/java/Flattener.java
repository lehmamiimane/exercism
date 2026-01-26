import java.util.List;
import java.util.ArrayList; 
class Flattener {

    List<Object> flatten(List<?> list) {
        List<Object> result = new ArrayList<>();
        for(Object item : list){
            if(item != null){
            if(item instanceof List<?>){
                List<?> flattenRes = flatten((List<?>) item);
                result.addAll(flattenRes);
            }else{
              result.add(item);
            }
            }
        }
        return result;
    }

}