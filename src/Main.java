import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String number = "А674МР197r";
        String lettersRange = "[АВЕКМНОРСТУХ]";
        String regex = lettersRange + "[0-9]{3}" +
                lettersRange + "{2}[0-9]{2,3}" + ".?";
        System.out.println(number.matches(regex));
        System.out.println(System.lineSeparator());

        String text = "http://elku.ru/ Алексей, добрый день!\nМой гитхаб — https://github.com/, а также ссылка на мой персональный сайт — https://www.skillbox.ru/\nЕсли возникнут вопросы, пишите мне напрямую. Я всегда доступен";
        //String regex1 = "http[s]?://[^,\s,\n]+";
        String regex1 = "https?://[^,\s,\n]+";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start, end));
        }
        System.out.println(System.lineSeparator());

        Matcher matcher1 = pattern.matcher(text);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }
        System.out.println(System.lineSeparator());

        String text2 = "Дмитрий сообщил следующее: «Я вернусь в 12:40 и, будьте добры, подготовьте к этому времени все документы!» На что Анна ему ответила: «А документы-то так и не привезли». Дмитрий удивлённо посмотрел на неё и сказал: «Ну и ладно», — вздохнул, махнул рукой и удалился.";
        String regex2 = "«([^»]+)»";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(text2);
        while (matcher2.find()) {
            String citation = matcher2.group(1);
            //System.out.println(citation);
            System.out.println(matcher2.group());
        }

//        System.out.println(matcher2.group());


        System.out.println("test" + System.lineSeparator());


//        String data = "thesis - 840, value - 546"; //+
//        String data = "weight: 540,687; height: 546;"; // -
//        String data = "Он был профессиональным кузнецом. Тогда это была особенная профессия, требующая знания всех металлов, сплавов, кузнечных инструментов, обладания невиданной силой"; // -
//        String data = "straight   and   forward"; // +
//        String data = "ambiguous and pretty"; // -
        String data = "256 * 32 = ?"; // -

        String[] words = data.split("\s+[^,;:]\s+");

        for(int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        System.out.println(System.lineSeparator());



        String text5 = "A23E-8M28-76AF-2L65-24A3";
        String regex5 = "[A-F0-9]{4}";
        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(text5);
        matcher5.find();
        matcher5.find();
        matcher5.find();
        System.out.println(matcher5.group());

        System.out.println(System.lineSeparator());
    }

}