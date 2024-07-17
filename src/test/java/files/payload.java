package files;

public class payload {

    public static String createAccount()
    {
        return "{\n" +
                "    \"name\": \"test8demo\",\n" +
                "    \"email\": \"test8demo@gmail.com\",\n" +
                "    \"phoneCountryCode\": \"+91\",\n" +
                "    \"phone\": \"600067735333\",\n" +
                "    \"password\": \"Admin@123\",\n" +
                "    \"confirmPassword\": \"Admin@123\"\n" +
                "}";
    }


    public static String userAuth()
    {
        return "{\n" +
                "  \"userName\": \"demo2663@gmail.com\",\n" +
                "  \"password\": \"Admin@123\"\n" +
                "}";
    }




    public static String addTags()
    {
        return "{\n" +
                "  \"name\": \"cello tag\",\n" +
                "  \"iconUrl\": \"https://cdn.jsdelivr.net/npm/emoji-datasource-apple/img/apple/64/1f60a.png\"\n" +
                "}";
    }
}
