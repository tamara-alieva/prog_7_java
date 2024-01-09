public class Checking {
    static public boolean nameCheck(String name) {
        boolean f;
        f = !name.isEmpty() && name.matches("^[a-zA-Z]+");
        return f;
    }

    static public int intCheck(String balance) {
        int f;
        if (!balance.isEmpty() && balance.matches("^[0-9]+")) f = 1;
        else f = 0;
        return f;
    }

    static public boolean booleanCheck(String str) {
        boolean f;
        f = !str.isEmpty() && str.matches("[01]{1}");
        return f;
    }
}
