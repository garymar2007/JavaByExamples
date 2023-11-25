//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import com.fasterxml.jackson.databind.deser.std;
//
//public class DateParsing {
//    private static String json="{\r\n" +
//            "\"title\" : \"JavaBook\", \r\n" +
//            "\"autor\" : \"Java\", \r\n" +
//            "\"price\" : 37,\r\n" +
//            "\"publicationDate\" : \"2023-06-23\"\r\n" +
//            "}";
//
//    public static void main(String... args) {
//        ObjectMapper mapper = new ObjectMapper();
//        EBook javaBook = mapper.readValue(json, EBook.class);
//        System.out.println(javaBook); //output: [title=JavaBook, author=Java, price=30, publicationDate=Fri Jun 23 00:00:00 SAST 2023]
//    }
//}
//
//class DateHelper extends StdDeserializer<Date> {
//    public DateHelper(){
//        this(null);
//    }
//
//    public DateHelper(Class<?> clazz) {
//        super(clazz);
//    }
//
//    @Override
//    public Date deserialize(JsonParser jsonparser, DeserializationContect context) throws IOException {
//        String date = jsonparser.getText();
//        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            return sdf.parse(date);
//        }catch(Exception e) {
//            return null;
//        }
//    }
//}
//
//@Data
//@AllArgsConstructor
//class EBook {
//    private String title;
//    private String author;
//    private int price;
//
//    @JsonDeserialize(using = DateHelper.class)
//    private Date publicationDate;
//}
