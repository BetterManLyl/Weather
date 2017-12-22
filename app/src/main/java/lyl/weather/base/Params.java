package lyl.weather.base;

import java.util.HashMap;
import java.util.List;

/**
 * @author lyl
 * @date 2017/12/22.
 */

public class Params {

    public HashMap<String, String> addParams(List<String> key, List<String> value) {
        HashMap<String, String> localHashmap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            localHashmap.put(key.get(i), value.get(i));
        }
        return localHashmap;
    }
}
