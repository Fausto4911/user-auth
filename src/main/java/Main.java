import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void  main(String ... args) {

        List<String> unorderList = new ArrayList<>();
        unorderList.add("agua");
        unorderList.add("dado");
        unorderList.add("sal");
        unorderList.add("bets");
        unorderList.add("casa");


        String x ="agua";
        String y = "saL";

        System.out.print( unorderList);

        unorderList.sort((o1,o2) -> o1.compareTo(o2));
        unorderList.sort((o1,o2) -> o1.compareTo(o2));
//        private List<MapEntryBean> orderListByValue (List<MapEntryBean> unorderList) {
//            List<MapEntryBean> orderList = unorderList;
//            orderList.sort((o1,o2) -> o1.getValue().compareTo(o2.getValue()));
//            return orderList;
//        }

        System.out.print( unorderList);

    }
}
