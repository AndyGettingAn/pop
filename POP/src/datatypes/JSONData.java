package datatypes;

import declaration.Block;
import main.RuntimeScope;
import operator.Operator;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONData {
    private JSONObject myData;

    public JSONData() {
        myData = null;
    }

    public JSONData(String raw) {
        try {
            myData = new JSONObject(raw.substring(1, raw.length()-1));
        } catch (JSONException e) {
            System.out.println("RUNTIME ERROR: syntax error in JSON raw data: " + raw + ": " + e.getMessage());
        }
    }

    public JSONData copy() {
        if (myData == null) return new JSONData();
        else {
            return new JSONData(myData.toString());
        }
    }

    public Object extractSubData(String path) {
        String [] pathSegments = path.split("\\.");
        Object o;
        JSONObject data;

        int s = 0;

        if (pathSegments.length > 0) {
            try {
                data = myData;
                do {
                    o = data.get(pathSegments[s]);
                    if (!(o instanceof JSONObject)) {
                        if (s == pathSegments.length - 1) {
                            String val = (String)o;

                            if (val.matches("[-]?\\d+[\\.\\d+]?")) return Double.parseDouble(val);
                            else if (val.equals("true")) return new Boolean(true);
                            else if (val.equals("false")) return new Boolean(false);
                            else return val;
                        }
                        else {
                            System.out.println("RUNTIME ERROR: path " + path + " cannot be found in " + myData.toString());
                            return null;
                        }
                    }
                    else {
                        data = (JSONObject) o;
                        s++;
                    }
                }
                while (s < pathSegments.length);

                return o;
            } catch (JSONException e) {
                System.out.println("RUNTIME ERROR while processing " + myData.toString() + ": " + e.getLocalizedMessage());
                return null;
            }
        }
        else {
            System.out.println("RUNTIME ERROR: invalid JSON path in " + path);
            return null;
        }
    }

    @Override
    public String toString() {
        return myData.toString();
    }
}
