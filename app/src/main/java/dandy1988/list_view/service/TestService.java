package dandy1988.list_view.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestService {
    public static final String TAG = "myLOG";
    public static void main(String[] args) {

        List<Boolean> booleans = new ArrayList<>();
        booleans = Arrays.asList(true, false, true, false, true);
        for (Boolean element:booleans) {
            if (element==true) booleans.remove(element);
        }
        Log.d(TAG, "booleans = " + booleans);
    }
}
